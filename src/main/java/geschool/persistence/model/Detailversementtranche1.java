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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "detailversementtranche1", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Detailversementtranche1.findAll", query = "SELECT d FROM Detailversementtranche1 d"),
    @NamedQuery(name = "Detailversementtranche1.findByIdDetailVersementTranche1", query = "SELECT d FROM Detailversementtranche1 d WHERE d.idDetailVersementTranche1 = :idDetailVersementTranche1"),
    @NamedQuery(name = "Detailversementtranche1.findByMontantVersement", query = "SELECT d FROM Detailversementtranche1 d WHERE d.montantVersement = :montantVersement")})
public class Detailversementtranche1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDetailVersementTranche1", nullable = false)
    private Integer idDetailVersementTranche1;
    @Column(name = "montantVersement")
    private Integer montantVersement;
    @JoinColumn(name = "ModePaiement_idModePaiement", referencedColumnName = "idModePaiement", nullable = false)
    @ManyToOne(optional = false)
    private Modepaiement modePaiementidModePaiement;
    @JoinColumn(name = "Tranche1_idTranche1", referencedColumnName = "idTranche1", nullable = false)
    @ManyToOne(optional = false)
    private Tranche1 tranche1idTranche1;

    public Detailversementtranche1() {
    }

    public Detailversementtranche1(Integer idDetailVersementTranche1) {
        this.idDetailVersementTranche1 = idDetailVersementTranche1;
    }

    public Integer getIdDetailVersementTranche1() {
        return idDetailVersementTranche1;
    }

    public void setIdDetailVersementTranche1(Integer idDetailVersementTranche1) {
        this.idDetailVersementTranche1 = idDetailVersementTranche1;
    }

    public Integer getMontantVersement() {
        return montantVersement;
    }

    public void setMontantVersement(Integer montantVersement) {
        this.montantVersement = montantVersement;
    }

    public Modepaiement getModePaiementidModePaiement() {
        return modePaiementidModePaiement;
    }

    public void setModePaiementidModePaiement(Modepaiement modePaiementidModePaiement) {
        this.modePaiementidModePaiement = modePaiementidModePaiement;
    }

    public Tranche1 getTranche1idTranche1() {
        return tranche1idTranche1;
    }

    public void setTranche1idTranche1(Tranche1 tranche1idTranche1) {
        this.tranche1idTranche1 = tranche1idTranche1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetailVersementTranche1 != null ? idDetailVersementTranche1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailversementtranche1)) {
            return false;
        }
        Detailversementtranche1 other = (Detailversementtranche1) object;
        if ((this.idDetailVersementTranche1 == null && other.idDetailVersementTranche1 != null) || (this.idDetailVersementTranche1 != null && !this.idDetailVersementTranche1.equals(other.idDetailVersementTranche1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Detailversementtranche1[ idDetailVersementTranche1=" + idDetailVersementTranche1 + " ]";
    }
    
}
