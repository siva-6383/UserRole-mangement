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
 * Servlet implementation class modalpermissionservlet
 */
@WebServlet("/modalpermissionservlet")
public class ModalPermissionServlet extends HttpServlet {
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
				showEditForms(request, response);
				break;
			case "mpupdate":
				modalupdateper(request, response);
				break;
			default:
				selectmodaluser(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private static void selectmodaluser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Login lg=new Login();
		
		List<ModalPer> permision = lg.modalpermission();
		request.setAttribute("modalper", permision);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForms(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
//	
		List<ModalPer> permision = lg.modalpermission();
		
		 List<User> existingUser=lg.RoleList();
		 System.out.println(existingUser+" "+"ROLE LIST");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("mp.jsp");
		request.setAttribute("modalper", permision);
		request.setAttribute("role", existingUser);
		
		dispatcher.forward(request, response);
	
		 ArrayList<Bean> list = lg.UsersData();				
		 request.setAttribute("result",list);
		 ArrayList<Bean> Roleper = lg.RolePermission();	
		 
		 request.setAttribute("permission", Roleper);
		 

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
	private void modalupdateper(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
	       String modal=request.getParameter("modal");
	       String roles=request.getParameter("roles");
	       HttpSession session=request.getSession(false);
	       String username=(String)session.getAttribute("usernames");
	       ModalPer mp=new ModalPer(modal,roles);
	       Login lg=new Login();
	       lg.modalupdate(mp);
	       
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


