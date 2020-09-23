 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import bll.BillOutCome;
import bll.BillOutComeDetails;
import bll.Perdoruesi;
import bll.Product;
import bll.Stock;
import com.google.common.collect.Lists;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import connection.Connect;
import dal.BillOutComeRepository;
import dal.PerdoruesiRepository;
import dal.PharmacyException;
import dal.ProductInterface;
import dal.ProductRepository;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import search.TST;

/**
 *
 * @author Adis Durguti
 */
public class POSForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form POSForm
     */
    private TST<Integer> tstName = new TST<Integer>();
    List<Product> list;
    ProductInterface pi = new ProductRepository();
    Product product = null;
    BillOutComeRepository bor = new BillOutComeRepository();
    PerdoruesiRepository pr = new PerdoruesiRepository();
    Connect connect = new Connect();
    Product p1 = new Product();
    Connection con = null;
    PreparedStatement pst = null;
    BillOutComeDetails BD = new BillOutComeDetails();
    DefaultTableModel model = new DefaultTableModel();
    LoginForm loginForm = new LoginForm();
    StockForm sf = new StockForm();
    Stock stock = new Stock();
    ReportsForm rf = new ReportsForm();
    String billNumber;
    Perdoruesi pactive1;
    private int qty;
    private int testQuantity;

    public POSForm() {
        initComponents();
        putIntoTSTname();
        dateLabel.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        showTime();
        dropDownPanel.setVisible(false);
        invoiceNotxt.setText(gjeneroNrFatures());

    }

    private void showTime() {   //metoda e cila tregon kohen aktuale
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss a");
                timeLabel.setText(s.format(d));
            }
        }).start();
    }

    public void putIntoTSTname() { // metoda e cila inserton ne TST te gjitha produktet
        Date date = new Date();
        list = pi.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (!((list.get(i)).toString().trim()).equals("")&&(list.get(i).getIsActive().equalsIgnoreCase("true")&&(list.get(i).getExpiringDate().after(date)))) {
                String key = list.get(i).toString1().toUpperCase();
                tstName.put(key, i);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchProduct = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        dropDownPanel = new javax.swing.JScrollPane();
        dropDownList = new javax.swing.JList<String>();
        jLabel1 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pricePerUnitTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        productIDtxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        invoiceNotxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        expirydateTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billDetailsTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        addButon = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        sellButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        amountTxt = new javax.swing.JLabel();

        setTitle("Point of Sale");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Product Information"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductActionPerformed(evt);
            }
        });
        searchProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchProductFocusGained(evt);
            }
        });
        searchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProductKeyReleased(evt);
            }
        });
        jPanel1.add(searchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 200, 40));

        dropDownList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(46, 151, 186), 2));
        dropDownList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        dropDownList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dropDownListMouseClicked(evt);
            }
        });
        dropDownPanel.setViewportView(dropDownList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dropDownPanel)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(dropDownPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 71, 200, -1));

        jLabel1.setText("Product Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 200, -1));

        quantityTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityTxt.setText("1");
        quantityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityTxtKeyTyped(evt);
            }
        });
        jPanel1.add(quantityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 200, 40));

        jLabel2.setText("Quantity");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 200, -1));

        pricePerUnitTxt.setEditable(false);
        jPanel1.add(pricePerUnitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 200, 40));

        jLabel3.setText("Price per Unit");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 200, -1));

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 190, 40));

        jLabel7.setText("Date");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, -1, -1));

        timeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 200, 40));

        jLabel8.setText("Time");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, -1, -1));

        productIDtxt.setEditable(false);
        productIDtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(productIDtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 200, 40));

        jLabel6.setText("Product ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        invoiceNotxt.setEditable(false);
        jPanel1.add(invoiceNotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 50, 200, 40));

        jLabel4.setText("Invoice No.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 30, -1, -1));

        expirydateTxt.setEditable(false);
        expirydateTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(expirydateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 200, 40));

        jLabel9.setText("Product ExpiryDate");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        billDetailsTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        billDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity", "Price", "Total"
            }
        ));
        billDetailsTable.setToolTipText("");
        jScrollPane2.setViewportView(billDetailsTable);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        addButon.setText("Add ");
        addButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        sellButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sellButton.setText("Sell");
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("TOTAL AMOUNT");

        amountTxt.setFont(new java.awt.Font("Tahoma", 0, 45)); // NOI18N
        amountTxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        amountTxt.setText("00.00$");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addComponent(addButon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(sellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(amountTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addButon, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sellButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(amountTxt)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductKeyReleased
        // TODO add your handling code here:    // metoda e cila gjeneron listen me ane te karakterit te pare qe eshte i njejte me ndonje te produktit
        char c = evt.getKeyChar();
        String t = searchProduct.getText().toUpperCase();
        if (!(c == KeyEvent.VK_CAPS_LOCK || c == KeyEvent.VK_SHIFT)) {
            if (!(t.equals(""))) {
                Iterable<String> it = tstName.keysWithPrefix(t);
                List<String> itlist = Lists.newArrayList(it.iterator());
                String[] st = new String[itlist.size()];

                for (int i = 0; i < itlist.size(); i++) {
                    st[i] = itlist.get(i);
                }
                if (!(st.length == 0)) {
                    dropDownList.setListData(st);
                    dropDownPanel.setVisible(true);
                    dropDownList.setFocusable(true);
                    dropDownPanel.setFocusable(true);
                } else {
                    dropDownPanel.setVisible(false);
                }
            } else {
                dropDownPanel.setVisible(false);
            }
        }
    }//GEN-LAST:event_searchProductKeyReleased

    private void searchProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchProductFocusGained
        // TODO add your handling code here:
        putIntoTSTname();
    }//GEN-LAST:event_searchProductFocusGained

    private void dropDownListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dropDownListMouseClicked
        // TODO add your handling code here:    //metode qe ruan produktin nga lista duke e selektuar me mouse dhe i mbush texfieldat me te dhenat e produktit
        String s = dropDownList.getSelectedValue();
        if (s != null) {
            if (Character.isLetter(s.charAt(0))) {
                for (Product list1 : list) {
                    if (list1.toString1().equalsIgnoreCase(s)) {
                        product = list1;

                    }
                }
            }
        }

        if (product != null) {
            searchProduct.setText(product.toString1());
            pricePerUnitTxt.setText(product.getProductSellPrice().toString());
            productIDtxt.setText(product.getProductID().toString());
            expirydateTxt.setText(new SimpleDateFormat("dd-MM-yyyy").format(product.getExpiringDate()));
            quantityTxt.requestFocus();

        }

        dropDownPanel.setVisible(false);
    }//GEN-LAST:event_dropDownListMouseClicked

    private void addButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButonActionPerformed
        // TODO add your handling code here:
        try {
            if (!(searchProduct.getText().trim().equals("") || pricePerUnitTxt.getText().trim().equals(""))) {

                con = connect.getConnect();
                String sql = "Select quantity from Stock where productID ='" + product.getProductID() + "'";
                pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    testQuantity = rs.getInt(1);
                }

                if (testQuantity >= Integer.parseInt(quantityTxt.getText())) {
                    //DefaultTableModel model = (DefaultTableModel) billDetailsTable.getModel();
                    model = (DefaultTableModel) billDetailsTable.getModel();
                    BigDecimal totalofproduct = new BigDecimal(BigInteger.ZERO);
                    BigDecimal quantity = new BigDecimal(quantityTxt.getText());
                    BigDecimal price = new BigDecimal(pricePerUnitTxt.getText());
                    totalofproduct = quantity.multiply(price);

                    model.addRow(new Object[]{product, (quantity.toBigInteger()), product.getProductSellPrice(), totalofproduct});
                    amountTxt.setText(generateTotal().toString());

                } else {
                    JOptionPane.showMessageDialog(this, "No quantity of " + product.getProductName() + " available !\nYou have only : " + testQuantity + " quanitity on Stock .");
                }
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill the required spaces !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(POSForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButonActionPerformed
    private BigDecimal generateTotal() {
        BigDecimal total = new BigDecimal(BigInteger.ZERO);
        for (int i = 0; i < billDetailsTable.getRowCount(); i++) {
            BigDecimal amount = (BigDecimal) billDetailsTable.getValueAt(i, 3);
            total = total.add(amount);
        }
        return total;
    }

    void clear() {
        amountTxt.setText(generateTotal().toString() + "$");
        quantityTxt.setText("1");
        searchProduct.setText("");
        pricePerUnitTxt.setText("");
        productIDtxt.setText("");
        expirydateTxt.setText("");
    }

    private String gjeneroNrFatures() {
        List<BillOutCome> listBillOutCome = bor.findAll();
        String n = "PHMS" + (1000000 + listBillOutCome.size() + 1);
        billNumber = n;
        return n;

    }


    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) billDetailsTable.getModel();

        int row = billDetailsTable.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Are u sure you want to delete ?", "Deletion", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                model.removeRow(row);
                amountTxt.setText(generateTotal().toString() + "$");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please , choose what you want to delete !");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        billDetailsTable.clearSelection();
        clear();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellButtonActionPerformed
        // TODO add your handling code here:
        if (!(billDetailsTable.getRowCount() == 0)) {
            BillOutCome b = new BillOutCome();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            try {
                b.setBillDate(date);
                b.setBillNumber(gjeneroNrFatures());
                b.setPerdoruesiID(LoginForm.p);
                b.setTotal(generateTotal());

                bor.create(b);
            } catch (PharmacyException ex) {
                Logger.getLogger(POSForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

                int rows = billDetailsTable.getRowCount();
                con = connect.getConnect();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime = new java.sql.Timestamp(timestamp.getTime());
                for (int i = 0; i < rows; i++) {
                    //int pID = Integer.parseInt(billDetailsTable.getValueAt(i, 0).toString());
                    Product productID = (Product) billDetailsTable.getValueAt(i, 0);
                    BigInteger quantity = (BigInteger) billDetailsTable.getValueAt(i, 1);
                    BigDecimal price = (BigDecimal) billDetailsTable.getValueAt(i, 2);
                    BigDecimal subtotal = (BigDecimal) billDetailsTable.getValueAt(i, 3);
                    String queryCo = "Insert into BillOutComeDetails(billOutComeID,productID,quantity,subtotal,billDate,billTime) values('" + b.getBillOutComeID() + "','" + productID.getProductID() + "','" + quantity + "','" + subtotal + "','" + sqlDate + "','"
                            + "" + sqlTime + "')";
                    pst = con.prepareStatement(queryCo);
                    pst.execute();

                    String sql = "Select quantity from Stock where productID ='" + productID.getProductID() + "'";
                    pst = con.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        qty = rs.getInt(1);
                    }
                    qty -= ((BigInteger) quantity).intValue();

                    String queryUpdate = "Update Stock set quantity = ? where productID='" + productID.getProductID() + "'";
                    pst = con.prepareStatement(queryUpdate);
                    pst.setInt(1, qty);
                    pst.executeUpdate();

                }
            } catch (SQLException | NumberFormatException e) {
                e.printStackTrace();
            }
            Object[] ob = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Do you want to Print ?", "Print", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {

                printJasperInvoice();
            } else {

            }
            model.setRowCount(0);
            amountTxt.setText(generateTotal().toString() + "$");
            invoiceNotxt.setText(gjeneroNrFatures());

        } else {
            JOptionPane.showMessageDialog(this, "Please fill the required spaces !");
        }
        sf.updateTable();
        rf.loadTableSales();

    }//GEN-LAST:event_sellButtonActionPerformed

    private void searchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductActionPerformed

    }//GEN-LAST:event_searchProductActionPerformed

    public void printJasperInvoice() {
        try {
            model = (DefaultTableModel) billDetailsTable.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(model);
            String reportSource = "C:\\Users\\Mimoza\\Desktop\\LabCourse\\PharmacyManagementSystemSoftware\\src\\reports\\OutComeInvoice.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(reportSource);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("operator",LoginForm.p.getName()+" "+LoginForm.p.getLastName());
            params.put("invoiceNo",invoiceNotxt.getText());
            params.put("date", dateLabel.getText());
            params.put("time", timeLabel.getText());
            params.put("grandTotal",generateTotal().toString());

            JasperPrint jp = JasperFillManager.fillReport(jr, params, datasource);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printoPDF() {

        JFileChooser fch = new JFileChooser();
        fch.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fch.setPreferredSize(new Dimension(700, 500));
        fch.setDialogTitle("Print Invoice");
        int returnVal = fch.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            FileOutputStream outtPutFile = null;
            try {
                Document doc = new Document(PageSize.A4.rotate());
                outtPutFile = new FileOutputStream(fch.getSelectedFile().getAbsolutePath() + " Invoice.pdf");
                PdfWriter.getInstance(doc, outtPutFile);
                doc.open();
                doc.add(new Paragraph("                       Invoice NO: " + billNumber));
                doc.add(new Paragraph("                       Operator  : " + LoginForm.p.getName() + " " + LoginForm.p.getLastName()));
                doc.add(new Paragraph("                       Date : " + new SimpleDateFormat("dd-MM-yyy").format(new Date())));
                doc.add(new Paragraph("                       Time : " + new SimpleDateFormat("HH:mm:ss").format(new Date())));
                doc.add(new Paragraph(""));
                PdfPTable pdfTable = new PdfPTable(billDetailsTable.getColumnCount());
                for (int i = 0; i < billDetailsTable.getColumnCount(); i++) {
                    pdfTable.addCell(billDetailsTable.getColumnName(i));
                }
                for (int rows = 0; rows < billDetailsTable.getRowCount(); rows++) {
                    for (int cols = 0; cols < billDetailsTable.getColumnCount(); cols++) {
                        pdfTable.addCell(billDetailsTable.getModel().getValueAt(rows, cols).toString());

                    }
                }
                doc.add(new Paragraph("\n"));
                doc.add(pdfTable);
                doc.add(new Paragraph("\n"));
                doc.add(new Paragraph("                                                                                                                                                                           Total Amount: " + generateTotal()));
                doc.close();
                JOptionPane.showMessageDialog(this, "Invoice saved successfully");
            } catch (FileNotFoundException | DocumentException ex) {
                Logger.getLogger(POSForm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    outtPutFile.close();
                } catch (IOException ex) {
                    Logger.getLogger(POSForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private void quantityTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTxtKeyReleased
        if (quantityTxt.getText().matches("^[0-9 ]*$")) {

        } else {
            JOptionPane.showMessageDialog(this, "Quantity cannot contain letters !");
            quantityTxt.setText("1");
        }
    }//GEN-LAST:event_quantityTxtKeyReleased

    private void quantityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTxtKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addButonActionPerformed(null);
            searchProduct.requestFocus();
        }
    }//GEN-LAST:event_quantityTxtKeyPressed

    private void quantityTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTxtKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_quantityTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButon;
    private javax.swing.JLabel amountTxt;
    private javax.swing.JTable billDetailsTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JList<String> dropDownList;
    private javax.swing.JScrollPane dropDownPanel;
    private javax.swing.JTextField expirydateTxt;
    private javax.swing.JTextField invoiceNotxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pricePerUnitTxt;
    private javax.swing.JTextField productIDtxt;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JTextField searchProduct;
    private javax.swing.JButton sellButton;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
