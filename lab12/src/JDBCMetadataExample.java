import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JDBCMetadataExample {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = JDBCConnection.getConnect("DESKTOP-GDNLTL9", "sampledb");
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("user name: " + metaData.getUserName());
            System.out.println("db version " + metaData.getDatabaseMajorVersion());
            System.out.println("driver name: " +metaData.getDriverName());
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
