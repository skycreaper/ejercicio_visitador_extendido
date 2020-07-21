package builder;

import javax.swing.*;
import java.awt.*;

public class OverseasUI extends OrderBuilder {
    private JTextField txtOrderAmnt, txtTaxOverseas;
    private JLabel lblOrderAmnt, lblTaxOverseas;

    @Override
    public void addUIComponent() {
        orderUI = new JPanel();
        lblOrderAmnt = new JLabel("Order Amount: ");
        lblTaxOverseas = new JLabel("Additional S & H:");
        txtOrderAmnt = new JTextField(10);
        txtTaxOverseas = new JTextField(10);

        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        orderUI.add(lblOrderAmnt);
        orderUI.add(txtOrderAmnt);
        orderUI.add(lblTaxOverseas);
        orderUI.add(txtTaxOverseas);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmnt, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblTaxOverseas, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmnt, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtTaxOverseas, gbc);
    }

    @Override
    public String getOrderAmount() {
        return txtOrderAmnt.getText();
    }

    @Override
    public String getTax() {
        return txtTaxOverseas.getText();
    }

    @Override
    public void setValuesFromOldOrders(String amount, String tax) {
        txtOrderAmnt.setText(amount);
        txtTaxOverseas.setText(tax);
    }

}
