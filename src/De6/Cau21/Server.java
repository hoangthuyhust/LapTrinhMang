/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De6.Cau21;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    public static void save(ArrayList<Nha> list, String path){
        try {
            FileWriter fw = new FileWriter(path);
            for(Nha n: list){
                fw.write(n.getSoNha()+"$"+n.getGiaBan()+"$"+n.isTinhTrang()+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(De6.Cau2.Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        ArrayList<Nha> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("nha.txt"));
            String s="";
            while((s=br.readLine())!=null){
                String[] arr=s.split("\\$");
                if(arr.length==3){
                    Nha n = new Nha(Integer.parseInt(arr[0]), Float.parseFloat(arr[1]), Boolean.parseBoolean(arr[2]) );
                    list.add(n);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ServerSocket server = new ServerSocket(1060);
            System.out.println("Dang doi...");
            Socket myServer = server.accept();
            System.out.println("Da ket noi thanh cong voi Client");
            Scanner sc = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(myServer.getInputStream());
            DataOutputStream dos = new DataOutputStream(myServer.getOutputStream());
            int select=0;
            String mess="";
            while(true){
                select=dis.read();
                switch(select){
                    case 1:
                        mess="";
                        for(Nha n1: list){
                            mess+=n1.toString()+"\n";
                        }
                        dos.writeUTF(mess);
                        break;
                    case 2:
                        mess=dis.readUTF();
                        String[] a = mess.split("\\$");
                        Nha n1 = new Nha();
                        n1.setSoNha(Integer.parseInt(a[0]));
                        n1.setGiaBan(Float.parseFloat(a[1]));
                        n1.setTinhTrang(Boolean.parseBoolean(a[2]));
                        list.add(n1);
                        save(list, "nha.txt");
                        dos.writeUTF("Them thanh cong");
                        break;
                    case 3:
                        int i=0;
                        int s = dis.read();
                        for(Nha n2: list){
                            if(s==n2.getSoNha()){
                                if(n2.isTinhTrang()){
                                    mess="Nha nay da duoc ban";
                                }else{
                                    n2.setTinhTrang(Boolean.parseBoolean("True"));
                                    mess="Mua nha thanh cong\n"+"Thong tin nha: \n"+n2.toString()+"\n";
                                    save(list, "nha.txt");
                                }
                            }
                            i++;
                        }
                        if(i==0){
                            mess="Nha nay khong ton tai";
                        }
                        dos.writeUTF(mess);
                        break;
                    case 4:
                        return;
                        default:
                            dos.writeUTF("Yeu cau nhap lai");
                        
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(De6.Cau2.Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
