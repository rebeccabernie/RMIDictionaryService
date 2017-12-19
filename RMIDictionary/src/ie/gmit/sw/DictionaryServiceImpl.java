package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

// Adapted from Distributed Systems RMI File Server Lab, needs to be changed

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	
	
	private ArrayList<String> entryList = new ArrayList<String>(); // Store 100 words with definitions in ArrayList
	private String result = "Word not found! Try another."; // Default to word not found

	public DictionaryServiceImpl() throws RemoteException{
		super();
	}
	
	public ArrayList<String> loadDictionary() throws RemoteException {
		ArrayList<String> entryList = new ArrayList<String>(); // List of 100 words with definitions
		
		try(BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"))) {
			// Read the file line by line, add each line to the list of words/definitions
			for(String line; (line = br.readLine()) != null; )
		        entryList.add(line);
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		return entryList;
	}
	
	@Override
	public String lookUp(String word) throws RemoteException {
		for(String line: this.entryList) {
			if (line.startsWith(word))
				result = line;
		}
		return result; // returns either word + definition or word not found
	} // end getDefinition

}
