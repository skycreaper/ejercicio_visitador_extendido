package composite;

public class ColombianOrder implements OrderComponent {
    
    private double orderAmount;
    private double additionalSH;

    public ColombianOrder(double inp_orderAmount, double inp_additionalSH) {
        orderAmount = inp_orderAmount;
        additionalSH = inp_additionalSH;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getAdditionalSH() {
        return additionalSH;
    }

    @Override
    public double getOrderTotal() {
        return getOrderAmount() + getAdditionalSH() + 2;
    }
}
