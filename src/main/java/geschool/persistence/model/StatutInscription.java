/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "statut_inscription", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "StatutInscription.findAll", query = "SELECT s FROM StatutInscription s"),
    @NamedQuery(name = "StatutInscription.findByIdstatutInscription", query = "SELECT s FROM StatutInscription s WHERE s.idstatutInscription = :idstatutInscription"),
    @NamedQuery(name = "StatutInscription.findByLibelle", query = "SELECT s FROM StatutInscription s WHERE s.libelle = :libelle")})
public class StatutInscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstatut_inscription", nullable = false)
    private Integer idstatutInscription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "libelle", nullable = false, length = 45)
    private String libelle;
    @OneToMany(mappedBy = "statut", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;

    public StatutInscription() {
    }

    public StatutInscription(Integer idstatutInscription) {
        this.idstatutInscription = idstatutInscription;
    }

    public StatutInscription(Integer idstatutInscription, String libelle) {
        this.idstatutInscription = idstatutInscription;
        this.libelle = libelle;
    }

    public Integer getIdstatutInscription() {
        return idstatutInscription;
    }

    public void setIdstatutInscription(Integer idstatutInscription) {
        this.idstatutInscription = idstatutInscription;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstatutInscription != null ? idstatutInscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatutInscription)) {
            return false;
        }
        StatutInscription other = (StatutInscription) object;
        if ((this.idstatutInscription == null && other.idstatutInscription != null) || (this.idstatutInscription != null && !this.idstatutInscription.equals(other.idstatutInscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.StatutInscription[ idstatutInscription=" + idstatutInscription + " ]";
    }
    
}
