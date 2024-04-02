package view;

import java.util.Scanner;

import controller.SinhVienController;
import controller.FileIOThread;

public class SinhVienView {
    private SinhVienController svController;

    public SinhVienView(SinhVienController svController) {
        this.svController = svController;
    }

    public void hienThiMenu() {
        System.out.println("----- Quản lý mượn trả sách -----");
        System.out.println("1. Hiển thị danh sách thẻ mượn");
        System.out.println("2. Thêm thẻ mượn");
        System.out.println("3. Xóa thẻ mượn");
        System.out.println("4. Lưu danh sách thẻ mượn xuống file");
        System.out.println("5. Tải danh sách thẻ mượn từ file");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public void thucHienChucNang(int luaChon) {
        Scanner scanner = new Scanner(System.in);
        switch (luaChon) {
            case 1:
                svController.hienThiThongTin();
                break;
            case 2:
                svController.themTheMuon(scanner);
                break;
            case 3:
                svController.xoaTheMuon(scanner);
                break;
            case 4:
                // Tạo và bắt đầu một luồng mới để thực hiện IO
                FileIOThread fileIOThread = new FileIOThread(svController);
                fileIOThread.start();
                break;
            case 5:
                // Tạo và bắt đầu một luồng mới để thực hiện IO
                FileIOThread fileIOThread2 = new FileIOThread(svController);
                fileIOThread2.start();
                break;
            case 0:
                System.out.println("Thoát chương trình.");
                System.exit(0);
                break;
            default:
                System.out.println("Chức năng không hợp lệ.");
        }
    }
}
