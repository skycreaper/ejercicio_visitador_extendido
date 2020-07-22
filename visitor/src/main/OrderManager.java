package main;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import builder.CaliforniaUI;
import builder.ColombianUI;
import builder.DirectorUI;
import builder.NonCaliforniaUI;
import builder.OrderBuilder;
import builder.OverseasUI;
import orders.*;
import visitor.OrderVisitor;
import utils.OrderTypes;

public class OrderManager extends JFrame {

  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String CREATE_ORDER = "Create Order";
  public static final String EXIT = "Exit";

  public final String ORDERS_TITLE = "Order History";

  private JComboBox cmbOrderType;
  private JLabel lblOrderType;
  private JPanel orderPanel;
  private JPanel allOrdersPanel;
  private OrderVisitor objVisitor;
  private JLabel lblTotal, lblTotalValue, lblOrderCreated, lblHistoryTitle;
  private JTable historyTable;
  private int orderId;

  public OrderManager() {
    super("Visitor Pattern - Example");
    // Create the visitor instance
    objVisitor = new OrderVisitor();
    orderPanel = new JPanel();

    allOrdersPanel = new JPanel();
    cmbOrderType = new JComboBox();
    lblTotal = new JLabel("Result:");
    lblOrderCreated = new JLabel("Click Create or GetTotal Button");
    lblTotalValue = new JLabel("Click Create or GetTotal Button");
    cmbOrderType.addItem("");
    cmbOrderType.addItem(OrderTypes.CA_ORDER);
    cmbOrderType.addItem(OrderTypes.NON_CA_ORDER);
    cmbOrderType.addItem(OrderTypes.OVERSEAS_ORDER);
    cmbOrderType.addItem(OrderTypes.COLOMBIAN_ORDER);

    lblOrderType = new JLabel("Order Type:");
    lblHistoryTitle = new JLabel(this.ORDERS_TITLE);

    // Create the open button
    JButton getTotalButton = new JButton(OrderManager.GET_TOTAL);
    getTotalButton.setMnemonic(KeyEvent.VK_G);
    JButton createOrderButton = new JButton(OrderManager.CREATE_ORDER);
    getTotalButton.setMnemonic(KeyEvent.VK_C);
    JButton exitButton = new JButton(OrderManager.EXIT);
    exitButton.setMnemonic(KeyEvent.VK_X);
    ButtonHandler objButtonHandler = new ButtonHandler(this);

    cmbOrderType.addActionListener(objButtonHandler);
    getTotalButton.addActionListener(objButtonHandler);
    createOrderButton.addActionListener(objButtonHandler);
    exitButton.addActionListener(new ButtonHandler());

    // For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();

    JPanel panel = new JPanel();
    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    GridBagConstraints gbc2 = new GridBagConstraints();
    panel.add(getTotalButton);
    panel.add(createOrderButton);
    panel.add(exitButton);
    gbc2.anchor = GridBagConstraints.EAST;
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(createOrderButton, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gridbag2.setConstraints(getTotalButton, gbc2);
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    gridbag2.setConstraints(exitButton, gbc2);

    // ****************************************************
    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    buttonPanel.add(lblOrderType);
    buttonPanel.add(cmbOrderType);
    buttonPanel.add(orderPanel);
    buttonPanel.add(lblTotal);
    // buttonPanel.add(lblOrderCreated);
    buttonPanel.add(lblTotalValue);

    /* history components */
    // String[] columns = { "Id", "Price", "Date" };
    Vector<String> columns = new Vector<String>();
    columns.add("Id");
    columns.add("Type");
    columns.add("Price");
    columns.add("Created time");

    historyTable = new JTable(new Vector(), columns);

    historyTable.getSelectionModel().addListSelectionListener(new ClickHandler(this));

    JScrollPane scrollPane = new JScrollPane(historyTable);

    allOrdersPanel.add(lblHistoryTitle);
    allOrdersPanel.add(scrollPane);
    buttonPanel.add(allOrdersPanel);

    gbc.insets.top = 40;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderType, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gridbag.setConstraints(lblTotal, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(cmbOrderType, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(orderPanel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 3;
    gridbag.setConstraints(lblTotalValue, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 20;

    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.VERTICAL;
    gbc.weighty = 0.0;
    gbc.gridheight = 3;
    gridbag.setConstraints(allOrdersPanel, gbc);
    //****************************************************

    //Add the buttons and the log to the frame
    Container contentPane = getContentPane();

    contentPane.add(buttonPanel, BorderLayout.NORTH);
    contentPane.add(panel, BorderLayout.CENTER);
    try {
      //UIManager.setLookAndFeel(new WindowsLookAndFeel());
      SwingUtilities.updateComponentTreeUI(
        OrderManager.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }

  }

  public static void main(String[] args) {
    JFrame frame = new OrderManager();

    frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        }
                           );

    //frame.pack();
    frame.setSize(1000, 600);
    frame.setVisible(true);
  }

  public void setTotalValue(String msg) {
    lblTotalValue.setText(msg);
  }

  public OrderVisitor getOrderVisitor() {
    return objVisitor;
  }


  public JComboBox getOrderTypeCtrl() {
    return cmbOrderType;
  }
  
  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }

  public JTable getHistoryTable() {
    return this.historyTable;
  }

  public void updateHistory() {
    Vector<OrderComponent> data = this.objVisitor.getAllOrdersData();
    DefaultTableModel model = (DefaultTableModel) historyTable.getModel();
    this.deleteAllTableElements(model);

    for (OrderComponent order : data) {
      model.addRow(new String[]
        {
          Integer.toString(order.getId()),
          order.getTypeName(),
          Double.toString(order.getOrderTotal()),
          order.getCreatedTime().toString()
        }
      );
    }
    this.historyTable.repaint();
  }

  private void deleteAllTableElements(DefaultTableModel model) {
    try {
      model.getDataVector().removeAllElements();
      model.fireTableDataChanged();
    } catch (Exception e) {
      // Handle exception
    }
  }

  public void updateTableRow(OrderComponent order) {
    this.objVisitor.getAllOrdersData();
    historyTable.getModel().setValueAt(
            Double.toString(order.getOrderTotal()),
            historyTable.getSelectedRow(),
            2
    );
  }

  public void displayNewUI(JPanel uiObj) {
    orderPanel.removeAll();
    orderPanel.add(uiObj);
    orderPanel.validate();
    validate();
  }

  public void setOrderId(int id){
    this.orderId = id;
  }

  } // End of class OrderManager

class ClickHandler implements ListSelectionListener {
  OrderManager objOrderManager;
  OrderBuilder builderBH;
  String id;
  JPanel UIObj;
  public ClickHandler(OrderManager objOrderManager) {
    this.objOrderManager = objOrderManager;
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    double amntOrder;
    double taxOrder;
    double shOrder;
    try {
      id = objOrderManager.getHistoryTable().getValueAt(objOrderManager.getHistoryTable().getSelectedRow(), 0).toString();
      String orderType = objOrderManager.getHistoryTable().getValueAt(objOrderManager.getHistoryTable().getSelectedRow(), 1).toString();
      int idValue = Integer.parseInt(id);
      objOrderManager.setOrderId(idValue);

      amntOrder = objOrderManager.getOrderVisitor().getOrderSimple(idValue).getOrderAmount();
      taxOrder = objOrderManager.getOrderVisitor().getOrderSimple(idValue).getAdditionalTax();
      shOrder = objOrderManager.getOrderVisitor().getOrderSimple(idValue).getAdditionalSH();

      String amnt = Double.toString(amntOrder);
      String tax = Double.toString(taxOrder);
      String sh = Double.toString(shOrder);

      BuilderFactory factory = new BuilderFactory();
      builderBH = factory.getUIBuilder(orderType);
      DirectorUI director = new DirectorUI(builderBH);
      director.build();

      if (shOrder > 0.0) {
        director.setValues(amnt,sh); //Obtener amount y tax de las ordenes dentro del vector
      } else {
        director.setValues(amnt,tax); //Obtener amount y tax de las ordenes dentro del vector
      }
      UIObj = builderBH.getPanel();
      JButton btnUpdate = new JButton("Update");
      btnUpdate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnUpdateShowActionPerformed(evt);
        }
      });
      UIObj.add(btnUpdate);
      objOrderManager.displayNewUI(UIObj);
    } catch (Exception exception) {
      // Handle exception
    }
  }

