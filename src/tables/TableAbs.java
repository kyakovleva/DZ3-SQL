package tables;

import db.IDbExecutor;
import db.MySqlDbExecutor;
import dbo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public abstract class TableAbs {

    protected IDbExecutor dbExecutor = null;

    public TableAbs(String dbType) {
        switch (dbType.toLowerCase(Locale.ROOT)) {
            case "mysql": {
                dbExecutor = new MySqlDbExecutor();
                break;
            }
        }
    }

    protected int tableCount(String tableName) {
        String query = "select count(*) from %s";

        ResultSet resultSet = this.dbExecutor.execute(String.format(query, tableName));
        int count = 0;
        try {
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }

        return count;
    }
}
