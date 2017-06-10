package geschool.persistence.model;

import geschool.persistence.model.Bulletin;
import geschool.persistence.model.Inscription;
import geschool.persistence.model.Note;
import geschool.persistence.model.Paiement;
import geschool.persistence.model.StatutEleve;
import geschool.persistence.model.TuteurEleve;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(Eleve.class)
public class Eleve_ { 

    public static volatile SingularAttribute<Eleve, Note> note;
    public static volatile SingularAttribute<Eleve, Date> dateCreation;
    public static volatile ListAttribute<Eleve, Inscription> inscriptionList;
    public static volatile SingularAttribute<Eleve, Date> dateNaissance;
    public static volatile SingularAttribute<Eleve, Integer> ideleve;
    public static volatile SingularAttribute<Eleve, Date> dateModification;
    public static volatile SingularAttribute<Eleve, String> prenomEleve;
    public static volatile SingularAttribute<Eleve, String> nomEleve;
    public static volatile SingularAttribute<Eleve, TuteurEleve> tuteurEleve;
    public static volatile SingularAttribute<Eleve, String> adresse;
    public static volatile ListAttribute<Eleve, Paiement> paiementList;
    public static volatile SingularAttribute<Eleve, StatutEleve> statut;
    public static volatile SingularAttribute<Eleve, Bulletin> bulletin;

}