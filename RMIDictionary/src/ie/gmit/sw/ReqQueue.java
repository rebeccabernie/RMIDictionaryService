package ie.gmit.sw;

import java.rmi.Naming;
import java.util.LinkedList;
import java.util.Queue;

// Request Queue class - handles incoming requests, what to do with those requests
// Also handles outgoing responses

public class ReqQueue implements Runnable{

	// Queue = java.util object for holding elements before processing them
	private Queue<String> requestQueue; // Queue for incoming requests
	private Queue<String> responseQueue; // Queue for outgoing responses
	private String message; // Message / status / response

	public ReqQueue(String word) {
		// Use 
		requestQueue = new LinkedList<>();
		responseQueue = new LinkedList<>();
		requestQueue.add(word);
	}
	
	public void queueRequest(String request) { // Queues a request -> add to the queue and then carry it out
		requestQueue.add(request);
		doRequest();
	}

	// Needed for threading - implements Runnable
	public void run() {
		doRequest();
	}


	public String getResponse() {
		return responseQueue.poll(); // Retrieve / remove object at head of queue
	}
	public void doRequest() { // Handles carrying out request and adding to the outgoing response queue
		try {

			if (requestQueue.peek() != null) { // Peek the queue, if empty do...
				DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService"); 
				this.message = ds.lookUp(requestQueue.poll().toLowerCase());
				responseQueue.add(message);
				// System.out.println(message);
			} else {} // Do nothing
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
