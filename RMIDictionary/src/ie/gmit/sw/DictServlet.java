package ie.gmit.sw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet implementation class DictServlet

@WebServlet("/DictServlet")
public class DictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReqQueue rq;
	
    // @see HttpServlet#HttpServlet()
    public DictServlet() {
        super();
    }
    
	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response, String status) throws ServletException, IOException {
		response.getWriter().append(status);
		response.sendRedirect("homepage.jsp?message=" + status); // displays error / definition in url
	}

	// @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (rq == null) { // If the ReqQueue object is empty, create new instance / start new thread			
			rq = new ReqQueue(request.getParameter("query"));
			new Thread(rq).start();
		} else {
			rq.queueRequest(request.getParameter("query")); // Add the request to the queue
		}
		try {
			
			Thread.sleep(1000);
			String status = rq.getResponse(); // Calls poll() on queue - item at head of queue
			doGet(request, response, status);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
