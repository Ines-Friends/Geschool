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
public class InscriptionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idinscription", nullable = false)
    private int idinscription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eleve", nullable = false)
    private int eleve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classe", nullable = false)
    private int classe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annee_scolaire", nullable = false)
    private int anneeScolaire;

    public InscriptionPK() {
    }

    public InscriptionPK(int idinscription, int eleve, int classe, int anneeScolaire) {
        this.idinscription = idinscription;
        this.eleve = eleve;
        this.classe = classe;
        this.anneeScolaire = anneeScolaire;
    }

    public int getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(int idinscription) {
        this.idinscription = idinscription;
    }

    public int getEleve() {
        return eleve;
    }

    public void setEleve(int eleve) {
        this.eleve = eleve;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
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
        hash += (int) idinscription;
        hash += (int) eleve;
        hash += (int) classe;
        hash += (int) anneeScolaire;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscriptionPK)) {
            return false;
        }
        InscriptionPK other = (InscriptionPK) object;
        if (this.idinscription != other.idinscription) {
            return false;
        }
        if (this.eleve != other.eleve) {
            return false;
        }
        if (this.classe != other.classe) {
            return false;
        }
        if (this.anneeScolaire != other.anneeScolaire) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.InscriptionPK[ idinscription=" + idinscription + ", eleve=" + eleve + ", classe=" + classe + ", anneeScolaire=" + anneeScolaire + " ]";
    }
    
}
