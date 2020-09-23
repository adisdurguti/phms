/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import bll.Company;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adis Durguti
 */
public class CompanyTableModel extends AbstractTableModel {

    List<Company> list;
    String[] cols = {"Company ID", "CompanyName", "BussinesNO", "CompanyEmail", "CompanyConctactNumber", "CompanyCountry", "CompanyAddress"};

    public CompanyTableModel(List<Company> list) {
        this.list = list;
    }

    public CompanyTableModel() {

    }

    public void addList(List<Company> list) {
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

    public Company getCompany(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Company c = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getCompanyID();
            case 1:
                return c.getCompanyName();
            case 2:
                return c.getCompanyBussinesNumber();
            case 3:
                return c.getCompanyEmail();
            case 4:
                return c.getCompanyContactNumber();
            case 5:
                return c.getCompanyCountry();
            case 6:
                return c.getCompanyAddress();
            default:
                return null;
        }
    }

}
