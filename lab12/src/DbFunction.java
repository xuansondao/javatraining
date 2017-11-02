import java.sql.*;

public class DbFunction {
    public static void getAge(String name, int[] ages){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver:// DESKTOP-GDNLTL9 :1433;databaseName = sampledb;integratedSecurity=true;");
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT MAX(age) FROM student WHERE name  like '%" +name +"%';");
            ages[0] = rs.next()?rs.getInt(1) : -1;


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
        }
    }

    public static void main(String[] args) {
        int [] ages = new int[1];
        getAge("Tran", ages);
        System.out.println(ages[0]);
    }
}
