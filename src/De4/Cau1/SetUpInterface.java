/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De4.Cau1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Admin
 */
public class SetUpInterface extends UnicastRemoteObject implements  NewInterface{

    public SetUpInterface() throws RemoteException{
    }
    

    @Override
    public int square(int a) throws RemoteException {
        return  a*a;
    }
    
}
