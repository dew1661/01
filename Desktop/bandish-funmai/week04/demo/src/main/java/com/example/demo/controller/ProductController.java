package com.example.demo.controller;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.dto.StudentRes;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/saveproduct")
    public ResponseEntity<Void> create(@RequestBody ProductRequest productRequest) {
        productService.saveProduct(productRequest);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getproduct")
    public ResponseEntity <List<ProductResponse>> findAll() {
        List<ProductResponse> productResponseList = productService.findAll();
        return ResponseEntity.ok().body(productResponseList);
    }
    @GetMapping("/getproduct/{id}")
    public ResponseEntity<ProductResponse> find(@PathVariable("id") Long id) {
        Optional<ProductResponse> productResponse = productService.find(id);
        return ResponseEntity.of(productResponse);
    }
}
