package tsi.ensg.jee.colloque.metier;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "participant")
public class Participant implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")

    @NaturalId
    private long num_pers;
    public Long getId() {
        return num_pers;
    }

    @Column(name = "nom", nullable = false)
    private static String nom;
    @Column(name = "prenom", nullable = false)
    private static String prenom;
    @Column(name = "email")
    private static String email;
    @Column(name = "date_naiss", nullable = false)
    private static String date_naiss;
    @Column(name = "organisation")
    private static String organisation;
    @Column(name = "observations")
    private static String observations;


    public Participant(){

    }

    public Participant(String nom, String prenom, String email, String date_naiss,String organisation,String observations){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observations = observations;
    }

    @OneToMany(
            mappedBy = "participant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ParticipantEvenement> evenements = new ArrayList<>();

    public List<ParticipantEvenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<ParticipantEvenement> evenements) {
        this.evenements = evenements;
    }

    public void addEvent(Evenement evenement) {
        ParticipantEvenement participantEvenement = new ParticipantEvenement( this, evenement );
        evenements.add( participantEvenement );
        evenement.getOwners().add( participantEvenement );
    }

    public void removeEvent(Evenement evenement) {
        ParticipantEvenement participantEvenement = new ParticipantEvenement( this, evenement );
        evenement.getOwners().remove( participantEvenement );
        evenements.remove( participantEvenement );
        participantEvenement.setParticipant( null );
        participantEvenement.setEvenement( null );
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Participant participant = (Participant) o;
        return Objects.equals( num_pers, participant.num_pers )&&
                Objects.equals( nom, participant.nom )&&
                Objects.equals( prenom, participant.prenom )&&
                Objects.equals( email, participant.email )&&
                Objects.equals( date_naiss, participant.date_naiss )&&
                Objects.equals( organisation, participant.organisation )&&
                Objects.equals( observations, participant.observations );
    }

    @Override
    public int hashCode() {
        return Objects.hash( num_pers, nom, prenom, email, date_naiss, organisation, observations );
    }



}
