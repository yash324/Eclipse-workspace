package com.cg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showHeaders")
public class headerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> headerNames = req.getHeaderNames();
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>Header Details</h1>");
		out.println("<table border = '1'>");
		
		out.println("<tr>");
		out.println("<td> <b>Name</b> </td>");
		out.println("<td> <b>Value</b> </td>");
		out.println("</tr>");
		while(headerNames.hasMoreElements())
		{
			String name = headerNames.nextElement();
			String value = req.getHeader(name);
			out.println("<tr>");
			out.println("<td>"+ name+ "</td>");
			out.println("<td>"+ value+ "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
	}
	

}
