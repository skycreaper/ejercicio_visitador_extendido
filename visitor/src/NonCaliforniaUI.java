import javax.swing.*;

public class NonCaliforniaUI extends OrderBuilder {
    private JTextField txtOrderAmnt, txtTaxNonCali;
    private JLabel lblOrderAmnt, lblTaxNonCali;
    private JLabel lblTotal, lblTotalValue;



    @Override
    public void addUIComponent() {
        lblOrderAmnt = new JLabel("Order Amount:");
        lblTaxNonCali = new JLabel("Additional Colombian Tax :");
        txtOrderAmnt = new JTextField(10);
        txtTaxNonCali = new JTextField(10);
        lblTotal = new JLabel("Result:");
        lblTotalValue = new JLabel("Click Create or GetTotal Button");

    }

    @Override
    public String getInfo() {
        return null;
    }
}
