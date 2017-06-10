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

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "detail_paiement", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetailPaiement.findAll", query = "SELECT d FROM DetailPaiement d"),
    @NamedQuery(name = "DetailPaiement.findByIddetailpaiement", query = "SELECT d FROM DetailPaiement d WHERE d.iddetailpaiement = :iddetailpaiement"),
    @NamedQuery(name = "DetailPaiement.findByMontantPaiement", query = "SELECT d FROM DetailPaiement d WHERE d.montantPaiement = :montantPaiement"),
    @NamedQuery(name = "DetailPaiement.findByDatePaiement", query = "SELECT d FROM DetailPaiement d WHERE d.datePaiement = :datePaiement")})
public class DetailPaiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetailpaiement", nullable = false)
    private Integer iddetailpaiement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant_paiement", nullable = false)
    private long montantPaiement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_paiement", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePaiement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detailpaiement", fetch = FetchType.LAZY)
    private List<Paiement> paiementList;
    @JoinColumn(name = "annee_scolaire", referencedColumnName = "idannee_scolaire", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AnneeScolaire anneeScolaire;
    @JoinColumn(name = "inscription", referencedColumnName = "idinscription", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inscription inscription;
    @JoinColumn(name = "type_paiement", referencedColumnName = "idtype_paiement", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypePaiement typePaiement;

    public DetailPaiement() {
    }

    public DetailPaiement(Integer iddetailpaiement) {
        this.iddetailpaiement = iddetailpaiement;
    }

    public DetailPaiement(Integer iddetailpaiement, long montantPaiement, Date datePaiement) {
        this.iddetailpaiement = iddetailpaiement;
        this.montantPaiement = montantPaiement;
        this.datePaiement = datePaiement;
    }

    public Integer getIddetailpaiement() {
        return iddetailpaiement;
    }

    public void setIddetailpaiement(Integer iddetailpaiement) {
        this.iddetailpaiement = iddetailpaiement;
    }

    public long getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(long montantPaiement) {
        this.montantPaiement = montantPaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetailpaiement != null ? iddetailpaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailPaiement)) {
            return false;
        }
        DetailPaiement other = (DetailPaiement) object;
        if ((this.iddetailpaiement == null && other.iddetailpaiement != null) || (this.iddetailpaiement != null && !this.iddetailpaiement.equals(other.iddetailpaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.DetailPaiement[ iddetailpaiement=" + iddetailpaiement + " ]";
    }
    
}
