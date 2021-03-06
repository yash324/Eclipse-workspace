package com.seed;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seed.beans.ShoppingCart;

//@WebServlet("/storeDetails")
//TODO:0	Modification required
public class StoreCartDetailsServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShoppingCart cartRef = null;
//		TODO:1	Obtain session created for client
//		if session is not created, ask container to create it.
		HttpSession session = request.getSession(true);
//		TODO:2	Retrieve attribute named as "shoppingCart" in session scope
//		assign it to "cartRef" local variable (you need casting to ShoppingCart) 
		cartRef = (ShoppingCart) session.getAttribute("shoppingCart");
//		TODO:3 If "shoppingCart" does not exist, create object of com.seed.beans.ShoppingCart referenced by "cartRef"
//		and assign "shoppingCart" as attribute name for this newly created ShoppingCart
		if(cartRef==null)
		{
			cartRef = new com.seed.beans.ShoppingCart();
			session.setAttribute("shoppingCart", cartRef);
		}
//		TODO:4	Read product ids from request parameter named as "bookID"
		String[] pid = request.getParameterValues("bookID");
//		TODO:5 add these product ids in the ShoppingCart object referenced by "cartRef" local variable
		if(pid!=null)
			cartRef.setProductList(pid);
//		TODO:6	if the user clicks "Shop More?" in "bookCatelogue.html", 
//		then redirect web-client to resource named as "categories.html"
		String redir = request.getParameter("continue");
		RequestDispatcher dispatcher = null;
		if(redir!=null)
			 response.sendRedirect("categories.html");
//		TODO:7	if the user clicks "Check Out" in "bookCatelogue.html", 
//		then instead of redirecting web-client to resource named as "displayDetails"
//		forward the current request to Servlet named as "DisplayCartDetailsServlet".
//		Please remember, in WEB.XML file there is no mapping for "DisplayCartDetailsServlet"
		 else
		 {
			 dispatcher = getServletContext().getNamedDispatcher("DisplayCartDetailsServlet");
			 if(dispatcher==null)
				 System.out.println("null");
			 dispatcher.forward(request, response);
		 }
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}









