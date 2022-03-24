//package tables;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UpdateGroupTable extends TableAbs {
//
//    //Обновить данные по группе сменив куратора
//    //Update grоup set id_curator = 4 where id =1
//
//    public UpdateGroupTable(String dbType) {
//        super(dbType);
//    }
//
//    public UpdateGroupTable() {
//        super("mysql");
//    }
//
//    private UpdateGroupTable executeQuery(String updateTable) {
//        String updateTable = "Update grоup set id_curator = 4 where id =1";
//        ResultSet resultSet = this.dbExecutor.execute(updateTable);
//
//        try {
//
//            System.out.println("Group");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
//
//
