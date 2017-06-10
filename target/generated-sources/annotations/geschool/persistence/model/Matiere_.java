package geschool.persistence.model;

import geschool.persistence.model.Enseignement;
import geschool.persistence.model.Note;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:19")
@StaticMetamodel(Matiere.class)
public class Matiere_ { 

    public static volatile SingularAttribute<Matiere, Note> note;
    public static volatile SingularAttribute<Matiere, Enseignement> enseignement;
    public static volatile SingularAttribute<Matiere, String> libelle;
    public static volatile SingularAttribute<Matiere, Integer> coefficient;
    public static volatile SingularAttribute<Matiere, Integer> idmatiere;

}