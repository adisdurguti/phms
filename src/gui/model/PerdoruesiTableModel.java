/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import bll.Perdoruesi;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adis Durguti
 */
public class PerdoruesiTableModel extends AbstractTableModel {

    List<Perdoruesi> list;
    String[] cols = {"UserID", "Role", "Username", "Password", "Name", "LastName", "Email", "Gender", "BirthDate", "Salary"};

    public PerdoruesiTableModel(List<Perdoruesi> list) {
        this.list = list;
    }

    public PerdoruesiTableModel() {

    }

    public void addList(List<Perdoruesi> list) {
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

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    public Perdoruesi getPerdoruesi(int index) {
        return list.get(index);
    }

    public void remove(int row) {
        list.remove(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Perdoruesi u = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getPerdoruesiID();
            case 1:
                return u.getRoleID();
            case 2:
                return u.getUserName();
            case 3:
                return u.getPassword().hashCode();
            case 4:
                return u.getName();
            case 5:
                return u.getLastName();
            case 6:
                return u.getEmail();
            case 7:
                return u.getGender();
            case 8:
                return new SimpleDateFormat("dd.MM.yyyy").format(u.getBirthDate());
            case 9:
                return u.getSalary();

            default:
                return null;
        }
    }

}
