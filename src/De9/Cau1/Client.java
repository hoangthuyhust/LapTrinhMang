/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De9.Cau1;

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
            Socket myClient = new Socket("localHost", 1032);
            System.out.println("Da ket noi thanh cong voi Server");
            System.out.println("Nhap vao thang, nam: ");
            Scanner sc = new Scanner(System.in);
            int thang = sc.nextInt();
            int nam = sc.nextInt();
            DataInputStream dis = new DataInputStream(myClient.getInputStream());
            DataOutputStream dos = new DataOutputStream(myClient.getOutputStream());
            dos.write(thang);
            dos.write(nam);
            String text = dis.readUTF();
            System.out.println(text);
            myClient.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
