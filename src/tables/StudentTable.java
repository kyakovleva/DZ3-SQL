package tables;

import dbo.Group;
import dbo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentTable extends TableAbs {

    public StudentTable(String dbType) {
        super(dbType);
    }

    public List<Student> list(String params) {
        //Вывести студенток
        ResultSet resultSet = this.dbExecutor.execute(String.format("select id, fio, sex, id_group from %s %s", Student.tableName, params));

        List<Student> students = new ArrayList<>();

        try {
            while (resultSet.next()) {
                students.add(new Student(
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

        return students;
    }
//Вывести на экран количество студентов

    public int studentsCount() {
        String query = "select count(*) from %s";

        ResultSet resultSet = this.dbExecutor.execute(String.format(query, Student.tableName));
        int count = 0;
        try {
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }

        return count;
    }

    public List<Student> getStudentsByGroup(String groupName) {
//Используя вложенные запросы вывести на экран студентов из определенной группы(поиск по имени группы)
        ResultSet resultSet = this.dbExecutor.execute(String.format("select id, fio, sex, id_group from %s where ID_GROUP in (select id from %s where GROUPNAME =\'%s\')"
                , Student.tableName, Group.tableName, groupName));

        List<Student> students = new ArrayList<>();

        try {
            while (resultSet.next()) {
                students.add(new Student(
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

        return students;
    }
}


