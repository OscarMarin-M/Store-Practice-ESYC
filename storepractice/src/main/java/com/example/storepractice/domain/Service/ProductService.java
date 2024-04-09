package com.example.storepractice.domain.Service;

import com.example.storepractice.domain.Entity.Product;
import java.util.UUID;

public interface ProductService {

  Product findById(UUID id);

}
