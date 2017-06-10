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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "note", catalog = "gestschool", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"classe"}),
    @UniqueConstraint(columnNames = {"annee_scolaire"}),
    @UniqueConstraint(columnNames = {"eleve"}),
    @UniqueConstraint(columnNames = {"matiere"})})
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByIdnote", query = "SELECT n FROM Note n WHERE n.notePK.idnote = :idnote"),
    @NamedQuery(name = "Note.findByValeur", query = "SELECT n FROM Note n WHERE n.valeur = :valeur"),
    @NamedQuery(name = "Note.findByAppreciation", query = "SELECT n FROM Note n WHERE n.appreciation = :appreciation"),
    @NamedQuery(name = "Note.findByMatiere", query = "SELECT n FROM Note n WHERE n.notePK.matiere = :matiere"),
    @NamedQuery(name = "Note.findByClasse", query = "SELECT n FROM Note n WHERE n.classe = :classe"),
    @NamedQuery(name = "Note.findByEleve", query = "SELECT n FROM Note n WHERE n.notePK.eleve = :eleve"),
    @NamedQuery(name = "Note.findByDateCreation", query = "SELECT n FROM Note n WHERE n.dateCreation = :dateCreation"),
    @NamedQuery(name = "Note.findByDateModification", query = "SELECT n FROM Note n WHERE n.dateModification = :dateModification")})
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotePK notePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur", nullable = false)
    private float valeur;
    @Size(max = 45)
    @Column(name = "appreciation", length = 45)
    private String appreciation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classe", nullable = false)
    private int classe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modification", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    @JoinColumn(name = "annee_scolaire", referencedColumnName = "idannee_scolaire", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private AnneeScolaire anneeScolaire;
    @JoinColumn(name = "eleve", referencedColumnName = "ideleve", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Eleve eleve1;
    @JoinColumn(name = "matiere", referencedColumnName = "idmatiere", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Matiere matiere1;

    public Note() {
    }

    public Note(NotePK notePK) {
        this.notePK = notePK;
    }

    public Note(NotePK notePK, float valeur, int classe, Date dateCreation, Date dateModification) {
        this.notePK = notePK;
        this.valeur = valeur;
        this.classe = classe;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }

    public Note(int idnote, int matiere, int eleve) {
        this.notePK = new NotePK(idnote, matiere, eleve);
    }

    public NotePK getNotePK() {
        return notePK;
    }

    public void setNotePK(NotePK notePK) {
        this.notePK = notePK;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public Eleve getEleve1() {
        return eleve1;
    }

    public void setEleve1(Eleve eleve1) {
        this.eleve1 = eleve1;
    }

    public Matiere getMatiere1() {
        return matiere1;
    }

    public void setMatiere1(Matiere matiere1) {
        this.matiere1 = matiere1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notePK != null ? notePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.notePK == null && other.notePK != null) || (this.notePK != null && !this.notePK.equals(other.notePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Note[ notePK=" + notePK + " ]";
    }
    
}
