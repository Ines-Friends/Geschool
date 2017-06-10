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
@Table(name = "enseignement", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Enseignement.findAll", query = "SELECT e FROM Enseignement e"),
    @NamedQuery(name = "Enseignement.findByIdenseignement", query = "SELECT e FROM Enseignement e WHERE e.idenseignement = :idenseignement"),
    @NamedQuery(name = "Enseignement.findByLibelle", query = "SELECT e FROM Enseignement e WHERE e.libelle = :libelle")})
public class Enseignement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idenseignement", nullable = false)
    private Integer idenseignement;
    @Size(max = 45)
    @Column(name = "libelle", length = 45)
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enseignement", fetch = FetchType.LAZY)
    private List<Matiere> matiereList;

    public Enseignement() {
    }

    public Enseignement(Integer idenseignement) {
        this.idenseignement = idenseignement;
    }

    public Integer getIdenseignement() {
        return idenseignement;
    }

    public void setIdenseignement(Integer idenseignement) {
        this.idenseignement = idenseignement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenseignement != null ? idenseignement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignement)) {
            return false;
        }
        Enseignement other = (Enseignement) object;
        if ((this.idenseignement == null && other.idenseignement != null) || (this.idenseignement != null && !this.idenseignement.equals(other.idenseignement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Enseignement[ idenseignement=" + idenseignement + " ]";
    }
    
}
