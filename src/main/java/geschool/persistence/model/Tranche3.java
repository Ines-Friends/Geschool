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
@Table(name = "tranche3", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tranche3.findAll", query = "SELECT t FROM Tranche3 t"),
    @NamedQuery(name = "Tranche3.findByIdTranche3", query = "SELECT t FROM Tranche3 t WHERE t.idTranche3 = :idTranche3"),
    @NamedQuery(name = "Tranche3.findByMontantTranche3", query = "SELECT t FROM Tranche3 t WHERE t.montantTranche3 = :montantTranche3"),
    @NamedQuery(name = "Tranche3.findByTotalVerseTranche3", query = "SELECT t FROM Tranche3 t WHERE t.totalVerseTranche3 = :totalVerseTranche3"),
    @NamedQuery(name = "Tranche3.findByTranche3Ok", query = "SELECT t FROM Tranche3 t WHERE t.tranche3Ok = :tranche3Ok")})
public class Tranche3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTranche3", nullable = false)
    private Integer idTranche3;
    @Column(name = "montantTranche3")
    private Integer montantTranche3;
    @Column(name = "TotalVerseTranche3")
    private Integer totalVerseTranche3;
    @Column(name = "Tranche3Ok")
    private Integer tranche3Ok;
    @JoinColumn(name = "Inscription_idInscription", referencedColumnName = "idInscription", nullable = false)
    @ManyToOne(optional = false)
    private Inscription inscriptionidInscription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tranche3idTranche3")
    private List<Detailversementtranche3> detailversementtranche3List;

    public Tranche3() {
    }

    public Tranche3(Integer idTranche3) {
        this.idTranche3 = idTranche3;
    }

    public Integer getIdTranche3() {
        return idTranche3;
    }

    public void setIdTranche3(Integer idTranche3) {
        this.idTranche3 = idTranche3;
    }

    public Integer getMontantTranche3() {
        return montantTranche3;
    }

    public void setMontantTranche3(Integer montantTranche3) {
        this.montantTranche3 = montantTranche3;
    }

    public Integer getTotalVerseTranche3() {
        return totalVerseTranche3;
    }

    public void setTotalVerseTranche3(Integer totalVerseTranche3) {
        this.totalVerseTranche3 = totalVerseTranche3;
    }

    public Integer getTranche3Ok() {
        return tranche3Ok;
    }

    public void setTranche3Ok(Integer tranche3Ok) {
        this.tranche3Ok = tranche3Ok;
    }

    public Inscription getInscriptionidInscription() {
        return inscriptionidInscription;
    }

    public void setInscriptionidInscription(Inscription inscriptionidInscription) {
        this.inscriptionidInscription = inscriptionidInscription;
    }

    public List<Detailversementtranche3> getDetailversementtranche3List() {
        return detailversementtranche3List;
    }

    public void setDetailversementtranche3List(List<Detailversementtranche3> detailversementtranche3List) {
        this.detailversementtranche3List = detailversementtranche3List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTranche3 != null ? idTranche3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tranche3)) {
            return false;
        }
        Tranche3 other = (Tranche3) object;
        if ((this.idTranche3 == null && other.idTranche3 != null) || (this.idTranche3 != null && !this.idTranche3.equals(other.idTranche3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Tranche3[ idTranche3=" + idTranche3 + " ]";
    }
    
}
