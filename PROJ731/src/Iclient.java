import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface Iclient extends Remote {
	public HashMap<String,Integer> getHashMap() throws RemoteException;


}
