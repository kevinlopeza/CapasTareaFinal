package capas.tareafinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ModelAndView login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
		ModelAndView mav = new ModelAndView();
		try {
			User user  = userService.verifyCredentials(username, password);
			if (user != null) {
				return new ModelAndView("redirect:/sucursales","user",user);
			} else {
				mav.setViewName("login");
				mav.addObject("error", "Credenciales incorrectas");
			}
		}
		catch(Exception e) {
			mav.addObject("error","Algo salió mal - No se pudo conectar");
			e.printStackTrace();
		}
		return mav;
	}
}
