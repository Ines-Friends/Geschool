package geschool.persistence.model;

import geschool.persistence.model.DetailPaiement;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(TypePaiement.class)
public class TypePaiement_ { 

    public static volatile SingularAttribute<TypePaiement, String> libelle;
    public static volatile SingularAttribute<TypePaiement, Integer> idtypePaiement;
    public static volatile ListAttribute<TypePaiement, DetailPaiement> detailPaiementList;

}