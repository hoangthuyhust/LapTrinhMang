/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau1;

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
            DatagramSocket myServer = new DatagramSocket(1024);
            byte[] receive = new byte[1024];
            int len = receive.length;
            DatagramPacket receiveData = new DatagramPacket(receive, len);
            myServer.receive(receiveData);
            String s = (new String(receiveData.getData(), 0, receiveData.getLength())).trim();
            String str = s.toUpperCase();
            byte[] send = new byte[1024];
            send = str.getBytes();
            int lenght = send.length;
            InetAddress add = receiveData.getAddress();
            int port = receiveData.getPort();
            DatagramPacket sendData = new DatagramPacket(send, lenght, add, port);
            myServer.send(sendData);
            myServer.close();
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
