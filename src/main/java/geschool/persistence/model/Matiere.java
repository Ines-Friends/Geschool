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
@Table(name = "matiere", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findByIdMatiere", query = "SELECT m FROM Matiere m WHERE m.idMatiere = :idMatiere"),
    @NamedQuery(name = "Matiere.findByLibelleMatiere", query = "SELECT m FROM Matiere m WHERE m.libelleMatiere = :libelleMatiere"),
    @NamedQuery(name = "Matiere.findBySigleMatiere", query = "SELECT m FROM Matiere m WHERE m.sigleMatiere = :sigleMatiere")})
public class Matiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMatiere", nullable = false)
    private Integer idMatiere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 260)
    @Column(name = "libelleMatiere", nullable = false, length = 260)
    private String libelleMatiere;
    @Size(max = 260)
    @Column(name = "sigleMatiere", length = 260)
    private String sigleMatiere;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matiereidMatiere")
    private List<Suivisessionclassematiere> suivisessionclassematiereList;

    public Matiere() {
    }

    public Matiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Matiere(Integer idMatiere, String libelleMatiere) {
        this.idMatiere = idMatiere;
        this.libelleMatiere = libelleMatiere;
    }

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getLibelleMatiere() {
        return libelleMatiere;
    }

    public void setLibelleMatiere(String libelleMatiere) {
        this.libelleMatiere = libelleMatiere;
    }

    public String getSigleMatiere() {
        return sigleMatiere;
    }

    public void setSigleMatiere(String sigleMatiere) {
        this.sigleMatiere = sigleMatiere;
    }

    public List<Suivisessionclassematiere> getSuivisessionclassematiereList() {
        return suivisessionclassematiereList;
    }

    public void setSuivisessionclassematiereList(List<Suivisessionclassematiere> suivisessionclassematiereList) {
        this.suivisessionclassematiereList = suivisessionclassematiereList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatiere != null ? idMatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.idMatiere == null && other.idMatiere != null) || (this.idMatiere != null && !this.idMatiere.equals(other.idMatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Matiere[ idMatiere=" + idMatiere + " ]";
    }
    
}
