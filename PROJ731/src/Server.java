
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Server  {
	
	
	
    static int clientNumber=10;
    protected Server() throws Exception {
    	
        super();
        
        
    }

   
    public  static void  main(String[] args) throws MalformedURLException, RemoteException, FileNotFoundException, NotBoundException, AlreadyBoundException{
    	Registry registry = LocateRegistry.getRegistry(2000);
        try {
        	Splitter splitter = new Splitter();
        	
            // Bind the remote object's stub in the registry
            splitter.split("C:\\Users\\besbe\\eclipse-workspace\\PROJ731\\src\\text.txt", clientNumber);
            System.out.println("File splitted to "+clientNumber+" files");
            System.err.println("Server ready");

        } catch (Exception e) {
            	System.err.println("Server exception: " + e.toString());
            	e.printStackTrace();
        }
            	System.out.println("Creating the "+clientNumber+" machines ... ");
          for (int i =0 ; i<clientNumber;i++) {
            	String filename = "split"+String.valueOf(i+1)+".txt";
            		Client c = new Client(i+1, filename);
            		String name="Client"+String.valueOf(i+1);
            		Iclient iclient = (Iclient) UnicastRemoteObject.exportObject(c, 0);	
            		registry.bind(name, iclient);
         		
            }
          System.out.println(clientNumber+" machines are created");
        //  ReducerImp red = new ReducerImp();
          	//Registry registry = LocateRegistry.getRegistry(2000);
  			//Mapper Mapperstub =   (Mapper) registry.lookup("Client");
        

    }
    



}       
 