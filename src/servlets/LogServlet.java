package servlets;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import com.sun.org.apache.xalan.internal.xsltc.runtime.InternalRuntimeError;

/**
 * Servlet implementation class LogServlet
 */
@WebServlet(name="LogServlet", urlPatterns="/LogServlet")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static Logger logger = LogManager.getLogger(LogServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        logger.info("init method execute");
        logger.error("init method execute");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hilo principal");
		
		final PrintWriter html = response.getWriter();
		html.println("<html>");
		html.println("<body>");
		html.println("SUBIENDO FICHEROS");
		final AsyncContext contextAsinc = request.startAsync();
		contextAsinc.start( new Runnable() {
			@Override
			public void run() {
				System.out.println("Hilo nuevo");
				try {
					Thread.sleep(10000);;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			contextAsinc.complete();
			}
		});
		
		html.println("</body>");
		html.println("</html>");
		html.close();
		
		/*logger.trace("Trace Message!");
		logger.debug("Debug Message!");
		logger.info("Info Message!");
		logger.warn("Warn Message!");
		logger.error("Error Message!");
		logger.fatal("Fatal Message!");*/
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
