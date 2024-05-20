package com.rayen.boisson.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rayen.boisson.entities.Boisson;
import com.rayen.boisson.entities.Type;
import com.rayen.boisson.service.BoissonService;

import jakarta.validation.Valid;

@Controller

public class BoissonController {
	@Autowired
	BoissonService boissonService;

	@RequestMapping("/ListeBoissons")
	public String listeProduits(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		Page<Boisson> b = boissonService.getAllBoissonsParPage(page, size);
		modelMap.addAttribute("boissons", b);
		modelMap.addAttribute("pages", new int[b.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeBoissons";
	}

	@RequestMapping("/showCreate")
	public String showCreatee(ModelMap modelMap) {
		List<Type> t = boissonService.getAllTypes();
		modelMap.addAttribute("boisson", new Boisson());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("types", t);
		return "formBoisson";
	}

	@RequestMapping("/saveBoisson")
	public String saveBoisson(@Valid Boisson boisson, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors())
			return "formBoisson";
		if (boisson.getIdBoisson() == null) // ajout
			isNew = true;
		boissonService.saveBoisson(boisson);
		if (isNew) // ajout
		{
			Page<Boisson> prods = boissonService.getAllBoissonsParPage(page, size);
			currentPage = prods.getTotalPages() - 1;
		} else // modif
			currentPage = page;
		return ("redirect:/ListeBoissons?page=" + currentPage + "&size=" + size);
	}

	@RequestMapping("/supprimerBoisson")
	public String supprimerBoisson(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		boissonService.deleteBoissonById(id);
		Page<Boisson> b = boissonService.getAllBoissonsParPage(page, size);
		modelMap.addAttribute("boissons", b);
		modelMap.addAttribute("pages", new int[b.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeBoissons";
	}

	@RequestMapping("/modifierBoisson")
	public String editerBoisson(@RequestParam("id") Long id, ModelMap modelMap) {
		Boisson b = boissonService.getBoisson(id);
		// List<Type> t = boissonService.getAllTypes();
		modelMap.addAttribute("boisson", b);
		modelMap.addAttribute("mode", "edit");
		// modelMap.addAttribute("types", t);
		return "formBoisson";
	}

	@RequestMapping("/updateBoisson")
	public String updateProduit(@ModelAttribute("boisson") Boisson boisson, ModelMap modelMap) throws ParseException {
		boissonService.updateBoisson(boisson);
		List<Boisson> b = boissonService.getAllBoisson();
		modelMap.addAttribute("produits", b);
		return "listeBoissons";
	}

	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}

}
