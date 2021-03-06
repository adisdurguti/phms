/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import bll.Company;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Adis Durguti
 */
public class CompanyComboBoxModel extends AbstractListModel<Company> implements ComboBoxModel<Company> {

    List<Company> list;
    Company selectedItem;

    public CompanyComboBoxModel(List<Company> list) {
        this.list = list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Company getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem = (Company) o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
