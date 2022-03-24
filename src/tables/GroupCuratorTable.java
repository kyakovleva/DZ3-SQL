package tables;

import db.IDbExecutor;
import dbo.GroupCurator;
import dbo.StudentGroupCurator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupCuratorTable extends TableAbs implements ITable {
    //Вывести список групп с их кураторами
    //select g.id, g.groupname, c.fio from grоup g inner join сurator c on c.id = g.id_curator"

    public GroupCuratorTable(String dbType) {
        super(dbType);
    }

    public GroupCuratorTable() {
        super("mysql");
    }

    private List<GroupCurator> executeQuery(String query) {
        try {
            ResultSet resultSet = this.dbExecutor.execute(query);
            return mapToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private List<GroupCurator> mapToList(ResultSet resultSet) throws SQLException {
        List<GroupCurator> list = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            GroupCurator groupCurator = new GroupCurator(
                    resultSet.getInt("g.id"),
                    resultSet.getString("g.groupname"),
                    resultSet.getString("c.fio")
            );
            list.add(groupCurator);
        }
        return list;
    }

    @Override
    public List<GroupCurator> list(String[] pred) {
        String query = "select g.id, g.groupname, c.fio from grоup g inner join сurator c on c.id = g.id_curator";
        return executeQuery(query);
    }

    public static List<GroupCurator> list() {
        return new GroupCuratorTable().list(new String[]{});
    }
}

