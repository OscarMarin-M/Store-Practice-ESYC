package com.example.storepractice.presentation.Request.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

  private String name;
  private String shippingAddress;
  private Boolean delivery;
  //:todo estos datos de abajo se pueden obtener mediante el JWT, pero por ahora lo podemos enviar manualmente
  private String createdBy;
  private String updatedBy;

  private List<DetailsOrderDto> detailslist;

  private UUID store;

}
