package com.assessment.sportyshoes.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name")
    private String productName;
    private Long price;
    private Long discount;
    private Long quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_season")
    private ProductSeason productSeason;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    private ProductCategory productCategory;

    @Column(name = "product_color")
    @Enumerated(EnumType.STRING)
    private ProductColor productColor;

    @Column(name = "product_brand")
    @Enumerated(EnumType.STRING)
    private ProductBrand productBrand;

    public Product(String productName,
                   Long price,
                   Long discount,
                   Long quantity,
                   ProductSeason productSeason,
                   ProductCategory productCategory,
                   ProductColor productColor,
                   ProductBrand productBrand) {
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.productSeason = productSeason;
        this.productCategory = productCategory;
        this.productColor = productColor;
        this.productBrand = productBrand;
    }



}
