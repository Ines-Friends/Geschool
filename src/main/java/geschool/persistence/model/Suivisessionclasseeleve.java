/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "suivisessionclasseeleve", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Suivisessionclasseeleve.findAll", query = "SELECT s FROM Suivisessionclasseeleve s"),
    @NamedQuery(name = "Suivisessionclasseeleve.findByIdSuiviSessionClasseEleve", query = "SELECT s FROM Suivisessionclasseeleve s WHERE s.idSuiviSessionClasseEleve = :idSuiviSessionClasseEleve"),
    @NamedQuery(name = "Suivisessionclasseeleve.findByDateSuiviSessionClasseEleve", query = "SELECT s FROM Suivisessionclasseeleve s WHERE s.dateSuiviSessionClasseEleve = :dateSuiviSessionClasseEleve"),
    @NamedQuery(name = "Suivisessionclasseeleve.findByOrdreRangement", query = "SELECT s FROM Suivisessionclasseeleve s WHERE s.ordreRangement = :ordreRangement")})
public class Suivisessionclasseeleve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSuiviSessionClasseEleve", nullable = false)
    private Integer idSuiviSessionClasseEleve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateSuiviSessionClasseEleve", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateSuiviSessionClasseEleve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordreRangement", nullable = false)
    private int ordreRangement;
    @JoinColumn(name = "Eleve_idEleve", referencedColumnName = "idEleve", nullable = false)
    @ManyToOne(optional = false)
    private Eleve eleveidEleve;
    @JoinColumn(name = "SessionClasse_idSessionClasse", referencedColumnName = "idSessionClasse", nullable = false)
    @ManyToOne(optional = false)
    private Sessionclasse sessionClasseidSessionClasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suiviSessionClasseEleveEleveidEleve")
    private List<Inscription> inscriptionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suiviSessionClasseEleveidSuiviSessionClasseEleve")
    private List<Permission> permissionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suiviSessionClasseEleveidSuiviSessionClasseEleve")
    private List<Attendance> attendanceList;

    public Suivisessionclasseeleve() {
    }

    public Suivisessionclasseeleve(Integer idSuiviSessionClasseEleve) {
        this.idSuiviSessionClasseEleve = idSuiviSessionClasseEleve;
    }

    public Suivisessionclasseeleve(Integer idSuiviSessionClasseEleve, Date dateSuiviSessionClasseEleve, int ordreRangement) {
        this.idSuiviSessionClasseEleve = idSuiviSessionClasseEleve;
        this.dateSuiviSessionClasseEleve = dateSuiviSessionClasseEleve;
        this.ordreRangement = ordreRangement;
    }

    public Integer getIdSuiviSessionClasseEleve() {
        return idSuiviSessionClasseEleve;
    }

    public void setIdSuiviSessionClasseEleve(Integer idSuiviSessionClasseEleve) {
        this.idSuiviSessionClasseEleve = idSuiviSessionClasseEleve;
    }

    public Date getDateSuiviSessionClasseEleve() {
        return dateSuiviSessionClasseEleve;
    }

    public void setDateSuiviSessionClasseEleve(Date dateSuiviSessionClasseEleve) {
        this.dateSuiviSessionClasseEleve = dateSuiviSessionClasseEleve;
    }

    public int getOrdreRangement() {
        return ordreRangement;
    }

    public void setOrdreRangement(int ordreRangement) {
        this.ordreRangement = ordreRangement;
    }

    public Eleve getEleveidEleve() {
        return eleveidEleve;
    }

    public void setEleveidEleve(Eleve eleveidEleve) {
        this.eleveidEleve = eleveidEleve;
    }

    public Sessionclasse getSessionClasseidSessionClasse() {
        return sessionClasseidSessionClasse;
    }

    public void setSessionClasseidSessionClasse(Sessionclasse sessionClasseidSessionClasse) {
        this.sessionClasseidSessionClasse = sessionClasseidSessionClasse;
    }

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
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
        hash += (idSuiviSessionClasseEleve != null ? idSuiviSessionClasseEleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suivisessionclasseeleve)) {
            return false;
        }
        Suivisessionclasseeleve other = (Suivisessionclasseeleve) object;
        if ((this.idSuiviSessionClasseEleve == null && other.idSuiviSessionClasseEleve != null) || (this.idSuiviSessionClasseEleve != null && !this.idSuiviSessionClasseEleve.equals(other.idSuiviSessionClasseEleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Suivisessionclasseeleve[ idSuiviSessionClasseEleve=" + idSuiviSessionClasseEleve + " ]";
    }
    
}
