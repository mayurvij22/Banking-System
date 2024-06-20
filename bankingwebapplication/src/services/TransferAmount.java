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
 * Servlet implementation class TransferAmount
 */
public class TransferAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferAmount() {
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
			
			//sender
			String uname = request.getParameter("uname1");
			String upassword= request.getParameter("upassword1");
		    PreparedStatement ps1 = con.prepareStatement("select * from user_tbl where uname=? and upassword=?");
            ps1.setString(1,uname);
			ps1.setString(2,upassword);
			ResultSet rs1 = ps1.executeQuery();
			
			//receiver
			String uname1 = request.getParameter("uname2");
		    PreparedStatement ps11 = con.prepareStatement("select * from user_tbl where uname=?");
            ps11.setString(1,uname1);
			ResultSet rs11 = ps11.executeQuery();
			int damt = Integer.parseInt(request.getParameter("damt"));
			int i=0,i1=0;
			while(rs1.next())
			{
            PreparedStatement ps2 = con.prepareStatement("UPDATE user_tbl SET ubalance = ubalance -? where uname=? and upassword=?");
			ps2.setInt(1,damt);
			ps2.setString(2,uname);
			ps2.setString(3,upassword);
			i = ps2.executeUpdate();
			}
			while(rs11.next())
			{ 
				PreparedStatement ps21 = con.prepareStatement("UPDATE user_tbl SET ubalance = ubalance + ? WHERE uname = ?"); 
			    ps21.setInt(1, damt);
			    ps21.setString(2, uname1);
			   i1 = ps21.executeUpdate();
			}
			
			if(i==1 && i1==1)
			{
				response.sendRedirect("transactiondone.html");
			}
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	
	}

}
