package com.edutech.progressive.service.impl;

import com.edutech.progressive.dao.ProductDAO;
import com.edutech.progressive.entity.Product;
import com.edutech.progressive.service.ProductService;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplJdbc implements ProductService {

    private ProductDAO productDAO;

    public ProductServiceImplJdbc(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return productDAO.getProductById(productId);
    }

    @Override
    public int addProduct(Product product) throws SQLException {
        int id = productDAO.addProduct(product);
        product.setProductId(id); // THIS is critical
        return id;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        productDAO.deleteProduct(productId);
    }
}