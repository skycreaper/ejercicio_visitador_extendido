package orders;

import java.time.LocalDateTime;

import utils.OrderTypes;
import visitor.OrderVisitor;

public class OverseasOrder extends OrderComponent implements Order {

  private int id;
  private LocalDateTime createdTime;
  private double orderAmount;
  private double additionalSH;

  public OverseasOrder() { }

  public OverseasOrder(int id, double inp_orderAmount, double inp_additionalSH) {
    this.id = id;
    this.createdTime = LocalDateTime.now();
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
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
    return OrderTypes.OVERSEAS_ORDER;
  }
  
  public double getOrderAmount() {
    return orderAmount;
  }

  public double getAdditionalSH() {
    return additionalSH;
  }

  public void accept(OrderVisitor v) {
    v.visit(this);
  }

  @Override
  public double getOrderTotal() {
    return this.orderAmount + this.additionalSH;
  }
}
