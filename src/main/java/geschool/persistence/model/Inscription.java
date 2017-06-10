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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "inscription", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i"),
    @NamedQuery(name = "Inscription.findByIdinscription", query = "SELECT i FROM Inscription i WHERE i.inscriptionPK.idinscription = :idinscription"),
    @NamedQuery(name = "Inscription.findByFraisInscription", query = "SELECT i FROM Inscription i WHERE i.fraisInscription = :fraisInscription"),
    @NamedQuery(name = "Inscription.findByAutreFrais", query = "SELECT i FROM Inscription i WHERE i.autreFrais = :autreFrais"),
    @NamedQuery(name = "Inscription.findByDateInscrit", query = "SELECT i FROM Inscription i WHERE i.dateInscrit = :dateInscrit"),
    @NamedQuery(name = "Inscription.findByEleve", query = "SELECT i FROM Inscription i WHERE i.inscriptionPK.eleve = :eleve"),
    @NamedQuery(name = "Inscription.findByClasse", query = "SELECT i FROM Inscription i WHERE i.inscriptionPK.classe = :classe"),
    @NamedQuery(name = "Inscription.findByAnneeScolaire", query = "SELECT i FROM Inscription i WHERE i.inscriptionPK.anneeScolaire = :anneeScolaire")})
public class Inscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscriptionPK inscriptionPK;
    @Size(max = 45)
    @Column(name = "frais_inscription", length = 45)
    private String fraisInscription;
    @Size(max = 45)
    @Column(name = "autre_frais", length = 45)
    private String autreFrais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_inscrit", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateInscrit;
    @JoinColumn(name = "annee_scolaire", referencedColumnName = "idannee_scolaire", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AnneeScolaire anneeScolaire1;
    @JoinColumn(name = "classe", referencedColumnName = "idclasse", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Classe classe1;
    @JoinColumn(name = "eleve", referencedColumnName = "ideleve", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Eleve eleve1;
    @JoinColumn(name = "statut", referencedColumnName = "idstatut_inscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatutInscription statut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscription", fetch = FetchType.LAZY)
    private List<DetailPaiement> detailPaiementList;

    public Inscription() {
    }

    public Inscription(InscriptionPK inscriptionPK) {
        this.inscriptionPK = inscriptionPK;
    }

    public Inscription(InscriptionPK inscriptionPK, Date dateInscrit) {
        this.inscriptionPK = inscriptionPK;
        this.dateInscrit = dateInscrit;
    }

    public Inscription(int idinscription, int eleve, int classe, int anneeScolaire) {
        this.inscriptionPK = new InscriptionPK(idinscription, eleve, classe, anneeScolaire);
    }

    public InscriptionPK getInscriptionPK() {
        return inscriptionPK;
    }

    public void setInscriptionPK(InscriptionPK inscriptionPK) {
        this.inscriptionPK = inscriptionPK;
    }

    public String getFraisInscription() {
        return fraisInscription;
    }

    public void setFraisInscription(String fraisInscription) {
        this.fraisInscription = fraisInscription;
    }

    public String getAutreFrais() {
        return autreFrais;
    }

    public void setAutreFrais(String autreFrais) {
        this.autreFrais = autreFrais;
    }

    public Date getDateInscrit() {
        return dateInscrit;
    }

    public void setDateInscrit(Date dateInscrit) {
        this.dateInscrit = dateInscrit;
    }

    public AnneeScolaire getAnneeScolaire1() {
        return anneeScolaire1;
    }

    public void setAnneeScolaire1(AnneeScolaire anneeScolaire1) {
        this.anneeScolaire1 = anneeScolaire1;
    }

    public Classe getClasse1() {
        return classe1;
    }

    public void setClasse1(Classe classe1) {
        this.classe1 = classe1;
    }

    public Eleve getEleve1() {
        return eleve1;
    }

    public void setEleve1(Eleve eleve1) {
        this.eleve1 = eleve1;
    }

    public StatutInscription getStatut() {
        return statut;
    }

    public void setStatut(StatutInscription statut) {
        this.statut = statut;
    }

    public List<DetailPaiement> getDetailPaiementList() {
        return detailPaiementList;
    }

    public void setDetailPaiementList(List<DetailPaiement> detailPaiementList) {
        this.detailPaiementList = detailPaiementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscriptionPK != null ? inscriptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.inscriptionPK == null && other.inscriptionPK != null) || (this.inscriptionPK != null && !this.inscriptionPK.equals(other.inscriptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Inscription[ inscriptionPK=" + inscriptionPK + " ]";
    }
    
}
