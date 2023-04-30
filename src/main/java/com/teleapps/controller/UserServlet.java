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
import com.teleapps.model.ModalPer;
import com.teleapps.model.User;
import com.teleapps.repostitory.Login;
import com.teleapps.repostitory.DaoClass;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoClass userDAO;  
    
	public void init() {
		userDAO = new DaoClass();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = (String) request.getParameter("action");		
		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertUser(request, response);
				break;
			case "delete":
				deleteUser(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Role.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		request.setAttribute("user", existingUser);
		
		dispatcher.forward(request, response);
		Login lg=new Login();
		ArrayList<Bean> list = lg.UsersData();				
		 request.setAttribute("result",list);
		 ArrayList<Bean> Roleper = lg.RolePermission();	
		 request.setAttribute("permission", Roleper);
		 List<ModalPer> permision = lg.modalpermission();
		 request.setAttribute("modalper", permision);
		 List<User> listUser = userDAO.selectAllUsers();
		 request.setAttribute("listUser", listUser);
		 HttpSession session=request.getSession(false);
	       String username=(String)session.getAttribute("usernames");
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

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String Role = request.getParameter("Role");
		User newUser = new User(id, Role);	
		userDAO.insertUser(newUser);
		
		Login lg=new Login();
		 ArrayList<Bean> list = lg.UsersData();				
		 request.setAttribute("result",list);
		 ArrayList<Bean> Roleper = lg.RolePermission();	
		 request.setAttribute("permission", Roleper);
		 List<ModalPer> permision = lg.modalpermission();
		 request.setAttribute("modalper", permision);
		 List<User> listUser = userDAO.selectAllUsers();
		 request.setAttribute("listUser", listUser);
		 HttpSession session=request.getSession(false);
	       String username=(String)session.getAttribute("usernames");
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

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String Role = request.getParameter("Role");
		

		 User book = new User(id, Role);
		 userDAO.updateUser(book);
		 Login lg=new Login();
		 ArrayList<Bean> list = lg.UsersData();				
		 request.setAttribute("result",list);
		 ArrayList<Bean> Roleper = lg.RolePermission();	
		 request.setAttribute("permission", Roleper);
		 List<ModalPer> permision = lg.modalpermission();
		 request.setAttribute("modalper", permision);
		 List<User> listUser = userDAO.selectAllUsers();
		 request.setAttribute("listUser", listUser);
		 HttpSession session=request.getSession(false);
	       String username=(String)session.getAttribute("usernames");
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

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 
		 userDAO.deleteUser(id);
		 Login lg=new Login();
		 ArrayList<Bean> list = lg.UsersData();				
		 request.setAttribute("result",list);
		 ArrayList<Bean> Roleper = lg.RolePermission();	
		 request.setAttribute("permission", Roleper);
		 List<ModalPer> permision = lg.modalpermission();
		 request.setAttribute("modalper", permision);
		 List<User> listUser = userDAO.selectAllUsers();
		 request.setAttribute("listUser", listUser);
		 HttpSession session=request.getSession(false);
	       String username=(String)session.getAttribute("usernames");
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