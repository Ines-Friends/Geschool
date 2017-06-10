package geschool.persistence.model;

import geschool.persistence.model.Bulletin;
import geschool.persistence.model.DetailPaiement;
import geschool.persistence.model.Inscription;
import geschool.persistence.model.Note;
import geschool.persistence.model.Paiement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(AnneeScolaire.class)
public class AnneeScolaire_ { 

    public static volatile SingularAttribute<AnneeScolaire, Integer> idanneeScolaire;
    public static volatile SingularAttribute<AnneeScolaire, Date> debut;
    public static volatile SingularAttribute<AnneeScolaire, Note> note;
    public static volatile ListAttribute<AnneeScolaire, Inscription> inscriptionList;
    public static volatile ListAttribute<AnneeScolaire, Paiement> paiementList;
    public static volatile SingularAttribute<AnneeScolaire, Date> fin;
    public static volatile ListAttribute<AnneeScolaire, DetailPaiement> detailPaiementList;
    public static volatile SingularAttribute<AnneeScolaire, Bulletin> bulletin;

}