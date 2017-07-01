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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "sessionenseignant", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sessionenseignant.findAll", query = "SELECT s FROM Sessionenseignant s"),
    @NamedQuery(name = "Sessionenseignant.findByIdSessionEnseignant", query = "SELECT s FROM Sessionenseignant s WHERE s.idSessionEnseignant = :idSessionEnseignant"),
    @NamedQuery(name = "Sessionenseignant.findByActif", query = "SELECT s FROM Sessionenseignant s WHERE s.actif = :actif")})
public class Sessionenseignant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSessionEnseignant", nullable = false)
    private Integer idSessionEnseignant;
    @Column(name = "actif")
    private Integer actif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionEnseignantidSessionEnseignant")
    private List<Suivisessionclassematiere> suivisessionclassematiereList;
    @JoinColumn(name = "Session_idSession", referencedColumnName = "idSession", nullable = false)
    @ManyToOne(optional = false)
    private Session sessionidSession;
    @JoinColumn(name = "Enseignant_idEnseignant", referencedColumnName = "idEnseignant", nullable = false)
    @ManyToOne(optional = false)
    private Enseignant enseignantidEnseignant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionEnseignantidSessionEnseignant")
    private List<Examen> examenList;

    public Sessionenseignant() {
    }

    public Sessionenseignant(Integer idSessionEnseignant) {
        this.idSessionEnseignant = idSessionEnseignant;
    }

    public Integer getIdSessionEnseignant() {
        return idSessionEnseignant;
    }

    public void setIdSessionEnseignant(Integer idSessionEnseignant) {
        this.idSessionEnseignant = idSessionEnseignant;
    }

    public Integer getActif() {
        return actif;
    }

    public void setActif(Integer actif) {
        this.actif = actif;
    }

    public List<Suivisessionclassematiere> getSuivisessionclassematiereList() {
        return suivisessionclassematiereList;
    }

    public void setSuivisessionclassematiereList(List<Suivisessionclassematiere> suivisessionclassematiereList) {
        this.suivisessionclassematiereList = suivisessionclassematiereList;
    }

    public Session getSessionidSession() {
        return sessionidSession;
    }

    public void setSessionidSession(Session sessionidSession) {
        this.sessionidSession = sessionidSession;
    }

    public Enseignant getEnseignantidEnseignant() {
        return enseignantidEnseignant;
    }

    public void setEnseignantidEnseignant(Enseignant enseignantidEnseignant) {
        this.enseignantidEnseignant = enseignantidEnseignant;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSessionEnseignant != null ? idSessionEnseignant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessionenseignant)) {
            return false;
        }
        Sessionenseignant other = (Sessionenseignant) object;
        if ((this.idSessionEnseignant == null && other.idSessionEnseignant != null) || (this.idSessionEnseignant != null && !this.idSessionEnseignant.equals(other.idSessionEnseignant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Sessionenseignant[ idSessionEnseignant=" + idSessionEnseignant + " ]";
    }
    
}
