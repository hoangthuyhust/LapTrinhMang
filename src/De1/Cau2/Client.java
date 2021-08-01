/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau2;

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
            Socket myClient = new Socket("localHost", 1039);
            System.out.println("Da ket noi thanh cong voi Server");
            DataInputStream dis = new DataInputStream(myClient.getInputStream());
            DataOutputStream dos = new DataOutputStream(myClient.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String mess="";
            
            while(true){
                String str=dis.readUTF();
                System.out.println(str);
                System.out.println("Nhap dap an:");               
                dos.writeUTF(sc.nextLine());
                mess=dis.readUTF();
                if(mess.equalsIgnoreCase("Incorrect")){
                    System.out.println("End game!");
                    return;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
}
