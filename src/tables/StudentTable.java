package tables;

import dbo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbo.Student;

public class StudentTable extends TableAbs implements ITable<Student> {

    private Student student;

    public StudentTable(String dbType) {
        super(dbType);
    }

    @Override
    public List<Student> list(String[] pred) {
        String requestTemplate = "";
        if (pred.length == 0) {
            requestTemplate = String.format("select * from %s", Student.tableName);
        } else {
            requestTemplate = String.format("select * from %s " + getPredicat(pred), Student.tableName);
        }

        ResultSet resultSet = this.dbExecutor.execute(requestTemplate);

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

    private String getPredicat(String[] predicat) {
        return "where " + String.join(" and ", predicat);


    }
}

