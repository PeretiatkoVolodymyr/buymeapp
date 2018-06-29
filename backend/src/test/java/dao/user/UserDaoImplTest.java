package dao.user;

import dao.DaoTestUtil;
import model.BaseEntity;
import model.user.User;
import org.junit.*;
import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplTest {

    private static UserDaoImpl dao;
    private static EntityManagerFactory factory;
    private static List<BaseEntity> users;

    @BeforeClass
    public static void init() throws Exception {

        //init factory and dao
        factory = Persistence.createEntityManagerFactory(DaoTestUtil.PERSISTENCE_TEST_UNIT);
        dao = new UserDaoImpl();

        //set factory in dao
        Field fieldFactory = dao.getClass().getDeclaredField("factory");
        fieldFactory.setAccessible(true);
        fieldFactory.set(dao, factory);

        //test data
        User user1 = new User("user1", "1qaz", "Jhon", "j@i.com", null, "+38044");
        User user2 = new User("user2", "2qaz", "Bohj", "b@i.com", null, "+38044");
        User user3 = new User("user3", "3qaz", "Burz", "u@i.com", null, "+38044");
        User user4 = new User("user4", "4qaz", "Mike", "m@i.com", null, "+38044");
        User user5 = new User("user5", "5qaz", "Jhon", "h@i.com", null, "+38044");

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    @AfterClass
    public static void down() throws Exception {
        factory.close();
    }

    @Before
    public void setUp() throws Exception {

        //fill in test data
        DaoTestUtil.createAllEllements(dao, users);
    }

    @After
    public void teardown() throws Exception {

        //remove test data
        DaoTestUtil.DeleteAllData(factory, User.class.getName());
    }

    @Test
    public void create() throws Exception {

        User newEntity = dao.create(new User("user6", "1qaz", "Jhon", "i@i.com", null, "+38044"));
        assertTrue(newEntity.getId() > 0);
        assertTrue("user6".equals(newEntity.getLogin()));

        newEntity = dao.create(null);
        assertEquals(null, newEntity);

    }

    @Test
    public void find() throws Exception {

        List<User> users = dao.findAll();

    }


}
