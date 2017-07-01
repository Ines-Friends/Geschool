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
@Table(name = "enseignant", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
    @NamedQuery(name = "Enseignant.findByIdEnseignant", query = "SELECT e FROM Enseignant e WHERE e.idEnseignant = :idEnseignant"),
    @NamedQuery(name = "Enseignant.findByNomEnseignant", query = "SELECT e FROM Enseignant e WHERE e.nomEnseignant = :nomEnseignant"),
    @NamedQuery(name = "Enseignant.findByPrenomEnseignant", query = "SELECT e FROM Enseignant e WHERE e.prenomEnseignant = :prenomEnseignant"),
    @NamedQuery(name = "Enseignant.findByAdresse", query = "SELECT e FROM Enseignant e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Enseignant.findByTelephone1", query = "SELECT e FROM Enseignant e WHERE e.telephone1 = :telephone1"),
    @NamedQuery(name = "Enseignant.findByTelephone2", query = "SELECT e FROM Enseignant e WHERE e.telephone2 = :telephone2"),
    @NamedQuery(name = "Enseignant.findByDateCreation", query = "SELECT e FROM Enseignant e WHERE e.dateCreation = :dateCreation"),
    @NamedQuery(name = "Enseignant.findByDateModification", query = "SELECT e FROM Enseignant e WHERE e.dateModification = :dateModification")})
public class Enseignant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEnseignant", nullable = false)
    private Integer idEnseignant;
    @Size(max = 255)
    @Column(name = "nomEnseignant", length = 255)
    private String nomEnseignant;
    @Size(max = 255)
    @Column(name = "prenomEnseignant", length = 255)
    private String prenomEnseignant;
    @Size(max = 260)
    @Column(name = "adresse", length = 260)
    private String adresse;
    @Size(max = 45)
    @Column(name = "telephone1", length = 45)
    private String telephone1;
    @Size(max = 45)
    @Column(name = "telephone2", length = 45)
    private String telephone2;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enseignantidEnseignant")
    private List<Sessionenseignant> sessionenseignantList;
    @JoinColumn(name = "Sexe_idSexe", referencedColumnName = "idSexe", nullable = false)
    @ManyToOne(optional = false)
    private Sexe sexeidSexe;

    public Enseignant() {
    }

    public Enseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Enseignant(Integer idEnseignant, Date dateCreation, Date dateModification) {
        this.idEnseignant = idEnseignant;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }

    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public String getPrenomEnseignant() {
        return prenomEnseignant;
    }

    public void setPrenomEnseignant(String prenomEnseignant) {
        this.prenomEnseignant = prenomEnseignant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
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

    public List<Sessionenseignant> getSessionenseignantList() {
        return sessionenseignantList;
    }

    public void setSessionenseignantList(List<Sessionenseignant> sessionenseignantList) {
        this.sessionenseignantList = sessionenseignantList;
    }

    public Sexe getSexeidSexe() {
        return sexeidSexe;
    }

    public void setSexeidSexe(Sexe sexeidSexe) {
        this.sexeidSexe = sexeidSexe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnseignant != null ? idEnseignant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.idEnseignant == null && other.idEnseignant != null) || (this.idEnseignant != null && !this.idEnseignant.equals(other.idEnseignant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Enseignant[ idEnseignant=" + idEnseignant + " ]";
    }
    
}
