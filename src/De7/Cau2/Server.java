/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De7.Cau2;

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
    public static void save(ArrayList<KhachHang> list, String path){
        try {
            FileWriter fw = new FileWriter(path);
            for(KhachHang kh: list){
                fw.write(kh.getMaKH()+"$"+kh.getTenKH()+"$"+kh.getLoaiP()+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("khachhang.txt"));
            String s="";
            while((s=br.readLine())!=null){
                String[] a = s.split("\\$");
                if(a.length==3){
                    KhachHang kh = new KhachHang(a[0], a[1], a[2]);
                    list.add(kh);
                }
                
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ServerSocket server = new ServerSocket(7000);
            System.out.println("Dang doi...");
            Socket myServer =  server.accept();
            System.out.println("Da ket noi thanh cong voi Client");
            DataInputStream dis = new DataInputStream(myServer.getInputStream());
            DataOutputStream dos = new DataOutputStream(myServer.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String mess="";
            while(true){
                int select=dis.read();
                switch(select){
                    case 1:
                        mess=dis.readUTF();
                        String[] b = mess.split("\\$");
                        KhachHang kh1 = new KhachHang(b[0], b[1], b[2]);
                        list.add(kh1);
                        save(list, "khachhang.txt");
                        dos.writeUTF("Them thanh cong");
                        break;
                    case 2:
                        int i=0;
                        String timTen=dis.readUTF();
                        int n=dis.read();
                        for(KhachHang kh2: list){
                            if(timTen.equalsIgnoreCase(kh2.getTenKH())){
                                mess=kh2.toString()+","+ " Tong tien: "+ kh2.tinhTien(n)+"\n";
                                i++;
                            }
                           
                        }
                        if(i==0){
                            mess="Khong tim thay ten khach hang";
                        }
                        dos.writeUTF(mess);
                        
                        break;
                    case 3:
                        break;
                        default:
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
