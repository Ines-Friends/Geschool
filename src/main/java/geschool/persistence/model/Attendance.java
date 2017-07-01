/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "attendance", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a"),
    @NamedQuery(name = "Attendance.findByIdAttendance", query = "SELECT a FROM Attendance a WHERE a.idAttendance = :idAttendance"),
    @NamedQuery(name = "Attendance.findByDateAbsenceJournee", query = "SELECT a FROM Attendance a WHERE a.dateAbsenceJournee = :dateAbsenceJournee"),
    @NamedQuery(name = "Attendance.findByHeureDebut", query = "SELECT a FROM Attendance a WHERE a.heureDebut = :heureDebut"),
    @NamedQuery(name = "Attendance.findByHeureFin", query = "SELECT a FROM Attendance a WHERE a.heureFin = :heureFin"),
    @NamedQuery(name = "Attendance.findByPeriode", query = "SELECT a FROM Attendance a WHERE a.periode = :periode")})
public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAttendance", nullable = false)
    private Integer idAttendance;
    @Column(name = "dateAbsenceJournee")
    @Temporal(TemporalType.DATE)
    private Date dateAbsenceJournee;
    @Column(name = "heureDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut;
    @Column(name = "heureFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin;
    @Column(name = "periode")
    private Integer periode;
    @JoinColumn(name = "StatutAttendance_idStatutAttendance", referencedColumnName = "idStatutAttendance", nullable = false)
    @ManyToOne(optional = false)
    private Statutattendance statutAttendanceidStatutAttendance;
    @JoinColumn(name = "SuiviSessionClasseEleve_idSuiviSessionClasseEleve", referencedColumnName = "idSuiviSessionClasseEleve", nullable = false)
    @ManyToOne(optional = false)
    private Suivisessionclasseeleve suiviSessionClasseEleveidSuiviSessionClasseEleve;
    @JoinColumn(name = "SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere", referencedColumnName = "idSuiviSessionClasseMatiere", nullable = false)
    @ManyToOne(optional = false)
    private Suivisessionclassematiere suiviSessionClasseMatiereidSuiviSessionClasseMatiere;

    public Attendance() {
    }

    public Attendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
    }

    public Integer getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
    }

    public Date getDateAbsenceJournee() {
        return dateAbsenceJournee;
    }

    public void setDateAbsenceJournee(Date dateAbsenceJournee) {
        this.dateAbsenceJournee = dateAbsenceJournee;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public Integer getPeriode() {
        return periode;
    }

    public void setPeriode(Integer periode) {
        this.periode = periode;
    }

    public Statutattendance getStatutAttendanceidStatutAttendance() {
        return statutAttendanceidStatutAttendance;
    }

    public void setStatutAttendanceidStatutAttendance(Statutattendance statutAttendanceidStatutAttendance) {
        this.statutAttendanceidStatutAttendance = statutAttendanceidStatutAttendance;
    }

    public Suivisessionclasseeleve getSuiviSessionClasseEleveidSuiviSessionClasseEleve() {
        return suiviSessionClasseEleveidSuiviSessionClasseEleve;
    }

    public void setSuiviSessionClasseEleveidSuiviSessionClasseEleve(Suivisessionclasseeleve suiviSessionClasseEleveidSuiviSessionClasseEleve) {
        this.suiviSessionClasseEleveidSuiviSessionClasseEleve = suiviSessionClasseEleveidSuiviSessionClasseEleve;
    }

    public Suivisessionclassematiere getSuiviSessionClasseMatiereidSuiviSessionClasseMatiere() {
        return suiviSessionClasseMatiereidSuiviSessionClasseMatiere;
    }

    public void setSuiviSessionClasseMatiereidSuiviSessionClasseMatiere(Suivisessionclassematiere suiviSessionClasseMatiereidSuiviSessionClasseMatiere) {
        this.suiviSessionClasseMatiereidSuiviSessionClasseMatiere = suiviSessionClasseMatiereidSuiviSessionClasseMatiere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAttendance != null ? idAttendance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.idAttendance == null && other.idAttendance != null) || (this.idAttendance != null && !this.idAttendance.equals(other.idAttendance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Attendance[ idAttendance=" + idAttendance + " ]";
    }
    
}
