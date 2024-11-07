/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ior.mk;

import org.hibernate.Session;
import static test.data.DataLoader.loadTestData;

/**
 *
 * @author student
 */
public class IORMK {

    public static void main(String[] args) {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            loadTestData(session);
        }
    }
}
