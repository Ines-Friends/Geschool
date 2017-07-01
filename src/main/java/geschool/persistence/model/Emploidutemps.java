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
import javax.persistence.Lob;
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
@Table(name = "emploidutemps", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Emploidutemps.findAll", query = "SELECT e FROM Emploidutemps e"),
    @NamedQuery(name = "Emploidutemps.findByIdEmploiDuTemps", query = "SELECT e FROM Emploidutemps e WHERE e.idEmploiDuTemps = :idEmploiDuTemps"),
    @NamedQuery(name = "Emploidutemps.findByDateEmploiDuTemps", query = "SELECT e FROM Emploidutemps e WHERE e.dateEmploiDuTemps = :dateEmploiDuTemps"),
    @NamedQuery(name = "Emploidutemps.findByHeureDebut", query = "SELECT e FROM Emploidutemps e WHERE e.heureDebut = :heureDebut"),
    @NamedQuery(name = "Emploidutemps.findByHeureFin", query = "SELECT e FROM Emploidutemps e WHERE e.heureFin = :heureFin")})
public class Emploidutemps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEmploiDuTemps", nullable = false)
    private Integer idEmploiDuTemps;
    @Column(name = "dateEmploiDuTemps")
    @Temporal(TemporalType.DATE)
    private Date dateEmploiDuTemps;
    @Column(name = "heureDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut;
    @Column(name = "heureFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin;
    @Lob
    @Size(max = 65535)
    @Column(name = "commentaire", length = 65535)
    private String commentaire;
    @JoinColumn(name = "SessionTrimestre_idSessionTrimestre", referencedColumnName = "idSessionTrimestre", nullable = false)
    @ManyToOne(optional = false)
    private Sessiontrimestre sessionTrimestreidSessionTrimestre;
    @JoinColumn(name = "SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere", referencedColumnName = "idSuiviSessionClasseMatiere", nullable = false)
    @ManyToOne(optional = false)
    private Suivisessionclassematiere suiviSessionClasseMatiereidSuiviSessionClasseMatiere;

    public Emploidutemps() {
    }

    public Emploidutemps(Integer idEmploiDuTemps) {
        this.idEmploiDuTemps = idEmploiDuTemps;
    }

    public Integer getIdEmploiDuTemps() {
        return idEmploiDuTemps;
    }

    public void setIdEmploiDuTemps(Integer idEmploiDuTemps) {
        this.idEmploiDuTemps = idEmploiDuTemps;
    }

    public Date getDateEmploiDuTemps() {
        return dateEmploiDuTemps;
    }

    public void setDateEmploiDuTemps(Date dateEmploiDuTemps) {
        this.dateEmploiDuTemps = dateEmploiDuTemps;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Sessiontrimestre getSessionTrimestreidSessionTrimestre() {
        return sessionTrimestreidSessionTrimestre;
    }

    public void setSessionTrimestreidSessionTrimestre(Sessiontrimestre sessionTrimestreidSessionTrimestre) {
        this.sessionTrimestreidSessionTrimestre = sessionTrimestreidSessionTrimestre;
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
        hash += (idEmploiDuTemps != null ? idEmploiDuTemps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emploidutemps)) {
            return false;
        }
        Emploidutemps other = (Emploidutemps) object;
        if ((this.idEmploiDuTemps == null && other.idEmploiDuTemps != null) || (this.idEmploiDuTemps != null && !this.idEmploiDuTemps.equals(other.idEmploiDuTemps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Emploidutemps[ idEmploiDuTemps=" + idEmploiDuTemps + " ]";
    }
    
}
