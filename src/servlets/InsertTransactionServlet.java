package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AccountDAO;
import dao.TransaccionDAO;
import beans.Account;
import beans.Cliente;
import beans.Transaccion;

/**
 * Servlet implementation class InsertTransactionServlet
 */
@WebServlet("/InsertTransactionServlet")
public class InsertTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		double importe = Double.parseDouble(request.getParameter("importe"));
		TransaccionDAO.realizaTransaccion(origen, destino, importe);
		response.sendRedirect("loginok.jsp");
	}

}