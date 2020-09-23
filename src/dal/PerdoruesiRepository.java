/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.Perdoruesi;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Adis Durguti
 */
public class PerdoruesiRepository extends EntMngClass implements PerdoruesiInterface{
           @Override
    public void create(Perdoruesi u) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Perdoruesi u) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Perdoruesi u) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Perdoruesi> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Perdoruesi.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Perdoruesi  findByID(Integer ID){
        Query q = em.createQuery("Select p from Perdoruesi p where p.perdoruesiID=:id");
        q.setParameter("id", ID);
        return (Perdoruesi)q.getSingleResult();        
    }
    
    public Perdoruesi loginByUsernameAndPassword(String u,String p) throws PharmacyException {
        try {
           Query q=em.createQuery("Select p from Perdoruesi p where p.userName=:un AND p.password=:psw");
           q.setParameter("un",u);
           q.setParameter("psw",p);
           return (Perdoruesi)q.getSingleResult();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }
}
