package geschool.persistence.model;

import geschool.persistence.model.AnneeScolaire;
import geschool.persistence.model.Classe;
import geschool.persistence.model.DetailPaiement;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.InscriptionPK;
import geschool.persistence.model.StatutInscription;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(Inscription.class)
public class Inscription_ { 

    public static volatile SingularAttribute<Inscription, InscriptionPK> inscriptionPK;
    public static volatile SingularAttribute<Inscription, AnneeScolaire> anneeScolaire1;
    public static volatile SingularAttribute<Inscription, Classe> classe1;
    public static volatile SingularAttribute<Inscription, String> fraisInscription;
    public static volatile SingularAttribute<Inscription, Date> dateInscrit;
    public static volatile ListAttribute<Inscription, DetailPaiement> detailPaiementList;
    public static volatile SingularAttribute<Inscription, String> autreFrais;
    public static volatile SingularAttribute<Inscription, StatutInscription> statut;
    public static volatile SingularAttribute<Inscription, Eleve> eleve1;

}