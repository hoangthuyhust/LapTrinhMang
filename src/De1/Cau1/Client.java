/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
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
public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket myClient = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap vao mot ki tu: ");
            String s=sc.nextLine();
            byte[] send = new byte[1024];
            send=s.getBytes();
            int len = send.length;
            InetAddress add =  InetAddress.getByName("localHost");
            DatagramPacket sendData = new DatagramPacket(send, len, add, 1024);
            myClient.send(sendData);
            byte[] receive = new byte[1024];
            int length = receive.length;
            DatagramPacket receiveData = new DatagramPacket(receive, length);
            myClient.receive(receiveData);
            String str=(new String(receiveData.getData(), 0, receiveData.getLength())).trim();
            System.out.println(str);
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
