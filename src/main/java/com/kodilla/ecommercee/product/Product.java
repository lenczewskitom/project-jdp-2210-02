package com.kodilla.ecommercee.product;

import com.kodilla.ecommercee.cart.Cart;
import com.kodilla.ecommercee.group.Group;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@NoArgsConstructor
@Getter
@Entity
@Data
@Table(name = "PRODUCTS")
public class Product {

    public Product(String name, String description, int quantity, double price, final Group group) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.group = group;
    }

    public Product(Long id, String name, String description, int quantity, double price,Group group) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.group = group;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique = true)

    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRICE")
    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToMany
    @JoinTable(
            name = "ProductsInCart",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CART_ID")
    )
    private List<Cart> carts;
}
