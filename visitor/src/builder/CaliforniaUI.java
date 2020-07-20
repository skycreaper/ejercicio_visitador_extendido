package builder;

import javax.swing.*;
import java.awt.*;

public class CaliforniaUI extends OrderBuilder {
    private JTextField txtOrderAmnt, txtTaxCalifornia;
    private JLabel lblOrderAmnt, lblTaxCalifornia;

    @Override
    public void addUIComponent() {
        orderUI = new JPanel();
        lblOrderAmnt = new JLabel("Order Amount:");
        lblTaxCalifornia = new JLabel("Additional California Tax :");
        txtOrderAmnt = new JTextField(10);
        txtTaxCalifornia = new JTextField(10);

        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        orderUI.add(lblOrderAmnt);
        orderUI.add(txtOrderAmnt);
        orderUI.add(lblTaxCalifornia);
        orderUI.add(txtTaxCalifornia);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmnt, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblTaxCalifornia, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmnt, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtTaxCalifornia, gbc);
    }

    @Override
    public String getOrderAmount() {
        return txtOrderAmnt.getText();
    }

    @Override
    public String getTax() {
        return txtTaxCalifornia.getText();
    }

}
