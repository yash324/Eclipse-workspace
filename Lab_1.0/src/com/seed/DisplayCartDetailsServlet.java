package com.seed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayDetails")
public class DisplayCartDetailsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Enumeration<String> params = req.getParameterNames();
		out.println("<html> <body>");
		out.println("<h4> Following books were selected </h4>");
		out.println("<table border = '1'>");
		String[] values = req.getParameterValues("bookName");
		for (int i = 0; i < values.length; i++)
			out.println("<tr><td>" + values[i] + "</td></tr>");
		out.println("</table> </body> </html> ");
	}

	// TODO:2 Provide call-back method (called by web container) for HTTP
	// request made using HTTP GET method
	// TODO:3 This method should read products selected by web-client from
	// bookCatelogue.html and
	// display them in tabular format as html response to the web client.
}
