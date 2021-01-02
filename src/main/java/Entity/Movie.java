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
@Table(name = "movie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieID", query = "SELECT m FROM Movie m WHERE m.movieID = :movieID"),
    @NamedQuery(name = "Movie.findByMovieName", query = "SELECT m FROM Movie m WHERE m.movieName = :movieName"),
    @NamedQuery(name = "Movie.findByDatails", query = "SELECT m FROM Movie m WHERE m.datails = :datails"),
    @NamedQuery(name = "Movie.findByLinkYouTube", query = "SELECT m FROM Movie m WHERE m.linkYouTube = :linkYouTube")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MovieID")
    private Integer movieID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MovieName")
    private String movieName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "Datails")
    private String datails;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "LinkYouTube")
    private String linkYouTube;
    @JoinTable(name = "review_movies", joinColumns = {
        
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID")}, inverseJoinColumns = {
        
        @JoinColumn(name = "ReviewerID", referencedColumnName = "ReviewerID")})
    @ManyToMany
    private List<Reviewers> reviewersList;
    @JoinTable(name = "comments", joinColumns = {
       
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID")}, inverseJoinColumns = {
      
        @JoinColumn(name = "UserName", referencedColumnName = "UserName")})
    @ManyToMany
    private List<Users> usersList;
    @ManyToMany(mappedBy = "movieList")
    private List<Actors> actorsList;
    @ManyToMany(mappedBy = "movieList")
    private List<Categories> categoriesList;
    @ManyToMany(mappedBy = "movieList")
    private List<Directors> directorsList;

    public Movie() {
    }

    public Movie(Integer movieID) {
        this.movieID = movieID;
    }

    public Movie(Integer movieID, String movieName, String datails, String linkYouTube) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.datails = datails;
        this.linkYouTube = linkYouTube;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDatails() {
        return datails;
    }

    public void setDatails(String datails) {
        this.datails = datails;
    }

    public String getLinkYouTube() {
        return linkYouTube;
    }

    public void setLinkYouTube(String linkYouTube) {
        this.linkYouTube = linkYouTube;
    }

    @XmlTransient
    public List<Reviewers> getReviewersList() {
        return reviewersList;
    }

    public void setReviewersList(List<Reviewers> reviewersList) {
        this.reviewersList = reviewersList;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @XmlTransient
    public List<Actors> getActorsList() {
        return actorsList;
    }

    public void setActorsList(List<Actors> actorsList) {
        this.actorsList = actorsList;
    }

    @XmlTransient
    public List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }

    @XmlTransient
    public List<Directors> getDirectorsList() {
        return directorsList;
    }

    public void setDirectorsList(List<Directors> directorsList) {
        this.directorsList = directorsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieID != null ? movieID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieID == null && other.movieID != null) || (this.movieID != null && !this.movieID.equals(other.movieID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieID=" + movieID + ", movieName=" + movieName + ", datails=" + datails + ", linkYouTube=" + linkYouTube + ", reviewersList=" + reviewersList + ", usersList=" + usersList + ", actorsList=" + actorsList + ", categoriesList=" + categoriesList + ", directorsList=" + directorsList + '}';
    }



  
}
