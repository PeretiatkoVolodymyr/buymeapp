package model.order;

import model.product.Product;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {

    @ManyToOne
    private Order order;
    private Product product;
    private int price;
    private int quantity;
    private int amount;

}
