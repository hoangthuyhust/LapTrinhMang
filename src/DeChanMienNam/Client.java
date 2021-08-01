/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeChanMienNam;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Client {
    public static void menu(){
        System.out.println("----------------------");
        System.out.println("Thao tac voi tap tin:");
        System.out.println("1. Doc nhi phan");
        System.out.println("2. Ghi nhi phan");
        System.out.println("3. Doc van ban");
        System.out.println("4. Ghi van ban");
    }
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.getRegistry("localHost", 1099);
            Interface rmiApp= (Interface) reg.lookup("RMI");
            while(true){
                menu();
                int choice;
                Scanner sc = new Scanner(System.in);
                
                choice = sc.nextInt();
                String strFileName;
                String strBuff;
                sc.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Nhap ten file:");
                        strFileName = sc.nextLine();
                        System.out.println("File data: ");
                        System.out.println(Arrays.toString(rmiApp.ReadFileStream(strFileName)));
                        break;
                    case 2:
                        System.out.println("Nhap ten file:");
                        strFileName = sc.nextLine(); 
                        System.out.println("Nhap noi dung: ");
                        strBuff = sc.nextLine();
                        rmiApp.writeFileStream(strFileName, strBuff);
                        System.out.println("----------------------");
                        System.out.println("Ghi file thanh cong!");
                        break;
                    case 3:
                        System.out.println("Nhap ten file:");
                        strFileName = sc.nextLine();
                        System.out.println("File data: ");
                        System.out.println(rmiApp.ReadFileBuff(strFileName));
                        break;
                    case 4:
                        System.out.println("Nhap ten file:");
                        strFileName = sc.nextLine(); 
                        System.out.println("Nhap noi dung: ");
                        strBuff = sc.nextLine();
                        rmiApp.writeFileBuff(strFileName, strBuff);
                        System.out.println("----------------------");
                        System.out.println("Ghi file thanh cong!");
                        break;
                    default:
                        System.out.println("----------------------");
                        System.out.println("Lua chon khong phu hop!");
                        break;
                }
            }
        }catch(RemoteException | java.rmi.NotBoundException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
