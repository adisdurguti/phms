/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.Product;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public interface ProductInterface {
     void create(Product p) throws PharmacyException;

    void edit(Product p) throws PharmacyException;

    void delete(Product p) throws PharmacyException;

    List<Product> findAll() ;

    Product findByID(Integer ID);
}
