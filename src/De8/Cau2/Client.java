/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8.Cau2;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
            Registry reg = LocateRegistry.getRegistry("localhost", 7000);
            Interface ni = (Interface) reg.lookup("RMI");
            System.out.println("Nhap vao hai so a, b: ");
            Scanner sc = new Scanner(System.in);
            float a =sc.nextFloat();
            float b=sc.nextFloat();
            int select=0;
            while(true){
                System.out.println("1. Cong");
                System.out.println("2. Tru");
                System.out.println("3. Nhan");
                System.out.println("4. Chia");
                System.out.println("5. UCLN");
                System.out.println("6. Thoat");
                System.out.println("Moi ban chon: ");
                select=sc.nextInt();
                switch(select){
                    case 1:
                        System.out.println("Tong: "+ni.sum(a, b));
                        break;
                    case 2:
                        System.out.println("Hieu: "+ni.sub(a, b));
                        break;
                    case 3:
                        System.out.println("Tich: "+ni.mul(a, b));
                        break;
                    case 4:
                        System.out.println("Thuong: "+ni.div(a, b));
                        break;
                    case 5:
                        System.out.println("UCLN: "+ni.UCLN(a, b));
                        break;
                    case 6:
                        break;
                        default:
                            System.out.println("Moi nhap lai: ");
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
