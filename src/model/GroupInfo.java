package model;

public class GroupInfo {
    private int idgroup;
    private String groupname;
    private String curatorfio;

    @Override
    public String toString() {
        return "GroupInfo{" +
                "idgroup=" + idgroup +
                ", groupname='" + groupname + '\'' +
                ", curatorfio='" + curatorfio + '\'' +
                '}';
    }

    public GroupInfo(int idgroup, String groupname, String curatorfio) {
        this.idgroup = idgroup;
        this.groupname = groupname;
        this.curatorfio = curatorfio;
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
