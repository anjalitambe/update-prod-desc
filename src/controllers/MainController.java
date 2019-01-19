package controllers;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.TransactionManager;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import model.Address;
import model.Admin;
import model.Bank;
import model.Customer;
import model.EMICard;
import model.Installment;
import model.Product;
import service.AdminService;
import service.CustomerService;
import service.IInstallmentService;
import service.IProductService;



@Controller
@SessionAttributes(value = "sessionuser")
public class MainController {
	
	private IProductService productService;

	public IProductService getProductService() {
		return productService;
	}
	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	@Autowired
	SessionFactory sf;

	
	
	private CustomerService customerService;
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


  
	private AdminService adminService;
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	private IInstallmentService iInstallmentService;
	@Autowired
	public void setiInstallmentService(IInstallmentService iInstallmentService) {
		this.iInstallmentService = iInstallmentService;
	}
	
	
	





	

	
	
	// FOR LOGIN AND LOGIN FORM
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String indexes() {
		return "login";
	}
	

		/*i changed here!!!!!!!!!*/
		@RequestMapping(value = "/LoginForms", method = RequestMethod.POST)
		public ModelAndView loginpro1(HttpServletRequest request, HttpServletResponse response,
				HttpSession session,	@ModelAttribute("login") Customer u, BindingResult result, Model model, EMICard e) {
			ModelAndView mav = null;
			String username=request.getParameter("email");
			String password=request.getParameter("password");
			System.out.println("Username is: "+ username+ " Password is: "+password);
			if(customerService.verifyUser(username,password))
			{
				mav = new ModelAndView("dashboard");
				Customer customer = customerService.getCustomer(username, password);//new code
				session.setAttribute("customerobj", customer);
				//whatever you want to display add here
				session.setAttribute("firstName", customer.getFirstName());//new code
				session.setAttribute("lastName", customer.getLastName());
				session.setAttribute("cardType", customer.getCard().getCardType());
				session.setAttribute("validDate",customer.getCard().getValidDate());
				session.setAttribute("activated",customer.getCard().getActivated());
				session.setAttribute("cardID",customer.getCard().getCardID());
			
				
				session.setAttribute("balance",customer.getBank().getBalance());
			session.setAttribute("credits",customer.getCard().getCredits());
				session.setAttribute("remaingCredits",customer.getCard().getRemaingCredits());
			
//				
				
//				int cred = customer.getCard().getCredits();
//				int remaingCred = customer.getCard().getRemaingCredits();
//				
//				int usedCredits = cred - remaingCred;
//				session.setAttribute("usedCredits", usedCredits);
				
				
				
				//session.setAttribute("usedCredits",);
				//calculate used credits
				
				
				System.out.println("Username is: "+ username+ " Password is: "+password);
				
			}
			else
			{
				mav = new ModelAndView("loginerror");
			}
			return mav;
			}
		
		
		

		//FOR REGISTRATION AND REGISTRATION FORM
		@RequestMapping(value = "/RegisterSpring", method = RequestMethod.GET)
		public String regSpring(Model model) {
			model.addAttribute("customer",new Customer());
			return "register";
			}
		
		 @RequestMapping(value = "/RegisterFormsSpring", method = RequestMethod.POST)
		    public String validateregistrationPage1(@Valid @ModelAttribute("customer") Customer customer,
		    		BindingResult bindingResult,Model model) {
			 	System.out.println(customer);
			 	String card1="Gold";
			 	String card2="Titanium";
			 	
			 	if(customer.getCard().getCardType().equals(card1))
			 	{
			 		customer.getCard().setCredits(40000);
			 		Date validDate= customerService.createValidDate();
			 		customer.getCard().setValidDate(validDate);
			 	}
			 	else if(customer.getCard().getCardType().equals(card2))
			 	{
			 		customer.getCard().setCredits(60000);
			 		Date validDate= customerService.createValidDate();
			 		customer.getCard().setValidDate(validDate);
			 	}
			 	
				double bal = customerService.createBalance();
				customer.getBank().setBalance(bal);
				Date vd = customerService.createValidDate();
				customer.getCard().setValidDate(vd);
			    customerService.addCustomer(customer);
			    return "regSuccess";
		 	}
		 
	
		
		
		
		
		
		
		
		
		
		
		//FOR ADMIN LOGIN 
		@RequestMapping(value = "/Admin", method = RequestMethod.GET)
		public String adminLog(Model model) {
		model.addAttribute("admin",new Admin());
		return "adminLogin";
		}
		
		
		//FROM ADMIN LOGIN FORM

