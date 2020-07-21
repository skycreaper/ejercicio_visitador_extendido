package builder;

import javax.swing.*;
import java.awt.*;

public class ColombianUI extends OrderBuilder {
    private JTextField txtOrderAmnt, txtTaxColombia;
    private JLabel lblOrderAmnt, lblTaxColombia;


    @Override
    public void addUIComponent() {
        orderUI = new JPanel();
        lblOrderAmnt = new JLabel("Order Amount: ");
        lblTaxColombia = new JLabel("Additional S & H:");
        txtOrderAmnt = new JTextField(10);
        txtTaxColombia = new JTextField(10);


        GridBagLayout gridbag = new GridBagLayout();
        orderUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        orderUI.add(lblOrderAmnt);
        orderUI.add(txtOrderAmnt);
        orderUI.add(lblTaxColombia);
        orderUI.add(txtTaxColombia);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmnt, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblTaxColombia, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmnt, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtTaxColombia, gbc);
    }

    @Override
    public String getOrderAmount() {
        return txtOrderAmnt.getText();
    }
    public String getTax() {
        return txtTaxColombia.getText();
    }

    @Override
    public void setValuesFromOldOrders(String amount, String tax) {
        txtOrderAmnt.setText(amount);
        txtTaxColombia.setText(tax);
    }
}
