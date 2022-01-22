package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Users u =  em.find(Users.class,2);
        System.out.println(u);

        Users x = new Users();
        x.setId(3);
        x.setName("Name2");
        x.setSalary(90L);
        em.getTransaction().begin();
        em.persist(x);
        em.getTransaction().commit();
        System.out.println(x);
    }
}