		@RequestMapping(value = "/AdminForms", method = RequestMethod.POST)
		public ModelAndView loginpro(HttpServletRequest request, HttpServletResponse response,
		@ModelAttribute("admin") Admin u, BindingResult result, Model model) {
		ModelAndView mav = null;
		String adminName=request.getParameter("adminName");
		String password=request.getParameter("password");

		if(adminService.verifyUser1(adminName,password))
		{

		mav = new ModelAndView("admindashboard");   

		}
		else
		{
		
		mav = new ModelAndView("loginerror");
		}

		return mav;

		}  
		
		 //Adminproduct to edit or delete or view the products in db
		 @RequestMapping(value = "/AdminProduct", method = RequestMethod.GET)
			public ModelAndView adminProduct(Model model) 
			{
			 
			  List<Product> products = productService.getAllProducts(); 
				model.addAttribute("customer",new Customer());

				  return new ModelAndView("adminproduct", "products", products);
	
				}
		
		
		
		 //Dashboard
		 @RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
			public String userDashboard(Model model) 
			{
				model.addAttribute("customer",new Customer());
				return "dashboard";
				}
		

			
			@RequestMapping(value="/Logout",method = RequestMethod.GET)
			public String logout(HttpSession session){
				session.invalidate();
				
				return "logoutSucess";
			}
			
			
			@RequestMapping(value = "/Product", method = RequestMethod.GET)
			public String redirectToProducts(Model model) {
				model.addAttribute("product", new Product());
				model.addAttribute("customer",new Customer());
				
				return "product";
			}
			
			@RequestMapping(value = "/Product-Detail", method = RequestMethod.POST)
			public String redirectToProductDets(HttpServletRequest request, HttpServletResponse response,
					HttpSession session,Customer u, BindingResult result, Model model, EMICard e,
					@ModelAttribute("product") Product p) {
				System.out.println(p);
				//System.out.println(inst);
				model.addAttribute("installment", new Installment());
				Product prod=p;
				session.setAttribute("productobj",prod);
				Customer c= (Customer) session.getAttribute("customerobj");
			  System.out.println("Customer in product is:"+c);
			  
			  session.setAttribute("productName", p.getProductName());
			  session.setAttribute("productPrice", p.getProductPrice());
			  session.setAttribute("productCategory", p.getProductCategory());
			  session.setAttribute("unitStock", p.getUnitStock());
			  session.setAttribute("productDescription", p.getProductDescription());
			  

				session.setAttribute("firstName", c.getFirstName());//new code
				session.setAttribute("lastName", c.getLastName());
				session.setAttribute("cardType", c.getCard().getCardType());
				session.setAttribute("validDate",c.getCard().getValidDate());
				session.setAttribute("activated",c.getCard().getActivated());
				session.setAttribute("cardID",c.getCard().getCardID());
				
				session.setAttribute("balance",c.getBank().getBalance());
				
				
				
				
				return "product-detail";
			}
			
			
			@RequestMapping(value = "/DisplayEMI", method = RequestMethod.POST)
			public String EMIDuration(HttpServletRequest request, HttpServletResponse response,
					HttpSession session,Customer u, BindingResult result, Model model, 
					@ModelAttribute("installment") Installment inst) {
				Installment installment = inst;//new code
				session.setAttribute("installmentobj", installment);
				
				
				System.out.println(inst);
				int duration=inst.getDuration();
				System.out.println("duration is"+duration);
			
				Customer c= (Customer) session.getAttribute("customerobj");
				Product p=(Product) session.getAttribute("productobj");
				double emi=((p.getProductPrice()))/duration;
				inst.setAmountToPay(emi);
				session.setAttribute("amountToPay", emi);
				return "product-detail";
				
				
			}
			
			
			
			
			
			
			@RequestMapping(value = "/BuyNow", method = RequestMethod.GET)
			public String redirectToPayment(Model model,HttpSession session) {
				Session session1 = sf.openSession();
				Transaction tx = session1.beginTransaction();
				Customer c= (Customer) session.getAttribute("customerobj");
				Installment i= (Installment) session.getAttribute("installmentobj");
				Product p= (Product) session.getAttribute("productobj");
				
				System.out.println("ji");
				System.out.println(c);
				System.out.println(p);
				
				//To deduct emi from bank account
				double emi=i.getAmountToPay();
				double bal=c.getBank().getBalance();
				double newbal= iInstallmentService.calculateNewBal(emi,bal);
				//double newbal = bal-emi; 
				System.out.println(newbal);
				c.getBank().setBalance(newbal);
				
				
				//To deduct credits from EMI Card
				
				double cred= c.getCard().getCredits();
				double price=p.getProductPrice();
				double remcreds= iInstallmentService.getRemCredits(cred,price);
				//double remcred= cred-price;
				c.getCard().setRemaingCredits(remcreds);
				session.setAttribute("remaingCredits", remcreds);
				session.setAttribute("amountToPay", price);
				session.setAttribute("perMonthAmount", emi);
				tx.commit();
				session1.save(c);
				
				
				
				return "payment";
			}
			
			
			 //Successpayment
			 @RequestMapping(value = "/SuccessPayment", method = RequestMethod.GET)
				public String paymentsuccessful(Model model) 
				{
					model.addAttribute("customer",new Customer());
					return "successpayment";
					}
			
			
			 
				

				
				
				
				//ADDING A PRODUCT
				@RequestMapping(value = "AddProduct")
				public String getProductForm(Model model) {		
					model.addAttribute("product",new Product());
					return "addProduct";
				}
				@RequestMapping(value = "addProductForms", method = RequestMethod.POST)
				public String addingProduct(@ModelAttribute("product") @Valid Product prod, BindingResult result,
					@RequestParam("productImage") MultipartFile file, Model model) {
//					// Binding Result is used if the form that has any error then it will
//					// redirect to the same page without performing any functions
////					if (result.hasErrors()) {
					
////						return "addProduct";}
				System.out.println(result.toString());
					System.out.println("File:" + file.getName());
					System.out.println("ContentType:" + file.getContentType());
//					
					try {
							byte[ ] b =file.getBytes();	
							Session session = sf.openSession();
							Blob blob= Hibernate.getLobCreator(session).createBlob(b);
							
						
					} catch (IOException e) {
						e.printStackTrace();
					}
			System.out.println(result.toString());
			System.out.println("product being added :" + prod);
				productService.addProduct(prod);
//				Path path = Paths
//					.get( "D:/EMI Repos/EMICardManagement1/WebContent/resources/img/products/"
//								+ prod.getProductName() + ".jpg");
			//	
//				MultipartFile image = (MultipartFile) prod.getProductImage();
//				try {
//					image.transferTo(new File(path.toString()));
//					//image.transferTo(new File(path.toString()));
//					
//				} catch (IllegalStateException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					
//					e.printStackTrace();
//				}
				
				
				
				
				
//					MultipartFile image = prod.getProductImage();
//					if (image != null && !image.isEmpty()) {
//						Path path = Paths
//							.get( "D:/EMI Repos/EMICardManagement1/WebContent/resources/img/products"
//										+ prod.getProductId() + ".jpg");
			//
//					try {
//						image.transferTo(new File(path.toString()));
//					} catch (IllegalStateException e) {
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}

					
					return "redirect:/AdminProduct";
					
				}
				
				
				
				
