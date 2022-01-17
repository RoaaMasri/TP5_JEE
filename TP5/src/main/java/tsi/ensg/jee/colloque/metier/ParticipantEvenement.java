package tsi.ensg.jee.colloque.metier;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "participantEvenement")
public class ParticipantEvenement implements Serializable {



    @Id
    @ManyToOne
    private Participant participant;

    @Id
    @ManyToOne
    private Evenement evenement;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public ParticipantEvenement(Participant participant, Evenement evenement) {
        this.participant = participant;
        this.evenement = evenement;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        ParticipantEvenement that = (ParticipantEvenement) o;
        return Objects.equals( participant, that.participant ) &&
                Objects.equals( evenement, that.evenement );
    }

    @Override
    public int hashCode() {
        return Objects.hash( participant, evenement );
    }
}
