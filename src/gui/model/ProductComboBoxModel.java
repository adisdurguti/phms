/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import bll.Product;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Adis Durguti
 */
public class ProductComboBoxModel extends AbstractListModel<Product> implements ComboBoxModel<Product> {

    List<Product> list;
    Product selectedItem;

    public ProductComboBoxModel(List<Product> list) {
        this.list = list;
    }


    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Product getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem = (Product) o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}