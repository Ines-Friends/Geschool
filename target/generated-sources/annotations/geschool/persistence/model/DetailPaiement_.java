package geschool.persistence.model;

import geschool.persistence.model.AnneeScolaire;
import geschool.persistence.model.Inscription;
import geschool.persistence.model.Paiement;
import geschool.persistence.model.TypePaiement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(DetailPaiement.class)
public class DetailPaiement_ { 

    public static volatile SingularAttribute<DetailPaiement, Date> datePaiement;
    public static volatile SingularAttribute<DetailPaiement, Integer> iddetailpaiement;
    public static volatile SingularAttribute<DetailPaiement, AnneeScolaire> anneeScolaire;
    public static volatile SingularAttribute<DetailPaiement, TypePaiement> typePaiement;
    public static volatile ListAttribute<DetailPaiement, Paiement> paiementList;
    public static volatile SingularAttribute<DetailPaiement, Inscription> inscription;
    public static volatile SingularAttribute<DetailPaiement, Long> montantPaiement;

}