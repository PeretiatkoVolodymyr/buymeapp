package model.user;

import model.BaseEntity;
import model.user.Adress;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String login;
    private String password;
    private String name;
    private String email;
    private Adress address;
    private String phone;




}
