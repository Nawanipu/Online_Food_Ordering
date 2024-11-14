package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.CartServiceImpl;
import service.iCartService;

/**
 * Servlet implementation class UpdateCartItemsServlet
 */
@WebServlet("/UpdateCartItemsServlet")
public class UpdateCartItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("uitemId"));
		int qnt = Integer.parseInt(request.getParameter("quantity"));
		double total = Double.parseDouble(request.getParameter("total"));
		double price = Double.parseDouble(request.getParameter("price"));
		String email = request.getParameter("uitemId");
		System.out.println("total:"+total);

		
		iCartService cartService = new CartServiceImpl();
		
		cartService.calculate(email);
		cartService.updateItems(id,qnt,total,price);
		
		response.sendRedirect("cart.jsp");
	}

}
