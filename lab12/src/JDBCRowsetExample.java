import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.SQLException;

public class JDBCRowsetExample {
    public static void main(String[] args) {

        JdbcRowSet jdbcRowSet = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            jdbcRowSet = new JdbcRowSetImpl();
            jdbcRowSet.setUrl("jdbc:sqlserver:// DESKTOP-GDNLTL9 :1433;databaseName = sampledb;integratedSecurity=true;");
            jdbcRowSet.setUsername("DESKTOP-GDNLTL9\\xuanson");
            jdbcRowSet.setPassword("");
            String sql = "select * from student";
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.execute();
            while (jdbcRowSet.next()){
                System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString("name"));
            }
            jdbcRowSet.first();
            jdbcRowSet.updateNString("name", "Hoang Van X");
            jdbcRowSet.commit();

            jdbcRowSet.first();
            System.out.println(jdbcRowSet.getInt("id") + "\t" + jdbcRowSet.getNString(2));
            jdbcRowSet.absolute(8);
            System.out.println(jdbcRowSet.getNString("name") + " : " + jdbcRowSet.getInt("age"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                jdbcRowSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
