/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    public static void main(String[] args) {
        ArrayList<CauHoi> list=new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("cauhoi.txt"));
            String s="";
            while((s=br.readLine())!=null){
                String[] a = s.split("\\$");
                if(a.length==3){
                    CauHoi ques = new CauHoi(a[0], a[1], a[2]);
                    list.add(ques);
                }
                
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ServerSocket server = new ServerSocket(1039);
            System.out.println("Dang doi...");
            Socket myServer = server.accept();
            System.out.println("Da ket noi thanh cong voi Client");
            DataInputStream dis = new DataInputStream(myServer.getInputStream());
            DataOutputStream dos = new DataOutputStream(myServer.getOutputStream());
            String mess="";
            for(CauHoi ch: list){
                String str=ch.getCauHoi()+"\n"+ch.getLuaChon();
                dos.writeUTF(str);
                String dapAn = dis.readUTF();
                if(dapAn.equalsIgnoreCase(ch.getDapAn())){
                    mess="Correct";
                    dos.writeUTF(mess);
                }else{
                    mess="Incorrect";
                    dos.writeUTF(mess);
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
