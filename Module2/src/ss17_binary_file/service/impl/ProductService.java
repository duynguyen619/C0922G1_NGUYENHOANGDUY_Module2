package ss17_binary_file.service.impl;

import ss17_binary_file.model.Product;
import ss17_binary_file.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static final Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.println("Nhập Id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tên nhà sản xuất: ");
        String producer = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        List<Product> products = readFile();
        products.add(new Product(id, name, producer, price));

        File file = new File("src/ss17_binarry_file/product_file/data/Product.csv");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileOutputStream != null;
                fileOutputStream.close();
                assert objectOutputStream != null;
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Product> readFile() {
        List<Product> products = new ArrayList<>();

        File file = new File("src/ss17_binarry_file/product_file/data/Product.csv");
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            if (file.length() > 0) {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                products = (List<Product>) objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file.length() > 0) {
                    assert fileInputStream != null;
                    fileInputStream.close();
                    assert objectInputStream != null;
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    public void displayProduct() {
        List<Product> products = readFile();
        System.out.println("Danh sách sản phẩm: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void search() {
        List<Product> products = readFile();
        System.out.println("Nhập Id sản phẩm: ");
        String Id = scanner.nextLine();

        for (Product product : products) {
            if (products.size() == 0) {
                System.out.println("Danh sách không có");
            } else {
                System.out.println(product);
            }
        }
        System.out.println("Không thể tìm kiếm sản phẩm!");
    }
}
