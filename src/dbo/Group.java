package dbo;

public class Group {
    public final static String tableName = "grоup";

    public Group(int id, String groupname, int id_curator) {
        this.id = id;
        this.groupname = groupname;
        this.id_curator = id_curator;
    }

    private int id;
    private String groupname;
    private int id_curator;

    public int getId() {
        return this.id;
    }

    public String getGroupname() {
        return this.groupname;
    }

    public int getId_curator() {
        return this.id_curator;
    }
}
