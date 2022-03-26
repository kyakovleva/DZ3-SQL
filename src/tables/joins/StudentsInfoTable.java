package tables.joins;

import dbo.Curator;
import dbo.Group;
import dbo.Student;
import model.StudentsInfo;
import tables.TableAbs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsInfoTable extends TableAbs implements JoinTable<StudentsInfo> {

    public StudentsInfoTable(String dbType) {
        super(dbType);
    }

    public List<StudentsInfo> getInfo() {
        String query = "select s.id, s.FIO, s.SEX, g.GROUPNAME, cr.FIO" +
                " from %s s" +
                "         join %s g on s.ID_GROUP = g.ID" +
                "         join %s CR on CR.ID = g.ID_CURATOR";


        ResultSet resultSet = this.dbExecutor.execute(String.format(query, Student.tableName, Group.tableName, Curator.tableName));

        List<StudentsInfo> studentsInfos = new ArrayList<>();

        try {
            while (resultSet.next()) {
                studentsInfos.add(new StudentsInfo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }
        return studentsInfos;
    }
}
