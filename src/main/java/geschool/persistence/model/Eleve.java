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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "eleve", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e"),
    @NamedQuery(name = "Eleve.findByIdEleve", query = "SELECT e FROM Eleve e WHERE e.idEleve = :idEleve"),
    @NamedQuery(name = "Eleve.findByNomEleve", query = "SELECT e FROM Eleve e WHERE e.nomEleve = :nomEleve"),
    @NamedQuery(name = "Eleve.findByPrenomEleve", query = "SELECT e FROM Eleve e WHERE e.prenomEleve = :prenomEleve"),
    @NamedQuery(name = "Eleve.findByDateNaissance", query = "SELECT e FROM Eleve e WHERE e.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Eleve.findByAdresse", query = "SELECT e FROM Eleve e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Eleve.findByTelephone", query = "SELECT e FROM Eleve e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Eleve.findByDateCreation", query = "SELECT e FROM Eleve e WHERE e.dateCreation = :dateCreation"),
    @NamedQuery(name = "Eleve.findByDateModification", query = "SELECT e FROM Eleve e WHERE e.dateModification = :dateModification")})
public class Eleve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEleve", nullable = false)
    private Integer idEleve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 260)
    @Column(name = "nomEleve", nullable = false, length = 260)
    private String nomEleve;
    @Size(max = 260)
    @Column(name = "prenomEleve", length = 260)
    private String prenomEleve;
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 520)
    @Column(name = "adresse", length = 520)
    private String adresse;
    @Size(max = 45)
    @Column(name = "telephone", length = 45)
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateModification", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    @JoinColumn(name = "Sexe_idSexe", referencedColumnName = "idSexe", nullable = false)
    @ManyToOne(optional = false)
    private Sexe sexeidSexe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eleveidEleve")
    private List<Suivisessionclasseeleve> suivisessionclasseeleveList;

    public Eleve() {
    }

    public Eleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public Eleve(Integer idEleve, String nomEleve, Date dateCreation, Date dateModification) {
        this.idEleve = idEleve;
        this.nomEleve = nomEleve;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }

    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public Sexe getSexeidSexe() {
        return sexeidSexe;
    }

    public void setSexeidSexe(Sexe sexeidSexe) {
        this.sexeidSexe = sexeidSexe;
    }

    public List<Suivisessionclasseeleve> getSuivisessionclasseeleveList() {
        return suivisessionclasseeleveList;
    }

    public void setSuivisessionclasseeleveList(List<Suivisessionclasseeleve> suivisessionclasseeleveList) {
        this.suivisessionclasseeleveList = suivisessionclasseeleveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEleve != null ? idEleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.idEleve == null && other.idEleve != null) || (this.idEleve != null && !this.idEleve.equals(other.idEleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Eleve[ idEleve=" + idEleve + " ]";
    }
    
}
