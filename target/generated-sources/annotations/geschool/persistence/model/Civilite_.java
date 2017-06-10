package geschool.persistence.model;

import geschool.persistence.model.TuteurEleve;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(Civilite.class)
public class Civilite_ { 

    public static volatile SingularAttribute<Civilite, Integer> idcivilite;
    public static volatile ListAttribute<Civilite, TuteurEleve> tuteurEleveList;
    public static volatile SingularAttribute<Civilite, String> libelle;

}