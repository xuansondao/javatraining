import com.sun.rowset.CachedRowSetImpl;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAcessLogic {
    private final static Logger logger = Logger.getLogger(DataAcessLogic.class.getName());
    Connection connection = null;
    CachedRowSet rowSet;

    public DataAcessLogic() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlserver:// DESKTOP-GDNLTL9 :1433;databaseName = sampledb;integratedSecurity=true;");
            rowSet = new CachedRowSetImpl();
            rowSet.setCommand("Select * from student");
            rowSet.execute(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void disconnect() {

        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.toString());
        }
    }

    int pageSize  =10;
    List<String> loadNames(int page) throws SQLException {
        List<String> names = new ArrayList<>();
        rowSet.setPageSize(pageSize);
        int start = (page-1)*pageSize + 1;
        if(!rowSet.absolute(start))
            return names;

        rowSet.previous();
        while (rowSet.next()){
            names.add(rowSet.getString("name"));
            if(names.size() > pageSize)
                break;
        }
        return names;

    }

    int numberOfPage(){
        Statement statement = null;
        int totalPage = 0;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT (*) FROM student");
            if(!rs.next()) return 0;
            int total = rs.getInt(1);
            totalPage = total/pageSize;
            if(total % pageSize != 0) totalPage++;


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalPage;
    }

}
