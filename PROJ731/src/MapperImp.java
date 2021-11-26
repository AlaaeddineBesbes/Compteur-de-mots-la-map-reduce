import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MapperImp  implements Mapper{


	protected MapperImp() throws RemoteException {
		super();
		
	}
	
	

	public HashMap<String, Integer> map(String filename) throws FileNotFoundException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<String> textLines = new ArrayList<String>();
		Scanner scan = new Scanner(new File("C:\\Users\\besbe\\eclipse-workspace\\PROJ731\\src\\"+filename));
		int i =0;
		while (scan.hasNextLine()){	
	    	String line = scan.nextLine();
	    	textLines.add(line);
	    	i++;	 	
	    }
		 for(int k=0; k<textLines.size(); k++) {
		    	String line = textLines.get(k);
		    	
		    	
		    	line = line.replaceAll("[^a-zA-Z0-9]", " "); 
		    	String[] pairs = line.split(" ");

		    	for (int k1=0;k1<pairs.length;k1++) {
		    	    String pair = pairs[k1];
		    	     
		    	     if (map.containsKey(pair)){ 	 
		    	    	 int k2= map.get(pair) ;
		    	         map.put(pair, k2 +1 );}
		    	     
		    	     else { map.put(pair, 1);}
		    	     
		    	 }
		    	
			  }
		
		return map;
		
		
	}
	
	 public  static void  main(String[] args) throws MalformedURLException, RemoteException, FileNotFoundException, NotBoundException{
	    	
	        try {
	        	
	        	MapperImp mapper = new MapperImp();	
	        	Registry registry = LocateRegistry.createRegistry(2000);
	            Mapper Mapperstub = (Mapper) UnicastRemoteObject.exportObject(mapper, 0);	
	            registry.bind("Mapper", Mapperstub);
	            	

	        } catch (Exception e) {
	            	System.err.println("Server exception: " + e.toString());
	            	e.printStackTrace();
	        }
	        

	    }
	     

}
