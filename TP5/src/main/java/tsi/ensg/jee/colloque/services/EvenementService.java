package tsi.ensg.jee.colloque.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tsi.ensg.jee.colloque.metier.Evenement;

import java.util.List;

public class EvenementService {
    private final SessionFactory sessionFactory;

    public EvenementService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertEvenement(Evenement participant){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(participant);
        session.getTransaction().commit();
        session.close();
    }

    public List getAllEvenement(){
        Session session = this.sessionFactory.openSession();
        List result = session.createQuery("from Evenement").list();
        session.close();
        return result;
    }
}
