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
@Table(name = "trimestre", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t"),
    @NamedQuery(name = "Trimestre.findByIdTrimestre", query = "SELECT t FROM Trimestre t WHERE t.idTrimestre = :idTrimestre"),
    @NamedQuery(name = "Trimestre.findByLibelleTrimestre", query = "SELECT t FROM Trimestre t WHERE t.libelleTrimestre = :libelleTrimestre"),
    @NamedQuery(name = "Trimestre.findBySigleTrimestre", query = "SELECT t FROM Trimestre t WHERE t.sigleTrimestre = :sigleTrimestre")})
public class Trimestre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTrimestre", nullable = false)
    private Integer idTrimestre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 260)
    @Column(name = "libelleTrimestre", nullable = false, length = 260)
    private String libelleTrimestre;
    @Size(max = 45)
    @Column(name = "sigleTrimestre", length = 45)
    private String sigleTrimestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimestreidTrimestre")
    private List<Sessiontrimestre> sessiontrimestreList;

    public Trimestre() {
    }

    public Trimestre(Integer idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public Trimestre(Integer idTrimestre, String libelleTrimestre) {
        this.idTrimestre = idTrimestre;
        this.libelleTrimestre = libelleTrimestre;
    }

    public Integer getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Integer idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public String getLibelleTrimestre() {
        return libelleTrimestre;
    }

    public void setLibelleTrimestre(String libelleTrimestre) {
        this.libelleTrimestre = libelleTrimestre;
    }

    public String getSigleTrimestre() {
        return sigleTrimestre;
    }

    public void setSigleTrimestre(String sigleTrimestre) {
        this.sigleTrimestre = sigleTrimestre;
    }

    public List<Sessiontrimestre> getSessiontrimestreList() {
        return sessiontrimestreList;
    }

    public void setSessiontrimestreList(List<Sessiontrimestre> sessiontrimestreList) {
        this.sessiontrimestreList = sessiontrimestreList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrimestre != null ? idTrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.idTrimestre == null && other.idTrimestre != null) || (this.idTrimestre != null && !this.idTrimestre.equals(other.idTrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Trimestre[ idTrimestre=" + idTrimestre + " ]";
    }
    
}
