package capas.tareafinal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import capas.tareafinal.domain.Store;
import capas.tareafinal.service.SucursalService;

@Controller
public class SucursalController {
	
	@Autowired
	SucursalService sucService;
	
	@RequestMapping("/sucursales")
	public ModelAndView ShowAll(){
		
		ModelAndView mav = new ModelAndView("index");
		List<Store> storeList = null;
	
		try {
			storeList = sucService.fetchAllStores();
		} catch (DataAccessException e) {
			mav.addObject("Error", "Not able to fetch store list");
		}
		
		mav.addObject("storeList", storeList);
		return mav;
	}
	
	@GetMapping("/store/delete/{id}")
	public RedirectView deleteStore(@PathVariable("id") Integer code, HttpServletRequest request, RedirectAttributes ra) {
		RedirectView rv = new RedirectView(request.getContextPath()+"/sucursales");
		rv.setExposeModelAttributes(false);
		try {
			sucService.deleteStore(code);
			ra.addFlashAttribute("message", "La sucursal fue removida con éxito");			
		} catch (Exception e) {
			ra.addFlashAttribute("message", "No se pudo remover la sucursal");
			e.printStackTrace();
		}
		return rv;
	}
}
