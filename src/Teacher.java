import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Teacher {
    Connection con = JDBCConnection.getJDBCConnection();
    Scanner scan = new Scanner(System.in);
    public boolean signIn(){

        String account, fistName, lastName, email;
        List<String> accountDB = new ArrayList<String>();
        boolean signIn = false;

        System.out.println("ĐĂNG NHẬP:");
        System.out.println("Nhập account: ");
        account = scan.nextLine();
        System.out.println("Nhập fist name: ");
        fistName = scan.nextLine();
        System.out.println("Nhập last name: ");
        lastName = scan.nextLine();
        System.out.println("Nhập email: ");
        email = scan.nextLine();
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT ACCOUNT FROM TEACHER";
            ResultSet rs = statement.executeQuery(sql) ;

            while(rs.next()) {
                accountDB.add(rs.getString(1));
            }

            for(String ac : accountDB){
                if(account.equals(ac)){
                    signIn = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(signIn == true){
            System.out.println("ĐĂNG NHẬP THÀNH CÔNG");
            Student std = new Student();
            std.showStudent();
            try {
                Statement statement1 = con.createStatement();
                String sql = "UPDATE TEACHER SET FIRST_NAME = '" +fistName+ "', LAST_NAME = '" +lastName+ "', EMAIL = '" +email+ "', LAST_LOGIN = SYSDATE WHERE ACCOUNT = '" +account+ "'";
                statement1.executeQuery(sql);
            } catch (SQLException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("ĐĂNG NHẬP THẤT BẠI");
            System.out.println("Đăng nhập lại!");
            this.signIn();
        }
        return signIn;
    }

    public void filter() {
        try {
            Statement statement = con.createStatement();
            String sql1 = "SELECT * FROM STUDENT WHERE CLASS = 'CL01'";
            String sql2 = "SELECT * FROM STUDENT WHERE CLASS = 'CL02'";
            ResultSet rs1 = statement.executeQuery(sql1);
            System.out.println("Danh Sách Học Viên Của CL01");
            while(rs1.next()){
                String name = rs1.getString(2);
                String email = rs1.getString(3);
                String telephone = rs1.getString(4);
                System.out.println(name+ "      " +email+ "        " +telephone);
            }
            ResultSet rs2 = statement.executeQuery(sql2);
            System.out.println("Danh Sách Học Viên Của CL02");
            while(rs2.next()){
                String name = rs2.getString(2);
                String email = rs2.getString(3);
                String telephone = rs2.getString(4);
                System.out.println(name+ "      " +email+ "        " +telephone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sortByName() {
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM STUDENT ORDER BY NAME";
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Danh Sách Học Viên Sắp Xếp Theo Tên");
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String telephone = rs.getString(4);
                String classes = rs.getString(5);
                System.out.println(id+ "    " +name+ "     " +email+ "     " +telephone+ "     " +classes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sortByPhone() {
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM STUDENT ORDER BY TELEPHONE";
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Danh Sách Học Viên Sắp Xếp Theo Tên");
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String telephone = rs.getString(4);
                String classes = rs.getString(5);
                System.out.println(id+ "    " +name+ "     " +email+ "     " +telephone+ "     " +classes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sortByEmail() {
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM STUDENT ORDER BY EMAIL";
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Danh Sách Học Viên Sắp Xếp Theo Tên");
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String telephone = rs.getString(4);
                String classes = rs.getString(5);
                System.out.println(id+ "    " +name+ "     " +email+ "     " +telephone+ "     " +classes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByName() {
        List<String> listName = new ArrayList<String>();
        System.out.println("Nhập tên học viên muốn tìm:");
        String findName = scan.nextLine();
        boolean haveName = false;
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM STUDENT";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                listName.add(rs.getString(2));
            }
            for(String name : listName){
                if(findName.equals(name)){
                    haveName = true;
                    break;
                } else{
                    haveName = false;
                }
            }
            if(haveName == false){
                System.out.println("Không có học viên nào");
            } else {
                String sql1 = "SELECT * FROM STUDENT WHERE NAME = '" +findName+"'";
                ResultSet rs1 = statement.executeQuery(sql1);
                while(rs1.next()){
                    String id = rs1.getString(1);
                    String fullName = rs1.getString(2);
                    String email = rs1.getString(3);
                    String telephone = rs1.getString(4);
                    String classes = rs1.getString(5);
                    System.out.println(id + "   " +fullName+ "      " +email+ "     " +telephone+ "     " +classes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByPhone() {
        List<String> listPhone = new ArrayList<String>();
        System.out.println("Nhập số điện thoại học viên muốn tìm:");
        String findPhone = scan.nextLine();
        boolean havePhone = false;
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM STUDENT";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                listPhone.add(rs.getString(4));
            }
            for(String phone : listPhone){
                if(findPhone.equals(phone)){
                    havePhone = true;
                    break;
                } else{
                    havePhone = false;
                }
            }
            if(havePhone == false){
                System.out.println("Không có học viên nào");
            } else {
                String sql1 = "SELECT * FROM STUDENT WHERE TELEPHONE = '" +findPhone+"'";
                ResultSet rs1 = statement.executeQuery(sql1);
                while(rs1.next()){
                    String id = rs1.getString(1);
                    String fullName = rs1.getString(2);
                    String email = rs1.getString(3);
                    String telephone = rs1.getString(4);
                    String classes = rs1.getString(5);
                    System.out.println(id + "   " +fullName+ "      " +email+ "     " +telephone+ "     " +classes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByEmail() {
        List<String> listEmail = new ArrayList<String>();
        System.out.println("Nhập email học viên muốn tìm:");
        String findEmail = scan.nextLine();
        boolean haveEmail = false;
        try {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM STUDENT";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                listEmail.add(rs.getString(3));
            }
            for(String email : listEmail){
                if(findEmail.equals(email)){
                    haveEmail = true;
                    break;
                } else{
                    haveEmail = false;
                }
            }
            if(haveEmail == false){
                System.out.println("Không có học viên nào");
            } else {
                String sql1 = "SELECT * FROM STUDENT WHERE EMAIL = '" +findEmail+"'";
                ResultSet rs1 = statement.executeQuery(sql1);
                while(rs1.next()){
                    String id = rs1.getString(1);
                    String fullName = rs1.getString(2);
                    String email = rs1.getString(3);
                    String telephone = rs1.getString(4);
                    String classes = rs1.getString(5);
                    System.out.println(id + "   " +fullName+ "      " +email+ "     " +telephone+ "     " +classes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        int i = 0;
        boolean haveClass = false;
        System.out.println("Nhập thông tin học viên muốn thêm:");
        System.out.println("Nhập tên:");
        String name = scan.nextLine();
        System.out.println("Nhập email: ");
        String email = scan.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String telephone = scan.nextLine();
        System.out.println("Nhập lớp:");
        String classes = scan.nextLine();
        List<String> listClass = new ArrayList<String>();
        try {
            Statement statement = con.createStatement();
            String sql1 = "SELECT * FROM CLASSES";
            ResultSet rs1 = statement.executeQuery(sql1);
            while(rs1.next()){
                listClass.add(rs1.getString(1));
            }
            for(String cl : listClass){
                if(classes.equals(cl)){
                    haveClass = true;
                    break;
                }
            }

            if(haveClass == false){
                System.out.println("THÊM HỌC VIÊN THÂT BẠI");
                System.out.println("Không có lớp nào");
            } else {
                String sql2 = "SELECT COUNT(*) FROM STUDENT";
                ResultSet rs2 = statement.executeQuery(sql2);
                while(rs2.next()){
                    i = Integer.parseInt(rs2.getString(1));
                }
                System.out.println("THÊM HỌC VIÊN THÀNH CÔNG");
                    String sql3 = "INSERT INTO STUDENT VALUES('STD" + ++i + "', '" + name + "', '" + email + "', '" + telephone + "', '" +classes+ "')";
                    statement.executeQuery(sql3);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeStudent() {
        System.out.println("Nhập mã học viên cần xóa");
        String idRemove = scan.nextLine();
        boolean haveID = false;
        List<String> listID = new ArrayList<String>();
        try {
            Statement statement = con.createStatement();
            String sql1 = "SELECT * FROM STUDENT";
            ResultSet rs1 = statement.executeQuery(sql1);
            while(rs1.next()){
                listID.add(rs1.getString(1));
            }
            for(String id : listID){
                if(idRemove.equals(id)){
                    haveID = true;
                    break;
                }
            }
            if(haveID == false){
                System.out.println("XÓA HỌC VIÊN KHÔNG THÀNH CÔNG");
                System.out.println("Không có học viên nào");
                System.out.println("Nhập lại");
                this.removeStudent();
            } else {
                System.out.println("XÓA HỌC VIÊN THÀNH CÔNG");
                String sql2= "DELETE FROM STUDENT WHERE ID = '" +idRemove+ "'";
                statement.executeQuery(sql2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void replaceStudent() {
        System.out.println("Nhập mã học viên cần sửa");
        String idReplace = scan.nextLine();
        System.out.println("Nhập tên muốn sửa");
        String name = scan.nextLine();
        System.out.println("Nhập email muốn sửa");
        String email = scan.nextLine();
        System.out.println("Nhập số điện thoại muốn sửa");
        String telephone = scan.nextLine();
        System.out.println("Nhập tên lớp muốn sửa");
        String classReplace = scan.nextLine();
        boolean haveID = false;
        boolean haveClass = false;
        List<String> listID = new ArrayList<String>();
        List<String> listClass = new ArrayList<String>();
        try {
            Statement statement = con.createStatement();
            String sql1 = "SELECT * FROM STUDENT";
            ResultSet rs1 = statement.executeQuery(sql1);
            while(rs1.next()){
                listID.add(rs1.getString(1));
            }
            String sql2 = "SELECT * FROM CLASSES";

            ResultSet rs2 = statement.executeQuery(sql2);
            while(rs2.next()){
                listClass.add(rs2.getString(1));
            }

            for(String id : listID){
                if(idReplace.equals(id)){
                    haveID = true;
                    break;
                }
            }

            for(String classes : listClass ){
                if(classReplace.equals(classes)){
                    haveClass = true;
                    break;
                }
            }
            if(haveID == false || haveClass == false){
                System.out.println("SỬA HỌC VIÊN KHÔNG THÀNH CÔNG");
                System.out.println("Không có học viên nào");
                System.out.println("Nhập lại");
                this.replaceStudent();
            } else if(haveClass == true) {
                System.out.println("SỬA HỌC VIÊN THÀNH CÔNG");
                String sql3= "UPDATE STUDENT SET NAME = '" +name+ "', EMAIL = '" +email+ "', TELEPHONE = '" +telephone+ "', CLASS = '" +classReplace+"' WHERE ID = '" +idReplace +"'";
                statement.executeQuery(sql3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
