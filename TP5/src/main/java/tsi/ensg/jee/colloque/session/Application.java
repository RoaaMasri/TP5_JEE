package tsi.ensg.jee.colloque.session;


import org.hibernate.SessionFactory;
import tsi.ensg.jee.colloque.metier.Evenement;
import tsi.ensg.jee.colloque.metier.Participant;
import tsi.ensg.jee.colloque.metier.ParticipantEvenement;
import tsi.ensg.jee.colloque.services.EvenementService;
import tsi.ensg.jee.colloque.services.ParticipantEvenementService;
import tsi.ensg.jee.colloque.services.ParticipantService;

import static tsi.ensg.jee.colloque.session.HibernateUtils.createSessionFactory;

public class Application {
    public static void main(String[] args) {
        SessionFactory sessionFactory = createSessionFactory();

        Evenement evenement1 = new Evenement("ev1", "fun", "10-1-2022","une_hour",50,"","","");
        Participant participant1 = new Participant("toto","tutu","toto@gmail.com", "12/12/2000","","");


        EvenementService evenementService = new EvenementService(sessionFactory);
        evenementService.insertEvenement(evenement1);

        ParticipantService participantService = new ParticipantService(sessionFactory);
        participantService.insertParticipant(participant1);

        ParticipantEvenementService participantEvenementService = new ParticipantEvenementService(sessionFactory);
        participantEvenementService.insertParticipantEvenement(new ParticipantEvenement(participant1,evenement1));

        closeSessionFactory(sessionFactory);
    }

    private static void closeSessionFactory(SessionFactory sessionFactory) {
        sessionFactory.close();
    }

}
