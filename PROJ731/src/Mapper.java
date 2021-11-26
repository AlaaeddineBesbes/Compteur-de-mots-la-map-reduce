import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;


public interface Mapper extends Remote  {
	public HashMap<String, Integer> map(String filename) throws FileNotFoundException, RemoteException;

}
