package capas.tareafinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import capas.tareafinal.domain.User;
import capas.tareafinal.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;

	@GetMapping("/")	
	public String initMain(){
		return "login";
	}

	@PostMapping("/verify")
	public ModelAndView verifyCredendentials(@RequestParam String username, @RequestParam String password){
		
		ModelAndView mav = new ModelAndView("login");
		
		userService.verifyCredentials(username, password);
		User user = null;
		try {
			user = userService.verifyCredentials(username, password);
		} catch(DataAccessException e) {	
			mav.addObject("error", "Not able to fetch book list");
		}
		String errorMessage = "Not able to verify credentials";
		mav.addObject("error",errorMessage);
		return mav;
	}
	
}
