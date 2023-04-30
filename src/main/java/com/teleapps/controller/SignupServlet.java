package com.teleapps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teleapps.model.User;
import com.teleapps.model.Bean;
import com.teleapps.model.ModalPer;
import com.teleapps.repostitory.Login;
import com.teleapps.repostitory.SignupAction;
import com.teleapps.repostitory.DaoClass;

/**
 * Servlet implementation class Signupservlet
 */
@WebServlet("/Signupservlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private DaoClass userDAO;
	private Login lg;
	public void init() {
	     lg = new Login();
		 userDAO = new DaoClass();
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = (String) request.getParameter("action");		
		switch (action) {

		
		case "update2":
			try {
				updateprofile(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			userediteprofile(request, response);
			break;
		}
	}
	private void userediteprofile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		    String username=request.getParameter("name");
	        String email=request.getParameter("email");
			String password=request.getParameter("password1");
		
		
			Bean b=new Bean();
			b.setUsername(username);
		    b.setEmail(email);
		    b.setPassword(password);
		    
		    
		    SignupAction sa= new SignupAction();
		    ArrayList<Bean> status=sa.signupDetails(b);
            
            
            if(status != null) {
   			 RequestDispatcher rd=getServletContext().getRequestDispatcher("/Signupsucess.jsp");
   			 rd.forward(request, response);
   		 }
   		 else {
   			 response.sendRedirect("Signupunsucess.jsp");
   		 }
		   
			
	}
	private void updateprofile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		 
		   int id = Integer.parseInt(request.getParameter("ids"));
		   String username=request.getParameter("name");
	       String email=request.getParameter("email");
	       String password=request.getParameter("password");
	       Bean mp=new Bean(id,username,email,password);
	   	       lg.editupdate(mp);
	       
	         ArrayList<Bean> list = lg.UsersData();				
			 request.setAttribute("result",list);
			 ArrayList<Bean> Roleper = lg.RolePermission();	
			 request.setAttribute("permission", Roleper);
			 List<User> listUser = userDAO.selectAllUsers();
			 request.setAttribute("listUser", listUser);
			 List<ModalPer> permision = lg.modalpermission();
			 request.setAttribute("modalper", permision);
			 List<Bean> Editpro = lg.Profiles(username);
			 request.setAttribute("proedit", Editpro);
			 List<Object> modules=null;
				String mpcheck="";
				modules = lg.AllData(username);
				
				//List<String> mpcheckList = new ArrayList<String>();
				
				for( Object modulecheck:modules)
				{
				
					 //mpcheck += modulecheck.toString();						 
					// mpcheckList.add(mpcheck);
					 mpcheck = mpcheck +"," +modulecheck.toString();
					 
				}
				
				request.setAttribute("checkmodal", mpcheck);		
			 RequestDispatcher rd=getServletContext().getRequestDispatcher("/home.jsp");				
			 rd.forward(request, response);
	       
	       
	}


}
