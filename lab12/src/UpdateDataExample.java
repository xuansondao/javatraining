import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataExample {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = JDBCConnection.getConnect("DESKTOP-GDNLTL9", "sampledb");
            preparedStatement = connection.prepareStatement("UPDATE student set name = ? WHERE  id = ?");
            preparedStatement.setNString(1, "dao xuan son");
            preparedStatement.setInt(2, 3);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
