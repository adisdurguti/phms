/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.Company;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public interface CompanyInterface {
     void create(Company c) throws PharmacyException;

    void edit(Company c) throws PharmacyException;

    void delete(Company c) throws PharmacyException;

    List<Company> findAll() throws PharmacyException;

    Company findByID(Integer ID);
}
