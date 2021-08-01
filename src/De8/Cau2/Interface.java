/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8.Cau2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Admin
 */
public interface Interface extends Remote{
    public float sum(float a, float b) throws RemoteException;
    public float sub(float a, float b) throws RemoteException;
    public float mul(float a, float b) throws RemoteException;
    public float div(float a, float b) throws RemoteException;
    public float UCLN(float a, float b) throws RemoteException;
    
}
