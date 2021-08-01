/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De9.Cau2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Client {
    DatagramSocket socket;
    DatagramPacket packet;
    public void connect(){
        try {
            socket=new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void sendData(String s){
        try {
            byte[] guiDL = new byte[1024];
            guiDL=s.getBytes();
            int len = guiDL.length;
            InetAddress add = InetAddress.getByName("LocalHost");
            packet = new DatagramPacket(guiDL, len, add, 3000);
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
    public static void main(String[] args) {
        Client m = new Client();
        m.connect();
        Scanner sc = new Scanner(System.in);
        int select;
        String mess="";
        while(true){
            System.out.println("1. Hien thi danh sach");
            System.out.println("2. Muon sach");
            System.out.println("3. Thoat");
            System.out.println("Moi ban chon: ");
            select=sc.nextInt();
            String chon = String.valueOf(select);
            m.sendData(chon);
            switch(select){
                case 1:
                    mess+=m.receiveData();
                    System.out.println("Thong tin ve sach: ");
                    System.out.println(mess);
                    break;
                case 2:
                    mess="";
                    System.out.println("Nhap vao ten sach: ");
                    sc.nextLine();
                    String ten=sc.nextLine();
                    m.sendData(ten);
                    System.out.println("Nhap vao nguoi muon: ");
                    String nguoi=sc.nextLine();
                    m.sendData(nguoi);
                    mess+=m.receiveData();
                    System.out.println(mess);
                    break;
                case 3:
                    return;
                    default:
                        System.out.println(m.receiveData());
                    
            }
                    
        }
    }
    
}
