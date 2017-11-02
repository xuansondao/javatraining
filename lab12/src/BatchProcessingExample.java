import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingExample {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = JDBCConnection.getConnect("DESKTOP-GDNLTL9", "sampledb");
            statement = connection.createStatement();

            for (int i = 0; i < 20; i++) {
                String name = "Le Cong Vu";
                int age = 25;
                String sql = "INSERT  INTO student(name, age) VALUES ("+"'" + name + "',"+age+")";
                statement.execute(sql);

            }
            statement.executeBatch();

            ResultSet rs = statement.executeQuery("SELECT COUNT(*)FROM student");
            if(rs.next())
                System.out.println("Total records = " + rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
