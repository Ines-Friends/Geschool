package geschool.persistence.model;

import geschool.persistence.model.Matiere;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(Enseignement.class)
public class Enseignement_ { 

    public static volatile SingularAttribute<Enseignement, String> libelle;
    public static volatile SingularAttribute<Enseignement, Integer> idenseignement;
    public static volatile ListAttribute<Enseignement, Matiere> matiereList;

}