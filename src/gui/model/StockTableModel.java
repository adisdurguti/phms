/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import bll.Stock;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adis Durguti
 */
public class StockTableModel extends AbstractTableModel{
      
    List<Stock> list;
    String[] cols = {"Stock","Product","StockName","Quantity"};

    public StockTableModel(List<Stock> list) {
        this.list = list;
    }

    public StockTableModel() {

    }

    public void addList(List<Stock> list) {
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

    public Stock getStock(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stock p = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getStockID();
            case 1:
                return p.getProductID();
            case 2:
                return p.getStockName();
            case 3:
                return p.getQuantity();
            default:
                return null;
        }
    }
}
