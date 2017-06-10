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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "annee_scolaire", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "AnneeScolaire.findAll", query = "SELECT a FROM AnneeScolaire a"),
    @NamedQuery(name = "AnneeScolaire.findByIdanneeScolaire", query = "SELECT a FROM AnneeScolaire a WHERE a.idanneeScolaire = :idanneeScolaire"),
    @NamedQuery(name = "AnneeScolaire.findByDebut", query = "SELECT a FROM AnneeScolaire a WHERE a.debut = :debut"),
    @NamedQuery(name = "AnneeScolaire.findByFin", query = "SELECT a FROM AnneeScolaire a WHERE a.fin = :fin")})
public class AnneeScolaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idannee_scolaire", nullable = false)
    private Integer idanneeScolaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "debut", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date debut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "anneeScolaire", fetch = FetchType.LAZY)
    private Note note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anneeScolaire", fetch = FetchType.LAZY)
    private List<Paiement> paiementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anneeScolaire1", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anneeScolaire", fetch = FetchType.LAZY)
    private List<DetailPaiement> detailPaiementList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "anneeScolaire1", fetch = FetchType.LAZY)
    private Bulletin bulletin;

    public AnneeScolaire() {
    }

    public AnneeScolaire(Integer idanneeScolaire) {
        this.idanneeScolaire = idanneeScolaire;
    }

    public AnneeScolaire(Integer idanneeScolaire, Date debut, Date fin) {
        this.idanneeScolaire = idanneeScolaire;
        this.debut = debut;
        this.fin = fin;
    }

    public Integer getIdanneeScolaire() {
        return idanneeScolaire;
    }

    public void setIdanneeScolaire(Integer idanneeScolaire) {
        this.idanneeScolaire = idanneeScolaire;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
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

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    public List<DetailPaiement> getDetailPaiementList() {
        return detailPaiementList;
    }

    public void setDetailPaiementList(List<DetailPaiement> detailPaiementList) {
        this.detailPaiementList = detailPaiementList;
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
        hash += (idanneeScolaire != null ? idanneeScolaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnneeScolaire)) {
            return false;
        }
        AnneeScolaire other = (AnneeScolaire) object;
        if ((this.idanneeScolaire == null && other.idanneeScolaire != null) || (this.idanneeScolaire != null && !this.idanneeScolaire.equals(other.idanneeScolaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.AnneeScolaire[ idanneeScolaire=" + idanneeScolaire + " ]";
    }
    
}
