/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "matiere", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findByIdmatiere", query = "SELECT m FROM Matiere m WHERE m.idmatiere = :idmatiere"),
    @NamedQuery(name = "Matiere.findByLibelle", query = "SELECT m FROM Matiere m WHERE m.libelle = :libelle"),
    @NamedQuery(name = "Matiere.findByCoefficient", query = "SELECT m FROM Matiere m WHERE m.coefficient = :coefficient")})
public class Matiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmatiere", nullable = false)
    private Integer idmatiere;
    @Size(max = 45)
    @Column(name = "libelle", length = 45)
    private String libelle;
    @Column(name = "coefficient")
    private Integer coefficient;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "matiere1", fetch = FetchType.LAZY)
    private Note note;
    @JoinColumn(name = "enseignement", referencedColumnName = "idenseignement", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Enseignement enseignement;

    public Matiere() {
    }

    public Matiere(Integer idmatiere) {
        this.idmatiere = idmatiere;
    }

    public Integer getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Integer idmatiere) {
        this.idmatiere = idmatiere;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Enseignement getEnseignement() {
        return enseignement;
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatiere != null ? idmatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.idmatiere == null && other.idmatiere != null) || (this.idmatiere != null && !this.idmatiere.equals(other.idmatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Matiere[ idmatiere=" + idmatiere + " ]";
    }
    
}
