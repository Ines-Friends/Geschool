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
@Table(name = "statutattendance", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Statutattendance.findAll", query = "SELECT s FROM Statutattendance s"),
    @NamedQuery(name = "Statutattendance.findByIdStatutAttendance", query = "SELECT s FROM Statutattendance s WHERE s.idStatutAttendance = :idStatutAttendance"),
    @NamedQuery(name = "Statutattendance.findByLibelleStatutAttendance", query = "SELECT s FROM Statutattendance s WHERE s.libelleStatutAttendance = :libelleStatutAttendance"),
    @NamedQuery(name = "Statutattendance.findByActif", query = "SELECT s FROM Statutattendance s WHERE s.actif = :actif")})
public class Statutattendance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idStatutAttendance", nullable = false)
    private Integer idStatutAttendance;
    @Size(max = 255)
    @Column(name = "libelleStatutAttendance", length = 255)
    private String libelleStatutAttendance;
    @Column(name = "actif")
    private Integer actif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statutAttendanceidStatutAttendance")
    private List<Attendance> attendanceList;

    public Statutattendance() {
    }

    public Statutattendance(Integer idStatutAttendance) {
        this.idStatutAttendance = idStatutAttendance;
    }

    public Integer getIdStatutAttendance() {
        return idStatutAttendance;
    }

    public void setIdStatutAttendance(Integer idStatutAttendance) {
        this.idStatutAttendance = idStatutAttendance;
    }

    public String getLibelleStatutAttendance() {
        return libelleStatutAttendance;
    }

    public void setLibelleStatutAttendance(String libelleStatutAttendance) {
        this.libelleStatutAttendance = libelleStatutAttendance;
    }

    public Integer getActif() {
        return actif;
    }

    public void setActif(Integer actif) {
        this.actif = actif;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatutAttendance != null ? idStatutAttendance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statutattendance)) {
            return false;
        }
        Statutattendance other = (Statutattendance) object;
        if ((this.idStatutAttendance == null && other.idStatutAttendance != null) || (this.idStatutAttendance != null && !this.idStatutAttendance.equals(other.idStatutAttendance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Statutattendance[ idStatutAttendance=" + idStatutAttendance + " ]";
    }
    
}
