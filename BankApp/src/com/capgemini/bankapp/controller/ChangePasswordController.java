package com.capgemini.bankapp.controller;

import java.io.IOException;import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.bankapp.database.DummyDataBase;
import com.capgemini.bankapp.exceptions.InsufficientBalanceException;
import com.capgemini.bankapp.model.Customer;
import com.capgemini.bankapp.service.CustomerService;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/changePassword.do")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Set<Customer> customers = DummyDataBase.getCustomer();
    private CustomerService customerService;

       
   
    public ChangePasswordController() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerOldPassword = request.getParameter("customerOldPassword");
		String customerNewPassword = request.getParameter("customerNewPassword");
        HttpSession session = request.getSession();
        Customer c=(Customer)session.getAttribute("customer");
      try {
		customerService.updatePassword(c, customerOldPassword, customerNewPassword);
	} catch (InsufficientBalanceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        }



	}


