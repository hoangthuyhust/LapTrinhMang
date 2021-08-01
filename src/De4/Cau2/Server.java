/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De4.Cau2;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    public static void save(ArrayList<NhanVien> list, String path){
        try {
            FileWriter fw = new FileWriter(path);
            for(NhanVien nv: list){
                fw.write(nv.getHoTen()+"$"+nv.getNgaySinh()+"$"+nv.getChucDanh()+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("nhanvien.txt"));
            String s="";
            while((s=br.readLine())!=null){
                String[] arr=s.split("\\$");
                if(arr.length==3){
                    NhanVien nv = new NhanVien(arr[0], arr[1], arr[2]);
                    list.add(nv);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ServerSocket server = new ServerSocket(1050);
            System.out.println("Dang doi...");
            Socket mySocket = server.accept();
            System.out.println("Da ket noi thanh cong voi Client");
            DataInputStream dis = new DataInputStream(mySocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(mySocket.getOutputStream());
            int select=0;
            String mess="";
            while(select!=4){
                select=dis.read();
                switch(select){
                    case 1:
                        mess="";
                        for(NhanVien nv: list){
                            mess+=nv.toString()+"\n";
                        }
                        dos.writeUTF(mess);
                        break;
                    case 2:
                        mess=dis.readUTF();
                        String[] a =mess.split("\\$");
                        NhanVien nv1=new NhanVien();
                        nv1.setHoTen(a[0]);
                        nv1.setNgaySinh(a[1]);
                        nv1.setChucDanh(a[2]);
                        list.add(nv1);
                        save(list, "nhanvien.txt");
                        dos.writeUTF("Them thanh cong");
                        break;
                    case 3:
                        mess="";
                        String t = dis.readUTF();
                        int i=0;
                        for(NhanVien nv2: list){
                            if(t.equalsIgnoreCase(nv2.getHoTen())){
                                mess+=nv2.toString()+"\n";
                                i++;
                            }
                        }
                        if(i==0){
                            mess="Khong tim thay";
                        }
                        dos.writeUTF(mess);
                        break;
                    case 4:
                        return;
                        default:
                            dos.writeUTF("Yeu cau chon lai: ");
                        
                }
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
