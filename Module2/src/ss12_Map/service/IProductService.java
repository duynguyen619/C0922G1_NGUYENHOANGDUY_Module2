package ss12_Map.service;

import java.io.IOException;

public interface IProductService {
    void addProduct() throws IOException;

    void editProduct() throws IOException;

    void displayProduct() throws IOException;

    void seachProduct() throws IOException;

    void deleteProduct() throws IOException;
}
