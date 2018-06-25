package model.order;

import model.BaseEntity;
import model.user.User;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column
    private LocalDateTime date;

    @Column
    private User user;

    @Column
    private String adress;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy="order")
    private List<OrderLine> orderProducts;




}
