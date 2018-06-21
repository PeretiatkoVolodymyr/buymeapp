package model.order;

import model.BaseEntity;
import model.user.User;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private LocalDateTime date;
    private User user;
    private String adress;
    private OrderStatus status;
    private List<OrderLine> orderProducts;


}
