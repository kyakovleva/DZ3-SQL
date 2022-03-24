package tables;

import dbo.Curator;
import dbo.Group;
import dbo.Student;
import dbo.StudentGroupCurator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

///Вывести на экран информацию о всех студентах включая название группы и имя куратора
//select* from student s
//        inner join group g on g.id = s.id_group
//inner join curator c on c.id = g.id_curator

public class CommonJoin extends TableAbs implements ITable<StudentGroupCurator> {


    public CommonJoin(String dbType) {
        super(dbType);
    }

    public CommonJoin() {
        super("mysql");
    }

    private List<StudentGroupCurator> executeQuery(String query) {
        try {
            ResultSet resultSet = this.dbExecutor.execute(query);
            return mapToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private List<StudentGroupCurator> mapToList(ResultSet resultSet) throws SQLException {
        List<StudentGroupCurator> list = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            StudentGroupCurator studentGroupCurator = new StudentGroupCurator(
                    resultSet.getInt("s.id"),
                    resultSet.getString("fio"),
                    resultSet.getString("sex"),
                    resultSet.getInt("g.id"),
                    resultSet.getString("groupname"),
                    resultSet.getString("c.fio")
            );
            list.add(studentGroupCurator);
        }
        return list;
    }

    @Override
    public List<StudentGroupCurator> list(String[] pred) {
        String query = "select s.id, s.fio, s.sex, g.id, g.groupname, c.fio from student s inner join grоup g on g.id = s.id_group inner join сurator c on c.id = g.id_curator";
        return executeQuery(query);
    }

    public static List<StudentGroupCurator> list() {
        return new CommonJoin().list(new String[]{});
    }
}
