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
import javax.servlet.http.HttpSession;

import com.teleapps.model.Bean;
import com.teleapps.model.User;
import com.teleapps.model.ModalPer;
import com.teleapps.repostitory.Login;
import com.teleapps.repostitory.DaoClass;





/**
 * Servlet implementation class LoginServlets
 */
@WebServlet("/LoginServlets")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() {
		Login lg = new Login();
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		 
		 HttpSession session=request.getSession();  
	        session.setAttribute("usernames",username);  
		
		Bean po =new Bean();
        po.setUsername(username);
        po.setPassword(password);
 


      //  String email=po.getEmail();
	
		Login lg=new Login();
		
		DaoClass userDAO=new DaoClass();
		User us=new User();
		//pojorole ro=new pojorole();
          boolean status = lg.LoginData(po);
			 if(status == true) {
				 
				 ArrayList<Bean> list = lg.UsersData();				
				 request.setAttribute("result",list);
				 ArrayList<Bean> Roleper = lg.RolePermission();	
				 request.setAttribute("permission", Roleper);
				
			     ArrayList<Bean> dropdown = lg.Dropdown();	
				 request.setAttribute("list", dropdown);
				 List<User> listUser = userDAO.selectAllUsers();
				 request.setAttribute("listUser", listUser);
				
					
					List<User> existingUser=lg.RoleList();
					request.setAttribute("role", existingUser);
					List<ModalPer> permision = lg.modalpermission();
					request.setAttribute("modalper", permision);
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

                 // request.setAttribute("checkmodal", mpcheck);
					 List<Bean> Editpro = lg.Profiles(username);
					 request.setAttribute("proedit", Editpro);
								
				 RequestDispatcher rd=getServletContext().getRequestDispatcher("/home.jsp");				
				 rd.forward(request, response);				 
			 }
			 else {
				 response.sendRedirect("unsucess.jsp");
			 }
		}



	}
