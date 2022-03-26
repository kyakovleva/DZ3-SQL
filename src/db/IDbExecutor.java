package db;

import java.sql.ResultSet;

public interface IDbExecutor {
    ResultSet execute(String sqlRequest);
    int executeUpdate(String sqlRequest);
    void close();
}
