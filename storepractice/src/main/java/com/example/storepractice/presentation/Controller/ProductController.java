package com.example.storepractice.presentation.Controller;

import com.example.storepractice.domain.Entity.Product;
import com.example.storepractice.domain.Service.ProductService;
import com.example.storepractice.presentation.Request.Dto.ProductDto;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private ProductService productService;

  public ResponseEntity<Product> getById(UUID id){
    Product product=productService.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(product);
  }
}
