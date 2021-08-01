/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeChanMienNam;

import De6.Cau1.SetUpInterface;
import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String[] args){
      try{
            Registry reg = LocateRegistry.createRegistry(1099);
            RemoteRMI setup = new RemoteRMI();
            reg.bind("RMI", setup);
        }catch(RemoteException e){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
