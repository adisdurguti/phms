/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.BillOutCome;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public interface BillOutComeInterface {

    void create(BillOutCome bocd) throws PharmacyException;

    void edit(BillOutCome bocd) throws PharmacyException;

    void delete(BillOutCome bocd) throws PharmacyException;

    List<BillOutCome> findAll();

    BillOutCome findByID(Integer ID);
}
