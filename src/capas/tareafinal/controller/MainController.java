package capas.tareafinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import capas.tareafinal.service.EmployeeService;
import capas.tareafinal.service.SucursalService;
import capas.tareafinal.service.UserService;

@Controller
public class MainController {

	@Autowired
	EmployeeService eService;
	
	@Autowired
	SucursalService sService;
	
	@Autowired
	UserService uService;
	
	@RequestMapping("/")
	public ModelAndView initMain(){
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
}
