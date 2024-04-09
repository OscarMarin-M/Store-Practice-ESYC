package com.example.storepractice.domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "products")
/**
 * el tamaño por defecto en POSTGRES de un varchar es de 255, asi que no es necesario colocar la
 * anotacion:   @Column(columnDefinition = "varchar(255)") o modificar el length
 */
public class Product {
  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  @Column(nullable = false)
  private UUID id;

  private String name;

  private String description;

  private Integer stock;

  private Double price;

  private Boolean active;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String createdBy;

  private String updatedBy;

  @ManyToOne
  // @MANYTOONE= mencionada en la CLASE HIJA----> ASI SE RELACIONA A LA CLASE/ENTITY CATEGORY
  @JoinColumn(name="category_id")          // @JoinColumn nos permite validar valores del foreing key
  private Category category;
}
