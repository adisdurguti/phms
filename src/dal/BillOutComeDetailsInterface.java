/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.BillOutComeDetails;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public interface BillOutComeDetailsInterface {
    
     void create(BillOutComeDetails bocd) throws PharmacyException;

    void edit(BillOutComeDetails bocd) throws PharmacyException;

    void delete(BillOutComeDetails bocd) throws PharmacyException;

    List<BillOutComeDetails> findAll();

    BillOutComeDetails findByID(Integer ID);
}
