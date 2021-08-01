/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String[] args) throws RemoteException, FileNotFoundException, IOException {
        ArrayList<Word> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("word.txt"));
        String s = br.readLine();
        while (s!=null) {            
            String a[] = s.split("\\$");
            Word w = new Word(a[0], a[1]);
            list.add(w);
            s=br.readLine();
        }
        br.close();
        InterfaceWord interfaceWord = new RemoteWord(list);
        Registry reg = LocateRegistry.createRegistry(2000);
        reg.rebind("RMI", interfaceWord);
    }
}

