package ie.gmit.sw;

import java.rmi.RemoteException;
import java.util.ArrayList;

// Adapted from Distributed Systems RMI File Server Lab, needs to be changed

public interface DictionaryService {
	
	public byte[] getFile(String filename) throws RemoteException;
	
	public ArrayList<String> getFileNames() throws RemoteException;
	
	public void uploadFile(String fileName, byte[] bytes) throws RemoteException;

}
