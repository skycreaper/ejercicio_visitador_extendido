package orders;

import java.time.LocalDateTime;

import utils.OrderTypes;
import visitor.OrderVisitor;

public class ColombianOrder extends OrderComponent implements Order {

    private int id;
    private LocalDateTime createdTime;
    private double orderAmount;
    private double additionalSH;

    public ColombianOrder(int id, double inp_orderAmount, double inp_additionalSH) {
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
    public void accept(OrderVisitor v) {
        v.visit(this);
    }

    @Override
    public String getTypeName() {
      return OrderTypes.COLOMBIAN_ORDER;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getAdditionalSH() {
        return additionalSH;
    }

    @Override
    public double getOrderTotal() {
        return this.orderAmount + this.additionalSH + (this.orderAmount * 0.19);
    }
}
