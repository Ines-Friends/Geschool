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
@Table(name = "typeexamen", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Typeexamen.findAll", query = "SELECT t FROM Typeexamen t"),
    @NamedQuery(name = "Typeexamen.findByIdTypeExamen", query = "SELECT t FROM Typeexamen t WHERE t.idTypeExamen = :idTypeExamen"),
    @NamedQuery(name = "Typeexamen.findByLibelleTypeExamen", query = "SELECT t FROM Typeexamen t WHERE t.libelleTypeExamen = :libelleTypeExamen"),
    @NamedQuery(name = "Typeexamen.findByActif", query = "SELECT t FROM Typeexamen t WHERE t.actif = :actif")})
public class Typeexamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTypeExamen", nullable = false)
    private Integer idTypeExamen;
    @Size(max = 255)
    @Column(name = "libelleTypeExamen", length = 255)
    private String libelleTypeExamen;
    @Column(name = "actif")
    private Integer actif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeExamenidTypeExamen")
    private List<Examen> examenList;

    public Typeexamen() {
    }

    public Typeexamen(Integer idTypeExamen) {
        this.idTypeExamen = idTypeExamen;
    }

    public Integer getIdTypeExamen() {
        return idTypeExamen;
    }

    public void setIdTypeExamen(Integer idTypeExamen) {
        this.idTypeExamen = idTypeExamen;
    }

    public String getLibelleTypeExamen() {
        return libelleTypeExamen;
    }

    public void setLibelleTypeExamen(String libelleTypeExamen) {
        this.libelleTypeExamen = libelleTypeExamen;
    }

    public Integer getActif() {
        return actif;
    }

    public void setActif(Integer actif) {
        this.actif = actif;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeExamen != null ? idTypeExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeexamen)) {
            return false;
        }
        Typeexamen other = (Typeexamen) object;
        if ((this.idTypeExamen == null && other.idTypeExamen != null) || (this.idTypeExamen != null && !this.idTypeExamen.equals(other.idTypeExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Typeexamen[ idTypeExamen=" + idTypeExamen + " ]";
    }
    
}
