package tsi.ensg.jee.colloque.metier;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "evenement")
public class Evenement {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long num_even;
    public Long getId() {
        return num_even;
    }
    @Column(name = "intitule", nullable = false)
    private String intitule;
    @Column(name = "theme")
    private String theme;
    @Column(name = "date_debut", nullable = false)
    private String date_debut;
    @Column(name = "duree")
    private String duree;
    @Column(name = "nb_part_max", nullable = false)
    private long nb_part_max;
    @Column(name = "description")
    private String description;
    @Column(name = "organisateur")
    private String organisateur;
    @Column(name = "type_even")
    private String type_even;



    @OneToMany(
            mappedBy = "evenement",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ParticipantEvenement> owners = new ArrayList<>();

    public List<ParticipantEvenement> getOwners() {
        return owners;
    }

    public void setOwners(List<ParticipantEvenement> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Evenement evenement = (Evenement) o;
        return Objects.equals( intitule, evenement.intitule ) &&
                Objects.equals(theme,evenement.theme) &&
                Objects.equals(date_debut, evenement.date_debut) &&
                Objects.equals(duree,evenement.duree)&&
                Objects.equals(nb_part_max,evenement.nb_part_max)&&
                Objects.equals(description,evenement.description)&&
                Objects.equals(organisateur,evenement.organisateur)&&
                Objects.equals(type_even,evenement.type_even);
    }

    @Override
    public int hashCode() {
        return Objects.hash( intitule,theme, date_debut, duree, nb_part_max, description, organisateur, type_even);
    }


    public Evenement(){

    }

    public Evenement(String intitule, String theme, String date_debut, String duree,
                     long nb_part_max, String description, String organisateur, String type_even){
        this.intitule= intitule;
        this.theme = theme;
        this.date_debut = date_debut;
        this.duree = duree;
        this.nb_part_max = nb_part_max;
        this.description = description;
        this.organisateur = organisateur;
        this.type_even = type_even;
    }

}
