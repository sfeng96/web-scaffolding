package learning.scaffolding.web.webflux.models;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Table("orders_list")
public class Order {

  @Column("order_id")
  private String orderId;

  @Column("product_id")
  private String productId;

  @Column("amount")
  private BigDecimal amount;
}
