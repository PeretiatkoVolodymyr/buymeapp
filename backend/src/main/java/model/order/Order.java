package model.order;

import model.BaseEntity;
import model.user.User;

import java.time.LocalDateTime;
import java.util.List;

public class Order extends BaseEntity {

    LocalDateTime date;
    User user;
    String adress;
    OrderStatus status;
    List<OrderLine> orderProducts;

}
