/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.BillIncome;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public interface BillIncomeInterface {

    void create(BillIncome bocd) throws PharmacyException;

    void edit(BillIncome bocd) throws PharmacyException;

    void delete(BillIncome bocd) throws PharmacyException;

    List<BillIncome> findAll();

    BillIncome findByID(Integer ID);
}
