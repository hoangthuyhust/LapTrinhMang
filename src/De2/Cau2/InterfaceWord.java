/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Admin
 */
public interface InterfaceWord extends Remote{
     public String convert_dayDu_tat(String s) throws RemoteException;
     public String convert_tat_dayDu(String s) throws RemoteException;
}
