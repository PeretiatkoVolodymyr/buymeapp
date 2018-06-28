package dao.user;

import model.user.User;
import org.junit.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Field;

public class UserDaoImplTest {

    private static UserDaoImpl dao;
    private static EntityManagerFactory factory;

    @BeforeClass
    public static void init() throws Exception {

        //init factory and dao
        factory = Persistence.createEntityManagerFactory("hibernate-test-unit");
        dao = new UserDaoImpl();

        //set factory in dao
        Field fieldFactory = dao.getClass().getDeclaredField("factory");
        fieldFactory.setAccessible(true);
        fieldFactory.set(dao, factory);

    }

    @AfterClass
    public static void down() throws Exception {
        factory.close();
        dao = null;
    }

    @Test
    public void create() throws Exception {

        User newEntity = dao.create(new User());
        Assert.assertTrue(newEntity.getId() != 0);

    }


}
