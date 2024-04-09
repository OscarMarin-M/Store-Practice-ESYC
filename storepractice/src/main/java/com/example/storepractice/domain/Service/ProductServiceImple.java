package com.example.storepractice.domain.Service;

import com.example.storepractice.data.Repository.ProductRepository;
import com.example.storepractice.domain.Entity.Product;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImple implements ProductService {

  private ProductRepository productRepository;

  @Override
  public Product findById(UUID id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product not found"));
  }
}
