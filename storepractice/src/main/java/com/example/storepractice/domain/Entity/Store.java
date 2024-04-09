package com.example.storepractice.domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "stores")
/**
 * en esta entidad si es necesario(segun el modelo ER) designar longitudes especificas.
 */
public class Store {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  @Column(nullable = false)
  private UUID id;

  @Column(columnDefinition = "varchar(50)")
  private String name;
  @Column(columnDefinition = "varchar(150)")
  private String address;
  @Column(columnDefinition = "varchar(150)")
  private String city;
  @Column(columnDefinition = "varchar(50)")
  private String openingHours;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String createdBy;
  private String updatedBy;


}
