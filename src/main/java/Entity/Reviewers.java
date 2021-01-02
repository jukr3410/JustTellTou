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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "reviewers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reviewers.findAll", query = "SELECT r FROM Reviewers r"),
    @NamedQuery(name = "Reviewers.findByReviewerID", query = "SELECT r FROM Reviewers r WHERE r.reviewerID = :reviewerID"),
    @NamedQuery(name = "Reviewers.findByReviewerFname", query = "SELECT r FROM Reviewers r WHERE r.reviewerFname = :reviewerFname"),
    @NamedQuery(name = "Reviewers.findByReviewerLname", query = "SELECT r FROM Reviewers r WHERE r.reviewerLname = :reviewerLname")})
public class Reviewers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReviewerID")
    private Integer reviewerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ReviewerFname")
    private String reviewerFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ReviewerLname")
    private String reviewerLname;
    @ManyToMany(mappedBy = "reviewersList")
    private List<Movie> movieList;
    @JoinColumns({
        @JoinColumn(name = "UserName", referencedColumnName = "UserName"),
        @JoinColumn(name = "UserName", referencedColumnName = "UserName"),
        @JoinColumn(name = "UserName", referencedColumnName = "UserName"),
        @JoinColumn(name = "UserName", referencedColumnName = "UserName")})
    @ManyToOne(optional = false)
    private Users users;

    public Reviewers() {
    }

    public Reviewers(Integer reviewerID) {
        this.reviewerID = reviewerID;
    }

    public Reviewers(Integer reviewerID, String reviewerFname, String reviewerLname) {
        this.reviewerID = reviewerID;
        this.reviewerFname = reviewerFname;
        this.reviewerLname = reviewerLname;
    }

    public Integer getReviewerID() {
        return reviewerID;
    }

    public void setReviewerID(Integer reviewerID) {
        this.reviewerID = reviewerID;
    }

    public String getReviewerFname() {
        return reviewerFname;
    }

    public void setReviewerFname(String reviewerFname) {
        this.reviewerFname = reviewerFname;
    }

    public String getReviewerLname() {
        return reviewerLname;
    }

    public void setReviewerLname(String reviewerLname) {
        this.reviewerLname = reviewerLname;
    }

    @XmlTransient
    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewerID != null ? reviewerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reviewers)) {
            return false;
        }
        Reviewers other = (Reviewers) object;
        if ((this.reviewerID == null && other.reviewerID != null) || (this.reviewerID != null && !this.reviewerID.equals(other.reviewerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Reviewers[ reviewerID=" + reviewerID + " ]";
    }
    
}
