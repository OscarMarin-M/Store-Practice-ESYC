package com.example.storepractice.presentation.Request.Dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoreDto {
  private String name;

  private String address;

  private String city;

  private String openingHours;

}
