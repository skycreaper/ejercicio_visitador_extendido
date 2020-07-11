import javax.swing.*;

public abstract class OrderBuilder {
    protected JPanel orderUI;

    public abstract void addUIComponent();
    public abstract String getOrderAmount();
    public abstract String getTax();
    public JPanel getPanel() {
        return orderUI;
    }
}
