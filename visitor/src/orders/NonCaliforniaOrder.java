package orders;

import java.time.LocalDateTime;

import utils.OrderTypes;
import visitor.OrderVisitor;

public class NonCaliforniaOrder extends OrderComponent implements Order {

  private int id;
  private LocalDateTime createdTime;
  private double orderAmount;

  public NonCaliforniaOrder() {}

  public NonCaliforniaOrder(int id, double inp_orderAmount) {
    this.id = id;
    this.createdTime = LocalDateTime.now();
    orderAmount = inp_orderAmount;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public LocalDateTime getCreatedTime() {
    return this.createdTime;
  }
  
  @Override
  public String getTypeName() {
    return OrderTypes.NON_CA_ORDER;
  }

  public double getOrderAmount() {
    return orderAmount;
  }

  public void accept(OrderVisitor v) {
    v.visit(this);
  }

  @Override
  public double getOrderTotal() {
    return this.orderAmount;
  }
}
