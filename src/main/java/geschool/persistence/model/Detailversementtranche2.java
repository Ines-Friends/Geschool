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
@Table(name = "detailversementtranche2", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Detailversementtranche2.findAll", query = "SELECT d FROM Detailversementtranche2 d"),
    @NamedQuery(name = "Detailversementtranche2.findByIdDetailVersementTranche2", query = "SELECT d FROM Detailversementtranche2 d WHERE d.idDetailVersementTranche2 = :idDetailVersementTranche2"),
    @NamedQuery(name = "Detailversementtranche2.findByMontantVersement", query = "SELECT d FROM Detailversementtranche2 d WHERE d.montantVersement = :montantVersement")})
public class Detailversementtranche2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDetailVersementTranche2", nullable = false)
    private Integer idDetailVersementTranche2;
    @Column(name = "montantVersement")
    private Integer montantVersement;
    @JoinColumn(name = "ModePaiement_idModePaiement", referencedColumnName = "idModePaiement", nullable = false)
    @ManyToOne(optional = false)
    private Modepaiement modePaiementidModePaiement;
    @JoinColumn(name = "Tranche2_idTranche2", referencedColumnName = "idTranche2", nullable = false)
    @ManyToOne(optional = false)
    private Tranche2 tranche2idTranche2;

    public Detailversementtranche2() {
    }

    public Detailversementtranche2(Integer idDetailVersementTranche2) {
        this.idDetailVersementTranche2 = idDetailVersementTranche2;
    }

    public Integer getIdDetailVersementTranche2() {
        return idDetailVersementTranche2;
    }

    public void setIdDetailVersementTranche2(Integer idDetailVersementTranche2) {
        this.idDetailVersementTranche2 = idDetailVersementTranche2;
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

    public Tranche2 getTranche2idTranche2() {
        return tranche2idTranche2;
    }

    public void setTranche2idTranche2(Tranche2 tranche2idTranche2) {
        this.tranche2idTranche2 = tranche2idTranche2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetailVersementTranche2 != null ? idDetailVersementTranche2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailversementtranche2)) {
            return false;
        }
        Detailversementtranche2 other = (Detailversementtranche2) object;
        if ((this.idDetailVersementTranche2 == null && other.idDetailVersementTranche2 != null) || (this.idDetailVersementTranche2 != null && !this.idDetailVersementTranche2.equals(other.idDetailVersementTranche2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Detailversementtranche2[ idDetailVersementTranche2=" + idDetailVersementTranche2 + " ]";
    }
    
}
