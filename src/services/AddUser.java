package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectdb.ConnectDB;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		// TODO Auto-generated method stub
		doGet(request, response);

		String uname=request.getParameter("uname");
		String uemail=request.getParameter("uemail");
		String umob=request.getParameter("umob");
		String upassword=request.getParameter("upassword");
String ubalance=request.getParameter("ubalance");
int dbal=Integer.parseInt(ubalance);
		try
		{
			Connection con=ConnectDB.connect();
			PreparedStatement ps1=con.prepareStatement("insert into user_tbl values (?,?,?,?,?,?)");
			
			ps1.setInt(1,0);
			ps1.setString(2,uname);
			ps1.setString(3,uemail);
			ps1.setString(4,umob);
			ps1.setString(5,upassword);
			ps1.setInt(6,dbal);
			int i=ps1.executeUpdate();
				if(i==1)
				{
					response.sendRedirect("options.html");
				}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
