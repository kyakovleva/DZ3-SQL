package tables;

import db.IDbExecutor;
import db.MySqlDbExecutor;

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
}
