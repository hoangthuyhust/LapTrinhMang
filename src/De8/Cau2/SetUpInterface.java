/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8.Cau2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Admin
 */
public class SetUpInterface extends UnicastRemoteObject implements Interface{

    public SetUpInterface() throws RemoteException{
        super();
    }
    

    @Override
    public float sum(float a, float b) throws RemoteException {
        return a+b;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float sub(float a, float b) throws RemoteException {
        return a-b;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float mul(float a, float b) throws RemoteException {
        return a*b;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float div(float a, float b) throws RemoteException {
        return a/b;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float UCLN(float a, float b) throws RemoteException {
         while(a!=b){
             if(a>b){
                 a-=b;
             }else{
                 b-=a;
             }
         }
         return a;
    }
    
}
