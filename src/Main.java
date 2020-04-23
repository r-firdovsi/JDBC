import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        //
    }

    public static void selectDemo() throws SQLException {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;

        try {
            connection = helper.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM country");
            ArrayList<Country> countries = new ArrayList<Country>();

            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(countries.size());
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
    }

    public static void insertData() throws SQLException {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            connection = helper.getConnection();
            String sql = "INSERT INTO city (Name, CountryCode, District, Population) values (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Turkey 2");
            statement.setString(2,"TUR");
            statement.setString(3,"Duzce");
            statement.setInt(4,500);
            int result = statement.executeUpdate();
            System.out.println("Kayit eklendi");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
    }

    public static void updateData() throws Exception {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            connection = helper.getConnection();
            String sql = "UPDATE city SET population=100, Name='Turkey Country' WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4080);
            int result = statement.executeUpdate();

            System.out.println("Kayit Guncellendi");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
    }

    public static void deleteData() throws SQLException {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            connection = helper.getConnection();
            String sql = "DELETE from city WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4080);
            int result = statement.executeUpdate();

            System.out.println("Kayit Silindi");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
    }
}
