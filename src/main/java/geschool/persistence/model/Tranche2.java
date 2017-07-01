/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "tranche2", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tranche2.findAll", query = "SELECT t FROM Tranche2 t"),
    @NamedQuery(name = "Tranche2.findByIdTranche2", query = "SELECT t FROM Tranche2 t WHERE t.idTranche2 = :idTranche2"),
    @NamedQuery(name = "Tranche2.findByMontantTranche2", query = "SELECT t FROM Tranche2 t WHERE t.montantTranche2 = :montantTranche2"),
    @NamedQuery(name = "Tranche2.findByTotalVerseTranche2", query = "SELECT t FROM Tranche2 t WHERE t.totalVerseTranche2 = :totalVerseTranche2"),
    @NamedQuery(name = "Tranche2.findByTranche2Ok", query = "SELECT t FROM Tranche2 t WHERE t.tranche2Ok = :tranche2Ok")})
public class Tranche2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTranche2", nullable = false)
    private Integer idTranche2;
    @Column(name = "montantTranche2")
    private Integer montantTranche2;
    @Column(name = "TotalVerseTranche2")
    private Integer totalVerseTranche2;
    @Column(name = "Tranche2Ok")
    private Integer tranche2Ok;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tranche2idTranche2")
    private List<Detailversementtranche2> detailversementtranche2List;
    @JoinColumn(name = "Inscription_idInscription", referencedColumnName = "idInscription", nullable = false)
    @ManyToOne(optional = false)
    private Inscription inscriptionidInscription;

    public Tranche2() {
    }

    public Tranche2(Integer idTranche2) {
        this.idTranche2 = idTranche2;
    }

    public Integer getIdTranche2() {
        return idTranche2;
    }

    public void setIdTranche2(Integer idTranche2) {
        this.idTranche2 = idTranche2;
    }

    public Integer getMontantTranche2() {
        return montantTranche2;
    }

    public void setMontantTranche2(Integer montantTranche2) {
        this.montantTranche2 = montantTranche2;
    }

    public Integer getTotalVerseTranche2() {
        return totalVerseTranche2;
    }

    public void setTotalVerseTranche2(Integer totalVerseTranche2) {
        this.totalVerseTranche2 = totalVerseTranche2;
    }

    public Integer getTranche2Ok() {
        return tranche2Ok;
    }

    public void setTranche2Ok(Integer tranche2Ok) {
        this.tranche2Ok = tranche2Ok;
    }

    public List<Detailversementtranche2> getDetailversementtranche2List() {
        return detailversementtranche2List;
    }

    public void setDetailversementtranche2List(List<Detailversementtranche2> detailversementtranche2List) {
        this.detailversementtranche2List = detailversementtranche2List;
    }

    public Inscription getInscriptionidInscription() {
        return inscriptionidInscription;
    }

    public void setInscriptionidInscription(Inscription inscriptionidInscription) {
        this.inscriptionidInscription = inscriptionidInscription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTranche2 != null ? idTranche2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tranche2)) {
            return false;
        }
        Tranche2 other = (Tranche2) object;
        if ((this.idTranche2 == null && other.idTranche2 != null) || (this.idTranche2 != null && !this.idTranche2.equals(other.idTranche2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Tranche2[ idTranche2=" + idTranche2 + " ]";
    }
    
}
