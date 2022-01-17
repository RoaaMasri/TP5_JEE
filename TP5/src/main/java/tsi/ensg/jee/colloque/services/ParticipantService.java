package tsi.ensg.jee.colloque.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tsi.ensg.jee.colloque.metier.Participant;

import java.util.List;

public class ParticipantService {
    private final SessionFactory sessionFactory;

    public ParticipantService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertParticipant(Participant participant){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(participant);
        session.getTransaction().commit();
        session.close();
    }

    public List getAllParticipant(){
        Session session = this.sessionFactory.openSession();
        List result = session.createQuery("from Participant").list();
        session.close();
        return result;
    }
}
