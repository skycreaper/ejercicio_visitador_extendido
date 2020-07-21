package orders;

import java.time.LocalDateTime;

import visitor.OrderVisitor;
import utils.OrderTypes;

public class CaliforniaOrder extends OrderComponent implements Order {

  private int id;
  private LocalDateTime createdTime;
  private double orderAmount;
  private double additionalTax;

  public CaliforniaOrder(int id, double inp_orderAmount, double inp_additionalTax) {
    this.id = id;
    this.createdTime = LocalDateTime.now();
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
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
    return OrderTypes.CA_ORDER;
  }

  public double getOrderAmount() {
    return orderAmount;
  }

  @Override
  public void setOrderAmount(double dblAmount) {
    this.orderAmount = dblAmount;
  }

  @Override
  public void setAdditionalTax(double dblTax) {
    this.additionalTax = dblTax;
  }


  public double getAdditionalTax() {
    return additionalTax;
  }

  public void accept(OrderVisitor v) {
    v.visit(this);
  }

  @Override
  public double getOrderTotal() {
    return this.orderAmount + this.additionalTax;
  }
}

