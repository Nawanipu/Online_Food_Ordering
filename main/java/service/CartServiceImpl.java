package service;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;
import online_food.DBconnecter;

public class CartServiceImpl implements iCartService{
	
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs  = null;
	
	//get all items from database and show in home page
	@Override
	public boolean getItems(int itemId, int quentity, String userID) {

		boolean isSucces = false;
		String ItemName = "";
		int Tprice = 0;
		int price = 0;
		try {
			con = DBconnecter.getConnection();
			st = con.createStatement();

	        String sql = "SELECT Name, Unitprice FROM itemnew WHERE ID = " + itemId;
	        rs = st.executeQuery(sql);
			
			if(rs.next()) {

				ItemName = rs.getString("Name");
				price = rs.getInt("Unitprice");// change to double unite price is double in table
				
					
			}
			System.out.println(Tprice);
			Tprice = price*quentity;
			String username = userID;
			int Quentity = quentity;
			
			con = DBconnecter.getConnection();
			st = con.createStatement();
			String sql1 = "insert into cart values(0,'"+userID+"','"+ItemName+"','"+Quentity+"','"+price+"','"+Tprice+"')";
			int rs1 = st.executeUpdate(sql1);
			
			if(rs1>0) {
				isSucces = true;
			}
			else {
				isSucces = false;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSucces;
	}
//show cart item details
	@Override
	public List<Cart> getCartDetails(String username) {

		ArrayList<Cart> cartItems = new ArrayList<>();
		System.out.println("cart DB:"+username);
		
		String itemss = null;
		int quentity = 0;
		double price = 0;
		int ID = 0;
		double Tpirce=0;
		
		
		try {
			con = DBconnecter.getConnection();
			st = con.createStatement();
			String sql2 = "select * from cart where userId = '"+username+"'";
			
			rs = st.executeQuery(sql2);
			
			while(rs.next()) {
				
				itemss = rs.getString("itemName");
				quentity = rs.getInt("quentity");
				price = rs.getDouble("price");
				ID  = rs.getInt("id");
				Tpirce = rs.getDouble("Tprice");
				
				Cart ca  = new Cart(itemss, quentity,price,ID,Tpirce);
				cartItems.add(ca);
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cartItems;
		
	}
//delete cart items
	@Override
	public void deleteItems(int id) {

		try {
			con = DBconnecter.getConnection();
			st = con.createStatement();
			String sql3 = "DELETE FROM cart WHERE id = '"+id+"'";
			int rs3 = st.executeUpdate(sql3);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//update cart items prices
	@Override
	public void updateItems(int id, int qnt,double total,double price) {
		// TODO Auto-generated method stub
		
		System.out.println("succes qnt"+qnt);
		total = price*qnt;
		try {
			con = DBconnecter.getConnection();
			st = con.createStatement();
			String sql4 = "UPDATE cart SET quentity = '"+qnt+"',Tprice = '"+total+"' where id= '"+id+"'";
			int rs4 = st.executeUpdate(sql4);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int calculate(String mail) {
		int totall = 0;
		try {
			
			con = DBconnecter.getConnection();
			st = con.createStatement();
			String sql = "SELECT Tprice FROM cart WHERE userId = " + mail;
	        rs = st.executeQuery(sql);
	        
	        while (rs.next()) {
	            int price = rs.getInt("Tprice");
	            totall += price; // Add the price to the total
	        }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return totall;
	}

	@Override
	public boolean checkCart(int id,String uid) {
		// TODO Auto-generated method stub
		con = DBconnecter.getConnection();
		try {
			st = con.createStatement();
			String sql = "select * from cart where itemName = '"+id+"'userId = '"+id+"'";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
