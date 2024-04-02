package controller;

public class FileIOThread extends Thread {
    private SinhVienController svController;

    public FileIOThread(SinhVienController svController) {
        this.svController = svController;
    }

    @Override
    public void run() {
        // Gọi các phương thức liên quan đến IO ở đây, ví dụ:
        svController.TestLuuFile();
        svController.TestDocFile();
    }
}
