package dbo;

public class Student {
    public final static String tableName = "Student";

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", sex='" + sex + '\'' +
                ", idGroup=" + idGroup +
                '}';
    }

    public Student(int id, int idGroup, String fio, String sex) {
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.idGroup = idGroup;
    }

    private int id;
    private String fio;
    private String sex;
    private int idGroup;

    public int getId() {
        return this.id;
    }

    public String getFio() {
        return this.fio;
    }

    public String getSex(String w) {
        return this.sex;
    }

    public int getIdGroup() {
        return this.idGroup;
    }
}
