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
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "examen", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByIdExamen", query = "SELECT e FROM Examen e WHERE e.idExamen = :idExamen"),
    @NamedQuery(name = "Examen.findByLibelleExamen", query = "SELECT e FROM Examen e WHERE e.libelleExamen = :libelleExamen"),
    @NamedQuery(name = "Examen.findByDateExamen", query = "SELECT e FROM Examen e WHERE e.dateExamen = :dateExamen"),
    @NamedQuery(name = "Examen.findByHeureDebut", query = "SELECT e FROM Examen e WHERE e.heureDebut = :heureDebut"),
    @NamedQuery(name = "Examen.findByHeureFin", query = "SELECT e FROM Examen e WHERE e.heureFin = :heureFin")})
public class Examen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idExamen", nullable = false)
    private Integer idExamen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelleExamen", nullable = false, length = 255)
    private String libelleExamen;
    @Column(name = "dateExamen")
    @Temporal(TemporalType.DATE)
    private Date dateExamen;
    @Column(name = "heureDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut;
    @Column(name = "heureFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examenidExamen")
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "TypeExamen_idTypeExamen", referencedColumnName = "idTypeExamen", nullable = false)
    @ManyToOne(optional = false)
    private Typeexamen typeExamenidTypeExamen;
    @JoinColumn(name = "SessionTrimestre_idSessionTrimestre", referencedColumnName = "idSessionTrimestre", nullable = false)
    @ManyToOne(optional = false)
    private Sessiontrimestre sessionTrimestreidSessionTrimestre;
    @JoinColumn(name = "SuiviSessionClasseMatiere_idSuiviSessionClasseMatiere", referencedColumnName = "idSuiviSessionClasseMatiere", nullable = false)
    @ManyToOne(optional = false)
    private Suivisessionclassematiere suiviSessionClasseMatiereidSuiviSessionClasseMatiere;
    @JoinColumn(name = "SessionEnseignant_idSessionEnseignant", referencedColumnName = "idSessionEnseignant", nullable = false)
    @ManyToOne(optional = false)
    private Sessionenseignant sessionEnseignantidSessionEnseignant;

    public Examen() {
    }

    public Examen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public Examen(Integer idExamen, String libelleExamen) {
        this.idExamen = idExamen;
        this.libelleExamen = libelleExamen;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public String getLibelleExamen() {
        return libelleExamen;
    }

    public void setLibelleExamen(String libelleExamen) {
        this.libelleExamen = libelleExamen;
    }

    public Date getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(Date dateExamen) {
        this.dateExamen = dateExamen;
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

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Typeexamen getTypeExamenidTypeExamen() {
        return typeExamenidTypeExamen;
    }

    public void setTypeExamenidTypeExamen(Typeexamen typeExamenidTypeExamen) {
        this.typeExamenidTypeExamen = typeExamenidTypeExamen;
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

    public Sessionenseignant getSessionEnseignantidSessionEnseignant() {
        return sessionEnseignantidSessionEnseignant;
    }

    public void setSessionEnseignantidSessionEnseignant(Sessionenseignant sessionEnseignantidSessionEnseignant) {
        this.sessionEnseignantidSessionEnseignant = sessionEnseignantidSessionEnseignant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamen != null ? idExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idExamen == null && other.idExamen != null) || (this.idExamen != null && !this.idExamen.equals(other.idExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Examen[ idExamen=" + idExamen + " ]";
    }
    
}
