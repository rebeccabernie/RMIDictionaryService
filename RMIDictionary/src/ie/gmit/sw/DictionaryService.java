package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
//import java.util.ArrayList;

// Adapted from Distributed Systems RMI File Server Lab, needs to be changed

public interface DictionaryService extends Remote{
	
	public ArrayList<String> loadDictionary() throws RemoteException;
	
	public String lookUp(String word) throws RemoteException;
	

}
