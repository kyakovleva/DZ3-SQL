import java.sql.*;


public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            String url = "jdbc:mysql://localhost:3306/OtusDZ3";
            String username = "root";
            String password = "San1Wcx@";
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String selectSql = "SELECT * FROM сurator";

                try (Statement stmt = connection.createStatement()) {
                    try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                        while (resultSet.next()) {
                            String rowData = String.format("id: %s, fio: %s",
                                    resultSet.getString("id"),
                                    resultSet.getString("fio"));
                            System.out.println(rowData);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Incorrect");
            System.out.println(ex);
        }

    }
}
