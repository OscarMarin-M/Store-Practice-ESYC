package com.example.storepractice.domain.Service;

import com.example.storepractice.data.Repository.OrderRepository;
import com.example.storepractice.data.Repository.StoreRepository;
import com.example.storepractice.domain.Entity.DetailsOrder;
import com.example.storepractice.domain.Entity.Order;
import com.example.storepractice.domain.Entity.Store;
import com.example.storepractice.presentation.Request.Dto.OrderDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImple implements OrderService {
  private ProductService productService;
  private OrderRepository orderRepository;
  private StoreService storeService;

  @Override
  public Order createOrder(OrderDto orderDto) {
    Order ordertosave=new Order();
    ordertosave.setName(orderDto.getName());
    ordertosave.setDate(LocalDate.now());
    ordertosave.setDelivery(orderDto.getDelivery());

    if(orderDto.getDelivery()){
      ordertosave.setShippingAddress(orderDto.getShippingAddress());
    }else{
      ordertosave.setShippingAddress("STORE PICK UP");
    }

    ordertosave.setCreatedAt(LocalDateTime.now());
    ordertosave.setCreatedBy("ORDER CREATED MANUALLY");
    ordertosave.setUpdatedAt(LocalDateTime.now());
    ordertosave.setUpdatedAt(LocalDateTime.now());

    List<DetailsOrder> alldetails=orderDto.getDetailslist().stream().map((detailsOrderDto)->{

      DetailsOrder detail=new DetailsOrder();
      detail.setQuantity(detailsOrderDto.getQuantity());
      detail.setProduct(productService.findById(detailsOrderDto.getProductId()));
      detail.setOrder(ordertosave);

      //todo: incluso en le jwt se puede configurar la store desde la cual se esta logeado para setear el order correspondiente
      // y asi no tener que enviarlo manualmente en el body del request
      return detail;
    }).toList();
    ordertosave.setDetailsOrders(alldetails);

    Store store=(storeService.getById(orderDto.getStore()));
    ordertosave.setStore(store);

    return orderRepository.save(ordertosave);
  }
}
