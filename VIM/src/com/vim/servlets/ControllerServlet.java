package com.vim.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vim.util.DBUtility;
import com.vim.dao.CarDAO;
import com.vim.dto.CarDTO;

//TODO 1 Import appropriate classes

//Follow TODOs (if available)
/**
 * 
 * This is a ControllerServlet class
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */

public class ControllerServlet extends HttpServlet
{
    private static final String ACTION_KEY = "action";
    private static final String VIEW_CAR_LIST_ACTION = "viewCarList";
    private static final String ADD_CAR_ACTION = "addCar";
    private static final String SAVE_CAR_ACTION = "saveCar";
    private static final String EDIT_CAR_ACTION = "editCar";
    private static final String DELETE_CAR_ACTION = "deleteCar";
    private static final String ERROR_KEY = "errorMessage";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
    	processRequest(request, response);
        //TODO 2 Invoke processRequest
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	processRequest(request, response);
        //TODO 3 Invoke processRequest
    }

    /**
     * This method will process request based on action performed on screen. 
     * @param request				HttpServletRequest
     * @param response				HttpServletResponse
     * @throws ServletException		if error occurs
     * @throws IOException			if error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionName = request.getParameter(ACTION_KEY);
        String destinationPage = null; 
        CarDAO carDAO = DBUtility.getCarDAO();
        List<CarDTO> carList;
        // perform action
        if(VIEW_CAR_LIST_ACTION.equals(actionName))
        {            
            //TODO 4 
        	carList = carDAO.findAll();
        	request.setAttribute("carList", carList);
        	destinationPage = "carList.jsp";
			//Use carDao to get the list of the cars
			//Set the list in request with attribute name as 'carList'
			//Set the destination page to carList.jsp
			
        }
        else if(ADD_CAR_ACTION.equals(actionName))
        {
			//TODO 5 
        	CarDTO car = new CarDTO();
        	request.setAttribute("car", car);
        	destinationPage = "carForm.jsp";
			//Create a new CarDTO and set in request with attribute name as 'car'
			//Set the destination page to carForm.jsp
            
        }  
        else if(EDIT_CAR_ACTION.equals(actionName))
        {
			//TODO 6 
        	int id = Integer.parseInt(request.getParameter("empid"));
			//Get the car id from request, with parameter name as 'id'
        	CarDTO car = carDAO.findById(id);
			//Find the respective car (CarDTO) from carDAO using appropriate API of DAO
        	request.setAttribute("car", car);
			//Set the found car in request with name as 'car'
        	destinationPage = "carForm.jsp";
			//Set the destination page to carForm.jsp
        }        
        else if(SAVE_CAR_ACTION.equals(actionName))
        {
			//TODO 7 
			//Create a new CarDTO
        	CarDTO car = new CarDTO();
			//set the properties of the DTO from request parameters
        	car.setMake(request.getParameter("make"));
        	car.setModel(request.getParameter("model"));
        	car.setModelYear(request.getParameter("modelYear"));
        	int id = Integer.parseInt(request.getParameter("empid"));
        	car.setId(id);
			//TODO If it is a new car then invoke create api of DAO else update api
        	if(id==-1)
        		carDAO.create(car);
        	else
        		carDAO.update(car);
			//Get all the Cars using DAO
        	carList = carDAO.findAll();
        	request.setAttribute("carList", carList);
        	destinationPage = "carList.jsp";
			//Set the found cars in request with name as 'carList'
			//Set the destination page to carList.jsp
        }  
        else if(DELETE_CAR_ACTION.equals(actionName))
        {
            //TODO 8 
			String[] ids = request.getParameterValues("empid");
        	//Get the ids of all cars to be deleted from request
        	
			//Use appropriate api of DAO to delete all cars
			carDAO.delete(ids);
			//Get all the Cars using DAO
			carList = carDAO.findAll();
			//Set the found cars in request with name as 'carList'
			request.setAttribute("carList", carList);
			//Set the destination page to carList.jsp
            destinationPage = "carList.jsp";
        }                    
        else
        {
            String errorMessage = "[" + actionName + "] is not a valid action.";
            request.setAttribute(ERROR_KEY, errorMessage);
        }


        //TODO 9 Use appropriate Servlet API to forward the request to 
		//appropriate destination page set in above if else blocks depending on action.
        RequestDispatcher r = request.getRequestDispatcher(destinationPage);
        r.forward(request, response);
    }
}
