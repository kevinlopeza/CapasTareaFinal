package capas.tareafinal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.validation.Valid;
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
	
	@RequestMapping("/add")
	public ModelAndView storeForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("store",  new Store());
		mav.addObject("action", "Agregar");
		mav.setViewName("addStore");
		return mav;
	}
	
	@RequestMapping(path="/save", method = RequestMethod.POST)
	public ModelAndView saveStore(@Valid @ModelAttribute("store") Store store, BindingResult result, RedirectAttributes ra,HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("action", store.getCode() == null ? "Agregar":"Editar");
			mav.setViewName("addStore");
		} else {
			try {
				sucService.save(store);
				RedirectView rv = new RedirectView(req.getContextPath()+"/sucursales");
				rv.setExposeModelAttributes(false);
				ra.addFlashAttribute("message", "Cambios realizados con éxito.");	
				mav.setView(rv);
			}
			catch(Exception e) {
				mav.addObject("action", store.getCode() == null ? "Agregar":"Editar");
				mav.addObject("message", "Oops. No se pudieron realizar los cambios.");
				mav.setViewName("addStore");
				e.printStackTrace();
			}
		}
		return mav;
	}
	
	@GetMapping("/store/delete/{id}")
	public RedirectView deleteStore(@PathVariable("id") Integer code, HttpServletRequest request, RedirectAttributes ra) {
		RedirectView rv = new RedirectView(request.getContextPath()+"/sucursales");
		rv.setExposeModelAttributes(false);
		try {
			sucService.deleteStore(code);
			ra.addFlashAttribute("message", "El registro de la sucursal ha sido eliminado.");			
		} catch (Exception e) {
			ra.addFlashAttribute("message", "Oops. No se pudo eliminar el registro de la sucursal.");
			e.printStackTrace();
		}
		return rv;
	}
	
	@RequestMapping("/store/edit/{id}")
	public String editStore(@PathVariable("id") Integer code, Model m){
		try {
			Store store = sucService.findOne(code);
			m.addAttribute("action", "Editar");
			m.addAttribute("store", store);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "addStore";
	}
}
