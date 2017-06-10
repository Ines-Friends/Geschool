package geschool.persistence.model;

import geschool.persistence.model.Inscription;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-10T01:00:20")
@StaticMetamodel(Classe.class)
public class Classe_ { 

    public static volatile SingularAttribute<Classe, Integer> nbreEleveMax;
    public static volatile SingularAttribute<Classe, Integer> idclasse;
    public static volatile SingularAttribute<Classe, Date> dateCreation;
    public static volatile ListAttribute<Classe, Inscription> inscriptionList;
    public static volatile SingularAttribute<Classe, Integer> nbreEleveMin;
    public static volatile SingularAttribute<Classe, String> designation;

}