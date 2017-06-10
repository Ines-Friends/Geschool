/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "civilite", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Civilite.findAll", query = "SELECT c FROM Civilite c"),
    @NamedQuery(name = "Civilite.findByIdcivilite", query = "SELECT c FROM Civilite c WHERE c.idcivilite = :idcivilite"),
    @NamedQuery(name = "Civilite.findByLibelle", query = "SELECT c FROM Civilite c WHERE c.libelle = :libelle")})
public class Civilite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcivilite", nullable = false)
    private Integer idcivilite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "libelle", nullable = false, length = 45)
    private String libelle;
    @OneToMany(mappedBy = "civilite", fetch = FetchType.LAZY)
    private List<TuteurEleve> tuteurEleveList;

    public Civilite() {
    }

    public Civilite(Integer idcivilite) {
        this.idcivilite = idcivilite;
    }

    public Civilite(Integer idcivilite, String libelle) {
        this.idcivilite = idcivilite;
        this.libelle = libelle;
    }

    public Integer getIdcivilite() {
        return idcivilite;
    }

    public void setIdcivilite(Integer idcivilite) {
        this.idcivilite = idcivilite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<TuteurEleve> getTuteurEleveList() {
        return tuteurEleveList;
    }

    public void setTuteurEleveList(List<TuteurEleve> tuteurEleveList) {
        this.tuteurEleveList = tuteurEleveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcivilite != null ? idcivilite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Civilite)) {
            return false;
        }
        Civilite other = (Civilite) object;
        if ((this.idcivilite == null && other.idcivilite != null) || (this.idcivilite != null && !this.idcivilite.equals(other.idcivilite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Civilite[ idcivilite=" + idcivilite + " ]";
    }
    
}
