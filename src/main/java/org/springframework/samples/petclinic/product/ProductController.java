package org.springframework.samples.petclinic.product;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
    private ProductService productService;
    
	
	@GetMapping("/create")
	public String createProduct(ModelMap modelMap) {
		String view = "products/createOrUpdateProductForm";
		modelMap.addAttribute("product", new Product());
		modelMap.addAttribute("productType", productService.getAllProductTypes());
		return view;
	}
	
	
	
	
	@PostMapping("/create")
	public String validateNewProduct(@Valid Product product, BindingResult result) {
		String viewSuccesfult="welcome";
		String viewError=  "products/createOrUpdateProductForm";
		if (result.hasErrors()) {
			return viewError;
		}
		else {
			//creating owner, user and authorities
			productService.save(product);
			
			return viewSuccesfult;
		}
	}
}
