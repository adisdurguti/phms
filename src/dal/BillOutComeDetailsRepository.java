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
public class BillOutComeDetailsRepository extends EntMngClass implements BillOutComeDetailsInterface {

    @Override
    public void create(BillOutComeDetails bocd) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(bocd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(BillOutComeDetails bocd) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(bocd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(BillOutComeDetails bocd) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(bocd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<BillOutComeDetails> findAll() {
        return em.createNamedQuery("BillOutComeDetails.findAll").getResultList();

    }

    @Override
    public BillOutComeDetails findByID(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
