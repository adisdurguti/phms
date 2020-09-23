/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.PerdoruesiReport;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Adis Durguti
 */
public class PerdoruesiReportRepository extends EntMngClass implements PerdoruesiReportInterface{
    @Override
    public void create(PerdoruesiReport u) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(PerdoruesiReport u) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(PerdoruesiReport u) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<PerdoruesiReport> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("PerdoruesiReport.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public PerdoruesiReport findByID(Integer ID) {
         Query q = em.createQuery("Select p from PerdoruesiReport p where p.reportID:id");
        q.setParameter("id", ID);
        return (PerdoruesiReport)q.getSingleResult(); 
    }

}
