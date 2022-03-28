import dbo.Student;
import model.GroupInfo;
import model.StudentsInfo;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;
import tables.joins.GroupsInfoTable;
import tables.joins.StudentsInfoTable;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String databaseType = "mysql";

    public static void main(String... args) {

        StudentTable studentTable = new StudentTable(databaseType);
        CuratorTable curatorTable = new CuratorTable(databaseType);
        GroupTable groupTable = new GroupTable(databaseType);
        StudentsInfoTable studentsInfoTable = new StudentsInfoTable(databaseType);
        GroupsInfoTable groupsInfoTable = new GroupsInfoTable(databaseType);

        task5(studentsInfoTable);
        task6(studentTable);
        task7(studentTable);
        task8(curatorTable, groupTable);
        task9(groupsInfoTable);
        task10(studentTable);
    }

    private static void task5(StudentsInfoTable studentsInfoTable) {
        System.out.println("Задание №5: Вывести на экран информацию о всех студентах включая название группы и имя куратора");

        List<StudentsInfo> studentsInfos = studentsInfoTable.getInfo();

        if (studentsInfos != null && !studentsInfos.isEmpty()) {
            for (StudentsInfo studentsInfo : studentsInfos) {
                System.out.println(studentsInfo.toString());
            }
        } else {
            System.out.println("Информации о студентах не найдено");
        }

        System.out.println("==============================================================================================");
    }

    private static void task6(StudentTable studentTable) {
        System.out.println("Задание №6: Вывести на экран количество студентов");

        int studentsCount = studentTable.tableCount();

        System.out.println(String.format("Количество студентов = %d", studentsCount));

        System.out.println("==============================================================================================");
    }

    private static void task7(StudentTable studentTable) {
        System.out.println("Задание №7: Вывести студенток");

        List<Student> students = studentTable.list(" where sex=\'W\'");

        if (students != null && !students.isEmpty()) {
            for (Student student : students) {
                System.out.println(student.getFio());
            }
        } else {
            System.out.println("Информации о студентках не найдено");
        }

        System.out.println("==============================================================================================");
    }

    private static void task8(CuratorTable curatorTable, GroupTable groupTable) {
        System.out.println("Задание №8: Обновить данные по группе сменив куратора");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите наименование группы");
        String groupName = scanner.nextLine();

        System.out.println("Введите ФИО нового куратора для группы");
        String fioCurator = scanner.nextLine();

        Integer groupId = groupTable.getGroupByName(groupName);
        if (groupId == null) {
            System.out.printf("Группа с именем = %s не найдена", groupName);
            System.out.println("==============================================================================================");
            return;
        }

        Integer newCuratorId = curatorTable.getCuratorByName(fioCurator);
        if (newCuratorId == null) {
            System.out.printf("Куратор с ФИО = %s не найден", fioCurator);
            System.out.println("==============================================================================================");
            return;
        }

        int resultUpdate = groupTable.updateCurator(groupId, newCuratorId);
        if(resultUpdate > 0) {
            System.out.println("Группа обновлена");
        } else {
            System.out.println("Группа не обновлена");
        }

        System.out.println("==============================================================================================");
    }

    private static void task9(GroupsInfoTable groupsInfoTable) {
        System.out.println("Задание №9: Вывести список групп с их кураторами");

        List<GroupInfo> groupInfos = groupsInfoTable.getInfo();

        if (groupInfos != null && !groupInfos.isEmpty()) {
            for (GroupInfo groupInfo : groupInfos) {
                System.out.println(groupInfo.toString());
            }
        } else {
            System.out.println("Информации о группах и кураторах не найдено");
        }

        System.out.println("==============================================================================================");
    }

    private static void task10(StudentTable studentTable) {
        System.out.println("Задание №10: Используя вложенные запросы вывести студентов из определенной группы");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите наименование группы");
        String groupName = scanner.nextLine();

        List<Student> students = studentTable.getStudentsByGroup(groupName);
        if (students != null && !students.isEmpty()) {
            for (Student student : students) {
                System.out.println(student.getFio());
            }
        } else {
            System.out.printf("Студенты, входящие в группу = %s не найдены", groupName);
        }

        System.out.println("==============================================================================================");
    }
}
