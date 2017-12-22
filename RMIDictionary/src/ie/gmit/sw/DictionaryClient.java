package ie.gmit.sw;

import java.rmi.Naming;
import java.util.ArrayList;

public class DictionaryClient {

	public static void main(String[] args) throws Exception {
		//Ask the registry running on localhost and listening in port 1099 for the instance of
		//the FileService object that is bound to the RMI registry with the name fileService.
		DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");

		// Make an RMI to get dictionary entries, ArrayList of entries is transferred over the network in serialized form
		ArrayList<String> entryList = ds.loadDictionary();

		//print the list of file names on the server to the console
		System.out.println("Number of entries: " + entryList.size()); // Error handling, given file has 100 definitions in it
		//System.out.println("Dictionary contents: " + entryList); // Un-comment out to print out full contents of dictionary

		// Make a remote invocation to the service to get the given word
		String definition = ds.lookUp("abate"); // Testing with first word in file
		System.out.println("Fetching definition...");
		Thread.sleep(2000);
		System.out.println(definition);

	}

}
