import javax.swing.*;

public class ColombianUI extends OrderBuilder {
    private JTextField txtOrderAmnt, txtTaxColombia;
    private JLabel lblOrderAmnt, lblTaxColombia;
    private JLabel lblTotal, lblTotalValue;


    @Override
    public void addUIComponent() {
        lblOrderAmnt = new JLabel("Order Amount:");
        lblTaxColombia = new JLabel("Additional Colombian Tax :");
        txtOrderAmnt = new JTextField(10);
        txtTaxColombia = new JTextField(10);
        lblTotal = new JLabel("Result:");
        lblTotalValue = new JLabel("Click Create or GetTotal Button");


    }

    @Override
    public String getInfo() {
        return null;
    }
}
