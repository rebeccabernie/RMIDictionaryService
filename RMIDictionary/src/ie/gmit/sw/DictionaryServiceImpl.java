package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

// Adapted from Distributed Systems RMI File Server Lab, needs to be changed

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> entryList = new ArrayList<String>(); // List of 100 words with definitions
	private String result = "Word not found! Try another."; // Default to word not found
	
	public DictionaryServiceImpl() throws RemoteException{
		super();
	}
	
	public ArrayList<String> loadDictionary() throws RemoteException {
		entryList.add("abate: means this");
		return entryList;
	}
	
	@Override
	public String lookUp(String word) throws RemoteException {
		for(String line: entryList) {
			if (line.startsWith(word))
				return line;
		}
		return result; // returns either word + definition or word not found
	} // end getDefinition

}
