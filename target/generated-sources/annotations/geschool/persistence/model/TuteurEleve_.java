package geschool.persistence.model;

import geschool.persistence.model.Civilite;
import geschool.persistence.model.Eleve;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(TuteurEleve.class)
public class TuteurEleve_ { 

    public static volatile SingularAttribute<TuteurEleve, String> prenomTuteur;
    public static volatile SingularAttribute<TuteurEleve, Date> dateCreation;
    public static volatile SingularAttribute<TuteurEleve, String> nomTuteur;
    public static volatile SingularAttribute<TuteurEleve, Date> dateModification;
    public static volatile SingularAttribute<TuteurEleve, String> adresse;
    public static volatile ListAttribute<TuteurEleve, Eleve> eleveList;
    public static volatile SingularAttribute<TuteurEleve, Integer> idtuteurEleve;
    public static volatile SingularAttribute<TuteurEleve, Civilite> civilite;

}