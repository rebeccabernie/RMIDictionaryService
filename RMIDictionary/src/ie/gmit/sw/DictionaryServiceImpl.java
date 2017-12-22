package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Scanner;

// Adapted from Distributed Systems RMI File Server Lab, needs to be changed

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> entryList = new ArrayList<String>(); // List of 100 words with definitions
	private String result = "Word not found! Try another."; // Default to word not found
	
	public DictionaryServiceImpl() throws RemoteException{
		super();
	}
	
	public ArrayList<String> loadDictionary() throws RemoteException {
		Scanner s;
		if(entryList.isEmpty() == true) { // Only run if the list is empty
		try {
			// Load lines adapted from https://stackoverflow.com/a/5343727/7232648
			s = new Scanner(new File("dictionary.txt"));
			while (s.hasNextLine())
			    entryList.add(s.nextLine());
			
			s.close();
		
		} catch (IOException e) {
			e.printStackTrace();
			entryList.add("File not found");
		}}
		
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
