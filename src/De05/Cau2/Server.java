/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De05.Cau2;

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
public class Server {
    DatagramSocket socket;
    DatagramPacket packet;
    public void connect(){
        try {
            socket=new DatagramSocket(6000);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void senData(String s){
        
        try {
            byte[] guiDL = new byte[1024];
            guiDL=s.getBytes();
            int len = guiDL.length;
            InetAddress add = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(guiDL, len, add, port);
            socket.send(packet);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String receiveData(){
        try {
            byte[] nhanDL= new byte[1024];
            int len = nhanDL.length;
            packet=new DatagramPacket(nhanDL, len);
            socket.receive(packet);
            String s = (new String(packet.getData(), 0, packet.getLength())).trim();
            return s;
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    public static void main(String[] args) {
        Server s = new Server();
        s.connect();
        Scanner sc = new Scanner(System.in);
        String mess="";
        int select=0;
        int tong=0;
        while(true){
            select=Integer.parseInt(s.receiveData());
            switch(select){
                case 1:
                    int thu = Integer.parseInt(s.receiveData());
                    tong+=thu;
                    mess+="Da thu: "+thu+"\n";
                    break;
                case 2:
                    int chi=Integer.parseInt(s.receiveData());
                    tong-=chi;
                    mess+="Da chi: "+chi+"\n";
                    break;
                case 3:
                    s.senData(String.valueOf(tong));
                    break;
                case 4:
                    mess+="Con lai: "+tong;
                    s.senData(mess);
                    break;
                case 5:
                    break;
                    default:
                        
            }
        }
    }
    
}
