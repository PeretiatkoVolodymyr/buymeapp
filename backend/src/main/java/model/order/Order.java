package model.order;

import model.BaseEntity;
import model.user.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private User user;
    private int amount;
    private String address;

}
