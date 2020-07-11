import javax.swing.*;
import java.awt.*;

public class NonCaliforniaUI extends OrderBuilder {
    private JTextField txtOrderAmnt, txtTaxNonCali;
    private JLabel lblOrderAmnt, lblTaxNonCali;

    @Override
    public void addUIComponent() {
        orderUI = new JPanel();
        lblOrderAmnt = new JLabel("Order Amount:");
        lblTaxNonCali = new JLabel("Additional Non Californian Tax :");
        txtOrderAmnt = new JTextField(10);
        txtTaxNonCali = new JTextField(10);

        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        orderUI.add(lblOrderAmnt);
        orderUI.add(txtOrderAmnt);
        orderUI.add(lblTaxNonCali);
        orderUI.add(txtTaxNonCali);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmnt, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblTaxNonCali, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmnt, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtTaxNonCali, gbc);

    }

    @Override
    public String getOrderAmount() {
        return txtOrderAmnt.getText();
    }

    @Override
    public String getTax() {
        return txtTaxNonCali.getText();
    }

}
