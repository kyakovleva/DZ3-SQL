import dbo.GroupCurator;
import dbo.Student;
import dbo.StudentGroupCurator;
import tables.CommonJoin;
import tables.GroupCuratorTable;
import tables.StudentTable;

import java.util.List;

public class Main {

    public static void main(String... args) {
        List<Student> students = new StudentTable("mysql").list(new String[]{"sex=\"w\""});
        int studentsCount = new StudentTable("mysql").list(new String[]{}).size();

        List<StudentGroupCurator> sgc = CommonJoin.list();
        List<GroupCurator> gct = GroupCuratorTable.list();

        List<Student> innerstudents = InnerTable.list(new String[]{"Group 1"});
        //Вывести студенток
        for (Student student : students) {
            System.out.println(student);
        }
        //Вывести на экран информацию о всех студентах включая название группы и имя куратора
        for (StudentGroupCurator stud : sgc) {
            System.out.println(stud);
        }
        //Вывести на экран количество студентов
        System.out.println(studentsCount);
        //Обновить данные по группе сменив куратора
        System.out.println("ДОПИСАТЬ КОД");
        //Вывести список групп с их кураторами
        for (GroupCurator groupCurator : gct) {
            System.out.println(groupCurator);
        }
        //Используя вложенные запросы вывести на экран студентов из определенной группы(поиск по имени группы)

//        for (Student inner : innerstudents) {
//            System.out.println(inner); }
//    }

}

