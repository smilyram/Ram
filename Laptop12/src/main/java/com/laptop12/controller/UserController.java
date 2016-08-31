package com.laptop12.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.mapping.MappableAttributesRetriever;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptop12.model.Item;
import com.laptop12.service.CategoryService;

 @Controller
public class UserController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/category")//this is for edit code in view products
	public ModelAndView editItem(@RequestParam("category") String category) throws JsonGenerationException, JsonMappingException, IOException
	{
		System.out.println("category"+category);
		List<Item> item=categoryService.getItemByCategory(category);
		ObjectMapper mapper = new ObjectMapper();
		
		String listJSON= mapper.writeValueAsString(item);
		System.out.println("Item name");
	    return new ModelAndView("i3","item",listJSON);
	}
}
