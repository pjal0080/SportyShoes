package com.assessment.sportyshoes.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT * FROM products WHERE product_season=:season",nativeQuery = true)
    List<Product> findAllBySeason(@Param("season") String season);

    @Query(value = "SELECT * FROM products WHERE product_brand=:brand",nativeQuery = true)
    List<Product> findAllByBrand(@Param("brand") String brand);

    @Query(value = "SELECT * FROM products WHERE product_color=:color",nativeQuery = true)
    List<Product> findAllByColor(@Param("color") String color);

    @Query(value = "SELECT * FROM products WHERE product_category=:category",nativeQuery = true)
    List<Product> findAllByCategory(@Param("category") String category);
}
