package com.assessment.sportyshoes.orders;

import com.assessment.sportyshoes.products.Product;
import com.assessment.sportyshoes.users.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    @JsonView(OrderView.Base.class)
    private Long id;

    @Column(name = "order_quantity")
    @JsonView(OrderView.Base.class)
    private Long quantity;

    @Column(name = "purchase_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonView(OrderView.Base.class)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonView(OrderView.Base.class)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonView(OrderView.Base.class)
    private Product product;

    public Order(Long quantity, Date date, User user, Product product) {
        this.quantity = quantity;
        this.date = date;
        this.user = user;
        this.product = product;
    }


}
