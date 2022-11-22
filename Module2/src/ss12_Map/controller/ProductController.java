package ss12_Map.controller;

import ss12_Map.service.impl.ProductService;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    private static final Scanner scaner = new Scanner(System.in);
    private ProductService product = new ProductService() {
    };

    public void menuMangement() throws IOException {
        while (true) {
            System.out.println("--------------Quản lý sản phẩm--------------");
            System.out.println("1.Thêm sản phẩm mới");
            System.out.println("2.Sửa sản phẩm");
            System.out.println("3.Hiện thị sản phẩm");
            System.out.println("4.Tìm kiếm sản phẩm");
            System.out.println("5.Xóa sản phẩm");
            System.out.println("6.Thoát");
            System.out.println("Mời bạn chọn chức năng");
            int choice = Integer.parseInt(scaner.nextLine());
            switch (choice) {
                case 1:
                    product.addProduct();
                    break;
                case 2:
                    product.editProduct();
                    break;
                case 3:
                    product.displayProduct();
                    break;
                case 4:
                    product.seachProduct();
                    break;
                case 5:
                    product.deleteProduct();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Bạn không đúng vui lòng nhập lại!");
            }
        }
    }
}
