import com.sun.rowset.FilteredRowSetImpl;

import javax.sql.rowset.FilteredRowSet;
import java.sql.SQLException;

public class DataFilterExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            FilteredRowSet frs = new FilteredRowSetImpl();
            frs.setUrl("jdbc:sqlserver:// DESKTOP-GDNLTL9 :1433;databaseName = sampledb;integratedSecurity=true;");
            frs.setCommand("select * from student");
            frs.setFilter(new DataFilter());
            frs.execute();


            while (frs.next()){
                System.out.println(frs.getInt(1) + "\t" + frs.getString("name") + "\t" + frs.getInt("age"));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
