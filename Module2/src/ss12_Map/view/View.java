package ss12_Map.view;

import ss12_Map.controller.ProductController;

import java.io.IOException;

public class View {
    public static void main(String[] args) throws IOException {
        ProductController productController=new ProductController();
        productController.menuMangement();
    }
}
