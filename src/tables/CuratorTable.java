package tables;

import dbo.Curator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CuratorTable extends TableAbs {

    public CuratorTable(String dbType) {
        super(dbType);
    }

    public Integer getCuratorByName(String curatorName) {
        ResultSet resultSet = this.dbExecutor.execute(String.format("select id from %s where fio = \'%s\'", Curator.tableName, curatorName));

        Integer curatorId = null;

        try {
            while (resultSet.next()) {
                curatorId = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }
        return curatorId;
    }
}