/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.PerdoruesiReport;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public interface PerdoruesiReportInterface {

    void create(PerdoruesiReport u) throws PharmacyException;

    void edit(PerdoruesiReport u) throws PharmacyException;

    void delete(PerdoruesiReport u) throws PharmacyException;

    List<PerdoruesiReport> findAll() throws PharmacyException;

    PerdoruesiReport findByID(Integer ID);

}
