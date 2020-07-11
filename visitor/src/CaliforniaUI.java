import javax.swing.*;

public class CaliforniaUI extends OrderBuilder {
    private JTextField txtOrderAmnt, txtTaxCalifornia;
    private JLabel lblOrderAmnt, lblTaxCalifornia;
    private JLabel lblTotal, lblTotalValue;



    @Override
    public void addUIComponent() {
        lblOrderAmnt = new JLabel("Order Amount:");
        lblTaxCalifornia = new JLabel("Additional California Tax :");
        txtOrderAmnt = new JTextField(10);
        txtTaxCalifornia = new JTextField(10);
        lblTotal = new JLabel("Result:");
        lblTotalValue = new JLabel("Click Create or GetTotal Button");

    }

    @Override
    public String getInfo() {
        return null;
    }
}
