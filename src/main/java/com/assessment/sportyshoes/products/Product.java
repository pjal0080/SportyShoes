package com.assessment.sportyshoes.products;

import com.assessment.sportyshoes.orders.Order;
import com.assessment.sportyshoes.orders.OrderView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    @JsonView(OrderView.Base.class)
    private String productName;

    private Long price;
    private Long discount;
    private Long quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_season")
    private ProductSeason productSeason;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    @JsonView(OrderView.Base.class)
    private ProductCategory productCategory;

    @Column(name = "product_color")
    @Enumerated(EnumType.STRING)
    private ProductColor productColor;

    @Column(name = "product_brand")
    @Enumerated(EnumType.STRING)
    private ProductBrand productBrand;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Order> orders;

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

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Long getPrice() {
        return price;
    }

    public Long getDiscount() {
        return discount;
    }

    public Long getQuantity() {
        return quantity;
    }

    public ProductSeason getProductSeason() {
        return productSeason;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public ProductColor getProductColor() {
        return productColor;
    }

    public ProductBrand getProductBrand() {
        return productBrand;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setProductSeason(ProductSeason productSeason) {
        this.productSeason = productSeason;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductColor(ProductColor productColor) {
        this.productColor = productColor;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand;
    }
}
