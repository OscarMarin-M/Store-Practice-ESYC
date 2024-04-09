package com.example.storepractice.domain.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "orders")
/**
 * el tamaño por defecto en POSTGRES de un varchar es de 255, asi que no es necesario colocar la
 * anotacion:   @Column(columnDefinition = "varchar(255)") o modificar el length
 */
public class Order {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  @Column(nullable = false)
  private UUID id;

  private String name;
  private LocalDate date =LocalDate.now();  //sin hora
  private String shippingAddress;
  private Boolean delivery;  //no usar "is como prefijo ya que el getter lo convertira en ".isisDelivery""
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String createdBy;
  private String updatedBy;


  // esta clase es PADRE de DetailsOrder, entonces al crear un Order, se pueden crear a la vez sus hijos,
  // y aqui se guardan de manera CASCADE esta lista de hijos
  @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
  List<DetailsOrder> detailsOrders;

  // a su vez esta clase es HIJA de la clase STORE, que se considera una sucursal, Branch
  @ManyToOne
  @JoinColumn(name ="store_id")
  private Store store;

}
