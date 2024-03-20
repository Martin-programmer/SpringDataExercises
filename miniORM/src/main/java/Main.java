import entity.User;
import orm.EntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/fsd";
    private static final String USER = "root";
    private static final String PASSWORD = "6152";
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException {
        Connection connection = getConnection();

        EntityManager<User> entityManager = new EntityManager<>(connection);
        User user = new User();
        user.setId(6);
        user.setUsername("88888");
        user.setPassword("12345678");
        user.setAge(4);
        user.setRegistrationDate(LocalDate.of(2000,11,1));

        entityManager.persist(user);

//        System.out.println(entityManager.findFirst(User.class, " where username like `%8`"));
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING, USER,PASSWORD);
    }
}
