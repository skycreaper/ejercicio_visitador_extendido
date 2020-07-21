package orders;

import visitor.OrderVisitor;

public class ColombianOrder extends OrderComponent implements Order {

    private int id;
    private double orderAmount;
    private double additionalSH;

    public ColombianOrder(int id, double inp_orderAmount, double inp_additionalSH) {
        this.id = id;
        orderAmount = inp_orderAmount;
        additionalSH = inp_additionalSH;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void accept(OrderVisitor v) {
        v.visit(this);
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
