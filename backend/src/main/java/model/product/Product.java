package model.product;

import model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int price;

}
