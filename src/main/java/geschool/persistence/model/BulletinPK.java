/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Embeddable
public class BulletinPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbulletin", nullable = false)
    private int idbulletin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eleve", nullable = false)
    private int eleve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annee_scolaire", nullable = false)
    private int anneeScolaire;

    public BulletinPK() {
    }

    public BulletinPK(int idbulletin, int eleve, int anneeScolaire) {
        this.idbulletin = idbulletin;
        this.eleve = eleve;
        this.anneeScolaire = anneeScolaire;
    }

    public int getIdbulletin() {
        return idbulletin;
    }

    public void setIdbulletin(int idbulletin) {
        this.idbulletin = idbulletin;
    }

    public int getEleve() {
        return eleve;
    }

    public void setEleve(int eleve) {
        this.eleve = eleve;
    }

    public int getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(int anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idbulletin;
        hash += (int) eleve;
        hash += (int) anneeScolaire;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BulletinPK)) {
            return false;
        }
        BulletinPK other = (BulletinPK) object;
        if (this.idbulletin != other.idbulletin) {
            return false;
        }
        if (this.eleve != other.eleve) {
            return false;
        }
        if (this.anneeScolaire != other.anneeScolaire) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.BulletinPK[ idbulletin=" + idbulletin + ", eleve=" + eleve + ", anneeScolaire=" + anneeScolaire + " ]";
    }
    
}
