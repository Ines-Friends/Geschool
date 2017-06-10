/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "classe", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findByIdclasse", query = "SELECT c FROM Classe c WHERE c.idclasse = :idclasse"),
    @NamedQuery(name = "Classe.findByDesignation", query = "SELECT c FROM Classe c WHERE c.designation = :designation"),
    @NamedQuery(name = "Classe.findByNbreEleveMax", query = "SELECT c FROM Classe c WHERE c.nbreEleveMax = :nbreEleveMax"),
    @NamedQuery(name = "Classe.findByNbreEleveMin", query = "SELECT c FROM Classe c WHERE c.nbreEleveMin = :nbreEleveMin"),
    @NamedQuery(name = "Classe.findByDateCreation", query = "SELECT c FROM Classe c WHERE c.dateCreation = :dateCreation")})
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclasse", nullable = false)
    private Integer idclasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "designation", nullable = false, length = 45)
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbre_eleve_max", nullable = false)
    private int nbreEleveMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbre_eleve_min", nullable = false)
    private int nbreEleveMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classe1", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;

    public Classe() {
    }

    public Classe(Integer idclasse) {
        this.idclasse = idclasse;
    }

    public Classe(Integer idclasse, String designation, int nbreEleveMax, int nbreEleveMin, Date dateCreation) {
        this.idclasse = idclasse;
        this.designation = designation;
        this.nbreEleveMax = nbreEleveMax;
        this.nbreEleveMin = nbreEleveMin;
        this.dateCreation = dateCreation;
    }

    public Integer getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Integer idclasse) {
        this.idclasse = idclasse;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbreEleveMax() {
        return nbreEleveMax;
    }

    public void setNbreEleveMax(int nbreEleveMax) {
        this.nbreEleveMax = nbreEleveMax;
    }

    public int getNbreEleveMin() {
        return nbreEleveMin;
    }

    public void setNbreEleveMin(int nbreEleveMin) {
        this.nbreEleveMin = nbreEleveMin;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclasse != null ? idclasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idclasse == null && other.idclasse != null) || (this.idclasse != null && !this.idclasse.equals(other.idclasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Classe[ idclasse=" + idclasse + " ]";
    }
    
}
