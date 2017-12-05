package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getParameter("action")) {
		case "deleteAccount":
			try {
				request.getRequestDispatcher("/DeleteAccountsServlet").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").include(request, response);
			}
			break;
		case "detailsAccount":
			try {
				request.getRequestDispatcher("/ListTransactionsServlet").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").include(request, response);
			}
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		switch (request.getParameter("action")) {
		case "insertAccount":
			try {				
				request.getRequestDispatcher("/InsertAccountServlet").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").include(request, response);
			}
			break;
		case "insertTransaction":
			try {
				request.getRequestDispatcher("/InsertTransactionServlet").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("error.jsp").include(request, response);
			}	
			break;
		case "register":
			try {
				request.getRequestDispatcher("/RegisterServlet").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").include(request, response);
			}	
			break;
		case "update":
			try {
				request.getRequestDispatcher("/UpdateServlet").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").include(request, response);
			}	
			break;
		case "login":
			try {
				request.getRequestDispatcher("/LoginServlet").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").include(request, response);
			}
			break;
		case "logout":
			try {
				request.getRequestDispatcher("/LogoutServlet").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").include(request, response);
			}
			break;
		case "listAccounts":
			try {
				request.getRequestDispatcher("/ListAccountsServlet").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("error.jsp").include(request, response);
			}
			break;
		}
	}
}