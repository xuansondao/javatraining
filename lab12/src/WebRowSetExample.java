import com.sun.rowset.WebRowSetImpl;

import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class WebRowSetExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver:// DESKTOP-GDNLTL9 :1433;databaseName = sampledb;integratedSecurity=true;");
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM student");

            File file = new File("output.xml");
            FileWriter writer = new FileWriter(file);
            WebRowSet webRowSet = new WebRowSetImpl();
            webRowSet.writeXml(rs, writer);

            Desktop.getDesktop().open(file);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
