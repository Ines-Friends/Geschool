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
public class NotePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idnote", nullable = false)
    private int idnote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matiere", nullable = false)
    private int matiere;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eleve", nullable = false)
    private int eleve;

    public NotePK() {
    }

    public NotePK(int idnote, int matiere, int eleve) {
        this.idnote = idnote;
        this.matiere = matiere;
        this.eleve = eleve;
    }

    public int getIdnote() {
        return idnote;
    }

    public void setIdnote(int idnote) {
        this.idnote = idnote;
    }

    public int getMatiere() {
        return matiere;
    }

    public void setMatiere(int matiere) {
        this.matiere = matiere;
    }

    public int getEleve() {
        return eleve;
    }

    public void setEleve(int eleve) {
        this.eleve = eleve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idnote;
        hash += (int) matiere;
        hash += (int) eleve;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotePK)) {
            return false;
        }
        NotePK other = (NotePK) object;
        if (this.idnote != other.idnote) {
            return false;
        }
        if (this.matiere != other.matiere) {
            return false;
        }
        if (this.eleve != other.eleve) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.NotePK[ idnote=" + idnote + ", matiere=" + matiere + ", eleve=" + eleve + " ]";
    }
    
}
