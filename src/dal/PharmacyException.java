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
public class PharmacyException extends Exception {

    /**
     * Creates a new instance of <code>PharmacyException</code> without detail
     * message.
     */
    public PharmacyException() {
    }

    /**
     * Constructs an instance of <code>PharmacyException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PharmacyException(String msg) {
        super(msg);
    }
}
