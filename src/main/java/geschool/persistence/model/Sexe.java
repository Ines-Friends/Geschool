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
@Table(name = "sexe", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sexe.findAll", query = "SELECT s FROM Sexe s"),
    @NamedQuery(name = "Sexe.findByIdSexe", query = "SELECT s FROM Sexe s WHERE s.idSexe = :idSexe"),
    @NamedQuery(name = "Sexe.findByLibelleSexe", query = "SELECT s FROM Sexe s WHERE s.libelleSexe = :libelleSexe")})
public class Sexe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSexe", nullable = false)
    private Integer idSexe;
    @Size(max = 45)
    @Column(name = "libelleSexe", length = 45)
    private String libelleSexe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexeidSexe")
    private List<Parent> parentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexeidSexe")
    private List<Eleve> eleveList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexeidSexe")
    private List<Enseignant> enseignantList;

    public Sexe() {
    }

    public Sexe(Integer idSexe) {
        this.idSexe = idSexe;
    }

    public Integer getIdSexe() {
        return idSexe;
    }

    public void setIdSexe(Integer idSexe) {
        this.idSexe = idSexe;
    }

    public String getLibelleSexe() {
        return libelleSexe;
    }

    public void setLibelleSexe(String libelleSexe) {
        this.libelleSexe = libelleSexe;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSexe != null ? idSexe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexe)) {
            return false;
        }
        Sexe other = (Sexe) object;
        if ((this.idSexe == null && other.idSexe != null) || (this.idSexe != null && !this.idSexe.equals(other.idSexe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Sexe[ idSexe=" + idSexe + " ]";
    }
    
}
