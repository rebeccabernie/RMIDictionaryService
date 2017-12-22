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
		System.out.print("Number of entries: ");
		System.out.println(entryList.size());
		//System.out.println("Dictionary contents: " + entryList);

		// Make a remote invocation to the service to get the given word
		String definition = ds.lookUp("abate"); // Testing with first word in file
		System.out.println("Fetching definition...");
		Thread.sleep(2000);
		System.out.println(definition);

	}

}
