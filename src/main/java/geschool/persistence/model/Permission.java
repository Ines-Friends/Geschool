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
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "permission", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
    @NamedQuery(name = "Permission.findByIdPermission", query = "SELECT p FROM Permission p WHERE p.idPermission = :idPermission"),
    @NamedQuery(name = "Permission.findByMotif", query = "SELECT p FROM Permission p WHERE p.motif = :motif"),
    @NamedQuery(name = "Permission.findByDateDebut", query = "SELECT p FROM Permission p WHERE p.dateDebut = :dateDebut"),
    @NamedQuery(name = "Permission.findByDateFin", query = "SELECT p FROM Permission p WHERE p.dateFin = :dateFin"),
    @NamedQuery(name = "Permission.findByHeureDebut", query = "SELECT p FROM Permission p WHERE p.heureDebut = :heureDebut"),
    @NamedQuery(name = "Permission.findByHeureFin", query = "SELECT p FROM Permission p WHERE p.heureFin = :heureFin"),
    @NamedQuery(name = "Permission.findByNombreJours", query = "SELECT p FROM Permission p WHERE p.nombreJours = :nombreJours"),
    @NamedQuery(name = "Permission.findByNombreHeures", query = "SELECT p FROM Permission p WHERE p.nombreHeures = :nombreHeures")})
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPermission", nullable = false)
    private Integer idPermission;
    @Size(max = 520)
    @Column(name = "motif", length = 520)
    private String motif;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "heureDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut;
    @Column(name = "heureFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin;
    @Column(name = "nombreJours")
    private Integer nombreJours;
    @Column(name = "nombreHeures")
    private Integer nombreHeures;
    @JoinColumn(name = "SuiviSessionClasseEleve_idSuiviSessionClasseEleve", referencedColumnName = "idSuiviSessionClasseEleve", nullable = false)
    @ManyToOne(optional = false)
    private Suivisessionclasseeleve suiviSessionClasseEleveidSuiviSessionClasseEleve;

    public Permission() {
    }

    public Permission(Integer idPermission) {
        this.idPermission = idPermission;
    }

    public Integer getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Integer idPermission) {
        this.idPermission = idPermission;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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

    public Integer getNombreJours() {
        return nombreJours;
    }

    public void setNombreJours(Integer nombreJours) {
        this.nombreJours = nombreJours;
    }

    public Integer getNombreHeures() {
        return nombreHeures;
    }

    public void setNombreHeures(Integer nombreHeures) {
        this.nombreHeures = nombreHeures;
    }

    public Suivisessionclasseeleve getSuiviSessionClasseEleveidSuiviSessionClasseEleve() {
        return suiviSessionClasseEleveidSuiviSessionClasseEleve;
    }

    public void setSuiviSessionClasseEleveidSuiviSessionClasseEleve(Suivisessionclasseeleve suiviSessionClasseEleveidSuiviSessionClasseEleve) {
        this.suiviSessionClasseEleveidSuiviSessionClasseEleve = suiviSessionClasseEleveidSuiviSessionClasseEleve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermission != null ? idPermission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.idPermission == null && other.idPermission != null) || (this.idPermission != null && !this.idPermission.equals(other.idPermission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Permission[ idPermission=" + idPermission + " ]";
    }
    
}
