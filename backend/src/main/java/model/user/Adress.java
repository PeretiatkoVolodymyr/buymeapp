package model.user;

import model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users_adress")
public class Adress extends BaseEntity {

    private User customer;
    private int postCode;
    private String City;
    private String Street;



}
