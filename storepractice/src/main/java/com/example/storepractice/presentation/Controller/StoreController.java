package com.example.storepractice.presentation.Controller;

import com.example.storepractice.domain.Entity.Store;
import com.example.storepractice.domain.Service.StoreService;
import com.example.storepractice.presentation.Request.Dto.StoreDto;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/stores")
public class StoreController {

  private StoreService storeService;

  /**
   * OBTIENE UN STORE ATRAVEZ DE UN UUID EN LA URL SEPARADO POR "/" (@PathVaraible)
   * @param id
   * @return LA STORE ENCONTRADA POR EL REPOSITORY
   */
  @GetMapping("/{id}")
  public ResponseEntity<Store> getById(@PathVariable UUID id){
      Store storefound=storeService.getById(id);
      return ResponseEntity.status(HttpStatus.OK).body(storefound);
  }

  /**
   * OBTIENE TODAS LAS STORES
   * @return UN OPTIONAL SI ALGUNA STORE FUE ENCONTRADA
   */
  @GetMapping
  public ResponseEntity<List<Store>> getAllStores(){
    List<Store> allstores=storeService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(allstores);
  }

  /**
   * crea un nuevo producto en base a un mapper
   * @param storeDto
   * @return el cuerpo de la nueva store
   */
  @PostMapping
  public ResponseEntity<Store> create(@RequestBody StoreDto storeDto){
    Store store=storeService.create(storeDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(store);
  }

  /**
   * encuentra un store ya en la db y lo actualiza
   * @param storeDto
   * @param id
   * @return el body del store actualizado
   */
  @PutMapping("/{id}")
  public ResponseEntity<Store> update(@RequestBody StoreDto storeDto, @PathVariable UUID id){
    Store store=storeService.update(storeDto,id);
    return ResponseEntity.status(HttpStatus.OK).body(store);
  }


  /**
   * elimina una store por su id, NOTA: tener en cuenta que si el store tuviera relacion con algun ORDER, no podria eliminarse por el foreing key
   * @param id
   * @return string de confirmacion
   */
  @DeleteMapping("/{id}")

  public String delete(@PathVariable UUID id){
    storeService.delete(id);
    return "La tienda fue eliminada exitosamente";
  }

}
