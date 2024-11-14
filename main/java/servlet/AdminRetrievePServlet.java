package servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Items;
import service.AdminServiceImpl;
import service.iAdminService;

@WebServlet("/AdminRetrievePServlet")
public class AdminRetrievePServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminRetrievePServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		iAdminService AdminService = new AdminServiceImpl();
		
		List<Items> Items = AdminService.getAllItemDetails();
        request.setAttribute("items", Items);
        System.out.println("admin retrive");
        System.out.println(Items);
        request.getRequestDispatcher("Items.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
