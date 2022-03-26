package db;

import utils.resources.IReadProperty;
import utils.resources.ReadPropertiesFromPropsFile;

import java.sql.*;
import java.util.Properties;

public class MySqlDbExecutor implements IDbExecutor {

    private static Connection connect = null;
    private static Statement statement = null;

    @Override
    public ResultSet execute(String sqlRequest) {
        IReadProperty<Properties> readerProps = new ReadPropertiesFromPropsFile();
        Properties properties = readerProps.read();

        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection(
                    properties.getProperty("url") + "/" + properties.getProperty("db_name"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );

            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlRequest);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultSet;
    }

    @Override
    public int executeUpdate(String sqlRequest) {
        IReadProperty<Properties> readerProps = new ReadPropertiesFromPropsFile();
        Properties properties = readerProps.read();

        int updateQuery = 0;

        try {
            connect = DriverManager.getConnection(
                    properties.getProperty("url") + "/" + properties.getProperty("db_name"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );

            statement = connect.createStatement();
            updateQuery = statement.executeUpdate(sqlRequest);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return updateQuery;
    }

    @Override
    public void close() {
        try {
            connect.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
