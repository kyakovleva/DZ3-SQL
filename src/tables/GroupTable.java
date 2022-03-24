//package tables;
//
//import dbo.Group;
//import dbo.Student;
//
//import java.util.List;
//
//public class GroupTable extends TableAbs implements ITable {
//    //(select g.id from grоup g where groupname = %s)
//    private Group group;
//
//    public GroupTable(String dbType) {
//        super(dbType);
//    }
//
//    @Override
//    public List<Group> list(String[] pred) {
//        String requestTemplate = "";
//        requestTemplate = String.format("select g.id from grоup g where groupname = %s", Group.tableName)
//        return null;
//    }
//}
