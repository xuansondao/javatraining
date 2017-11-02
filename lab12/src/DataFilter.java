import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;

public class DataFilter implements javax.sql.rowset.Predicate {


    public boolean evaluate(RowSet rowSet){
        CachedRowSet crs = (CachedRowSet) rowSet;
        boolean x = false;
        try {
           x = crs.getString("name").indexOf("Le") > -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public boolean evaluate(Object value, int column) throws SQLException {
        return false;
    }

    @Override
    public boolean evaluate(Object value, String columnName) throws SQLException {
        return false;
    }
}
