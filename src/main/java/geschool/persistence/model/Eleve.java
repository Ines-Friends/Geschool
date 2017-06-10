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
import javax.persistence.OneToOne;
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
@Table(name = "eleve", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e"),
    @NamedQuery(name = "Eleve.findByIdeleve", query = "SELECT e FROM Eleve e WHERE e.ideleve = :ideleve"),
    @NamedQuery(name = "Eleve.findByNomEleve", query = "SELECT e FROM Eleve e WHERE e.nomEleve = :nomEleve"),
    @NamedQuery(name = "Eleve.findByPrenomEleve", query = "SELECT e FROM Eleve e WHERE e.prenomEleve = :prenomEleve"),
    @NamedQuery(name = "Eleve.findByAdresse", query = "SELECT e FROM Eleve e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Eleve.findByDateNaissance", query = "SELECT e FROM Eleve e WHERE e.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Eleve.findByDateCreation", query = "SELECT e FROM Eleve e WHERE e.dateCreation = :dateCreation"),
    @NamedQuery(name = "Eleve.findByDateModification", query = "SELECT e FROM Eleve e WHERE e.dateModification = :dateModification")})
public class Eleve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideleve", nullable = false)
    private Integer ideleve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_eleve", nullable = false, length = 45)
    private String nomEleve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prenom_eleve", nullable = false, length = 45)
    private String prenomEleve;
    @Size(max = 100)
    @Column(name = "adresse", length = 100)
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_naissance", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "date_modification")
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "eleve1", fetch = FetchType.LAZY)
    private Note note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleve", fetch = FetchType.LAZY)
    private List<Paiement> paiementList;
    @JoinColumn(name = "statut", referencedColumnName = "idstatut_eleve")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatutEleve statut;
    @JoinColumn(name = "tuteur_eleve", referencedColumnName = "idtuteur_eleve", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TuteurEleve tuteurEleve;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleve1", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "eleve1", fetch = FetchType.LAZY)
    private Bulletin bulletin;

    public Eleve() {
    }

    public Eleve(Integer ideleve) {
        this.ideleve = ideleve;
    }

    public Eleve(Integer ideleve, String nomEleve, String prenomEleve, Date dateNaissance, Date dateCreation) {
        this.ideleve = ideleve;
        this.nomEleve = nomEleve;
        this.prenomEleve = prenomEleve;
        this.dateNaissance = dateNaissance;
        this.dateCreation = dateCreation;
    }

    public Integer getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(Integer ideleve) {
        this.ideleve = ideleve;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    public StatutEleve getStatut() {
        return statut;
    }

    public void setStatut(StatutEleve statut) {
        this.statut = statut;
    }

    public TuteurEleve getTuteurEleve() {
        return tuteurEleve;
    }

    public void setTuteurEleve(TuteurEleve tuteurEleve) {
        this.tuteurEleve = tuteurEleve;
    }

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideleve != null ? ideleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.ideleve == null && other.ideleve != null) || (this.ideleve != null && !this.ideleve.equals(other.ideleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Eleve[ ideleve=" + ideleve + " ]";
    }
    
}
