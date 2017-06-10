/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "tuteur_eleve", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "TuteurEleve.findAll", query = "SELECT t FROM TuteurEleve t"),
    @NamedQuery(name = "TuteurEleve.findByIdtuteurEleve", query = "SELECT t FROM TuteurEleve t WHERE t.idtuteurEleve = :idtuteurEleve"),
    @NamedQuery(name = "TuteurEleve.findByNomTuteur", query = "SELECT t FROM TuteurEleve t WHERE t.nomTuteur = :nomTuteur"),
    @NamedQuery(name = "TuteurEleve.findByPrenomTuteur", query = "SELECT t FROM TuteurEleve t WHERE t.prenomTuteur = :prenomTuteur"),
    @NamedQuery(name = "TuteurEleve.findByAdresse", query = "SELECT t FROM TuteurEleve t WHERE t.adresse = :adresse"),
    @NamedQuery(name = "TuteurEleve.findByDateCreation", query = "SELECT t FROM TuteurEleve t WHERE t.dateCreation = :dateCreation"),
    @NamedQuery(name = "TuteurEleve.findByDateModification", query = "SELECT t FROM TuteurEleve t WHERE t.dateModification = :dateModification")})
public class TuteurEleve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtuteur_eleve", nullable = false)
    private Integer idtuteurEleve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_tuteur", nullable = false, length = 45)
    private String nomTuteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prenom_tuteur", nullable = false, length = 45)
    private String prenomTuteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresse", nullable = false, length = 100)
    private String adresse;
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "date_modification")
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    @JoinColumn(name = "civilite", referencedColumnName = "idcivilite")
    @ManyToOne(fetch = FetchType.LAZY)
    private Civilite civilite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tuteurEleve", fetch = FetchType.LAZY)
    private List<Eleve> eleveList;

    public TuteurEleve() {
    }

    public TuteurEleve(Integer idtuteurEleve) {
        this.idtuteurEleve = idtuteurEleve;
    }

    public TuteurEleve(Integer idtuteurEleve, String nomTuteur, String prenomTuteur, String adresse) {
        this.idtuteurEleve = idtuteurEleve;
        this.nomTuteur = nomTuteur;
        this.prenomTuteur = prenomTuteur;
        this.adresse = adresse;
    }

    public Integer getIdtuteurEleve() {
        return idtuteurEleve;
    }

    public void setIdtuteurEleve(Integer idtuteurEleve) {
        this.idtuteurEleve = idtuteurEleve;
    }

    public String getNomTuteur() {
        return nomTuteur;
    }

    public void setNomTuteur(String nomTuteur) {
        this.nomTuteur = nomTuteur;
    }

    public String getPrenomTuteur() {
        return prenomTuteur;
    }

    public void setPrenomTuteur(String prenomTuteur) {
        this.prenomTuteur = prenomTuteur;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtuteurEleve != null ? idtuteurEleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TuteurEleve)) {
            return false;
        }
        TuteurEleve other = (TuteurEleve) object;
        if ((this.idtuteurEleve == null && other.idtuteurEleve != null) || (this.idtuteurEleve != null && !this.idtuteurEleve.equals(other.idtuteurEleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.TuteurEleve[ idtuteurEleve=" + idtuteurEleve + " ]";
    }
    
}
