/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.Role;
import java.util.List;

/**
 *
 * @author Adis Durguti
 */
public class RoleRepository extends EntMngClass implements RoleInterface{
         @Override
    public void create(Role r) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Role r) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Role r) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Role> findAll() throws PharmacyException {
        try {
            return em.createNamedQuery("Role.findAll").getResultList();
        } catch (Exception e) {
            throw new PharmacyException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Role  findByID(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
