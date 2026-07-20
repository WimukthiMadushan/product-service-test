package com.wimukthi.ecommerce.Repository;

import com.wimukthi.ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
