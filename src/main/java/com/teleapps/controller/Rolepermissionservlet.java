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

import com.teleapps.model.Bean;
import com.teleapps.model.User;
import com.teleapps.model.ModalPer;
import com.teleapps.repostitory.Login;
import com.teleapps.repostitory.DaoClass;

/**
 * Servlet implementation class Rolepermissionservlet
 */
@WebServlet("/Rolepermissionservlet")
public class Rolepermissionservlet extends HttpServlet {
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
		try {
			switch (action) {

			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				RoleupdateUsers(request, response);
				break;
			default:
				listUsers(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		 Login lg=new Login();
		 ArrayList<Bean> Roleper = lg.RolePermission();	
		 request.setAttribute("permission", Roleper);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		 dispatcher.forward(request, response);
	}
	
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
//			int id = Integer.parseInt(request.getParameter("id"));
			String username=request.getParameter("username");
		 //  Bean role=request.getParameter("role");
			Bean b=new Bean();
			System.out.println(username+"hiii");
			//System.out.println(Rrole+"your");
			
			//String role=request.getParameter("role");
		
			 List<User> existingUser=lg.RoleList();
			 System.out.println(existingUser+" "+"ROLE LIST");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
			request.setAttribute("user", username);
			request.setAttribute("role", existingUser);
		
			dispatcher.forward(request, response);
		
			 ArrayList<Bean> list = lg.UsersData();				
			 request.setAttribute("result",list);
			 ArrayList<Bean> Roleper = lg.RolePermission();	
			 
			 request.setAttribute("permission", Roleper);
			 
	
			 List<User> listUser = userDAO.selectAllUsers();
			 request.setAttribute("listUser", listUser);
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
		}
		private void RoleupdateUsers(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException, ServletException {
			
			 String username=request.getParameter("name");
			 String Role = request.getParameter("Role");
			 
			
			 Bean b = new Bean(username,Role);
			 Login lg=new Login();
			 lg.updateUsers(b);
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
			 //response.sendRedirect("home.jsp");
		}
}
