import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = JDBCConnection.getConnect("DESKTOP-GDNLTL9", "sampledb");
            statement = connection.createStatement();
            statement.execute("INSERT  INTO student(name, age) VALUES('Tran Van B', 26)");
            statement.execute("INSERT  INTO student(name, age) VALUES('Tran Van B', 37)");
            statement.execute("INSERT  INTO student(name, age) VALUES('Tran Van B', 60)");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
