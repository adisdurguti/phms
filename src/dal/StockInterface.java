/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.Stock;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public interface StockInterface {
    void create(Stock r) throws PharmacyException;

    void edit(Stock r) throws PharmacyException;

    void delete(Stock r) throws PharmacyException;

    List<Stock> findAll() throws PharmacyException;

    Stock  findByID(Integer ID);
}
