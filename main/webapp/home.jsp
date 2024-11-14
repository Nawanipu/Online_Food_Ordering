<%@page import="model.Items"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="home.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
</head>
<body>
	<jsp:include page="/homes"></jsp:include>
	<%
	
	if(session.getAttribute("username")==null){
		response.sendRedirect("loginNew.jsp");
	}
		List<Items>itemDetails = (List<Items>)request.getAttribute("itemDetails");
		System.out.println(itemDetails);

	%>
    <!-- header section -->
    <header>
        <div class="header-1">
            <a href="${pageContext.request.contextPath}RetrieveCartServlet" class="logo"><i class="uil uil-restaurant"></i>  EasyEats</a>
            <form action="" class="search-boxx-cont">
                <input type="search" id="search-boxxx" placeholder="search here...">
                <label for="search-boxx"><i class="uil uil-search"></i></label>
            </form>
        </div>

        <div class="header-2">
            <nav class="navbar">
                <a href="#">home</a>
                <div class="dropdown">
                    <a href="#">category</a>
                    <div class="dropdown-content">
                        <a href="#">beverage</a>
                        <a href="#">bakery items</a>
                        <a href="#">ramen</a>
                        <a href="#">cofee & tea</a>
                        <a href="#">rice</a>
                        <a href="#">pizzas</a>
                    </div>
                </div>
                <a href="#">product</a>
                <a href="#">contact</a>
            </nav>
            

            <div class="icons">
                <a href="cart.jsp"><i class="uil uil-shopping-cart-alt"></i></a>
                <a href="#"><i class="uil uil-heart"></i></a>
                <a href="#" class="user-pic" onclick="toggleMenu()"><i class="uil uil-user-circle"></i></a>
                <div class="subb-men-wrapp" id="subMenu">
                    <div class="subb-men">
                        <div class="user-info">
                            <img src="image/user.png" alt="">
                            <h2>${username}</h2>
                        </div>
                        <hr>
                        <a href="loginNew.jsp" class="subb-men-linkk">
                            <img src="image/setting.png" alt="">
                            <p>login</p>
                            <span>></span>
                        </a>
                        <a href="${pageContext.request.contextPath}/LogoutServlet" class="subb-men-linkk">
                            <img src="image/logout.png" alt="">
                            <p>log out</p>
                            <span>></span>
                        </a>
                        <a href="${pageContext.request.contextPath}/CustomerRetriveServlet" class="subb-men-linkk">
                            <img src="image/help.png" alt="">
                            <p>view profile</p>
                            <span>></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <script src="home.js"></script>`
    <!-- header section end -->
    <!-- home/banner section start -->

    <section class="home" id="home">
        <div class="image">
            <img src="image/foodhomepage.png" alt="" width="700px" height="auto">
        </div>
        <div class="contt">
            <span>Quick and Delicious</span>
            <h4>Order Your Favorite Meals Online</h4>
            <a href="#" class="buttn">get start</a>
        </div>
    </section>

    <!-- home/banner section end -->
    <!-- category start -->
    <section class="category" id="category">
        <h1 class="heading">shop by <span>category</span></h1>
        <div>

        </div>
    </section>
    <div class="grid-container">
    	<div><a id="Beverages" href="#"><img src="image/juice.jpeg" alt="" width="150px"><p>beverages</p></a></div>
        <div><a href="${pageContext.request.contextPath}/ShowcategoryServlet?id=Bakery"><img src="image/bakery.png" alt="" width="150px"><p>bakery items</p></a></div>
        <div><a href="${pageContext.request.contextPath}/ShowcategoryServlet?id=sushi"><img src="image/sushii.png" alt="" width="150px"><p>Sushi</p></a></div>  
        <div><a href="${pageContext.request.contextPath}/ShowcategoryServlet?id=Tea"><img src="image/tea.jpeg" alt="" width="150px"><p>coffee,tea</p></a></div>
        <div><a href="${pageContext.request.contextPath}/ShowcategoryServlet?id=rice"><img src="image/rice.png" alt="" width="150px"><p>rice</p></a></div>
        <div><a href="${pageContext.request.contextPath}/ShowcategoryServlet?id=pizza"><img src="image/pizzaa.png" alt="" width="150px"><p>pizzas</p></a></div>
        <div><a href="${pageContext.request.contextPath}/ShowcategoryServlet?id=Snack"><img src="image/fries.png" alt="" width="150px"><p>Snacks</p></a></div>
        <div><a href="${pageContext.request.contextPath}/ShowcategoryServlet?id=ramen"><img src="image/ramen.jpeg" alt="" width="150px"><p>Ramen</p></a></div>
    </div>
    <!-- category end -->
    <!-- feature product start -->
    <section class="product" id="product">
        <h1 class="heading">latest <span>items</span></h1>
        <div>
            <div class="boxx-cont">

				<c:forEach var = "itemmm" items = "${itemDetails}">
                    <form action="AddToCartServlet" method="post">
                        <input type="hidden" name="itemid" value="${itemmm.id}">
                        
	                <div class="boxx">
	                    <span class="discount">-33%</span>
	                    <div class="icons">
	                        <a href="#"><i class="uil uil-heart-sign"></i></a>
	                        <a href="#"><i class="uil uil-eye"></i></a>
	                    </div>
	                    <img src="${itemmm.img}" alt="" height="100px">
	                    <h3>${itemmm.name}</h3>
	                    <div class="price">$10.0 <span>$13.20</span></div>
	                    <div class="quentity">
	                        <span>quantity:</span>
	                        <input type="number" min="1" max="100" value="1" name="quentity">
	                      <!--   <span></span>  --> 
	                    </div>
                        <input type="submit" class="buttn" name="submit" value="add to cart">
	                </div>
                </form>
				</c:forEach>
                
            </div>
        </div>
    </section>
    <!-- feature product end -->
    <!-- product start -->
   
    <%
    	String cat = request.getParameter("id");
    %>
    <section class="product" id="Beverages">
        <h1 class="heading"><%= cat %></h1>
            <div class="boxx-cont">
                <c:forEach var = "itemm" items = "${catergory}">
                        <form action="AddCartServlet" method="post">
                            <input type="hidden" name="itemid" value="${itemm.id}">
                            
                        <div class="boxx">
                            <span class="discount">-33%</span>
                            <div class="icons">
                                <a href="#"><i class="uil uil-heart-sign"></i></a>
                                <a href="#"><i class="uil uil-eye"></i></a>
                            </div>
                            <img src="" alt="" height="100px">
                            <h3>${itemm.name}</h3>
                            <div class="price">$10.0 <span>$13.20</span></div>
                            <div class="quentity">
                                <span>quantity:</span>
                                <input type="number" min="1" max="100" value="1" name="quentity">
                                <span></span>
                            </div>
                            <input type="submit" class="buttn" name="submit" value="add to cart">
                        </div>
                    </form>
                    </c:forEach>
            </div>
    </section>
    <!-- product end -->
    <!-- footer start -->
    <section class="footer">
    <hr>
        <div class="boxx-cont">
            <div class="boxx">
                <a href="#" class="logo"><i class="uil uil-restaurant"></i>  EasyEats</a>
                <p> Description of the web site</p>
                <div class="share">
                    <a href="#" class="buttn fab fa-facebook-f"></a>
                    <a href="#" class="buttn fab fa-twitter"></a>
                    <a href="#" class="buttn fab fa-instagram"></a>
                </div>
            </div>
            <div class="boxx">
                <h3>our location</h3>
                <div class="links">
                    <a href="#">home</a>
                    <a href="#">usa</a>
                    <a href="#">category</a>    
                </div>
            </div>
            <div class="boxx">
                <h3>our location</h3>
                <div class="links">
                    <a href="#">home</a>
                    <a href="#">usa</a>
                    <a href="#">category</a>    
                </div>
            </div>
        </div>
        <h1 class="credit">created by <span>KINN</span> | all rights reserved</h1>
    </section>
    <!-- footer end -->
    <script>
        let subMenu = document.getElementById("subMenu");

        function toggleMenu(){
            subMenu.classList.toggle("open-menu");
        }
        document.getElementById('Beverages').addEventListener('click', function(event) {
        // Prevent the default behavior (e.g., navigating to "#")
        event.preventDefault();

        // Navigate to the first destination (Google)
        window.location.href = '${pageContext.request.contextPath}/ShowcategoryServlet?id=Beverages';

        // Open the second destination in a new tab/window (OpenAI)
        // window.open('https://www.openai.com', '_blank');
    });

    </script>
</body>
</html>