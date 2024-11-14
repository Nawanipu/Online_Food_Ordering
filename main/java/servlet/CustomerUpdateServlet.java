package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerServiceImpl;
import service.iCustomerService;

@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerUpdateServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("cusid");
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String password = request.getParameter("password");
		
		
		iCustomerService CustomerService = new CustomerServiceImpl();
		
		boolean isTrue;
		
		isTrue = CustomerService.Updatecustomer(id, fname, lname, email, phone, password);
		if(isTrue == true) {
			
			List<Customer> cusDisplay = CustomerService.getcustomerprofile(email);
			request.setAttribute("cusDisplay", cusDisplay);
			request.getRequestDispatcher("useraccount.jsp").forward(request, response);

		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
	}

}
