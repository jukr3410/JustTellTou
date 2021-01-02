/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "review_movies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewMovie.findAll", query = "SELECT r FROM ReviewMovie r"),
    @NamedQuery(name = "ReviewMovie.findByReviewID", query = "SELECT r FROM ReviewMovie r WHERE r.reviewID = :reviewID"),
    @NamedQuery(name = "ReviewMovie.findByMovieID", query = "SELECT r FROM ReviewMovie r WHERE r.movieID = :movieID"),
    @NamedQuery(name = "ReviewMovie.findByRating", query = "SELECT r FROM ReviewMovie r WHERE r.rating = :rating"),
    @NamedQuery(name = "ReviewMovie.findByReviewText", query = "SELECT r FROM ReviewMovie r WHERE r.reviewText = :reviewText")})
public class ReviewMovie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id

    @Column(name = "ReviewID")
    private Integer reviewID;
//    @Column(name = "MovieID")
//    private Integer movieID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Rating")
    private Double rating;
    @Column(name = "ReviewerID")
    private Integer reviewerID;
    @Column(name = "ReviewText")
    private String reviewText;

    @JoinColumns({
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID")})
    @OneToOne(optional = false)
    private Movie movieID;

    public ReviewMovie() {
    }

    public ReviewMovie(Integer reviewID, Movie movieID, Double rating, Integer reviewerID, String reviewText) {
        this.reviewID = reviewID;
        this.movieID = movieID;
        this.rating = rating;
        this.reviewerID = reviewerID;
        this.reviewText = reviewText;
    }

    public Integer getReviewerID() {
        return reviewerID;
    }

    public void setReviewerID(Integer reviewerID) {
        this.reviewerID = reviewerID;
    }

    public ReviewMovie(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public Integer getReviewID() {
        return reviewID;
    }

    public void setReviewID(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public Movie getMovieID() {
        return movieID;
    }

    public void setMovieID(Movie movieID) {
        this.movieID = movieID;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewID != null ? reviewID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewMovie)) {
            return false;
        }
        ReviewMovie other = (ReviewMovie) object;
        if ((this.reviewID == null && other.reviewID != null) || (this.reviewID != null && !this.reviewID.equals(other.reviewID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReviewMovie{" + "reviewID=" + reviewID + ", movieID=" + movieID + ", rating=" + rating + ", reviewerID=" + reviewerID + ", reviewText=" + reviewText + '}';
    }

}
