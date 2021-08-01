/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De7.Cau2;

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
            Socket myClient = new Socket("localhost", 7000);
            System.out.println("Da ket noi thanh cong voi Server");
            DataInputStream dis = new DataInputStream(myClient.getInputStream());
            DataOutputStream dos = new DataOutputStream(myClient.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String mess="";
            int select=0;
            while(true){
                System.out.println("1. Them khach hang");
                System.out.println("2. Thanh toan tien");
                System.out.println("3. Thoat");
                System.out.println("Moi ban chon: ");
                select=sc.nextInt();
                dos.write(select);
                switch(select){
                    case 1:
                        System.out.println("Nhap thong tin khach hang can them: ");
                        System.out.println("Ma khach hang: ");
                        sc.nextLine();
                        String ma=sc.nextLine();
                        System.out.println("Ten khach hang: ");
                        String ten = sc.nextLine();
                        System.out.println("Loai phong: ");
                        String loai=sc.nextLine();
                        mess=ma+"$"+ten+"$"+loai;
                        dos.writeUTF(mess);
                        System.out.println(dis.readUTF());
                        break;
                    case 2:
                        System.out.println("Nhap ten khach hang: ");
                        sc.nextLine();
                        String timTen=sc.nextLine();
                        dos.writeUTF(timTen);
                        System.out.println("Nhap so ngay: ");
                        int n=sc.nextInt();
                        dos.write(n);
                        mess=dis.readUTF();
                        System.out.println(mess);
                        break;
                    case 3:
                        break;
                        default:
                            
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
