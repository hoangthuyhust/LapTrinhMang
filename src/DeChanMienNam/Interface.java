/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeChanMienNam;

import java.rmi.RemoteException;

/**
 *
 * @author Admin
 */
public interface Interface {
   //Ghi tap tin
    public int writeFileStream(String strFileName, String strBuf) throws RemoteException;
    //Doc tap tin
    public byte[] ReadFileStream(String strFileName) throws RemoteException;
    
    public int writeFileBuff(String strFileName, String strBuf) throws RemoteException;
    //Doc tap tin
    public String ReadFileBuff(String strFileName) throws RemoteException;
}
