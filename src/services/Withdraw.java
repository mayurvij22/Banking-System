package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectdb.ConnectDB;

/**
 * Servlet implementation class Withdraw
 */
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
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
		try
		{
			Connection con=ConnectDB.connect();
			String uname = request.getParameter("uname");
			String upassword= request.getParameter("upassword");
		    PreparedStatement ps1 = con.prepareStatement("select * from user_tbl where uname=? and upassword=?");
            ps1.setString(1,uname);
			ps1.setString(2,upassword);
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs1.next())
			{
			int damt = Integer.parseInt(request.getParameter("damt"));
            PreparedStatement ps2 = con.prepareStatement("UPDATE user_tbl SET ubalance = ubalance -? where uname=? and upassword=?");
			ps2.setInt(1,damt);
			ps2.setString(2,uname);
			ps2.setString(3,upassword);
		
	
			int i = ps2.executeUpdate();
			
			if(i==1)
			{
				response.sendRedirect("amountwithdrawn.html");
			}
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}

}
