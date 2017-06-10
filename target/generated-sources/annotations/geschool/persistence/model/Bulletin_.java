package geschool.persistence.model;

import geschool.persistence.model.AnneeScolaire;
import geschool.persistence.model.BulletinPK;
import geschool.persistence.model.Eleve;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(Bulletin.class)
public class Bulletin_ { 

    public static volatile SingularAttribute<Bulletin, BulletinPK> bulletinPK;
    public static volatile SingularAttribute<Bulletin, AnneeScolaire> anneeScolaire1;
    public static volatile SingularAttribute<Bulletin, Float> noteFinal;
    public static volatile SingularAttribute<Bulletin, String> appreciation;
    public static volatile SingularAttribute<Bulletin, Eleve> eleve1;

}