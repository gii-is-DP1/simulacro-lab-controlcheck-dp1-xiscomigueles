package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
	
	private ProductRepository productrepo;
	@Autowired
	public ProductService(ProductRepository productrepo) {
		this.productrepo=productrepo;
	}
    public List<Product> getAllProducts(){
        return productrepo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productrepo.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productrepo.getProductType(typeName);
    }
    public List<ProductType> getAllProductTypes(){
    	return productrepo.findAllProductTypes();
    }
 

    public Product save(Product p){
        return productrepo.save(p);       
    }

    
}
