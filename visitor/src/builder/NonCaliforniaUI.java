package builder;

import javax.swing.*;
import java.awt.*;

public class NonCaliforniaUI extends OrderBuilder {
    private JTextField txtOrderAmnt;
    private JLabel lblOrderAmnt;

    @Override
    public void addUIComponent() {
        orderUI = new JPanel();
        lblOrderAmnt = new JLabel("Order Amount:");
        txtOrderAmnt = new JTextField(10);

        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        orderUI.add(lblOrderAmnt);
        orderUI.add(txtOrderAmnt);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmnt, gbc);


        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmnt, gbc);
    }

    @Override
    public String getOrderAmount() {
        return txtOrderAmnt.getText();
    }

    @Override
    public String getTax() {
        return "0";
    }

    @Override
    public void setValuesFromOldOrders(String amount, String tax) {
        txtOrderAmnt.setText(amount);

    }

}
