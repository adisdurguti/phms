/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

/**
 *
 * @author Adis Durguti
 */
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class EntMngClass {

    EntityManager em = Persistence.createEntityManagerFactory("PharmacyPU").createEntityManager();
}
