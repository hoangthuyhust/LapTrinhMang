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
import javafx.scene.chart.PieChart;

/**
 *
 * @author Admin
 */
public class Client {
    DatagramSocket socket;
    DatagramPacket packet;
    public void connect(){
        try {
            socket= new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void senData(String s){
        
        try {
            byte[] guiDL = new byte[1024];
            guiDL=s.getBytes();
            int len = guiDL.length;
            InetAddress add = InetAddress.getByName("localHost");
            packet = new DatagramPacket(guiDL, len, add, 6000);
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
        Client m = new Client();
        m.connect();
        Scanner sc = new Scanner(System.in);
        int select;
        String mess="";
        while(true){
            System.out.println("1. Thu tien");
            System.out.println("2. Chi tien");
            System.out.println("3. Xem so du");
            System.out.println("4.Lich su giao dich");
            System.out.println("5. Thoat");
            System.out.println("Moi ban chon: ");
            select=sc.nextInt();
            m.senData(String.valueOf(select));
            switch(select){
                case 1:
                    System.out.println("Nhap so tien can thu: ");
                    int thu = sc.nextInt();
                    m.senData(String.valueOf(thu));
                    System.out.println("Da thu: " +thu);
                    break;
                case 2:
                    System.out.println("Nhap so tien can chi: ");
                    int chi=sc.nextInt();
                    m.senData(String.valueOf(chi));
                    System.out.println("Da chi: "+chi);
                    break;
                case 3:
                    int soDu=Integer.parseInt(m.receiveData());
                    System.out.println("So du: "+ soDu);
                    break;
                case 4:
                    mess=m.receiveData();
                    System.out.println(mess);
                    break;
                case 5: 
                    break;
                    default:
                        
                        
                    
            }
        }
    }
    
}
