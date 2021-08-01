/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De7.Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket myServer = new DatagramSocket(1040);
            byte[] receive = new byte[1024];
            int len = receive.length;
            DatagramPacket receiveData = new DatagramPacket(receive, len);
            myServer.receive(receiveData);
            String str = (new String(receiveData.getData(), 0, receiveData.getLength())).trim();
            int so=Integer.parseInt(str);
            String text=" ";
            switch(so){
                case 0:
                    text="Khong";
                    break;
                case 1:
                    text="Mot";
                    break;
                case 2:
                    text="Hai";
                    break;
                case 3:
                    text="Ba";
                    break;
                case 4:
                    text="Bon";
                    break;
                case 5:
                    text="Nam";
                    break;
                case 6:
                    text="Sau";
                    break;
                case 7:
                    text="Bay";
                    break;
                case 8:
                    text="Tam";
                    break;
                case 9:
                    text="Chin";
                    break;
            }
            byte[] send = new byte[1024];
            send=text.getBytes();
            int length=send.length;
            InetAddress add = receiveData.getAddress();
            int port = receiveData.getPort();
            DatagramPacket sendData = new DatagramPacket(send, length, add, port);
            myServer.send(sendData);
            myServer.close();
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
