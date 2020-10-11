package login.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import resgistration.auth.pojo.UserPojo;
import login.service.AddUserService;

public class AddUser extends HttpServlet{
	
	
	
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
	
	
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	

	
	try{
		
		String id = request.getParameter("id");        //this "id" coming from register.jsp page... 
		String name = request.getParameter("uname");   //this "uname" coming from register.jsp page...
		String address = request.getParameter("add");  //this "add" coming from register.jsp page...
		String mobno = request.getParameter("mob");    //this "mob" coming from register.jsp page...
		
		
		UserPojo userPojo = new UserPojo();
		
		userPojo.setId(id);
		userPojo.setName(name);
		userPojo.setAddress(address);
		userPojo.setMob(mobno);
		
		int status=AddUserService.insertdata(userPojo);
		
		
		if(request.getParameter("id").equals("") || request.getParameter("uname").equals("") || request.getParameter("add").equals("")
		|| request.getParameter("mob").equals("")){
			
			
	
			
	out.println("Record not Saved !!!");
	
	//request.getRequestDispatcher("dataError.jsp").include(request, response);
	request.getRequestDispatcher("register.jsp").include(request, response);	

}else{
	out.print("<p>Record saved successfully!</p>");  
	//request.getRequestDispatcher("register.jsp").include(request, response);
   response.sendRedirect("ListServlet");

}		
		
		
}catch(Exception ex){
		
		System.out.println(ex);
	}
	
}
}


