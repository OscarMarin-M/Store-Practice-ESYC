package com.example.storepractice.domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.cglib.core.Local;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  @Column(nullable = false)
  /**
   * el tamaño por defecto en POSTGRES de un varchar en db es de 255, asi que no es necesario colocar la
   * anotacion:   @Column(columnDefinition = "varchar(255)") o modificar el length
   */
  //:TODO  agregar security+Validator para validar desde ahi algunos valores como el @NotNull
  private UUID id;

  private String name;

  private String description;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String createdBy;

  private String updatedBy;
}
