package services;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectdb.ConnectDB;

/**
 * Servlet implementation class AccountDetails
 */
public class AccountDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub0
		doGet(request, response);
		try
		{
		String name=request.getParameter("uname");
		String password=request.getParameter("upassword");
		Connection con=ConnectDB.connect();
		PreparedStatement ps1=con.prepareStatement("Select * from user where uname=? and upassword=?");
		ps1.setString(1,name);
		ps1.setString(2,password);
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
		System.out.println("=====================User Information======================");
		System.out.println("1. User id is = "+rs.getInt(1));
		System.out.println("2.User name is = "+rs.getString(2));
		System.out.println("3. User emaid is = "+rs.getString(3));
		System.out.println("4.User Mobile number is = "+rs.getString(4));
		System.out.println("5.User balance is = "+rs.getString(5));
		
		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
