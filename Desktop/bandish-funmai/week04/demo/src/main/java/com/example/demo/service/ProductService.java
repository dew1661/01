package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.dto.StudentRes;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductEntity saveProduct(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productRequest.getId());
        productEntity.setProduct_code(productRequest.getProduct_code());
        productEntity.setProduct_name(productRequest.getProduct_name());
        productEntity.setPrice(productRequest.getPrice());
        productEntity.setStatus(productRequest.getStatus());
        productRepository.save(productEntity);
        return productRepository.save(productEntity);
    }

    public List<ProductResponse> findAll() {
        List<ProductResponse> productResponseList = new ArrayList<>();
        List<ProductEntity> productEntityList = (List<ProductEntity>) productRepository.findAll();
        for(int i=0 ; i<productEntityList.size(); i++) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(productEntityList.get(i).getId());
            productResponse.setProduct_code(productEntityList.get(i).getProduct_code());
            productResponse.setProduct_name(productEntityList.get(i).getProduct_name());
            productResponse.setPrice(productEntityList.get(i).getPrice());
            productResponse.setStatus(productEntityList.get(i).getStatus());
            productResponseList.add(productResponse);
        }
        return productResponseList;
    }
    public Optional<ProductEntity> find(Long id) {
        return productRepository.findById(id);
    }

    public ProductResponse findByid(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        ProductResponse productResponse = new ProductResponse();
        productEntity.setId(productResponse.getId());
        productEntity.setProduct_code(productResponse.getProduct_code());
        productEntity.setProduct_name(productResponse.getProduct_name());
        productEntity.setPrice(productResponse.getPrice());
        productEntity.setStatus(productResponse.getStatus());

        return productResponse;
    }
}
