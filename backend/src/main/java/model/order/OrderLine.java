package model.order;

import model.BaseEntity;
import model.product.Product;

import javax.persistence.*;


public class OrderLine extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST}, targetEntity = Order.class, optional=true)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column
    private int price;

    @Column
    private int quantity;

    @Column
    private int amount;

}
