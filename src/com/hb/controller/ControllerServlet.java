package com.hb.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.co.User;
import com.hb.operation.DbOperation;


@WebServlet(urlPatterns =
{
	"/fc", "/fc/*"
})
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DbOperation dbOperation;

    public void init() {
    	dbOperation = new DbOperation();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       // String action = request.getServletPath();
        String action = request.getParameter("action");

        try {
            switch (action)
            {
                case "/getUser":
                	getUser(request, response);
                    break;
             
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }



    private void getUser(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	 String id = request.getParameter("id");
         User existingUser = DbOperation.getUserById(id);
    }

 
}
