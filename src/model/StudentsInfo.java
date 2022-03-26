package model;

public class StudentsInfo {
    private int id;
    private String fio;
    private String sex;
    private int idgroup;
    private String groupname;
    private String curatorfio;

    @Override
    public String toString() {
        return "StudentsInfo{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", sex='" + sex + '\'' +
                ", groupname='" + groupname + '\'' +
                ", curatorfio='" + curatorfio + '\'' +
                '}';
    }

    public StudentsInfo(int id, String fio, String sex, String groupname, String curatorfio) {
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.idgroup = idgroup;
        this.groupname = groupname;
        this.curatorfio = curatorfio;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getSex() {
        return sex;
    }

    public int getIdgroup() {
        return idgroup;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getCuratorfio() {
        return curatorfio;
    }
}

