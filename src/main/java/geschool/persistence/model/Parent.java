/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "parent", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Parent.findAll", query = "SELECT p FROM Parent p"),
    @NamedQuery(name = "Parent.findByIdParent", query = "SELECT p FROM Parent p WHERE p.idParent = :idParent"),
    @NamedQuery(name = "Parent.findByNomParent", query = "SELECT p FROM Parent p WHERE p.nomParent = :nomParent"),
    @NamedQuery(name = "Parent.findByPrenomParent", query = "SELECT p FROM Parent p WHERE p.prenomParent = :prenomParent"),
    @NamedQuery(name = "Parent.findByAdresse", query = "SELECT p FROM Parent p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Parent.findByTelephone1", query = "SELECT p FROM Parent p WHERE p.telephone1 = :telephone1"),
    @NamedQuery(name = "Parent.findByTelephone2", query = "SELECT p FROM Parent p WHERE p.telephone2 = :telephone2"),
    @NamedQuery(name = "Parent.findByTelephone3", query = "SELECT p FROM Parent p WHERE p.telephone3 = :telephone3"),
    @NamedQuery(name = "Parent.findByDateCreation", query = "SELECT p FROM Parent p WHERE p.dateCreation = :dateCreation"),
    @NamedQuery(name = "Parent.findByDateModification", query = "SELECT p FROM Parent p WHERE p.dateModification = :dateModification"),
    @NamedQuery(name = "Parent.findByEmail", query = "SELECT p FROM Parent p WHERE p.email = :email")})
public class Parent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idParent", nullable = false)
    private Integer idParent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 260)
    @Column(name = "nomParent", nullable = false, length = 260)
    private String nomParent;
    @Size(max = 260)
    @Column(name = "prenomParent", length = 260)
    private String prenomParent;
    @Size(max = 260)
    @Column(name = "adresse", length = 260)
    private String adresse;
    @Size(max = 45)
    @Column(name = "telephone1", length = 45)
    private String telephone1;
    @Size(max = 45)
    @Column(name = "telephone2", length = 45)
    private String telephone2;
    @Size(max = 45)
    @Column(name = "telephone3", length = 45)
    private String telephone3;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "dateModification")
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email", length = 255)
    private String email;
    @JoinColumn(name = "Profession_idProfession", referencedColumnName = "idProfession", nullable = false)
    @ManyToOne(optional = false)
    private Profession professionidProfession;
    @JoinColumn(name = "Sexe_idSexe", referencedColumnName = "idSexe", nullable = false)
    @ManyToOne(optional = false)
    private Sexe sexeidSexe;

    public Parent() {
    }

    public Parent(Integer idParent) {
        this.idParent = idParent;
    }

    public Parent(Integer idParent, String nomParent) {
        this.idParent = idParent;
        this.nomParent = nomParent;
    }

    public Integer getIdParent() {
        return idParent;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
    }

    public String getNomParent() {
        return nomParent;
    }

    public void setNomParent(String nomParent) {
        this.nomParent = nomParent;
    }

    public String getPrenomParent() {
        return prenomParent;
    }

    public void setPrenomParent(String prenomParent) {
        this.prenomParent = prenomParent;
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

    public String getTelephone3() {
        return telephone3;
    }

    public void setTelephone3(String telephone3) {
        this.telephone3 = telephone3;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profession getProfessionidProfession() {
        return professionidProfession;
    }

    public void setProfessionidProfession(Profession professionidProfession) {
        this.professionidProfession = professionidProfession;
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
        hash += (idParent != null ? idParent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parent)) {
            return false;
        }
        Parent other = (Parent) object;
        if ((this.idParent == null && other.idParent != null) || (this.idParent != null && !this.idParent.equals(other.idParent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Parent[ idParent=" + idParent + " ]";
    }
    
}
