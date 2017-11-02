
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCFirstExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        File file = new File("sampledb");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = JDBCConnection.getConnect("DESKTOP-GDNLTL9", "sampledb");

            statement = connection.createStatement();
            System.out.println("db path" + file.getAbsolutePath());
            System.out.println("Creat database successful");

            String sql = "create table student(\n" +
                    "\tid bigint identity(1, 1) primary key,\n" +
                    "\tname varchar(100),\n" +
                    "\tage integer default 20\n" +
                    ");";
            boolean x = statement.execute(sql);
            System.out.println(x);
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
