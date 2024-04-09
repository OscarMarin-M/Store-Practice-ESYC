package com.example.storepractice.domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Types;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "order_details")
public class DetailsOrder {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  @Column(nullable = false)
  private UUID id;
  private Integer quantity;


  /**
   * esta clase es hija de product y de order, es decir se registrara con un id respectivo de estos.
   */
  @ManyToOne
  @JoinColumn(name="product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name ="order_id")
  private Order order;
}
