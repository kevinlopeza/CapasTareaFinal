package capas.tareafinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import capas.tareafinal.service.EmployeeService;
import capas.tareafinal.service.SucursalService;
import capas.tareafinal.service.UserService;

@Controller
public class MainController {


	@GetMapping("/")	
	public String initMain(){
		return "login";
	}
	
}
