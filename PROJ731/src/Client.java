

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Client implements Iclient{
	int id; 
	static String filename;
	
	public HashMap<String,Integer> map = new HashMap<String, Integer>();
	public HashMap<String,Integer> red = new HashMap<String, Integer>();
	
	public Client(int id,String filename) throws MalformedURLException, RemoteException, FileNotFoundException, NotBoundException, AlreadyBoundException {
		
		this.id = id;
		this.filename=filename;
		this.start();
		
	}

	public void start()throws MalformedURLException, RemoteException, FileNotFoundException, NotBoundException, AlreadyBoundException{
		Registry registry = LocateRegistry.getRegistry(2000);
		Mapper Mapperstub =   (Mapper) registry.lookup("Mapper");
		this.map=Mapperstub.map("split"+String.valueOf(this.id)+".txt");
		System.out.println(this.map);
		//this.red=Reducerstub.reduce(map);
		

	}
	
	public HashMap<String,Integer> getHashMap() throws RemoteException{
		return this.map;
	}
	
	

}

