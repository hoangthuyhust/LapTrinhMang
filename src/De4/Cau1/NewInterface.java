/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De4.Cau1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Admin
 */
public interface NewInterface extends Remote{
    public int square(int a) throws RemoteException;
}
