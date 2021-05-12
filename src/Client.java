import controller.Check;
import controller.Manager;
import model.Phonebook;
import storage.filePhonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        List<Phonebook> phonebookList = new ArrayList<>();
        filePhonebook filePhonebook = new filePhonebook();
        phonebookList = filePhonebook.getData();
        Manager hai = new Manager(phonebookList);
        Check checker = new Check();


        while (true){
            System.out.println("CHƯƠNG TRÌNH QUẢN LÍ DANH BẠ.");
            System.out.println("Chọn chức năng theo số để tiếp tục.");
            System.out.println("1: Xem danh sách.");
            System.out.println("2: Thêm mới");
            System.out.println("3: Cập nhật");
            System.out.println("4: Xóa");
            System.out.println("5: Tìm kiếm");
            System.out.println("6: Đọc từ file.");
            System.out.println("7: Ghi vào file");
            System.out.println("8: Thoát");
            System.out.println("Chọn chức năng");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    hai.showAllPhonebook();
                    break;
                case 2:
                    System.out.println("Mời nhập tên:");
                    Scanner scanner1 = new Scanner(System.in);
                    String name = scanner1.nextLine();
                    System.out.println("Mời nhập số điện thoại:");
                    Scanner scanner2 = new Scanner(System.in);
                    String phoneNumber = scanner2.nextLine();
                    System.out.println("Mời nhập địa chỉ:");
                    Scanner scanner3 = new Scanner(System.in);
                    String address = scanner3.nextLine();
                    System.out.println("Mời nhập email:");
                    Scanner scanner4 = new Scanner(System.in);
                    String email = scanner4.nextLine();
                    System.out.println("Mời nhập facebook:");
                    Scanner scanner5 = new Scanner(System.in);
                    String facebook = scanner5.nextLine();
                    Phonebook phonebook = new Phonebook(name,phoneNumber,address,email,facebook);
                    hai.addNewPhoneBook(phonebook);
                    break;
                case 3:
                    String phoneNumber3;
                    Scanner scanner6 = new Scanner(System.in);
                    do {
                        System.out.println("Nhập số điện thoại để thực hiện sửa:");
                        phoneNumber3 = scanner6.nextLine();
                    }while (!checker.checkPhoneNumber(phoneNumber3));
                    System.out.println("Nhập tên mới.");
                    Scanner scanner7 = new Scanner(System.in);
                    String newName = scanner7.nextLine();
                    System.out.println("Nhập địa chỉ mới.");
                    Scanner scanner8 = new Scanner(System.in);
                    String newAddress = scanner8.nextLine();
                    System.out.println("Nhập email mới.");
                    Scanner scanner9 = new Scanner(System.in);
                    String newEmail = scanner9.nextLine();
                    System.out.println("Nhập facebook mới.");
                    Scanner scanner10 = new Scanner(System.in);
                    String newFacebook = scanner10.nextLine();
                    hai.editPhonebook(phoneNumber3,newName, newAddress,newEmail,newFacebook);
                    break;
                case 4:
                    String phoneNumber4;
                    Scanner scanner11 = new Scanner(System.in);
                    do {
                        System.out.println("Nhập số điện thoại cho danh bạ cần xóa.");
                        phoneNumber4 = scanner11.nextLine();
                    }while (checker.checkPhoneNumber(phoneNumber4));
                    hai.deletePhoneBook(phoneNumber4);
                    break;
                case 5:
                    String phoneNumber5;
                    Scanner scanner12 = new Scanner(System.in);
                    do {
                        System.out.println("nhập số điện thoại để tìm kiếm danh bạ");
                        phoneNumber5 = scanner12.nextLine();
                    }while (checker.checkPhoneNumber(phoneNumber5));
                    hai.searchByPhoneNumber(phoneNumber5);
                    break;
                case 6:
                    phonebookList = filePhonebook.getData();
                    System.out.println("Đọc dữ liệu thành công");
                    break;
                case 7:
                    filePhonebook.setData(phonebookList);
                    System.out.println("ghi dữ liệu vào file thành công");
                    break;
                case 8:
                    return;
            }
        }

    }
}
