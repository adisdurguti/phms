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
public class BillIncomeRepository extends EntMngClass implements BillIncomeInterface{
    
    @Override
    public void create(BillIncome bocd) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(bocd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(BillIncome bocd) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(bocd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(BillIncome bocd) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(bocd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<BillIncome> findAll() {
        return em.createNamedQuery("BillIncome.findAll").getResultList();

    }

    @Override
    public BillIncome findByID(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
