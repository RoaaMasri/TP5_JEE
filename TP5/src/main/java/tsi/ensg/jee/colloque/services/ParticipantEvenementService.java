package tsi.ensg.jee.colloque.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.metier.ParticipantEvenement;

import java.util.List;

public class ParticipantEvenementService {

    private final SessionFactory sessionFactory;

    public ParticipantEvenementService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertParticipantEvenement(ParticipantEvenement participantEvenement){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(participantEvenement);
        session.getTransaction().commit();
        session.close();
    }


}
