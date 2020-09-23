/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.List;
import bll.Category;

/**
 *
 * @author Adis Durguti
 */
public interface CategoryInterface {

    void create(Category c) throws PharmacyException;

    void edit(Category c) throws PharmacyException;

    void delete(Category c) throws PharmacyException;

    List<Category> findAll() throws PharmacyException;

    Category findByID(Integer ID);
}