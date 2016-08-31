package com.laptop12.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptop12.model.Customer;
import com.laptop12.model.Item;
import com.laptop12.service.CustomerService;
import com.laptop12.service.ItemService;

@Controller
public class HomeController {
	@Autowired
	ItemService itemService;
	@Autowired
	CustomerService customerService;
  //first request come to home page
	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println("home() method called");
		return new ModelAndView("home");
	}
	@RequestMapping("/contact")
	public ModelAndView contact() {
		System.out.println("contact() method called");
		return new ModelAndView("ContactUs");
	}
	@RequestMapping("/about")
	public ModelAndView aboutUs() {
		System.out.println("aboutUs() method called");
		return new ModelAndView("AboutUs");
	}
	//this will call when customer signin
	
	@RequestMapping("/signUp")
	public ModelAndView signUp(){
		Customer customer=new Customer();
		System.out.println("signUp() method called");
		return new ModelAndView("signUp","customerObj",customer);
	}
	@RequestMapping("/login")
	public String loginMethod()
	{
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		System.out.println("logout page called");

		return "logout";
		
	}
	@RequestMapping("/Customer")
	public ModelAndView customerCheck(Principal principal) throws JsonGenerationException, JsonMappingException, IOException
	{
		System.out.println("im in view products");
		List<Item> item = itemService.viewItem();
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(item);
		System.out.println("jsonData" + jsonData);
		return new ModelAndView("ViewProductDetails", "item", jsonData);
	}
	@RequestMapping("/ProductInfo")
	public ModelAndView productInfo(@RequestParam("id") String id)
	{
		Item item=itemService.getItemById(Integer.parseInt(id));
		return new ModelAndView("ProductInfo","item",item);
		
	}
	@RequestMapping("/Admin")
	public ModelAndView adminCheck(Principal principal)
	{
		System.out.println("UserName : "+principal.getName());
		return new ModelAndView("adminHome");
	}
	@RequestMapping("/register")
	public ModelAndView register(@Valid@ModelAttribute("customerObj") Customer customer,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			System.out.println(bindingResult);
			return new ModelAndView("signUp");
		}
		System.out.println("UserName :"+customer.getName());
		System.out.println("Password :"+customer.getPassword());
		System.out.println("Email :"+customer.getEmail());
		System.out.println("mobile :"+customer.getMobile());
		customerService.addCustomer(customer);
		return new ModelAndView("login","message","you have successfully registered");
	}
}
