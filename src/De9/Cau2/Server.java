/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De9.Cau2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    DatagramSocket socket;
    DatagramPacket packet;
    public void connect(){
        try {
            socket=new DatagramSocket(3000);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sendData(String s){
        try {
            byte[] guiDL = new byte[1024];
            guiDL=s.getBytes();
            int len = guiDL.length;
            InetAddress add = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(guiDL, len, add, port);
            socket.send(packet);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public String receiveData(){
        try {
            byte[] nhanDL = new byte[1024];
            int len = nhanDL.length;
            packet = new DatagramPacket(nhanDL, len);
            socket.receive(packet);
            String s = (new String(packet.getData(), 0, packet.getLength())).trim();
            return s;
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    public static void save(List<Sach> list, String path){
        try {
            FileWriter fw = new FileWriter(path);
            for(Sach s: list){
                fw.write(s.getMaS()+"$"+s.getTenS()+"$"+s.getNguoiMuon()+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        Server s = new Server();
        s.connect();
        String mess="";
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("sach.txt"));
            String str ="";
            while((str=br.readLine())!=null){
                String[] a = str.split("\\$");
                Sach sach = new Sach(a[0], a[1], a[2]);
                list.add(sach);    
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            String chon = s.receiveData();
            int select = Integer.parseInt(chon);
            switch(select){
                case 1:
                    mess="";
                    for(Sach sach: list){
                        mess+=sach.toString()+"\n";
                    }
                    s.sendData(mess);
                    break;
                case 2:
                    mess="";
                    String ten =s.receiveData();
                    String nguoi=s.receiveData();
                    for(Sach sach1: list){
                        if(ten.equalsIgnoreCase(sach1.getTenS())){
                            if(sach1.getNguoiMuon().equalsIgnoreCase("chua muon")){
                                sach1.setNguoiMuon(nguoi);
                                mess="Muon sach thanh cong"+"\n"+sach1.toString();
                                save(list, "sach.txt");
                                s.sendData(mess);
                                break;
                            }else{
                                mess="Sach nay da duoc muon";
                                s.sendData(mess);
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    return;
                    default:
                        s.sendData("Moi chon lai: ");
                    
                    
                            
            }
        }
    }
    
}
