package com.cg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cookieExample")

public class CookieServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	HttpSession session= req.getSession();
	//	Cookie cookie = new Cookie("Sample", "Bansal");
//	resp.addCookie(cookie);
	/*RequestDispatcher dispatcher = req.getRequestDispatcher("/getDate");
	dispatcher.forward(req, resp);*/
//	resp.sendRedirect("getDate");
	String encodedURL = resp.encodeURL("getDate");
	System.out.println("CookieServlet Session ID: "+session.getId());
	resp.sendRedirect(encodedURL);
	
}
}
