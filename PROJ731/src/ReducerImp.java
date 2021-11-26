import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ReducerImp  implements Reducer  {
	
	public List<HashMap<String,Integer>> hashMapsList;
	protected ReducerImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public HashMap<String, Integer> reduce(List<HashMap<String,Integer>> hashMapsList) throws FileNotFoundException, RemoteException {
		 	HashMap<String, Integer> red = hashMapsList.get(0) ;	
		 		for (int i = 0; i < this.hashMapsList.size(); ++i) {
		 			for (Entry<String, Integer> m : this.hashMapsList.get(i).entrySet()) {
		 					if (red.containsKey(m.getKey())) 
		 						red.put(m.getKey(),  red.get(m.getKey()) + m.getValue());
	            
               else 
               red.put(m.getKey(), m.getValue());
               
	            
	            }
	        }

	        return red;
	
	      }
	
	
	
	 public   void  start()throws MalformedURLException, RemoteException, FileNotFoundException, NotBoundException{
		System.out.print("ll");
		 Registry registry = LocateRegistry.getRegistry(2000);
		 for(int i =0;i <10;i++) {
		 Iclient clientstub =   (Iclient) registry.lookup("Client"+String.valueOf(i));
		 hashMapsList.add(clientstub.getHashMap());   
	    }
		 System.out.print(reduce(hashMapsList));
		 }
		 





}
	 


