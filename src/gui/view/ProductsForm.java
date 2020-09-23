/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import bll.Category;
import bll.Company;
import bll.Product;
import connection.Connect;
import dal.ProductRepository;
import dal.CategoryInterface;
import dal.CategoryRepository;
import dal.CompanyInterface;
import dal.CompanyRepository;
import dal.PharmacyException;
import gui.model.CategoryComboBoxModel;
import gui.model.CompanyComboBoxModel;
import gui.model.ProductTableModel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Adis Durguti
 */
public class ProductsForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProductsForm
     */
    CategoryInterface ci = new CategoryRepository();
    CategoryComboBoxModel cabm;
    CompanyComboBoxModel cobm;
    ProductTableModel ptm = new ProductTableModel();
    ProductRepository pr = new ProductRepository();
    List<Product> listProduct = new ArrayList<>();
    CompanyInterface cai = new CompanyRepository();
    Connect connect = new Connect();
    Connection con = null;
    PreparedStatement pst = null;
    POSForm PF = new POSForm();

    public ProductsForm() {
        initComponents();
        loadComboBoxCategory();
        loadComboBoxCopmany();
        loadTable();
        tabelaSelectedIndexChange();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productIDtxt = new javax.swing.JTextField();
        categoryComboBox = new javax.swing.JComboBox();
        companyComboBox = new javax.swing.JComboBox();
        productNametxt = new javax.swing.JTextField();
        manufacturingDateChooser = new com.toedter.calendar.JDateChooser();
        expiryDateChooser = new com.toedter.calendar.JDateChooser();
        productBuyPricetxt = new javax.swing.JTextField();
        productSellPricetxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addProductBtn = new javax.swing.JButton();
        updateProductBtn = new javax.swing.JButton();
        deleteProductBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        productdoseTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        barcodeTxt = new javax.swing.JTextField();
        sericNumberTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        isActivetxt = new javax.swing.JTextField();

        setResizable(true);
        setTitle("Porducts");

        productIDtxt.setEditable(false);

        categoryComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                categoryComboBoxFocusGained(evt);
            }
        });

        companyComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                companyComboBoxFocusGained(evt);
            }
        });

        productNametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productNametxtKeyReleased(evt);
            }
        });

        productBuyPricetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productBuyPricetxtKeyReleased(evt);
            }
        });

        productSellPricetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productSellPricetxtKeyReleased(evt);
            }
        });

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(productTable);

        jLabel1.setText("Product ID");

        jLabel2.setText("Product Name");

        jLabel3.setText("Category");

        jLabel4.setText("Company");

        jLabel6.setText("Manufacturing Date");

        jLabel7.setText("Expiring Date");

        jLabel8.setText("Product Buy Price");

        jLabel9.setText("Product Sell Price");

        addProductBtn.setText("Add Product");
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });

        updateProductBtn.setText("Update Product");
        updateProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProductBtnActionPerformed(evt);
            }
        });

        deleteProductBtn.setText("Delete Product");
        deleteProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setText("Product Dose");

        barcodeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeTxtActionPerformed(evt);
            }
        });

        jLabel10.setText("Product Barcode");

        jLabel11.setText("Product Seric Number");

        jLabel12.setText("IsActive");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jLabel1))
                                .addComponent(productIDtxt)
                                .addComponent(productNametxt)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator2)
                                .addComponent(productdoseTxt)
                                .addComponent(barcodeTxt)
                                .addComponent(sericNumberTxt)
                                .addComponent(jLabel11)
                                .addComponent(jSeparator5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel5))
                                .addComponent(jSeparator10)
                                .addComponent(jSeparator11)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(productBuyPricetxt)
                                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(companyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator3)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator9)
                                        .addComponent(productSellPricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(isActivetxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(manufacturingDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expiryDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addComponent(addProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(updateProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(deleteProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(202, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 693, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 694, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteProductBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateProductBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(addProductBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(169, 169, 169))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productIDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barcodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sericNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productdoseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(companyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manufacturingDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expiryDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productBuyPricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productSellPricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isActivetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addGap(62, 62, 62))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 420, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 388, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categoryComboBoxFocusGained
        // TODO add your handling code here:
        loadComboBoxCategory();
    }//GEN-LAST:event_categoryComboBoxFocusGained

    private void companyComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companyComboBoxFocusGained
        // TODO add your handling code here:
        loadComboBoxCopmany();
    }//GEN-LAST:event_companyComboBoxFocusGained
    public boolean exists() {
        for (Product listProduct1 : listProduct) {
            if (listProduct1.getProductSericNumber().equals(sericNumberTxt.getText())) {
                return true;
            }
        }
        return false;
    }
    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtnActionPerformed
        // TODO add your handling code here:
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        s.format(d);
        if (check()) {
            if (barcodeTxt.getText().length() == 12) {
                if (exists()) {
                    if (!(manufacturingDateChooser.getDate().after(d))) {
                        if (!(expiryDateChooser.getDate().before(d))) {
                            Product p = new Product();
                            try {
                                //p.setProductID(Integer.parseInt(productIDtxt.getText()));
                                p.setCompanyID(cobm.getElementAt(companyComboBox.getSelectedIndex()));
                                p.setCategoryID(cabm.getElementAt(categoryComboBox.getSelectedIndex()));
                                p.setProductDosage(productdoseTxt.getText());
                                p.setProductBarcode(barcodeTxt.getText());
                                p.setProductSericNumber(sericNumberTxt.getText());
                                p.setProductName(productNametxt.getText());
                                p.setManufactoringDate(manufacturingDateChooser.getDate());
                                p.setExpiringDate(expiryDateChooser.getDate());
                                BigDecimal sp = new BigDecimal(productSellPricetxt.getText());
                                p.setProductSellPrice(sp);
                                BigDecimal bp = new BigDecimal(productBuyPricetxt.getText());
                                p.setIsActive(isActivetxt.getText());
                                p.setProductBuyPrice(bp);

                                pr.create(p);
                            } catch (PharmacyException ex) {
                                Logger.getLogger(CompanyForm.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Expiry Date cannot be less than actual date !");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Manufacturing Date cannot be greater than actual date !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "This product exists !");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Barcode should be 12 characters !");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please ,fill all the required information !");
        }
        loadTable();
        clear();

        /* MainForm mf = new MainForm();
         mf.ButtonStockAction(evt);*/
    }//GEN-LAST:event_addProductBtnActionPerformed

    private void updateProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProductBtnActionPerformed
        // TODO add your handling code here:
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        s.format(d);
        int row = productTable.getSelectedRow();
        if (row >= 0) {
            if (barcodeTxt.getText().length() == 12) {
               // if (exists()) {
                    if (!(manufacturingDateChooser.getDate().after(d))) {
                       //if (!(expiryDateChooser.getDate().before(d))) {
                            try {
                                Product p = ptm.getProduct(row);
                                //p.setProductID(Integer.parseInt(productIDtxt.getText()));
                                p.setProductBarcode(barcodeTxt.getText());
                                p.setProductSericNumber(sericNumberTxt.getText());
                                p.setProductName(productNametxt.getText());
                                p.setCategoryID(cabm.getElementAt(categoryComboBox.getSelectedIndex()));
                                p.setCompanyID(cobm.getElementAt(companyComboBox.getSelectedIndex()));
                                p.setProductDosage(productdoseTxt.getText());
                                p.setManufactoringDate(manufacturingDateChooser.getDate());
                                p.setExpiringDate(expiryDateChooser.getDate());
                                BigDecimal bp = new BigDecimal(productBuyPricetxt.getText());
                                p.setProductBuyPrice(bp);
                                BigDecimal sp = new BigDecimal(productSellPricetxt.getText());
                                p.setProductSellPrice(sp);
                                p.setIsActive(isActivetxt.getText());
                                pr.edit(p);
                            } catch (PharmacyException ex) {
                                JOptionPane.showMessageDialog(this, "MSG: " + ex.getMessage());
                            }
                        //} else {
                            //JOptionPane.showMessageDialog(this, "Expiry Date cannot be less than actual date !");
                        //}
                    } else {
                        JOptionPane.showMessageDialog(this, "Manufacturing Date cannot be greater than actual date !");
                    }
                //} else {
                   // JOptionPane.showMessageDialog(this, "This product exists !");
                //}

            } else {
                JOptionPane.showMessageDialog(this, "Barcode should be 12 characters !");
            }
            loadTable();
            clear();
            categoryComboBox.repaint();
            companyComboBox.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please , choose what you want to update !");
        }
    }//GEN-LAST:event_updateProductBtnActionPerformed

    private void deleteProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductBtnActionPerformed
        // TODO add your handling code here:
        int row = productTable.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Are u sure you want to delete ?", "Deletion", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                try {
                    Product p = ptm.getProduct(row);

                    con = connect.getConnect();
                    pst = con.prepareStatement("Delete from BillIncomeDetails where productID = ?");
                    pst.setInt(1, p.getProductID());
                    pst.executeUpdate();
                    pr.delete(p);

                    clear();
                    loadTable();
                    PF.putIntoTSTname();
                } catch (PharmacyException ex) {
                    JOptionPane.showMessageDialog(this, "MSG: " + ex.getMessage());
                } catch (SQLException ex) {
                    Logger.getLogger(ProductsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please , choose what you want to delete !");
        }
    }//GEN-LAST:event_deleteProductBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void productBuyPricetxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productBuyPricetxtKeyReleased
        // TODO add your handling code here:
        if (!productBuyPricetxt.getText().matches("^[\\d,.]+$")) {
            JOptionPane.showMessageDialog(this, "Buy Price cannot contain letters !");
            productBuyPricetxt.setText("");
        } else {

        }

    }//GEN-LAST:event_productBuyPricetxtKeyReleased

    private void productSellPricetxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productSellPricetxtKeyReleased
        // TODO add your handling code here:
        if (!productSellPricetxt.getText().matches("^[\\d,.]+$")) {
            JOptionPane.showMessageDialog(this, "Sell Price cannot contain letters !");
            productSellPricetxt.setText("");
        } else {

        }
    }//GEN-LAST:event_productSellPricetxtKeyReleased

    private void productNametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNametxtKeyReleased
        // TODO add your handling code here:
        if (!productNametxt.getText().matches("^[a-zA-Z]*$")) {
            JOptionPane.showMessageDialog(this, "ProductName cannot contain numbers !");
            productNametxt.setText("");
        } else {

        }
    }//GEN-LAST:event_productNametxtKeyReleased

    private void barcodeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodeTxtActionPerformed

    public void loadComboBoxCategory() {
        try {
            List<Category> list = ci.findAll();
            cabm = new CategoryComboBoxModel(list);
            categoryComboBox.setModel(cabm);
            categoryComboBox.repaint();
        } catch (PharmacyException ce) {
            JOptionPane.showMessageDialog(this, ce.getMessage());
        }
    }

    public void loadComboBoxCopmany() {
        try {
            List<Company> list = cai.findAll();
            cobm = new CompanyComboBoxModel(list);
            companyComboBox.setModel(cobm);
            companyComboBox.repaint();
        } catch (PharmacyException ce) {
            JOptionPane.showMessageDialog(this, ce.getMessage());
        }
    }

    public void loadTable() {

        List<Product> list = pr.findAll();
        ptm = new ProductTableModel(list);
        productTable.setModel(ptm);
        ptm.fireTableDataChanged();
        tabelaSelectedIndexChange();

    }

    public void clear() {
        productTable.clearSelection();
        productIDtxt.setText("");
        productNametxt.setText("");
        cabm.setSelectedItem(null);
        cobm.setSelectedItem(null);
        manufacturingDateChooser.setDate(null);
        expiryDateChooser.setDate(null);
        productBuyPricetxt.setText("");
        productSellPricetxt.setText("");
        productdoseTxt.setText("");
        barcodeTxt.setText("");
        sericNumberTxt.setText("");
        categoryComboBox.repaint();
        companyComboBox.repaint();
    }

    boolean check() {
        if (!(productNametxt.getText().trim().equals("")
                || productBuyPricetxt.getText().trim().equals("")
                || categoryComboBox.getSelectedIndex() == -1
                || companyComboBox.getSelectedIndex() == -1
                || productSellPricetxt.getText().trim().equals("")
                || manufacturingDateChooser.getDate().equals(null)
                || expiryDateChooser.getDate().equals(null))) {
            return true;
        }
        return false;
    }

    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = productTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Product p = ptm.getProduct(selectedIndex);
                    productIDtxt.setText(p.getProductID() + "");
                    productNametxt.setText(p.getProductName());
                    cabm.setSelectedItem(p.getCategoryID());
                    cobm.setSelectedItem(p.getCompanyID());
                    barcodeTxt.setText(p.getProductBarcode());
                    sericNumberTxt.setText(p.getProductSericNumber());
                    //quantityTxt.setText(p.getQuantity() + "");
                    manufacturingDateChooser.setDate(p.getManufactoringDate());
                    expiryDateChooser.setDate(p.getExpiringDate());
                    productBuyPricetxt.setText(p.getProductBuyPrice() + "");
                    productSellPricetxt.setText(p.getProductSellPrice() + "");
                    productdoseTxt.setText(p.getProductDosage() + "");
                    isActivetxt.setText(p.getIsActive());
                    categoryComboBox.repaint();
                    companyComboBox.repaint();

                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductBtn;
    private javax.swing.JTextField barcodeTxt;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JComboBox companyComboBox;
    private javax.swing.JButton deleteProductBtn;
    private com.toedter.calendar.JDateChooser expiryDateChooser;
    private javax.swing.JTextField isActivetxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private com.toedter.calendar.JDateChooser manufacturingDateChooser;
    private javax.swing.JTextField productBuyPricetxt;
    private javax.swing.JTextField productIDtxt;
    private javax.swing.JTextField productNametxt;
    private javax.swing.JTextField productSellPricetxt;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField productdoseTxt;
    private javax.swing.JTextField sericNumberTxt;
    private javax.swing.JButton updateProductBtn;
    // End of variables declaration//GEN-END:variables
}
