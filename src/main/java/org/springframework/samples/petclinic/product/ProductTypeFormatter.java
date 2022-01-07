package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{
	
	@Autowired
    private ProductService productService;
    
	@Override
    public String print(ProductType object, Locale locale) {
        // TODO Auto-generated method stub
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        // TODO Auto-generated method stub
        ProductType ps= productService.getProductType(text);
        if(ps==null) {
        	throw new ParseException("type not found", 0);
        }else {
        	return ps;
        }
    }
    
}
