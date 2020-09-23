/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import bll.PerdoruesiReport;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adis Durguti
 */
public class PerdoruesiReportTableModel extends AbstractTableModel {
    
    List<PerdoruesiReport> list;
    String[] cols = {"User","Status","Date","Time"};

    public PerdoruesiReportTableModel(List<PerdoruesiReport> list) {
        this.list = list;
    }

    public PerdoruesiReportTableModel() {

    }

    public void addList(List<PerdoruesiReport> list) {
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

    public PerdoruesiReport getPerdoruesiReport(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PerdoruesiReport p = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPerdoruesiID().toString1();
            case 1:
                return p.getStatus();
            case 2:
                return new SimpleDateFormat("dd.MM.yyyy").format(p.getDate());
            case 3:
                return new SimpleDateFormat("HH:mm:ss").format(p.getTime());
            default:
                return null;
        }
    }

}
