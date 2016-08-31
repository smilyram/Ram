package com.laptop12.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Patch;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.laptop12.model.*;
import com.laptop12.service.CustomerService;
import com.laptop12.service.ItemService;

@Controller
public class AdminController {

	@Autowired
	CustomerService customerService;

	@Autowired
	ItemService itemService;

	@RequestMapping("/ViewCustomer")
	public ModelAndView viewCustomer() throws JsonGenerationException, JsonMappingException, IOException {
		List<Customer> list = customerService.viewCustomer();
		System.out.println("List is:" + list);
		ObjectMapper mapper = new ObjectMapper();
		String listJSON = mapper.writeValueAsString(list);
		System.out.println(listJSON);
		return new ModelAndView("ViewCustomer", "listOfCustomer", listJSON);
	}

	@RequestMapping("/addItem")
	public ModelAndView addItem() {

		Item item = new Item();
		return new ModelAndView("addItem", "item", item);
	}

	@RequestMapping("/addProduct")
	public ModelAndView addProduct(@Valid@ModelAttribute("item") Item item, @RequestParam("file") MultipartFile file,
			BindingResult bindingResult) throws IllegalStateException, IOException 
	{
		MultipartFile itemimage = file;
		System.out.println("file data:"+file);
		System.out.println("iTEM IMAGE:"+itemimage);
		itemService.addproduct(item);
		
		Path path = Paths.get("C://Users//MRuser//workspace5//Laptop12//src//main//webapp//WEB-INF//resources//images//"+item.getItemId()+".jpg");

		System.out.println("Path:"+path);
		
		if(itemimage != null && !itemimage.isEmpty())
		{
			itemimage.transferTo(new File(path.toString()));
			
		}
		
		System.out.println("successfully add the produ/item data");
		

		return new ModelAndView("addItem");

	}
	@RequestMapping("/deleteItem")//this for delete code in view products
		public String deleteItem(@RequestParam("id") int id)
		{
		itemService.deleteItem(id);
		return "redirect:/ViewItem";
		}
	@RequestMapping("/ViewItem")
	public ModelAndView viewItem() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("im in view products");
		List<Item> item = itemService.viewItem();
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(item);
		System.out.println("jsonData" + jsonData);
		return new ModelAndView("ViewProduct", "item", jsonData);

	}
	@RequestMapping("/editItem")//this for edit code in view products
	public ModelAndView editItem(@RequestParam("id") int id)
	{
		System.out.println("Id"+id);
		Item item=itemService.getItemById(id);
		System.out.println("Item name"+item.getItemName());
	return new ModelAndView("uniqueItem","item",item);
	}
	@RequestMapping("/updateThisItem")//this for edit code in view products
	public String updateThisItem(@RequestParam("itemId") String itemId,@RequestParam("itemName") String itemName,@RequestParam("description") String description,@RequestParam("category") String category,@RequestParam("price") String price)
	{
		int iteId=Integer.parseInt(itemId);
		Item item=itemService.getItemById(iteId);
		item.setItemName(itemName);
		item.setCategory(category);
		item.setDescription(description);
		item.setPrice(Float.parseFloat(price));
		itemService.updateItem(item);
		return "redirect:/ViewItem";
		
	}
	

}
