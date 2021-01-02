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
@Table(name = "actors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actors.findAll", query = "SELECT a FROM Actors a"),
    @NamedQuery(name = "Actors.findByActorID", query = "SELECT a FROM Actors a WHERE a.actorID = :actorID"),
    @NamedQuery(name = "Actors.findByActorFname", query = "SELECT a FROM Actors a WHERE a.actorFname = :actorFname"),
    @NamedQuery(name = "Actors.findByActorLname", query = "SELECT a FROM Actors a WHERE a.actorLname = :actorLname")})
public class Actors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ActorID")
    private Integer actorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ActorFname")
    private String actorFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ActorLname")
    private String actorLname;
    @JoinTable(name = "movie_actors", joinColumns = {
        @JoinColumn(name = "ActorID", referencedColumnName = "ActorID"),
        @JoinColumn(name = "ActorID", referencedColumnName = "ActorID"),
        @JoinColumn(name = "ActorID", referencedColumnName = "ActorID"),
        @JoinColumn(name = "ActorID", referencedColumnName = "ActorID")}, inverseJoinColumns = {
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID"),
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID"),
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID"),
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID")})
    @ManyToMany
    private List<Movie> movieList;

    public Actors() {
    }

    public Actors(Integer actorID) {
        this.actorID = actorID;
    }

    public Actors(Integer actorID, String actorFname, String actorLname) {
        this.actorID = actorID;
        this.actorFname = actorFname;
        this.actorLname = actorLname;
    }

    public Integer getActorID() {
        return actorID;
    }

    public void setActorID(Integer actorID) {
        this.actorID = actorID;
    }

    public String getActorFname() {
        return actorFname;
    }

    public void setActorFname(String actorFname) {
        this.actorFname = actorFname;
    }

    public String getActorLname() {
        return actorLname;
    }

    public void setActorLname(String actorLname) {
        this.actorLname = actorLname;
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
        hash += (actorID != null ? actorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actors)) {
            return false;
        }
        Actors other = (Actors) object;
        if ((this.actorID == null && other.actorID != null) || (this.actorID != null && !this.actorID.equals(other.actorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Actors[ actorID=" + actorID + " ]";
    }
    
}