  public void btnUpdateShowActionPerformed(java.awt.event.ActionEvent evt) {
    try {
      int idValue = Integer.parseInt(id);
      getOrderAmount();
      getTaxValue();
      OrderComponent orderUpdated = objOrderManager.getOrderVisitor().getOrderSimple(idValue);
      orderUpdated.setOrderAmount(getOrderAmount());
      orderUpdated.setAdditionalTax(getTaxValue());
      objOrderManager.getOrderVisitor().editOrder(orderUpdated);
      objOrderManager.updateTableRow(orderUpdated);
      UIObj.removeAll();
      UIObj.validate();
      objOrderManager.validate();
    } catch (Exception e) {
      // Handle exception
    }

  }
  public double getOrderAmount() throws Exception {
    String strAmount = builderBH.getOrderAmount();
    double dblAmountUpdt = Double.parseDouble(strAmount);
    return dblAmountUpdt;
  }
  public double getTaxValue() throws Exception {
    String strTax = builderBH.getTax();
    double dblTaxUpdt = Double.parseDouble(strTax);
    return dblTaxUpdt;
  }
  
}

class ButtonHandler implements ActionListener {

  OrderManager objOrderManager;
  OrderBuilder builderBH;
  int id = 0;
  OrderVisitor visitor;

  public void actionPerformed(ActionEvent e) {
    String totalResult = null;

    if (e.getActionCommand().equals(OrderManager.EXIT)) {
      System.exit(1);
    }

    // Construye la interfaz correspondiente de acuerdo al tipo de orden
    if (e.getSource() == objOrderManager.getOrderTypeCtrl()) {
      String selection = objOrderManager.getOrderType();
      if (selection.equals("") == false) {
        objOrderManager.getHistoryTable().clearSelection();
        BuilderFactory builderFactory = new BuilderFactory();
        builderBH = builderFactory.getUIBuilder(selection);
        //configure the director with the builder
        DirectorUI director = new DirectorUI(builderBH);
        //director invokes different builder
        // methods
        director.build();
        //get the final build object
        JPanel UIObj = builderBH.getPanel();
        objOrderManager.displayNewUI(UIObj);
      } else {
        JOptionPane.showMessageDialog(objOrderManager, "Por favor seleccione un tipo de orden", "ERROR!", JOptionPane.WARNING_MESSAGE);
      }
    }

    // Crea un tipo de orden
    if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
      //get input values
      String orderType = objOrderManager.getOrderType();

      String strOrderAmount = builderBH.getOrderAmount();
      String strTax = builderBH.getTax();
      //String strSH = objOrderManager.getSH();

      double dblOrderAmount = 0.0;
      double dblTax = 0.0;
      //double dblSH = 0.0;

      if (strOrderAmount.trim().length() == 0) {
        strOrderAmount = "0.0";
      }
      if (strTax.trim().length() == 0) {
        strTax = "0.0";
      }

      dblOrderAmount = new Double(strOrderAmount).doubleValue();
      dblTax = new Double(strTax).doubleValue();

      //Create the order
      Order order = createOrder(orderType, dblOrderAmount, dblTax);
      //Get the Visitor
      visitor = objOrderManager.getOrderVisitor();

      // accept the visitor instance
      order.accept(visitor);

      objOrderManager.setTotalValue(" Order Created Successfully");
      objOrderManager.updateHistory();
    }

