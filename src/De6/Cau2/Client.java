/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De6.Cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket myClient = new Socket("LocalHost", 1060);
            System.out.println("Da ket noi thanh cong voi Server");
            Scanner sc = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(myClient.getInputStream());
            DataOutputStream dos = new DataOutputStream(myClient.getOutputStream());
            int select=0;
            String mess="";
            while(true){
                System.out.println("1. Hien thi danh sach nha trong chung cu");
                System.out.println("2. Them  nha vao chung cu");
                System.out.println("3. Mua nha");
                System.out.println("4. Thoat");
                System.out.println("Moi ban chon: ");
                select=sc.nextInt();
                dos.write(select);
                switch(select){
                    case 1:
                        mess="";
                        mess+=dis.readUTF();
                        System.out.println(mess);
                        break;
                    case 2:
                        mess="";
                        System.out.println("Nhap thong tin nha can them: ");
                        System.out.println("So nha: ");
                        int soNha=sc.nextInt();
                        System.out.println("Nhap gia ban: ");
                        float giaBan=sc.nextFloat();
                        System.out.println("Tinh trang: ");
                        sc.nextLine();
                        String tinhtrang=sc.nextLine();
                        mess=soNha+"$"+giaBan+"$"+tinhtrang;
                        dos.writeUTF(mess);
                        System.out.println(dis.readUTF());
                        break;
                    case 3:
                        System.out.println("Nhap so nha can mua: ");
                        int s = sc.nextInt();
                        dos.write(s);
                        System.out.println(dis.readUTF());
                        break;
                    case 4:
                        return;
                        default:
                            System.out.println(dis.readUTF());
                        
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
