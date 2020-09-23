/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

/**
 *
 * @author Lum Beqiri
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bll.Product;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adis Durguti
 */
public class ProductTableModel extends AbstractTableModel {

    List<Product> list;
    String[] cols = {"ProductID", "Product Barcode", "Product Seric Number", "Product Name", "Product Dose", "Category", "Company", "ManufacturingDate",
        "ExpiringDate", "BuyPrice", "SellPrice","Active"};

    public ProductTableModel(List<Product> list) {
        this.list = list;
    }

    public ProductTableModel() {

    }

    public void addList(List<Product> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public String getColumnName(int col) {
        return cols[col];
    }

    public void remove(int row) {
        list.remove(row);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    public Product getProduct(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product p = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getProductID();
            case 1:
                return p.getProductBarcode();
            case 2:
                return p.getProductSericNumber();
            case 3:
                return p.getProductName();
            case 4:
                return p.getProductDosage();
            case 5:
                return p.getCategoryID();
            case 6:
                return p.getCompanyID();
            case 7:
                return new SimpleDateFormat("dd.MM.yyyy").format(p.getManufactoringDate());
            case 8:
                return new SimpleDateFormat("dd.MM.yyyy").format(p.getExpiringDate());
            case 9:
                return p.getProductBuyPrice();
            case 10:
                return p.getProductSellPrice();
                case 11:
                return p.getIsActive();
            default:
                return null;
        }
    }

}
