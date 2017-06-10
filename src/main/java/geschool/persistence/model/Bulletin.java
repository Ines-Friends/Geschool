/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "bulletin", catalog = "gestschool", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"annee_scolaire"}),
    @UniqueConstraint(columnNames = {"eleve"})})
@NamedQueries({
    @NamedQuery(name = "Bulletin.findAll", query = "SELECT b FROM Bulletin b"),
    @NamedQuery(name = "Bulletin.findByIdbulletin", query = "SELECT b FROM Bulletin b WHERE b.bulletinPK.idbulletin = :idbulletin"),
    @NamedQuery(name = "Bulletin.findByAppreciation", query = "SELECT b FROM Bulletin b WHERE b.appreciation = :appreciation"),
    @NamedQuery(name = "Bulletin.findByNoteFinal", query = "SELECT b FROM Bulletin b WHERE b.noteFinal = :noteFinal"),
    @NamedQuery(name = "Bulletin.findByEleve", query = "SELECT b FROM Bulletin b WHERE b.bulletinPK.eleve = :eleve"),
    @NamedQuery(name = "Bulletin.findByAnneeScolaire", query = "SELECT b FROM Bulletin b WHERE b.bulletinPK.anneeScolaire = :anneeScolaire")})
public class Bulletin implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BulletinPK bulletinPK;
    @Size(max = 45)
    @Column(name = "appreciation", length = 45)
    private String appreciation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note_final", nullable = false)
    private float noteFinal;
    @JoinColumn(name = "annee_scolaire", referencedColumnName = "idannee_scolaire", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private AnneeScolaire anneeScolaire1;
    @JoinColumn(name = "eleve", referencedColumnName = "ideleve", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Eleve eleve1;

    public Bulletin() {
    }

    public Bulletin(BulletinPK bulletinPK) {
        this.bulletinPK = bulletinPK;
    }

    public Bulletin(BulletinPK bulletinPK, float noteFinal) {
        this.bulletinPK = bulletinPK;
        this.noteFinal = noteFinal;
    }

    public Bulletin(int idbulletin, int eleve, int anneeScolaire) {
        this.bulletinPK = new BulletinPK(idbulletin, eleve, anneeScolaire);
    }

    public BulletinPK getBulletinPK() {
        return bulletinPK;
    }

    public void setBulletinPK(BulletinPK bulletinPK) {
        this.bulletinPK = bulletinPK;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public float getNoteFinal() {
        return noteFinal;
    }

    public void setNoteFinal(float noteFinal) {
        this.noteFinal = noteFinal;
    }

    public AnneeScolaire getAnneeScolaire1() {
        return anneeScolaire1;
    }

    public void setAnneeScolaire1(AnneeScolaire anneeScolaire1) {
        this.anneeScolaire1 = anneeScolaire1;
    }

    public Eleve getEleve1() {
        return eleve1;
    }

    public void setEleve1(Eleve eleve1) {
        this.eleve1 = eleve1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bulletinPK != null ? bulletinPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bulletin)) {
            return false;
        }
        Bulletin other = (Bulletin) object;
        if ((this.bulletinPK == null && other.bulletinPK != null) || (this.bulletinPK != null && !this.bulletinPK.equals(other.bulletinPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Bulletin[ bulletinPK=" + bulletinPK + " ]";
    }
    
}
