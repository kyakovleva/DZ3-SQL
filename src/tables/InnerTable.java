package tables;

import dbo.Group;
import dbo.GroupCurator;
import dbo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InnerTable extends TableAbs implements ITable {

    //Используя вложенные запросы вывести на экран студентов из определенной группы(поиск по имени группы)
    //Select * from student s where s.id_group = (select g.id from grоup g where groupname = 'Group 1')
    //Select * from student s where s.id_group = (select g.id from grоup g where groupname = %s)

    public InnerTable(String dbType) {
        super(dbType);
    }

    public InnerTable() {
        super("mysql");
    }

    private Student student;

    @Override
    public List<Student> list (String[] requestStudents) {


        String requestStudentsgroup = "";
        requestStudentsgroup = String.format("Select * from student s where s.id_group = (select g.id from grоup g where groupname = %s)", Group.tableName);
        ResultSet resultSet = this.dbExecutor.execute(requestStudentsgroup);

        List<Student> groupstudents = new ArrayList<>();

        try {
            while (resultSet.next()) {
                groupstudents.add(new Student(
                        resultSet.getInt(1),
                        resultSet.getInt(4),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }

        return groupstudents;
    }
}

//    private String getInnerQuery(String[] innerquery) {
//        return "where " + String.join(" and ", predicat); }



