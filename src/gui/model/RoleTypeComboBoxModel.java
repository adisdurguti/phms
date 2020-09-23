/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import bll.Role;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Adis Durguti
 */
public class RoleTypeComboBoxModel extends AbstractListModel<Role> implements ComboBoxModel<Role> {
    List<Role> list;
    Role selectedItem;

    public RoleTypeComboBoxModel(List<Role> list) {
        this.list = list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Role getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem = (Role) o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
