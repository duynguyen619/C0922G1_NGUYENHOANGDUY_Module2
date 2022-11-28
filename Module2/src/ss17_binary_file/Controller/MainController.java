package ss17_binary_file.controller;

import ss17_binary_file.service.IProductService;
import ss17_binary_file.service.impl.ProductService;

import java.util.Scanner;

public class MainController {
    private static final Scanner scanner = new Scanner(System.in);
    private final IProductService product = new ProductService();

    public void menuMangement() {
        while (true) {
            System.out.println("----------Quản lý sản phẩm----------");
            System.out.println("1.Thêm sản phẩm mới");
            System.out.println("2.Hiện thị sản phẩm");
            System.out.println("3.Tìm kiếm sản phẩm");
            System.out.println("4.Thoát");
            System.out.println("Mời bạn chọn chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    product.addProduct();
                    break;
                case 2:
                    product.displayProduct();
                    break;
                case 3:
                    product.search();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhập lại. ");
                    break;
            }
        }
    }
}
