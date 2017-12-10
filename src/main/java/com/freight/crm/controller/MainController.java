package com.freight.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.freight.crm.service.ICustomerService;

@Controller
public class MainController {
	
	@Autowired
	private ICustomerService customerService;
	
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
