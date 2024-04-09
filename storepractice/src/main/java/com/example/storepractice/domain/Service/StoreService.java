package com.example.storepractice.domain.Service;

import com.example.storepractice.domain.Entity.Store;
import com.example.storepractice.presentation.Request.Dto.StoreDto;
import java.util.List;
import java.util.UUID;


public interface StoreService {

  Store getById(UUID id);
  List<Store> getAll();

  Store create(StoreDto storedto);

  Store update(StoreDto storeDto, UUID id);

  void delete(UUID id);
}
