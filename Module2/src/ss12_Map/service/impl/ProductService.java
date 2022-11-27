package ss12_Map.service.impl;

import ss12_Map.model.Product;
import ss12_Map.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Product> products;

    static {
        try {
            products=readProductFile("src/ss12_Map/data/Product.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProduct() throws IOException {
        products=readProductFile("src/ss12_Map/data/Product.csv");
        Product product = this.InfoProduct();
        products.add(product);
        writeProductFile("src/ss12_Map/data/Product.csv", products);
        System.out.println("Thêm mới thành công");
    }

    public Product InfoProduct() {
        String id = "SP-" + (products.size() + 1);
        System.out.print("Mời bạn nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập giá: ");
        int price = Integer.parseInt(scanner.nextLine());
        return new Product(id, name, price);
    }

    public void editProduct() throws IOException {
        products=readProductFile("src/ss12_Map/data/Product.csv");
        System.out.println("Nhập ID sản phẩm cần chỉnh sửa: ");
        String idEdit = scanner.nextLine();
        Product temp = null;
        Product product1 = null;
        for (Product product : products) {
            if (Objects.equals(idEdit, product.getName())) {
                temp = product;
                String setId = "SP-" + (products.size() + 1);
                System.out.println("Nhập chỉnh sửa tên của sản phẩm: ");
                String setName = scanner.nextLine();
                System.out.println("Nhập chỉnh sửa giá của sản phẩm: ");
                int setPrice=Integer.parseInt(scanner.nextLine());
                product1 = new Product(setId, setName, setPrice);
                break;
            }
        }
        if (temp != null) {
            int index = products.indexOf(temp);
            products.set(index, product1);
        }
    }

    public void displayProduct() throws IOException {
        products=readProductFile("src/ss12_Map/data/Product.csv");
        for (Product product : products) {
            if (products.size() == 0) {
                System.out.println("Danh sách không có");
            } else {
                System.out.println(product);
            }
        }
    }

    public void seachProduct() throws IOException {
        products=readProductFile("src/ss12_Map/data/Product.csv");
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        int count = 0;
        for (Product product : products) {
            if (name.equals(product.getName())) {
                System.out.println(product);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có tên sản phẩm");
        }
    }

    public void deleteProduct() throws IOException {
        products=readProductFile("src/ss12_Map/data/Product.csv");
        Product product = this.findProduct();
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm tương thích");
        } else {
            System.out.println("Bạn có chắc muốn xóa sản phẩm");
            System.out.println("1.Có");
            System.out.println("2.Suy nghĩ lại");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                products.remove(product);
                System.out.println("Xóa thành công");
            }
        }
    }

    public Product findProduct() {
        System.out.println("Mời bạn nhập vào tên cần xóa");
        String name = scanner.nextLine();
        for (Product product : products) {
            if (Objects.equals(product.getName(), name)) {
                return product;
            }
        }
        return null;
    }
    public static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> strings = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        bufferedReader.close();
        return strings;
    }

    public static List<Product> readProductFile(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Product> products = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            products.add(new Product(info[0],info[1],Integer.parseInt(info[2])));
        }
        return products;
    }

    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeProductFile(String path, List<Product> products) throws IOException {
        StringBuilder data = new StringBuilder(" ");
        for (Product product : products) {
            data.append(product.toString());
            data.append("\n");
        }
        writeFile(path, data.toString());
    }
}
