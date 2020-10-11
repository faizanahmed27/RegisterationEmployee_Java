package login.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.sun.java.swing.plaf.windows.WindowsOptionPaneUI;
import com.sun.java.swing.plaf.windows.WindowsPopupMenuSeparatorUI;
import com.sun.java.swing.plaf.windows.resources.windows;

import resgistration.auth.pojo.UserPojo;
import login.service.AddUserService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 

ServletException, IOException {
		
		
		
	
		
		String i = request.getParameter("id");
		System.out.println("i------------"+i);
		UserPojo us = AddUserService.getUserById(i);
		//System.out.println("us....." +us);
		
		request.setAttribute("id", us.getId());
		request.setAttribute("name", us.getName());
		request.setAttribute("addr", us.getAddress());
		request.setAttribute("mob", us.getMob());
		
		System.out.println("id,name,address,mobile no:- " +us.getId()+ ", " +us.getName()+ ", " +us.getAddress()+ ", " +us.getMob());
		
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 

ServletException, IOException {
		
			response.setContentType("text/html");
			
			PrintWriter writer = response.getWriter();
		
	try{
		
		String id1 =  request.getParameter("id");  //this "id" coming from update.jsp page... 
		String name1 = request.getParameter("uname");		//this "uname" coming from update.jsp page... 
		String address1 = request.getParameter("add");	//this "add" coming from update.jsp page... 
		String mobno = request.getParameter("mob");		//this "mob" coming from update.jsp page... 
		
		UserPojo userPojo = new UserPojo();
		
		userPojo.setId(id1);
		userPojo.setName(name1);
		userPojo.setAddress(address1);
		userPojo.setMob(mobno);
		
		AddUserService.updateUser(userPojo);
		
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
		}catch(Exception ex){
			
			System.out.println(ex);
		}
	}

}
