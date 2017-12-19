# RMIDictionaryService
> Rebecca Kane, G00320698  

> Module: Distributed Systems / 4th Year  
> Lecturer: Patrick Mannion  

Sample dictionary based on [100 Most Common SAT Words](http://education.yourdictionary.com/for-students-and-parents/100-most-common-sat-words.html). Copied, pasted and changed to csv format. Project specification states ~50 words is sufficient for this project.

## Requirements
Use the Servlet/JSP and Java RMI frameworks to develop a remote, asynchronous dictionary lookup service.  
A JSP page should provide users with the ability to specify a string which will be checkedagainst the dictionary.  
The HTML form information should be dispatched to a servlet that adds the client request to an in-queue and then returns a job ID to the web client.  
The web client should poll the web server periodically (every 10 seconds) and query if the request has been processed.  
Client requests in the inQueue should be periodically removed and processed (every 10 seconds).  

**Minimum Requirements**  
1. A web client request should be placed in a message queue to await processing. Each request should be allocated a job number. The job number should be added to an inQueue (a Map) along with the request string. The servlet handler should return the job number to the client which in turn should poll the server every 10 seconds for a response. When a response is received with a completed task, the result of the dictionary lookup should be displayed in the browser.
2. An interface called *DictionaryService* should expose a remote method with the following signature:  
`public String lookup(String s) throws RemoteException;`  
where `s` is the string to lookup in the dictionary, and the String returned is either the dictionary definition of `s` or the text *"String not found"*. In the *DictionaryServiceImpl*, before looking up the query string in the dictionary the thread should be put to sleep for a time, i.e. `Thread.sleep(1000)`, to slow the service down and simulate a real asynchronous service.
