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
@Table(name = "sessiontrimestre", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sessiontrimestre.findAll", query = "SELECT s FROM Sessiontrimestre s"),
    @NamedQuery(name = "Sessiontrimestre.findByIdSessionTrimestre", query = "SELECT s FROM Sessiontrimestre s WHERE s.idSessionTrimestre = :idSessionTrimestre"),
    @NamedQuery(name = "Sessiontrimestre.findByActif", query = "SELECT s FROM Sessiontrimestre s WHERE s.actif = :actif")})
public class Sessiontrimestre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSessionTrimestre", nullable = false)
    private Integer idSessionTrimestre;
    @Column(name = "actif")
    private Integer actif;
    @JoinColumn(name = "Trimestre_idTrimestre", referencedColumnName = "idTrimestre", nullable = false)
    @ManyToOne(optional = false)
    private Trimestre trimestreidTrimestre;
    @JoinColumn(name = "Session_idSession", referencedColumnName = "idSession", nullable = false)
    @ManyToOne(optional = false)
    private Session sessionidSession;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionTrimestreidSessionTrimestre")
    private List<Examen> examenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionTrimestreidSessionTrimestre")
    private List<Emploidutemps> emploidutempsList;

    public Sessiontrimestre() {
    }

    public Sessiontrimestre(Integer idSessionTrimestre) {
        this.idSessionTrimestre = idSessionTrimestre;
    }

    public Integer getIdSessionTrimestre() {
        return idSessionTrimestre;
    }

    public void setIdSessionTrimestre(Integer idSessionTrimestre) {
        this.idSessionTrimestre = idSessionTrimestre;
    }

    public Integer getActif() {
        return actif;
    }

    public void setActif(Integer actif) {
        this.actif = actif;
    }

    public Trimestre getTrimestreidTrimestre() {
        return trimestreidTrimestre;
    }

    public void setTrimestreidTrimestre(Trimestre trimestreidTrimestre) {
        this.trimestreidTrimestre = trimestreidTrimestre;
    }

    public Session getSessionidSession() {
        return sessionidSession;
    }

    public void setSessionidSession(Session sessionidSession) {
        this.sessionidSession = sessionidSession;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    public List<Emploidutemps> getEmploidutempsList() {
        return emploidutempsList;
    }

    public void setEmploidutempsList(List<Emploidutemps> emploidutempsList) {
        this.emploidutempsList = emploidutempsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSessionTrimestre != null ? idSessionTrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessiontrimestre)) {
            return false;
        }
        Sessiontrimestre other = (Sessiontrimestre) object;
        if ((this.idSessionTrimestre == null && other.idSessionTrimestre != null) || (this.idSessionTrimestre != null && !this.idSessionTrimestre.equals(other.idSessionTrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Sessiontrimestre[ idSessionTrimestre=" + idSessionTrimestre + " ]";
    }
    
}
