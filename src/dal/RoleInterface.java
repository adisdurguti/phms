/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.Role;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public interface RoleInterface {
    void create(Role r) throws PharmacyException;

    void edit(Role r) throws PharmacyException;

    void delete(Role r) throws PharmacyException;

    List<Role> findAll() throws PharmacyException;

    Role  findByID(Integer ID);
}
