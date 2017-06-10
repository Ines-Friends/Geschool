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
import javax.persistence.FetchType;
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
@Table(name = "type_paiement", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "TypePaiement.findAll", query = "SELECT t FROM TypePaiement t"),
    @NamedQuery(name = "TypePaiement.findByIdtypePaiement", query = "SELECT t FROM TypePaiement t WHERE t.idtypePaiement = :idtypePaiement"),
    @NamedQuery(name = "TypePaiement.findByLibelle", query = "SELECT t FROM TypePaiement t WHERE t.libelle = :libelle")})
public class TypePaiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtype_paiement", nullable = false)
    private Integer idtypePaiement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "libelle", nullable = false, length = 45)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typePaiement", fetch = FetchType.LAZY)
    private List<DetailPaiement> detailPaiementList;

    public TypePaiement() {
    }

    public TypePaiement(Integer idtypePaiement) {
        this.idtypePaiement = idtypePaiement;
    }

    public TypePaiement(Integer idtypePaiement, String libelle) {
        this.idtypePaiement = idtypePaiement;
        this.libelle = libelle;
    }

    public Integer getIdtypePaiement() {
        return idtypePaiement;
    }

    public void setIdtypePaiement(Integer idtypePaiement) {
        this.idtypePaiement = idtypePaiement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<DetailPaiement> getDetailPaiementList() {
        return detailPaiementList;
    }

    public void setDetailPaiementList(List<DetailPaiement> detailPaiementList) {
        this.detailPaiementList = detailPaiementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypePaiement != null ? idtypePaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypePaiement)) {
            return false;
        }
        TypePaiement other = (TypePaiement) object;
        if ((this.idtypePaiement == null && other.idtypePaiement != null) || (this.idtypePaiement != null && !this.idtypePaiement.equals(other.idtypePaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.TypePaiement[ idtypePaiement=" + idtypePaiement + " ]";
    }
    
}
