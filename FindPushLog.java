package com.kj.logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FindPushLog
 */

@WebServlet("/FindPushLog")
public class FindPushLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<controller> arr=new ArrayList<controller>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPushLog() {
        super();
        // TODO Auto-generated constructor stub
    }

   
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String RefNo = request.getParameter("RefNo");
		String env = request.getParameter("env");
		String schema = request.getParameter("Schema");
		int i=0;
		//String record;
		
		controller[] cd=new controller[50];
		try {
		Connection con=com.kj.connect.DBConnection.getConnection(RefNo,env,schema);
		//Class.forName("oracle.jdbc.driver.OracleDriver");  
		//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");  
		
		Statement stmt;
		
		//System.out.println("con");
		
			stmt = con.createStatement();
			System.out.println("execute");
		ResultSet rs = stmt.executeQuery("select log_type,log_subtype,log_payload from assa_user.bem_logger order by log_type");
		System.out.println("executed");
		while(rs.next()){
			 cd[i] = new controller();
			cd[i].setRefno(RefNo);
			cd[i].setSchema(schema);
			cd[i].setEnv(env);
			//System.out.println(rs.getString("log_type"));
			cd[i].setLog_type(rs.getString("log_type"));
			cd[i].setLog_subtype(rs.getString("log_subtype"));
			//System.out.println(com.kj.connect.DBConnection.format(rs.getString("log_payload")));
			
			//cd[i].setLog_pay("<![cd[i]ATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><name>kj</name><age>3643</age><data>5eya</data></root>]]");
			cd[i].setLog_pay(com.kj.connect.DBConnection.format(rs.getString("log_payload")));
			//cd[i].setLog_payload(rs.getString("log_payload"));
			//System.out.println("object "+cd[i].getLog_type());
			arr.add(cd[i]);
			//System.out.println(i+" "+cd[i]);
			
			//System.out.println("array "+i+arr.get(i).getLog_type());
			i=i+1;
			
		}
		//System.out.println(i+" "+arr);
//for(int j=0;j<19;j++)
	//System.out.println(cd[j]);
		 /* Iterator<controller> itr=arr.iterator();  
		  while(itr.hasNext()){  
			  controller st=(controller)itr.next(); 
			//  System.out.println(st);
			    System.out.println(st.log_type+" "+st.log_subtype);  
			  }  
		*/
	if (request.getParameter("pushapi") != null)
	{
		System.out.println("yes");
		
		
		//System.out.println(cd[i].getLog_type());
	}
	else
	{
		System.out.println("no");
		//arr.add(cd);
	}
		
		con.close();
		/*PrintWriter pw=response.getWriter();
		//pw.print("l");
			
		//pw.print("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><style>header, footer {    padding: 1em;    color: white;   background-color:STEELBLUE;    clear: left;    text-align: center;}.loader {  border: 10px solid #f3f3f3;  border-radius: 50%;  border-top: 10px solid #3498db; width: 120px;  height: 120px;   -webkit-animation: spin 1s linear infinite;  animation: spin 1s linear infinite;}@-webkit-keyframes spin {  0% {-webkit-transform: rotate(0deg); }  100% { -webkit-transform: rotate(360deg); }}@keyframes spin {  0% { transform: rotate(0deg); }  100% { transform:rotate(360deg); }}</style><title>BEM Logs</title></head><body><h1 style=\"text-align: center;\">Processing... !</h1><div class=\"loader\" style=\"margin : 100px auto auto auto; text-align: center\"></div></body></html>");
		//request.getRequestDispatcher("Welcome.jsp").include(request,response);  
		String RefNo = request.getParameter("RefNo");
		String env = request.getParameter("env");
		String schema = request.getParameter("Schema");
		String record;
		
		pw.print("<HTML><title>BEM Logs</title><BODY><header><h1>BEM Log Utility!</h1></header><h5>");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
	
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select TXN_NO from assa_user.bem_logger");
		while(rs.next())  
		{
			record=rs.getString(1);
			pw.print("<p>"+record+"</p>");
			System.out.println(rs.getString(1));  
			
		}
		int i=1;
		while(i==10000)
		{
			
		}
		con.close();  
		
		} catch (Exception e) {
			System.out.println("couldnt conact");
			e.printStackTrace();
		} 
		
		pw.print("</h5></BODY></HTML>");
		pw.close();
		
		while(true) 
		{
			System.out.println("hi");
		}*/
		//ArrayList<controller> arr=new ArrayList<controller>();
		//controller cd=new controller();
		//System.out.println((String)request.getParameter("RefNo"));
		/*cd.setRefno((String)request.getParameter("RefNo"));
		cd.setEnv((String)request.getParameter("env"));
		cd.setSchema((String)request.getParameter("Schema"));
		arr.add(cd);
		System.out.println(cd.refno);
		System.out.println(cd.schema);
		System.out.println(cd.env);*/
		//String[] articles={(String)request.getAttribute("RefNo"),"w","e","r","t","y","u"};
		request.setAttribute("articles", arr);

	       RequestDispatcher dispatcher = request.getRequestDispatcher("/ResultPage.jsp");
	       dispatcher.forward(request, response);
	        
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProcessingRequest.jsp");
		       dispatcher.forward(request, response);		}
	}


}
