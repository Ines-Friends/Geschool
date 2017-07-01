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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "modepaiement", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Modepaiement.findAll", query = "SELECT m FROM Modepaiement m"),
    @NamedQuery(name = "Modepaiement.findByIdModePaiement", query = "SELECT m FROM Modepaiement m WHERE m.idModePaiement = :idModePaiement"),
    @NamedQuery(name = "Modepaiement.findByLibelleModePaiement", query = "SELECT m FROM Modepaiement m WHERE m.libelleModePaiement = :libelleModePaiement"),
    @NamedQuery(name = "Modepaiement.findByActif", query = "SELECT m FROM Modepaiement m WHERE m.actif = :actif")})
public class Modepaiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idModePaiement", nullable = false)
    private Integer idModePaiement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "libelleModePaiement", nullable = false, length = 45)
    private String libelleModePaiement;
    @Column(name = "actif")
    private Integer actif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modePaiementidModePaiement")
    private List<Detailversementtranche2> detailversementtranche2List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modePaiementidModePaiement")
    private List<Detailversementtranche1> detailversementtranche1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modePaiementidModePaiement")
    private List<Detailversementtranche3> detailversementtranche3List;

    public Modepaiement() {
    }

    public Modepaiement(Integer idModePaiement) {
        this.idModePaiement = idModePaiement;
    }

    public Modepaiement(Integer idModePaiement, String libelleModePaiement) {
        this.idModePaiement = idModePaiement;
        this.libelleModePaiement = libelleModePaiement;
    }

    public Integer getIdModePaiement() {
        return idModePaiement;
    }

    public void setIdModePaiement(Integer idModePaiement) {
        this.idModePaiement = idModePaiement;
    }

    public String getLibelleModePaiement() {
        return libelleModePaiement;
    }

    public void setLibelleModePaiement(String libelleModePaiement) {
        this.libelleModePaiement = libelleModePaiement;
    }

    public Integer getActif() {
        return actif;
    }

    public void setActif(Integer actif) {
        this.actif = actif;
    }

    public List<Detailversementtranche2> getDetailversementtranche2List() {
        return detailversementtranche2List;
    }

    public void setDetailversementtranche2List(List<Detailversementtranche2> detailversementtranche2List) {
        this.detailversementtranche2List = detailversementtranche2List;
    }

    public List<Detailversementtranche1> getDetailversementtranche1List() {
        return detailversementtranche1List;
    }

    public void setDetailversementtranche1List(List<Detailversementtranche1> detailversementtranche1List) {
        this.detailversementtranche1List = detailversementtranche1List;
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
        hash += (idModePaiement != null ? idModePaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modepaiement)) {
            return false;
        }
        Modepaiement other = (Modepaiement) object;
        if ((this.idModePaiement == null && other.idModePaiement != null) || (this.idModePaiement != null && !this.idModePaiement.equals(other.idModePaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Modepaiement[ idModePaiement=" + idModePaiement + " ]";
    }
    
}