//				@RequestMapping("ListProducts") 
//				public ModelAndView getAllProducts() {
//					  List<Product> products = productService.getAllProducts(); 
//					  return new ModelAndView("productList", "products", products);
//					  }

				

				
//				@RequestMapping(value = "/admin/editProduct", method = RequestMethod.POST)
//				public String editProduct(@ModelAttribute(value = "editProductObj") Product product) {
//					System.out.println("here");
//					productService.editProduct(product);
//					return "redirect:/productList";
//				}
				
//				@RequestMapping(value = "/editProductbyAdmin",method = RequestMethod.POST)
//				public String editprod(@ModelAttribute("editProductObj") Product product, BindingResult r) {
//					System.out.println(r.toString());
//					productService.editProduct(product);
//					return "productList";	
//						}
				
				
				//EDIT PRODUCT BY ADMIN
				@RequestMapping(value = "/admin/product/editProduct/{productId}")
				public ModelAndView getEditForm(@PathVariable(value = "productId") Integer productId) {
					Product product = productService.getProductById(productId);
					System.out.println("ghhh");
					return new ModelAndView("editProduct", "editProductObj", product);
				}
				
				
				
				@RequestMapping(value = "/trying",method = RequestMethod.POST)
				public String trying(@ModelAttribute("editProductObj") Product p,BindingResult r) {
					System.out.println(r.toString());
					System.out.println(p);
					productService.editProduct(p);
					return "redirect:/AdminProduct";
					
				}
				
				
				
				//DELETING A PRODUCT BY ADMIN
				
				@RequestMapping("admin/product/delete/{productId}")
				public String deleteProduct(@PathVariable(value = "productId") Integer productId) {

			//	
//					Path path = Paths.get("C:/Users/Ismail/workspace/ShoppingCart/src/main/webapp/WEB-INF/resource/images/products/"
//							+ productId + ".jpg");
			//
//					if (Files.exists(path)) {
//						try {
//							Files.delete(path);
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}

					productService.deleteProduct(productId);
					
					return "redirect:/AdminProduct";
				}

				
				
			
			
			
		}
	 
 
	 
	
