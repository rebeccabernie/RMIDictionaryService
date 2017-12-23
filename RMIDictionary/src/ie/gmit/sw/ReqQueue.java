package ie.gmit.sw;

import java.rmi.Naming;
import java.util.ArrayDeque;
import java.util.Queue;

// Request Queue class - handles incoming requests, what to do with those requests
// Also handles outgoing responses

public class ReqQueue implements Runnable{
	
	// Spec asked for Map - tried LinkedHashMap / HashMap, got working with Queues, will try maps if time
	
	private Queue<String> requestQueue; // Queue for incoming requests
	private Queue<String> responseQueue; // Queue for outgoing responses
	private String message; // Message / status / response

	public ReqQueue(String word) {
		// Using Array Deques - "likely to be faster than LinkedList when used as a queue"
		// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html
		requestQueue = new ArrayDeque<>();
		responseQueue = new ArrayDeque<>();
		this.requestQueue.add(word);
	}
	
	public void queueRequest(String request) { // Queues a request -> add to the queue and then carry it out
		requestQueue.add(request);
		doRequest();
	}

	// Needed for threading
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
			} else {} // Do nothing
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
