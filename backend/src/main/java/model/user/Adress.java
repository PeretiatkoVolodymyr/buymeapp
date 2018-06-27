package model.user;

import model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User adress POJO model.
 *
 * @author PeretiatkoVolodymyr
 * @version 0.1
 *
 * @see BaseEntity
 */
@Entity
@Table(name = "users_adress")
public class Adress extends BaseEntity {

    @Column
    private int postCode;
    @Column
    private String City;
    @Column
    private String Street;

    public Adress() {
    }

    public Adress(int postCode, String city, String street) {
        this.postCode = postCode;
        City = city;
        Street = street;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getCity() {
        return City;
    }

    public String getStreet() {
        return Street;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setStreet(String street) {
        Street = street;
    }
}
