package tables.joins;

import dbo.Curator;
import dbo.Group;
import model.GroupInfo;
import tables.TableAbs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupsInfoTable extends TableAbs implements JoinTable<GroupInfo> {

    public GroupsInfoTable(String dbType) {
        super(dbType);
    }

    public List<GroupInfo> getInfo() {
        String query = "select g.id, g.GROUPNAME, c.FIO" +
                " from %s g" +
                "         join %s C on C.ID = g.ID_CURATOR";

        ResultSet resultSet = this.dbExecutor.execute(String.format(query, Group.tableName, Curator.tableName));

        List<GroupInfo> groupInfos = new ArrayList<>();

        try {
            while (resultSet.next()) {
                groupInfos.add(new GroupInfo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }
        return groupInfos;
    }
}