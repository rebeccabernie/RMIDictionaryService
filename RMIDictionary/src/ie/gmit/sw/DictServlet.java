package ie.gmit.sw;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet implementation class DictServlet

@WebServlet("/DictServlet")
public class DictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result = "Error / Word Not Found";

    // @see HttpServlet#HttpServlet()
    public DictServlet() {
        super();
    }
    
	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("given_word");

		try {
			DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
			result = ds.lookUp(query);
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("query", query);
		request.setAttribute("result", result);
		javax.servlet.RequestDispatcher dp = request.getRequestDispatcher("/definition.jsp");
		dp.forward(request, response);

	}

	// @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
