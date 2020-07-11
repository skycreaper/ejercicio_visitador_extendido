import javax.swing.*;

public class OverseasUI extends OrderBuilder {
    private JTextField txtOrderAmnt, txtTaxOverseas;
    private JLabel lblOrderAmnt, lblTaxOverseas;
    private JLabel lblTotal, lblTotalValue;



    @Override
    public void addUIComponent() {
        lblOrderAmnt = new JLabel("Order Amount:");
        lblTaxOverseas = new JLabel("Additional Overseas Tax :");
        txtOrderAmnt = new JTextField(10);
        txtTaxOverseas = new JTextField(10);
        lblTotal = new JLabel("Result:");
        lblTotalValue = new JLabel("Click Create or GetTotal Button");

    }

    @Override
    public String getInfo() {
        return null;
    }
}
