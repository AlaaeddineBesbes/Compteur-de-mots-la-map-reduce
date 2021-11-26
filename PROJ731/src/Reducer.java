import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

public interface Reducer extends Remote {
	public HashMap<String,Integer> reduce(List<HashMap<String,Integer>> map) throws FileNotFoundException,RemoteException;

}
