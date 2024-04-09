package com.example.storepractice.presentation.Controller;

import com.example.storepractice.domain.Entity.Order;
import com.example.storepractice.domain.Service.OrderService;
import com.example.storepractice.presentation.Request.Dto.OrderDto;
import lombok.AllArgsConstructor;
import netscape.javascript.JSObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

  private OrderService orderService;


  /**
   * CREAR UN ORDER con sus respectivos orderdetails de manera cascada
   *
   * @param orderDto
   * @return NOTA: algo interesante pasa si queremos devolver el objeto mismo creado, este entra en
   * un bucle infinito al armar el JSON y crea un order dentro de otra order, por eso se devuelve
   * solamente una cadena de confirmacion, la logica dentro del servicio esta bien tanto como las
   * relaciones, al no mandar el objeto ni se arma el json por lo que no consume recursos que si lo
   * haria con el bucle.
   */
  @PostMapping
  public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {

    Order neworder = orderService.createOrder(orderDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("{\"message\": \"" + "Your order was succesfully saved" + "\"}");
  }
}
