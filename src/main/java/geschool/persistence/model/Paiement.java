/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "paiement", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Paiement.findAll", query = "SELECT p FROM Paiement p"),
    @NamedQuery(name = "Paiement.findByIdpaiement", query = "SELECT p FROM Paiement p WHERE p.idpaiement = :idpaiement")})
public class Paiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaiement", nullable = false)
    private Integer idpaiement;
    @JoinColumn(name = "annee_scolaire", referencedColumnName = "idannee_scolaire", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AnneeScolaire anneeScolaire;
    @JoinColumn(name = "detailpaiement", referencedColumnName = "iddetailpaiement", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DetailPaiement detailpaiement;
    @JoinColumn(name = "eleve", referencedColumnName = "ideleve", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Eleve eleve;

    public Paiement() {
    }

    public Paiement(Integer idpaiement) {
        this.idpaiement = idpaiement;
    }

    public Integer getIdpaiement() {
        return idpaiement;
    }

    public void setIdpaiement(Integer idpaiement) {
        this.idpaiement = idpaiement;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public DetailPaiement getDetailpaiement() {
        return detailpaiement;
    }

    public void setDetailpaiement(DetailPaiement detailpaiement) {
        this.detailpaiement = detailpaiement;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaiement != null ? idpaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.idpaiement == null && other.idpaiement != null) || (this.idpaiement != null && !this.idpaiement.equals(other.idpaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Paiement[ idpaiement=" + idpaiement + " ]";
    }
    
}
