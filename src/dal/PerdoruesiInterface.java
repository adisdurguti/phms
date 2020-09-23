/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.Perdoruesi;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public interface PerdoruesiInterface {

    void create(Perdoruesi u) throws PharmacyException;

    void edit(Perdoruesi u) throws PharmacyException;

    void delete(Perdoruesi u) throws PharmacyException;

    List<Perdoruesi> findAll() throws PharmacyException;

    Perdoruesi findByID(Integer ID);

    Perdoruesi loginByUsernameAndPassword(String u, String p) throws PharmacyException ;
}
