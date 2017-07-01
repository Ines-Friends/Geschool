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

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "suivistatuteleve", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Suivistatuteleve.findAll", query = "SELECT s FROM Suivistatuteleve s"),
    @NamedQuery(name = "Suivistatuteleve.findByIdSuiviStatutEleve", query = "SELECT s FROM Suivistatuteleve s WHERE s.idSuiviStatutEleve = :idSuiviStatutEleve")})
public class Suivistatuteleve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSuiviStatutEleve", nullable = false)
    private Integer idSuiviStatutEleve;
    @JoinColumn(name = "StatutEleve_idStatutEleve", referencedColumnName = "idStatutEleve", nullable = false)
    @ManyToOne(optional = false)
    private Statuteleve statutEleveidStatutEleve;
    @JoinColumn(name = "Utilisateur_idUtilisateur", referencedColumnName = "idUtilisateur", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateuridUtilisateur;

    public Suivistatuteleve() {
    }

    public Suivistatuteleve(Integer idSuiviStatutEleve) {
        this.idSuiviStatutEleve = idSuiviStatutEleve;
    }

    public Integer getIdSuiviStatutEleve() {
        return idSuiviStatutEleve;
    }

    public void setIdSuiviStatutEleve(Integer idSuiviStatutEleve) {
        this.idSuiviStatutEleve = idSuiviStatutEleve;
    }

    public Statuteleve getStatutEleveidStatutEleve() {
        return statutEleveidStatutEleve;
    }

    public void setStatutEleveidStatutEleve(Statuteleve statutEleveidStatutEleve) {
        this.statutEleveidStatutEleve = statutEleveidStatutEleve;
    }

    public Utilisateur getUtilisateuridUtilisateur() {
        return utilisateuridUtilisateur;
    }

    public void setUtilisateuridUtilisateur(Utilisateur utilisateuridUtilisateur) {
        this.utilisateuridUtilisateur = utilisateuridUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuiviStatutEleve != null ? idSuiviStatutEleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suivistatuteleve)) {
            return false;
        }
        Suivistatuteleve other = (Suivistatuteleve) object;
        if ((this.idSuiviStatutEleve == null && other.idSuiviStatutEleve != null) || (this.idSuiviStatutEleve != null && !this.idSuiviStatutEleve.equals(other.idSuiviStatutEleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Suivistatuteleve[ idSuiviStatutEleve=" + idSuiviStatutEleve + " ]";
    }
    
}
