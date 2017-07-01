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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "suivisessionclassematiere", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Suivisessionclassematiere.findAll", query = "SELECT s FROM Suivisessionclassematiere s"),
    @NamedQuery(name = "Suivisessionclassematiere.findByIdSuiviSessionClasseMatiere", query = "SELECT s FROM Suivisessionclassematiere s WHERE s.idSuiviSessionClasseMatiere = :idSuiviSessionClasseMatiere")})
public class Suivisessionclassematiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSuiviSessionClasseMatiere", nullable = false)
    private Integer idSuiviSessionClasseMatiere;
    @JoinColumn(name = "Matiere_idMatiere", referencedColumnName = "idMatiere", nullable = false)
    @ManyToOne(optional = false)
    private Matiere matiereidMatiere;
    @JoinColumn(name = "SessionEnseignant_idSessionEnseignant", referencedColumnName = "idSessionEnseignant", nullable = false)
    @ManyToOne(optional = false)
    private Sessionenseignant sessionEnseignantidSessionEnseignant;
    @JoinColumn(name = "SessionClasse_idSessionClasse", referencedColumnName = "idSessionClasse", nullable = false)
    @ManyToOne(optional = false)
    private Sessionclasse sessionClasseidSessionClasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suiviSessionClasseMatiereidSuiviSessionClasseMatiere")
    private List<Examen> examenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suiviSessionClasseMatiereidSuiviSessionClasseMatiere")
    private List<Attendance> attendanceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suiviSessionClasseMatiereidSuiviSessionClasseMatiere")
    private List<Emploidutemps> emploidutempsList;

    public Suivisessionclassematiere() {
    }

    public Suivisessionclassematiere(Integer idSuiviSessionClasseMatiere) {
        this.idSuiviSessionClasseMatiere = idSuiviSessionClasseMatiere;
    }

    public Integer getIdSuiviSessionClasseMatiere() {
        return idSuiviSessionClasseMatiere;
    }

    public void setIdSuiviSessionClasseMatiere(Integer idSuiviSessionClasseMatiere) {
        this.idSuiviSessionClasseMatiere = idSuiviSessionClasseMatiere;
    }

    public Matiere getMatiereidMatiere() {
        return matiereidMatiere;
    }

    public void setMatiereidMatiere(Matiere matiereidMatiere) {
        this.matiereidMatiere = matiereidMatiere;
    }

    public Sessionenseignant getSessionEnseignantidSessionEnseignant() {
        return sessionEnseignantidSessionEnseignant;
    }

    public void setSessionEnseignantidSessionEnseignant(Sessionenseignant sessionEnseignantidSessionEnseignant) {
        this.sessionEnseignantidSessionEnseignant = sessionEnseignantidSessionEnseignant;
    }

    public Sessionclasse getSessionClasseidSessionClasse() {
        return sessionClasseidSessionClasse;
    }

    public void setSessionClasseidSessionClasse(Sessionclasse sessionClasseidSessionClasse) {
        this.sessionClasseidSessionClasse = sessionClasseidSessionClasse;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public List<Emploidutemps> getEmploidutempsList() {
        return emploidutempsList;
    }

    public void setEmploidutempsList(List<Emploidutemps> emploidutempsList) {
        this.emploidutempsList = emploidutempsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuiviSessionClasseMatiere != null ? idSuiviSessionClasseMatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suivisessionclassematiere)) {
            return false;
        }
        Suivisessionclassematiere other = (Suivisessionclassematiere) object;
        if ((this.idSuiviSessionClasseMatiere == null && other.idSuiviSessionClasseMatiere != null) || (this.idSuiviSessionClasseMatiere != null && !this.idSuiviSessionClasseMatiere.equals(other.idSuiviSessionClasseMatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Suivisessionclassematiere[ idSuiviSessionClasseMatiere=" + idSuiviSessionClasseMatiere + " ]";
    }
    
}
