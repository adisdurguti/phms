/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import bll.Category;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Adis Durguti
 */
public class CategoryComboBoxModel extends AbstractListModel<Category> implements ComboBoxModel<Category> {

    List<Category> list;
    Category selectedItem;

    public CategoryComboBoxModel(List<Category> list) {
        this.list = list;
    }


    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Category getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem = (Category) o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
