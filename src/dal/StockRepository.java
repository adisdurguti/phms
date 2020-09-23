/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.Stock;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public class StockRepository extends EntMngClass implements StockInterface{
         @Override
    public void create(Stock r) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Stock r) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Stock r) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Stock> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Stock.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Stock  findByID(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
