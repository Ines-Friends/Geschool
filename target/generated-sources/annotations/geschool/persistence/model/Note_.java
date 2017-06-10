package geschool.persistence.model;

import geschool.persistence.model.AnneeScolaire;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Matiere;
import geschool.persistence.model.NotePK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, Integer> classe;
    public static volatile SingularAttribute<Note, Date> dateCreation;
    public static volatile SingularAttribute<Note, Float> valeur;
    public static volatile SingularAttribute<Note, AnneeScolaire> anneeScolaire;
    public static volatile SingularAttribute<Note, Date> dateModification;
    public static volatile SingularAttribute<Note, Matiere> matiere1;
    public static volatile SingularAttribute<Note, String> appreciation;
    public static volatile SingularAttribute<Note, NotePK> notePK;
    public static volatile SingularAttribute<Note, Eleve> eleve1;

}