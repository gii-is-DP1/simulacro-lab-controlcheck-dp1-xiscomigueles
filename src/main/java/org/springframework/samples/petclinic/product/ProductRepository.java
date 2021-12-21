package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    @Query("SELECT productType FROM ProductType productType")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    @Query("SELECT productType FROM ProductType productType WHERE productType.name=:name")
    ProductType getProductType(@Param("name") String name);

    Product findByName(String name);
    Product save(Product p);
}
