import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Teacher t = new Teacher();
        String select;
        t.signIn();
            do {
                System.out.println("Nhập lựa chọn");
                System.out.println("1 - Lọc danh sách học viên theo lớp");
                System.out.println("2 - Tìm học viên theo tên");
                System.out.println("3 - Tìm học viên theo email");
                System.out.println("4 - Tìm học viên theo số điện thoại");
                System.out.println("5 - Sắp xếp học viên theo tên");
                System.out.println("6 - Sắp xếp học viên theo email");
                System.out.println("7 - Sắp xếp học viên theo số điện thoại");
                System.out.println("8 - Thêm học viên");
                System.out.println("9 - Xóa học viên");
                System.out.println("10 - Sửa học viên");
                System.out.println("Nhấn số bất kì để thoát");
                select = scan.nextLine();
                switch (select){
                    case "1": {
                        t.filter();
                        break;
                    }
                    case "2": {
                        t.findByName();
                        break;
                    }
                    case "3": {
                        t.findByEmail();
                        break;
                    }
                    case "4": {
                        t.findByPhone();
                        break;
                    }
                    case "5": {
                        t.sortByName();
                        break;
                    }
                    case "6": {
                        t.sortByEmail();
                        break;
                    }
                    case "7": {
                        t.sortByPhone();
                        break;
                    }
                    case "8": {
                        t.addStudent();
                        break;
                    }
                    case "9": {
                        t.removeStudent();
                        break;
                    }
                    case "10": {
                        t.replaceStudent();
                        break;
                    }
                }
            } while (Integer.parseInt(select) >= 1 && Integer.parseInt(select) <= 10 );
    }
}
