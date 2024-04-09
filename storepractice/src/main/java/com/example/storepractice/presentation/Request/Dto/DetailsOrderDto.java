package com.example.storepractice.presentation.Request.Dto;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetailsOrderDto {

  private int quantity;
  private UUID productId;

}
