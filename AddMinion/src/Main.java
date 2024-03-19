import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        String path = Main.class.getClassLoader().getResource("jdbc.properties").getPath();
        Properties properties = new Properties();
        properties.load(new FileReader(path));

        Connection connection = DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password")
        );

        Scanner scanner = new Scanner(System.in);
        forthTask_AddMinion(connection, scanner);
    }

    private static void forthTask_AddMinion(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Minion: ");
        String[] minionData = scanner.nextLine().split("\\s+");
        System.out.print("Villain: ");
        String villain = scanner.nextLine();
        String minionName = minionData[0];
        int minionAge = Integer.parseInt(minionData[1]);
        String town = minionData[2];
        if (townIsInDatabase(town,connection)){
            int townId = getTownId(town,connection);
            addMinionToDatabase(minionName,minionAge,townId,connection);
        }else{
            addTownToDatabase(town,connection);
        }
        if (villainID(villain,connection) < 0){
            addVillainToDatabase(villain,connection);
            }
        addMinionsVillainsToDatabase(getMinionId(connection,minionName),villainID(villain,connection),connection);
        System.out.printf("Successfully added %s to be minion of %s.",minionName,villain);
    }

    private static void addMinionsVillainsToDatabase(int minionId, int villainID, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO minions_villains VALUE (?, ?)");
        preparedStatement.setInt(1, minionId);
        preparedStatement.setInt(2, villainID);
        preparedStatement.executeUpdate();
    }

    private static int getMinionId(Connection connection, String minionName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id FROM minions WHERE name = ?");
        preparedStatement.setString(1, minionName);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()){
            id = resultSet.getInt("id");
        }
        return id;
    }

    private static void addVillainToDatabase(String villain, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO villains(name, evilness_factor) VALUE (?,?)");
        preparedStatement.setString(1, villain);
        preparedStatement.setString(2,"evil");
        preparedStatement.executeUpdate();
        System.out.printf("Villain %s was added to the database.%n",villain);
    }

    private static int villainID(String villain, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id FROM villains WHERE name = ?");
        preparedStatement.setString(1,villain);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = -1;
        while (resultSet.next()){
            id = resultSet.getInt("id");
        }
        return id;
    }


    private static void addMinionToDatabase(String minionName, int minionAge, int townId, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO minions(name, age, town_id) VALUE (?, ?, ?)");
        preparedStatement.setString(1, minionName);
        preparedStatement.setInt(2, minionAge);
        preparedStatement.setLong(3, townId);
        preparedStatement.executeUpdate();
    }

    private static int getTownId(String town, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id FROM towns WHERE name = ?");
        preparedStatement.setString(1,town);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }
        return id;
    }

    private static void addTownToDatabase(String town, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO towns(name) VALUE (?)");
        preparedStatement.setString(1,town);
        preparedStatement.executeUpdate();
        System.out.printf("Town %s was added to the database.%n",town);
    }

    private static boolean townIsInDatabase(String town, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM towns WHERE name = ?");
        preparedStatement.setString(1,town);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet == null){
            return false;
        }else{
            return resultSet.next();
        }
    }
}