package com.example.storepractice.domain.Mapper;

import com.example.storepractice.domain.Entity.Product;
import com.example.storepractice.domain.Entity.Store;
import com.example.storepractice.presentation.Request.Dto.StoreDto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {

public Store fromDto(StoreDto dto){

  Store store =new Store();
  store.setName(dto.getName());
  store.setAddress(dto.getAddress());
  store.setCity(dto.getCity());
  store.setOpeningHours(dto.getOpeningHours());
  //todo: store.setCreatedBy(token.principal); y updateBy
  store.setCreatedBy("MANUAL");
  store.setUpdatedBy("MANUAL");
  store.setCreatedAt(LocalDateTime.now());
  store.setUpdatedAt(LocalDateTime.now());
  return store;
}
}
