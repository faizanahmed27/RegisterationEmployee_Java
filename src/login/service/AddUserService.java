package login.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import resgistration.auth.pojo.UserPojo;

public class AddUserService {
	
	
	static Connection conn=null;
	
	//insert
	
		
	//public static UserPojo pojo(UserPojo user){
		
		
	public static int insertdata(UserPojo user)throws SQLException
	{
		PreparedStatement ps=null;
		
		     
	      String id = user.getId();
	      String name = user.getName();
	      String address = user.getAddress();
	      String con_no = user.getMob();
	      
		
		String Query = "insert into info values(?,?,?,?)";
		
		       
		   System.out.println("Your id is " + id);
		   System.out.println("Your name is " + name);
		   System.out.println("Your address is " + address);
		   System.out.println("Your mobile no is " + con_no);
		   
		   System.out.println("Query: "+Query);
		   
		   int status = 0;
		   try{
		
			   conn = ConnectionManager.getConnection();
			   
			   ps = conn.prepareStatement(Query);
			   
			   ps.setString(1, user.getId());
			   ps.setString(2, user.getName());
			   ps.setString(3, user.getAddress());
			   ps.setString(4, user.getMob());
			   
			   ps.executeUpdate();
			   
		
		

	
		   }catch(Exception ex){
			   System.out.println(ex);
		   }
		
		return status;
		}	
	
	
	//List data
	
public static List<UserPojo> getAllUser(){  
    
	List<UserPojo> list=new ArrayList<UserPojo>();  
      
    try{  
         conn=ConnectionManager.getConnection();  
        PreparedStatement ps=conn.prepareStatement("select * from info");  
        ResultSet rs=ps.executeQuery();  
       
        while(rs.next()){  
            UserPojo userpojo=new UserPojo();  
           
            userpojo.setId(rs.getString(1));  
            userpojo.setName(rs.getString(2));  
            userpojo.setAddress(rs.getString(3));  
            userpojo.setMob(rs.getString(4));  
             
            list.add(userpojo);  
        }  
        conn.close();  
    }catch(Exception e){
    	
    	e.printStackTrace();}  
      
    return list;  
}  

//Delete Data

public static int deletedata(String id){
	
	int status = 0;
	
	try{
		
		conn = ConnectionManager.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from info where id=?");
		
		ps.setString(1, id);
		
		status = ps.executeUpdate();
		
		conn.close();
		
		}catch(Exception ex){
		
		ex.printStackTrace();
	}
	
	return status;
	
	
}

//Update Data

 
public static UserPojo getUserById(String id) {
    
	UserPojo u = new UserPojo();
	
	try{
		
		conn = ConnectionManager.getConnection();
		PreparedStatement pps = conn.prepareStatement("select * from info where id=?");
		
		pps.setString(1, id);
		
		
		ResultSet rs = pps.executeQuery();
		
		
		if(rs.next()){
			
			u.setId(rs.getString(1));
			u.setName(rs.getString(2));
			u.setAddress(rs.getString(3));
			u.setMob(rs.getString(4));
			
		}
		
		conn.close();
		
	}catch(Exception exp){
		
		System.out.println(exp);
	}
	return u;
	
}

public static int updateUser(UserPojo userPojo) {
    
	int status=0;
	
	try{
		
		conn = ConnectionManager.getConnection();
		PreparedStatement pst = conn.prepareStatement("update info set name=?,address=?,cont_no=? where id=?  ");
		
		//,add='"+userPojo.getAddress()+"',cont_no='"+userPojo.getMob()+"'
		
		pst.setString(1, userPojo.getName());
		pst.setString(2, userPojo.getAddress());
		pst.setString(3, userPojo.getMob());
		pst.setString(4, userPojo.getId());
		
		//System.out.println("update:- " +userPojo.getId()+ "," +userPojo.getName()+ "," +userPojo.getAddress()+ "," +userPojo.getMob());
		
		status = pst.executeUpdate();
		
		}catch(Exception ex1){
		System.out.println(ex1);
	}
	return status;

}

}

//public static boolean updateUser(UserPojo userPojo)throws Exception{
//	
//	String query = "UPDATE data SET name=?, add=?, cont_no=?" + " Where id=?";
//	
//	conn = ConnectionManager.getConnection();
//	PreparedStatement ps1 = conn.prepareStatement(query);
//	
//	ps1.setString(1, userPojo.getName());
//	ps1.setString(2, userPojo.getAddress());
//	ps1.setString(3, userPojo.getMob());
//	ps1.setString(4, userPojo.getId());
//	
//	boolean rowUpdated = ps1.executeUpdate()>0;
//	ps1.close();
//	
//	return rowUpdated;
//	
//	}
//
//
//public UserPojo getUserById(String id)throws Exception{
//	
//	UserPojo user = new UserPojo();
//	
//	conn = ConnectionManager.getConnection();
//	
//	PreparedStatement ps2 = conn.prepareStatement("select * from data where id=?");
//	
//	ps2.setString(1, id);
//	
//	ResultSet rs1 = ps2.executeQuery();
//	
//	if(rs1.next()){
//		
//		user.setId(rs1.getString("id"));
//		user.setName(rs1.getString("name"));
//		user.setAddress(rs1.getString("add"));
//		user.setMob(rs1.getString("cont_no"));
//		
//	}
//	
//	return user;
//	
//	
//}

 
	
	
	

