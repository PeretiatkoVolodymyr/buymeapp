package model.user;

import model.BaseEntity;
import model.user.Adress;

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
@Table(name = "users")
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



}