    // Obtiene el total de ordenes
    if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
      //Get the Visitor
      totalResult = new Double(visitor.getOrderTotal()).toString();
      totalResult = " Orders Total = " + totalResult;
      objOrderManager.setTotalValue(totalResult);
    }

  }

  public Order createOrder(String orderType, double orderAmount, double tax) {
    Order newOrder = null;
    if (orderType.equalsIgnoreCase(OrderTypes.CA_ORDER)) {
      newOrder = new CaliforniaOrder(id, orderAmount, tax);
    }
    if (orderType.equalsIgnoreCase(OrderTypes.NON_CA_ORDER)) {
      newOrder = new NonCaliforniaOrder(id, orderAmount);
    }
    if (orderType.equalsIgnoreCase(OrderTypes.OVERSEAS_ORDER)) {
      newOrder = new OverseasOrder(id, orderAmount, tax);
    }
    if (orderType.equalsIgnoreCase(OrderTypes.COLOMBIAN_ORDER)) {
      newOrder = new ColombianOrder(id, orderAmount, tax);
    }
    id++;
    return newOrder;
  }

  public ButtonHandler() { }

  public ButtonHandler(OrderManager inObjOrderManager) {
    objOrderManager = inObjOrderManager;
    visitor = objOrderManager.getOrderVisitor();
  }

} // End of class ButtonHandler

class BuilderFactory { // se agrega clase para crear el tipo de orden

  public OrderBuilder getUIBuilder(String str) {
    OrderBuilder builder = null;
    if (str.equals(OrderTypes.CA_ORDER)) {
      builder = new CaliforniaUI();
    } else if (str.equals(OrderTypes.COLOMBIAN_ORDER)) {
      builder = new ColombianUI();
    } else if (str.equals(OrderTypes.NON_CA_ORDER)) {
      builder = new NonCaliforniaUI();
    } else if (str.equals(OrderTypes.OVERSEAS_ORDER)) {
      builder = new OverseasUI();
    }
    return builder;
  }
}