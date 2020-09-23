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
public class BillOutComeRepository extends EntMngClass implements BillOutComeInterface{
    
    @Override
    public void create(BillOutCome bocd) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(bocd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(BillOutCome bocd) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(bocd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(BillOutCome bocd) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(bocd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<BillOutCome> findAll() {
        return em.createNamedQuery("BillOutCome.findAll").getResultList();

    }

    @Override
    public BillOutCome findByID(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
