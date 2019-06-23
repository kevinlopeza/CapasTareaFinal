package capas.tareafinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import capas.tareafinal.domain.Store;
import capas.tareafinal.service.SucursalService;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {
	
	@Autowired
	SucursalService sucService;
	
	
	@RequestMapping()
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
}
