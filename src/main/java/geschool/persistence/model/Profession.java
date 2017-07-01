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
@Table(name = "profession", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Profession.findAll", query = "SELECT p FROM Profession p"),
    @NamedQuery(name = "Profession.findByIdProfession", query = "SELECT p FROM Profession p WHERE p.idProfession = :idProfession"),
    @NamedQuery(name = "Profession.findByLibelleProfession", query = "SELECT p FROM Profession p WHERE p.libelleProfession = :libelleProfession")})
public class Profession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProfession", nullable = false)
    private Integer idProfession;
    @Size(max = 255)
    @Column(name = "libelleProfession", length = 255)
    private String libelleProfession;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professionidProfession")
    private List<Parent> parentList;

    public Profession() {
    }

    public Profession(Integer idProfession) {
        this.idProfession = idProfession;
    }

    public Integer getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(Integer idProfession) {
        this.idProfession = idProfession;
    }

    public String getLibelleProfession() {
        return libelleProfession;
    }

    public void setLibelleProfession(String libelleProfession) {
        this.libelleProfession = libelleProfession;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfession != null ? idProfession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profession)) {
            return false;
        }
        Profession other = (Profession) object;
        if ((this.idProfession == null && other.idProfession != null) || (this.idProfession != null && !this.idProfession.equals(other.idProfession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Profession[ idProfession=" + idProfession + " ]";
    }
    
}
