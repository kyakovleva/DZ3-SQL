package dbo;

public class Curator {
    public final static String tableName = "сurator";

    public Curator(int id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    private int id;
    private String fio;

    public int getId() {
        return this.id;
    }

    public String getFio() {
        return this.fio;
    }
}
