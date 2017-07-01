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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "groupeutilisateur", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Groupeutilisateur.findAll", query = "SELECT g FROM Groupeutilisateur g"),
    @NamedQuery(name = "Groupeutilisateur.findByIdGroupeUtilisateur", query = "SELECT g FROM Groupeutilisateur g WHERE g.idGroupeUtilisateur = :idGroupeUtilisateur"),
    @NamedQuery(name = "Groupeutilisateur.findByLibelleGroupeUtilisateur", query = "SELECT g FROM Groupeutilisateur g WHERE g.libelleGroupeUtilisateur = :libelleGroupeUtilisateur")})
public class Groupeutilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGroupeUtilisateur", nullable = false)
    private Integer idGroupeUtilisateur;
    @Size(max = 255)
    @Column(name = "libelleGroupeUtilisateur", length = 255)
    private String libelleGroupeUtilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupeUtilisateuridGroupeUtilisateur")
    private List<Utilisateur> utilisateurList;

    public Groupeutilisateur() {
    }

    public Groupeutilisateur(Integer idGroupeUtilisateur) {
        this.idGroupeUtilisateur = idGroupeUtilisateur;
    }

    public Integer getIdGroupeUtilisateur() {
        return idGroupeUtilisateur;
    }

    public void setIdGroupeUtilisateur(Integer idGroupeUtilisateur) {
        this.idGroupeUtilisateur = idGroupeUtilisateur;
    }

    public String getLibelleGroupeUtilisateur() {
        return libelleGroupeUtilisateur;
    }

    public void setLibelleGroupeUtilisateur(String libelleGroupeUtilisateur) {
        this.libelleGroupeUtilisateur = libelleGroupeUtilisateur;
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroupeUtilisateur != null ? idGroupeUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupeutilisateur)) {
            return false;
        }
        Groupeutilisateur other = (Groupeutilisateur) object;
        if ((this.idGroupeUtilisateur == null && other.idGroupeUtilisateur != null) || (this.idGroupeUtilisateur != null && !this.idGroupeUtilisateur.equals(other.idGroupeUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Groupeutilisateur[ idGroupeUtilisateur=" + idGroupeUtilisateur + " ]";
    }
    
}
