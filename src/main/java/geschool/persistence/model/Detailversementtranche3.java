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
@Table(name = "detailversementtranche3", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Detailversementtranche3.findAll", query = "SELECT d FROM Detailversementtranche3 d"),
    @NamedQuery(name = "Detailversementtranche3.findByIdDetailVersementTranche3", query = "SELECT d FROM Detailversementtranche3 d WHERE d.idDetailVersementTranche3 = :idDetailVersementTranche3"),
    @NamedQuery(name = "Detailversementtranche3.findByMontantVersement", query = "SELECT d FROM Detailversementtranche3 d WHERE d.montantVersement = :montantVersement")})
public class Detailversementtranche3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDetailVersementTranche3", nullable = false)
    private Integer idDetailVersementTranche3;
    @Column(name = "montantVersement")
    private Integer montantVersement;
    @JoinColumn(name = "ModePaiement_idModePaiement", referencedColumnName = "idModePaiement", nullable = false)
    @ManyToOne(optional = false)
    private Modepaiement modePaiementidModePaiement;
    @JoinColumn(name = "Tranche3_idTranche3", referencedColumnName = "idTranche3", nullable = false)
    @ManyToOne(optional = false)
    private Tranche3 tranche3idTranche3;

    public Detailversementtranche3() {
    }

    public Detailversementtranche3(Integer idDetailVersementTranche3) {
        this.idDetailVersementTranche3 = idDetailVersementTranche3;
    }

    public Integer getIdDetailVersementTranche3() {
        return idDetailVersementTranche3;
    }

    public void setIdDetailVersementTranche3(Integer idDetailVersementTranche3) {
        this.idDetailVersementTranche3 = idDetailVersementTranche3;
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

    public Tranche3 getTranche3idTranche3() {
        return tranche3idTranche3;
    }

    public void setTranche3idTranche3(Tranche3 tranche3idTranche3) {
        this.tranche3idTranche3 = tranche3idTranche3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetailVersementTranche3 != null ? idDetailVersementTranche3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailversementtranche3)) {
            return false;
        }
        Detailversementtranche3 other = (Detailversementtranche3) object;
        if ((this.idDetailVersementTranche3 == null && other.idDetailVersementTranche3 != null) || (this.idDetailVersementTranche3 != null && !this.idDetailVersementTranche3.equals(other.idDetailVersementTranche3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Detailversementtranche3[ idDetailVersementTranche3=" + idDetailVersementTranche3 + " ]";
    }
    
}
