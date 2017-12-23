package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

// Adapted from Distributed Systems RMI File Server Lab

public class DictionaryServiceSetup {
	
	public static void main(String[] args) throws Exception {

		// Create an instance of a DictionaryServiceImpl
		// DictionaryServiceImpl implements the DictionaryService interface, can be referred to as a DictionaryService type
		DictionaryService ds = new DictionaryServiceImpl();
		ds.loadDictionary();

		// Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);

		// Bind remote object to the registry with the name "dictionaryService"
		Naming.rebind("dictionaryService", ds); // Cast to Remote type

		// Output message
		System.out.println("Server connected.");

	}

}
