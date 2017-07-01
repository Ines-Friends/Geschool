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
@Table(name = "tranche1", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tranche1.findAll", query = "SELECT t FROM Tranche1 t"),
    @NamedQuery(name = "Tranche1.findByIdTranche1", query = "SELECT t FROM Tranche1 t WHERE t.idTranche1 = :idTranche1"),
    @NamedQuery(name = "Tranche1.findByMontantTranche1", query = "SELECT t FROM Tranche1 t WHERE t.montantTranche1 = :montantTranche1"),
    @NamedQuery(name = "Tranche1.findByTotalVerseTranche1", query = "SELECT t FROM Tranche1 t WHERE t.totalVerseTranche1 = :totalVerseTranche1"),
    @NamedQuery(name = "Tranche1.findByTranche1Ok", query = "SELECT t FROM Tranche1 t WHERE t.tranche1Ok = :tranche1Ok")})
public class Tranche1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTranche1", nullable = false)
    private Integer idTranche1;
    @Column(name = "montantTranche1")
    private Integer montantTranche1;
    @Column(name = "TotalVerseTranche1")
    private Integer totalVerseTranche1;
    @Column(name = "Tranche1Ok")
    private Integer tranche1Ok;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tranche1idTranche1")
    private List<Detailversementtranche1> detailversementtranche1List;
    @JoinColumn(name = "Inscription_idInscription", referencedColumnName = "idInscription", nullable = false)
    @ManyToOne(optional = false)
    private Inscription inscriptionidInscription;

    public Tranche1() {
    }

    public Tranche1(Integer idTranche1) {
        this.idTranche1 = idTranche1;
    }

    public Integer getIdTranche1() {
        return idTranche1;
    }

    public void setIdTranche1(Integer idTranche1) {
        this.idTranche1 = idTranche1;
    }

    public Integer getMontantTranche1() {
        return montantTranche1;
    }

    public void setMontantTranche1(Integer montantTranche1) {
        this.montantTranche1 = montantTranche1;
    }

    public Integer getTotalVerseTranche1() {
        return totalVerseTranche1;
    }

    public void setTotalVerseTranche1(Integer totalVerseTranche1) {
        this.totalVerseTranche1 = totalVerseTranche1;
    }

    public Integer getTranche1Ok() {
        return tranche1Ok;
    }

    public void setTranche1Ok(Integer tranche1Ok) {
        this.tranche1Ok = tranche1Ok;
    }

    public List<Detailversementtranche1> getDetailversementtranche1List() {
        return detailversementtranche1List;
    }

    public void setDetailversementtranche1List(List<Detailversementtranche1> detailversementtranche1List) {
        this.detailversementtranche1List = detailversementtranche1List;
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
        hash += (idTranche1 != null ? idTranche1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tranche1)) {
            return false;
        }
        Tranche1 other = (Tranche1) object;
        if ((this.idTranche1 == null && other.idTranche1 != null) || (this.idTranche1 != null && !this.idTranche1.equals(other.idTranche1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Tranche1[ idTranche1=" + idTranche1 + " ]";
    }
    
}
