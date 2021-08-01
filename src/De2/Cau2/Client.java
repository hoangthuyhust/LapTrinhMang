/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Registry reg = LocateRegistry.getRegistry("localhost", 2000);
        InterfaceWord interfaceWord = (InterfaceWord) reg.lookup(("RMI"));
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.println("1. Chuyen tu viet tat sang day du");
            System.out.println("2. Chuyen tu day du sang viet tat");
            System.out.println("3. Ket thuc");
            System.out.println("Moi ban chon");
            int chon = sc.nextInt();
            switch(chon){
                case 1:
                    System.out.println("Nhap tu viet tat:");
                    sc.nextLine();
                    String tat = sc.nextLine();
                    System.out.println("Tu day du:"+interfaceWord.convert_tat_dayDu(tat));
                    break;
                case 2:
                    System.out.println("Nhap tu day du:");
                    sc.nextLine();
                    String dayDu = sc.nextLine();
                    System.out.println("Tu viet tat:"+interfaceWord.convert_dayDu_tat(dayDu));
                    break;
                case 3:
                    return;
            }
        }
    }
}
