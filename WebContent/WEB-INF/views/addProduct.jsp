<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">     
    <title>EMI Shop | Register Page</title>
    
    <script type="text/javascript">
    window.onload= function(){
    var txtPassword = document.getElementById("txtPassword");
    var txtConfirmPassword = document.getElementById("txtConfirmPassword");
    txtPassword.onchange = ConfirmPassword;
    txtConfirmPassword.onkeyup=ConfirmPassword;
  
    function ConfirmPassword(){
    	 txtConfirmPassword.setCustomValidity("");
    	  if(txtPassword.value != txtConfirmPassword.value) {
    		  txtConfirmPassword.setCustomValidity("Both passwords have to be same")
    	 
    	  } 
    	}
    }
    </script>
    <!-- Font awesome -->
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">   
    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <!-- Product view slider -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery.simpleLens.css">    
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/nouislider.css">
    <!-- Theme color -->
    <link id="switcher" href="${pageContext.request.contextPath}/resources/css/theme-color/default-theme.css" rel="stylesheet">
    <!-- <link id="switcher" href="css/theme-color/bridge-theme.css" rel="stylesheet"> -->
    <!-- Top Slider CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

    <!-- Main style sheet -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">    

    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    

    
    
    
  </head>
  <body>
  
   <!-- wpf loader Two -->
    <div id="wpf-loader-two">          
      <div class="wpf-loader-two-inner">
        <span>Loading</span>
      </div>
    </div> 
    <!-- / wpf loader Two -->       
 <!-- SCROLL TOP BUTTON -->
    <a class="scrollToTop" href=""><i class="fa fa-chevron-up"></i></a>
  <!-- END SCROLL TOP BUTTON -->


  <!-- Start header section -->
  <header id="aa-header">
    

    <!-- start header bottom  -->
    <div class="aa-header-bottom">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="aa-header-bottom-area">
              <!-- logo  -->
              <div class="aa-logo">
                <!-- Text based logo -->
                <a >
                  <span class="fa fa-shopping-cart"></span>
                  <p>EMI<strong>Shop</strong> <span>Your Shopping Partner</span></p>
                </a>
              </div>                                            
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- / header bottom  -->
  </header>
  <!-- / header section -->
  <!-- menu -->
  <section id="menu">
    <div class="container">
      <div class="menu-area">
        <!-- Navbar -->
        <div class="navbar navbar-default" role="navigation">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>          
          </div>
          <div class="navbar-collapse collapse">
            <!-- Left nav -->
            <div class="aa-header-top-center">
            <ul class="nav navbar-nav">

              <li style="float:right"><a href="Login">Contact</a></li>
              <li  style="float:right"><a href="Login">Products</a></li>
           </ul>
          </div><!--/.nav-collapse -->
      </div>
      </div> 
      </div>
    </div>
  </section>
  <!-- / menu -->  

 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">    
              <div class="container">
                  <h4>Add product</h4> 
                <form:form action="addProductForms" modelAttribute="product" method="post" enctype="multipart/form-data"><br>
  
<%--  Product Id:
								 <form:input
									placeholder="Enter Product Id" 
									path="productId"></form:input>	<br>	 --%>
                <div class="row">
                  <div class="col-25">
                    <label for="pname"> Product Name:<span style="color: red">*</span></label>
                  </div>
                  <div class="col-75">
                     <form:input
									placeholder="Enter Product Name.." 
									path="productName"></form:input>	<br>	
          </div>
                </div>
                <div class="row">
                  <div class="col-25">
                    <label for="pdesc">Product Description:<span style="color: red">*</span></label>
                  </div>
                  <div class="col-75">
                    
								 <form:textarea 
									placeholder="Enter Product Description.." 
									path="productDescription"></form:textarea><br>
									   </div>
                </div>
          
             
                        
                            <div class="row">
                                <div class="col-25">
                                  <label for="Gender">Product Category:<span style="color: red">*</span></label>
                                </div>
                               <form:radiobutton path="productCategory" value="Electronics"/>Electronics
								 <form:radiobutton path="productCategory" value="Watches"/>Watches
								 <form:radiobutton path="productCategory" value="Furniture"/>Furniture<br>
									
                              </div>
                              <div class="row">
                                  <div class="col-25">
                                    <label for="pprice"> Product Price:<span style="color: red">*</span></label>
                                  </div>
                                  <div class="col-75">
                                    <form:input 
									placeholder="Enter Product Price.." 
									path="productPrice"></form:input><br>
									      </div>
                                </div>
                                <div class="row">
                                    <div class="col-25">
                                      <label for="punits">Number of Products:</label>
                                    </div>
                                    <div class="col-75">
                                      <form:input
									placeholder="Number of Products.."
									path="unitStock"></form:input><br>	
									   </div>
                                  </div>
                                  <div class="row">
                                      <div class="col-25">
                                        <label for="pimage">Image:	</label>
                                      </div>
                                      <div class="col-75">
                                        <form:input path="productImage" type="file" name="productImage"/>	
                                        	   </div>
                                    </div>
                           
                                
                                     
             
            
                
                <div class="row">
                <center>
                    <button type="submit" style="text-align: center" class="aa-browse-btn">Submit</a></button>  
                     </center>  </div>
                 </form:form>
              </div>              
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->

 <!-- footer -->  
  <footer id="aa-footer">
      <!-- footer bottom -->
      <div class="aa-footer-top">
       <div class="container">
          <div class="row">
          <div class="col-md-12">
            <div class="aa-footer-top-area">
              <div class="row">
                  <div class="col-md-3 col-sm-6">
                      <div class="aa-footer-widget">
                        <div class="aa-footer-widget">  
                          <ul class="aa-footer-nav">
                            <li><a href="Info">Eligibility</a></li>
                          </ul>
                        </div>
                      </div>
                    </div>
                <div class="col-md-3 col-sm-6">
                  <div class="aa-footer-widget">       
                    <ul class="aa-footer-nav">
                      <li><a href="Info">Charges</a></li> 
                    </ul>
                  </div>
                </div>
                <div class="col-md-3 col-sm-6">
                  <div class="aa-footer-widget">
                    <div class="aa-footer-widget">  
                      <ul class="aa-footer-nav">
                        <li><a href="CardDetails">EMI Card Details</a></li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div class="col-md-3 col-sm-6">
                  <div class="aa-footer-widget">
                    <div class="aa-footer-widget">     
                      <ul class="aa-footer-nav">
                        <li><a href="Info">Terms and conditions apply</a></li>    
                      </ul>
                    </div>
                  </div>
                </div>  
              </div>
            </div>
          </div>
        </div>
       </div>
      </div>
   </footer>   
 
   <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>  
  <!-- SmartMenus jQuery plugin -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.smartmenus.js"></script>
  <!-- SmartMenus jQuery Bootstrap Addon -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.smartmenus.bootstrap.js"></script>  
  <!-- To Slider JS -->
  <script src="${pageContext.request.contextPath}/resources/js/sequence.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/sequence-theme.modern-slide-in.js"></script>  
  <!-- Product view slider -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.simpleGallery.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.simpleLens.js"></script>
  <!-- slick slider -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/slick.js"></script>
  <!-- Price picker slider -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/nouislider.js"></script>
  <!-- Custom js -->
  <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>     
</body>
</html>




















    