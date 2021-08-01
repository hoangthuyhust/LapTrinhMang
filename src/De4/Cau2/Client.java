/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De4.Cau2;

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
            Socket myCient = new Socket("LocalHost", 1050);
            System.out.println("Da ket noi thanh cong voi Server");
            Scanner sc = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(myCient.getInputStream());
            DataOutputStream dos = new DataOutputStream(myCient.getOutputStream());
            int select=0;
            String mess="";
            while(select!=4){
                System.out.println("1. Hien thi danh sach sinh vien");
                System.out.println("2. Them nhan vien");
                System.out.println("3. Tim kiem nhan vien");
                System.out.println("4. Thoat");
                System.out.println("Moi ban chon: ");
                select=sc.nextInt();
                dos.write(select);
                switch(select){
                    case 1:
                        mess="";
                        mess=dis.readUTF();
                        System.out.println(mess);
                        break;
                    case 2:
                        mess="";
                        System.out.println("Nhap thong tin nhan vien can them: ");
                        System.out.println("Ho ten: ");
                        sc.nextLine();
                        String ten=sc.nextLine();
                        System.out.println("Ngay sinh: ");
                        String ns=sc.nextLine();
                        System.out.println("Chuc danh: ");
                        String cd=sc.nextLine();
                        mess=ten+"$"+ns+"$"+cd;
                        dos.writeUTF(mess);
                        System.out.println(dis.readUTF());
                        break;
                    case 3:
                        System.out.println("Nhap ten nhan vien can tim: ");
                        sc.nextLine();
                        String t = sc.nextLine();
                        dos.writeUTF(t);
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
