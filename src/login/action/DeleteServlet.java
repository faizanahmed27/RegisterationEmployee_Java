package login.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resgistration.auth.pojo.UserPojo;
import login.service.AddUserService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
//		String[] userId = request.getParameterValues("deleteuser");
//		
//		for(int i=0;i<userId.length;i++){
//			
//			String id = request.getParameter("deleteUser");
//			
//			UserPojo pojo = new UserPojo();
//			
//			pojo.setId(id);
//			
//			AddUserService adus = new AddUserService();
//			
//			adus.deletedata(id);
			
			
					
			
			
		
		
		
		
		String rid = request.getParameter("id");
		
		
		String id = rid;
		
		AddUserService.deletedata(id);
		RequestDispatcher rdr = request.getRequestDispatcher("list.jsp");
		rdr.forward(request, response);		
		
		
		//response.sendRedirect("list.jsp");
		
	}

}

