package com.alexandrovskiy.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alexandrovskiy.web.dao.Offer;
import com.alexandrovskiy.web.service.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String showHome(Model model){
		
		List<Offer> offers = offersService.getCurrent();		
		
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model){
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result){
		if (result.hasErrors()){
			return "createoffer";
		}
		offersService.create(offer);
		
		return "offercreated";
	}
	
	// handles exceptions for this particular controller
	// see also DatabaseExceptionHandler (handles exceptions for all controllers)
//	@ExceptionHandler(DataAccessException.class)
//	public String handleDatabaseExceptions(DataAccessException ex) {
//		return "error";
//	}
	
	// test method - get url parameters
//	@RequestMapping(value="/id", method=RequestMethod.GET)
//	public String testId(Model model, @RequestParam("id") String id){
//		System.out.println("Id is: " + id);
//		return "home";
//	}
	
	
//	@RequestMapping("/")
//	public ModelAndView showHome(HttpSession session){
//		
//		ModelAndView mv = new ModelAndView("home");
//		
//		Map <String, Object> model = mv.getModel();
//		
//		model.put("name", "Bekky");
//		
//		return mv;
//	}

}
