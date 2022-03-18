package dbo;

public abstract class DBOabs {
    protected String tableName = "";

    public DBOabs(String tableName) {
        this.tableName = tableName;
    }
}
