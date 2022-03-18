package dbo;

public class Stundent extends DBOabs {
    private Stundent(int id, int id_group, String fio, String sex) {
        super ("Student");

        this.id = id;
    }
    private String fio;
    private String sex;
    private int id;
    private int id_group;

}
