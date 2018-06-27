package model.order;

import model.BaseEntity;
import model.product.Product;

import javax.persistence.*;

@Entity
public class OrderLine extends BaseEntity {

    @ManyToOne
    @Column
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
