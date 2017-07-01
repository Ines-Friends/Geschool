/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "evaluation", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e"),
    @NamedQuery(name = "Evaluation.findByIdEvaluation", query = "SELECT e FROM Evaluation e WHERE e.idEvaluation = :idEvaluation"),
    @NamedQuery(name = "Evaluation.findByLibelleEvaluation", query = "SELECT e FROM Evaluation e WHERE e.libelleEvaluation = :libelleEvaluation"),
    @NamedQuery(name = "Evaluation.findByNote", query = "SELECT e FROM Evaluation e WHERE e.note = :note"),
    @NamedQuery(name = "Evaluation.findByCoefficientEvaluation", query = "SELECT e FROM Evaluation e WHERE e.coefficientEvaluation = :coefficientEvaluation"),
    @NamedQuery(name = "Evaluation.findByNoteCoefficiee", query = "SELECT e FROM Evaluation e WHERE e.noteCoefficiee = :noteCoefficiee"),
    @NamedQuery(name = "Evaluation.findByPlafondCoefficiant", query = "SELECT e FROM Evaluation e WHERE e.plafondCoefficiant = :plafondCoefficiant")})
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEvaluation", nullable = false)
    private Integer idEvaluation;
    @Size(max = 255)
    @Column(name = "libelleEvaluation", length = 255)
    private String libelleEvaluation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note", nullable = false)
    private int note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coefficientEvaluation", nullable = false)
    private int coefficientEvaluation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noteCoefficiee", nullable = false)
    private int noteCoefficiee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plafondCoefficiant", nullable = false)
    private int plafondCoefficiant;
    @JoinColumn(name = "Examen_idExamen", referencedColumnName = "idExamen", nullable = false)
    @ManyToOne(optional = false)
    private Examen examenidExamen;

    public Evaluation() {
    }

    public Evaluation(Integer idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Evaluation(Integer idEvaluation, int note, int coefficientEvaluation, int noteCoefficiee, int plafondCoefficiant) {
        this.idEvaluation = idEvaluation;
        this.note = note;
        this.coefficientEvaluation = coefficientEvaluation;
        this.noteCoefficiee = noteCoefficiee;
        this.plafondCoefficiant = plafondCoefficiant;
    }

    public Integer getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Integer idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public String getLibelleEvaluation() {
        return libelleEvaluation;
    }

    public void setLibelleEvaluation(String libelleEvaluation) {
        this.libelleEvaluation = libelleEvaluation;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getCoefficientEvaluation() {
        return coefficientEvaluation;
    }

    public void setCoefficientEvaluation(int coefficientEvaluation) {
        this.coefficientEvaluation = coefficientEvaluation;
    }

    public int getNoteCoefficiee() {
        return noteCoefficiee;
    }

    public void setNoteCoefficiee(int noteCoefficiee) {
        this.noteCoefficiee = noteCoefficiee;
    }

    public int getPlafondCoefficiant() {
        return plafondCoefficiant;
    }

    public void setPlafondCoefficiant(int plafondCoefficiant) {
        this.plafondCoefficiant = plafondCoefficiant;
    }

    public Examen getExamenidExamen() {
        return examenidExamen;
    }

    public void setExamenidExamen(Examen examenidExamen) {
        this.examenidExamen = examenidExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluation != null ? idEvaluation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.idEvaluation == null && other.idEvaluation != null) || (this.idEvaluation != null && !this.idEvaluation.equals(other.idEvaluation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Evaluation[ idEvaluation=" + idEvaluation + " ]";
    }
    
}
