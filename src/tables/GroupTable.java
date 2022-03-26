package tables;

import dbo.Group;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupTable extends TableAbs {

    public GroupTable(String dbType) {
        super(dbType);
    }

    public Integer getGroupByName(String groupName) {
        ResultSet resultSet = this.dbExecutor.execute(String.format("select id from %1s where groupName = \'%2s\'", Group.tableName, groupName));

        Integer groupId = null;

        try {
            while (resultSet.next()) {
                groupId = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }
        return groupId;
    }

    public int updateCurator(int groupId, int newCuratorId) {
        return this.dbExecutor.executeUpdate(String.format("update %s set id_curator=%d where id=%d", Group.tableName, newCuratorId, groupId));
    }
}
