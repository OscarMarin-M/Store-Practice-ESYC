package com.example.storepractice.domain.Service;

import com.example.storepractice.data.Repository.StoreRepository;
import com.example.storepractice.domain.Entity.Store;
import com.example.storepractice.domain.Mapper.StoreMapper;
import com.example.storepractice.presentation.Request.Dto.StoreDto;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreServiceImple implements StoreService{

  private StoreRepository storeRepository;
  private StoreMapper storeMapper;
  @Override
  public Store getById(UUID id) {
    Store aux= storeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Store with id not found"));
    return aux;
  }

  @Override
  public List<Store> getAll() {
    List<Store> allstores= storeRepository.findAll();
    return allstores;
  }

  @Override
  public Store create(StoreDto storeDto) {
    Store store=storeMapper.fromDto(storeDto);
    return storeRepository.save(store);
  }

  @Override
  //no se debe usar el mismo mapper(que en create) en los update ya que crea una nueva instancia de store, y por ende sobreescribe a la ya encontrada
  public Store update(StoreDto storeDto, UUID id) {

    Store storefound=this.getById(id);
    storefound.setName(storeDto.getName());
    storefound.setAddress(storeDto.getAddress());
    storefound.setCity(storeDto.getCity());
    storefound.setOpeningHours(storeDto.getOpeningHours());
    storefound.setUpdatedAt(LocalDateTime.now());
    storefound.setUpdatedBy("USUARIO QUE MODIFICO LA STORE");
    return storeRepository.save(storefound);
  }

  @Override
  public void delete(UUID id) {
    Store store=this.getById(id);
    storeRepository.deleteById(store.getId());
  }
}
