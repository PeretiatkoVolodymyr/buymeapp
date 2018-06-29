package model.user;

import model.BaseEntity;


import javax.persistence.*;

/**
 * User POJO model.
 *
 * @author PeretiatkoVolodymyr
 * @version 0.1
 *
 * @see BaseEntity
 */
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"login"})})
public class User extends BaseEntity {

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Adress address;

    @Column
    private String phone;

    public User() {
    }

    public User(String login, String password, String name, String email, Adress address, String phone) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Adress getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
