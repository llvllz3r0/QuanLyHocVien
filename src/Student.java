import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    String name, email, phone, classes;
    public void showStudent() {
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            Statement statement = con.createStatement();
            String sql1 = "SELECT * FROM STUDENT";
            ResultSet rs1 = statement.executeQuery(sql1);
            System.out.println("--- Danh Sách Học Viên Trung Tâm ---");
            System.out.println("Họ Tên          Email               SĐT     Lớp");
            while(rs1.next()){
                name = rs1.getString(2);
                email = rs1.getString(3);
                phone = rs1.getString(4);
                classes = rs1.getString(5);
                System.out.println(name +"          "+ email +"         "+ phone +"     "+ classes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
