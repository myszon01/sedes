package com.freight.crm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainController {
	
	
	
	@RequestMapping(value= {"/", "/index"})
    String index(){
	 
        return "index";
    }
	@RequestMapping(value= {"/test"})
    String test(){
	 
        return "test";
    }
	@RequestMapping(value= {"/x"})
    String getCustomerPage(Model m){
		//.addAttribute("cus", customerService.getAllCustomers());
        return "customers";
    }
}
