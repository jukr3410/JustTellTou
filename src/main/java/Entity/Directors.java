/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "directors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Directors.findAll", query = "SELECT d FROM Directors d"),
    @NamedQuery(name = "Directors.findByDirectorID", query = "SELECT d FROM Directors d WHERE d.directorID = :directorID"),
    @NamedQuery(name = "Directors.findByDirectorFname", query = "SELECT d FROM Directors d WHERE d.directorFname = :directorFname"),
    @NamedQuery(name = "Directors.findByDirectorLname", query = "SELECT d FROM Directors d WHERE d.directorLname = :directorLname")})
public class Directors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DirectorID")
    private Integer directorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DirectorFname")
    private String directorFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DirectorLname")
    private String directorLname;
    @JoinTable(name = "movie_directors", joinColumns = {
        @JoinColumn(name = "DirectorID", referencedColumnName = "DirectorID"),
        @JoinColumn(name = "DirectorID", referencedColumnName = "DirectorID"),
        @JoinColumn(name = "DirectorID", referencedColumnName = "DirectorID"),
        @JoinColumn(name = "DirectorID", referencedColumnName = "DirectorID")}, inverseJoinColumns = {
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID"),
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID"),
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID"),
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID")})
    @ManyToMany
    private List<Movie> movieList;

    public Directors() {
    }

    public Directors(Integer directorID) {
        this.directorID = directorID;
    }

    public Directors(Integer directorID, String directorFname, String directorLname) {
        this.directorID = directorID;
        this.directorFname = directorFname;
        this.directorLname = directorLname;
    }

    public Integer getDirectorID() {
        return directorID;
    }

    public void setDirectorID(Integer directorID) {
        this.directorID = directorID;
    }

    public String getDirectorFname() {
        return directorFname;
    }

    public void setDirectorFname(String directorFname) {
        this.directorFname = directorFname;
    }

    public String getDirectorLname() {
        return directorLname;
    }

    public void setDirectorLname(String directorLname) {
        this.directorLname = directorLname;
    }

    @XmlTransient
    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (directorID != null ? directorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Directors)) {
            return false;
        }
        Directors other = (Directors) object;
        if ((this.directorID == null && other.directorID != null) || (this.directorID != null && !this.directorID.equals(other.directorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Directors[ directorID=" + directorID + " ]";
    }
    
}
