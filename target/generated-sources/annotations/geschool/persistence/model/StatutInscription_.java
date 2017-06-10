package geschool.persistence.model;

import geschool.persistence.model.Inscription;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(StatutInscription.class)
public class StatutInscription_ { 

    public static volatile ListAttribute<StatutInscription, Inscription> inscriptionList;
    public static volatile SingularAttribute<StatutInscription, String> libelle;
    public static volatile SingularAttribute<StatutInscription, Integer> idstatutInscription;

}