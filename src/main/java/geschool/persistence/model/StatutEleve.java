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
@Table(name = "statut_eleve", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "StatutEleve.findAll", query = "SELECT s FROM StatutEleve s"),
    @NamedQuery(name = "StatutEleve.findByIdstatutEleve", query = "SELECT s FROM StatutEleve s WHERE s.idstatutEleve = :idstatutEleve"),
    @NamedQuery(name = "StatutEleve.findByLibelle", query = "SELECT s FROM StatutEleve s WHERE s.libelle = :libelle")})
public class StatutEleve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstatut_eleve", nullable = false)
    private Integer idstatutEleve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "libelle", nullable = false, length = 45)
    private String libelle;
    @OneToMany(mappedBy = "statut", fetch = FetchType.LAZY)
    private List<Eleve> eleveList;

    public StatutEleve() {
    }

    public StatutEleve(Integer idstatutEleve) {
        this.idstatutEleve = idstatutEleve;
    }

    public StatutEleve(Integer idstatutEleve, String libelle) {
        this.idstatutEleve = idstatutEleve;
        this.libelle = libelle;
    }

    public Integer getIdstatutEleve() {
        return idstatutEleve;
    }

    public void setIdstatutEleve(Integer idstatutEleve) {
        this.idstatutEleve = idstatutEleve;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstatutEleve != null ? idstatutEleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatutEleve)) {
            return false;
        }
        StatutEleve other = (StatutEleve) object;
        if ((this.idstatutEleve == null && other.idstatutEleve != null) || (this.idstatutEleve != null && !this.idstatutEleve.equals(other.idstatutEleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.StatutEleve[ idstatutEleve=" + idstatutEleve + " ]";
    }
    
}
