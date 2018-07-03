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
    private static List<BaseEntity> actUsers;

    @BeforeClass
    public static void init() throws Exception {

        //init factory and dao
        factory = Persistence.createEntityManagerFactory(DaoTestUtil.PERSISTENCE_TEST_UNIT);
        dao = new UserDaoImpl();

        //set factory in dao
        Field fieldFactory = dao.getClass().getDeclaredField("factory");
        fieldFactory.setAccessible(true);
        fieldFactory.set(dao, factory);

    }

    @AfterClass
    public static void down() throws Exception {
        factory.close();
    }

    @Before
    public void initTestData() throws Exception {

        //test data
        User user1 = new User("user1", "1qaz", "Jhon", "j@i.com", null, "+38044");
        User user2 = new User("user2", "2qaz", "Bohj", "b@i.com", null, "+38044");
        User user3 = new User("user3", "3qaz", "Burz", "u@i.com", null, "+38044");
        User user4 = new User("user4", "4qaz", "Mike", "m@i.com", null, "+38044");
        User user5 = new User("user5", "5qaz", "Jhon", "h@i.com", null, "+38044");

        actUsers = new ArrayList<>();
        actUsers.add(user1);
        actUsers.add(user2);
        actUsers.add(user3);
        actUsers.add(user4);
        actUsers.add(user5);

        //fill in test data
        DaoTestUtil.createAllEllements(dao, actUsers);
    }

    @After
    public void teardown() throws Exception {
        //remove test data that not in list actUsers
        DaoTestUtil.deleteAllData(factory, User.class.getName());
    }

    @Test
    public void create() throws Exception {

        DaoTestUtil.createAllEllements(dao, actUsers);

        User newEntity = dao.create(new User("user6", "1qaz", "Jhon", "i@i.com", null, "+38044"));
        assertTrue(newEntity.getId() > 0);
        assertTrue("user6".equals(newEntity.getLogin()));

        newEntity = dao.create(null);
        assertEquals(null, newEntity);

    }

    @Test
    public void find() throws Exception {

        List<User> expected = dao.findAll();
        User expectedU = dao.find(6);

        assertEquals(expected, actUsers);

    }



}
