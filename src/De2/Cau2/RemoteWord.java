/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class RemoteWord extends UnicastRemoteObject implements  InterfaceWord
{
    public ArrayList<Word> listW;
    public RemoteWord (ArrayList<Word> list) throws RemoteException{
        super();
        listW = list;
    }

    
    @Override
    public String convert_dayDu_tat(String s) throws RemoteException{
        for(Word w:listW){
            if(s.equalsIgnoreCase(w.getDayDu())){
                return w.getTat();
            }       
        }
        return "Khong tim thay";
    }
       
    @Override
    public String convert_tat_dayDu(String s) throws RemoteException{
        for(Word w:listW){
            if(s.equalsIgnoreCase(w.getTat())){
                return w.getDayDu();
            }
        }
    return "Khong tim thay";
    }
}

