import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = JDBCConnection.getConnect("DESKTOP-GDNLTL9", "sampledb");
            statement = connection.createStatement();

            connection.setAutoCommit(false);
            for (int i = 0; i < 10; i++){
                String name = "Dao Xuan " + i;
                int age =10 + i;
                statement.executeUpdate("INSERT  INTO student(name, age) VALUES ("+"'" + name + "',"+age+")");
            }
            connection.rollback();
            connection.setAutoCommit(true);
            rs = statement.executeQuery("SELECT COUNT (*) FROM student");
            if(rs.next()) System.out.println("ToTal records = " + rs.getInt(1));


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
