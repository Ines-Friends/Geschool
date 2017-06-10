package geschool.persistence.model;

import geschool.persistence.model.AnneeScolaire;
import geschool.persistence.model.DetailPaiement;
import geschool.persistence.model.Eleve;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(Paiement.class)
public class Paiement_ { 

    public static volatile SingularAttribute<Paiement, DetailPaiement> detailpaiement;
    public static volatile SingularAttribute<Paiement, AnneeScolaire> anneeScolaire;
    public static volatile SingularAttribute<Paiement, Integer> idpaiement;
    public static volatile SingularAttribute<Paiement, Eleve> eleve;

}