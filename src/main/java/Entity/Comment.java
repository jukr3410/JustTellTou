/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT r FROM Comment r"),
    @NamedQuery(name = "Comment.findByCommentID", query = "SELECT r FROM Comment r WHERE r.commentID = :commentID"),
    @NamedQuery(name = "Comment.findByMovieID", query = "SELECT r FROM Comment r WHERE r.movieID = :movieID"),
    @NamedQuery(name = "Comment.findByUserName", query = "SELECT r FROM Comment r WHERE r.userName = :userName"),
    @NamedQuery(name = "Comment.findByCommentDes", query = "SELECT r FROM Comment r WHERE r.commentDes = :commentDes")})
public class Comment implements Serializable {

    @Id
    @Column(name = "CommentID")
    private Integer commentID;
//    @Column(name = "MovieID")
//    private Integer movieID;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "CommentDes")
    private String commentDes;
       @JoinColumns({
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID")})
    @ManyToOne(optional = false)
    private Movie movieID;

    public Comment() {
    }

    public Comment(Integer commentID, Movie movieID, String userName, String commentDes) {
        this.commentID = commentID;
        this.movieID = movieID;
        this.userName = userName;
        this.commentDes = commentDes;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public Movie getMovieID() {
        return movieID;
    }

    public void setMovieID(Movie movieID) {
        this.movieID = movieID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentDes() {
        return commentDes;
    }

    public void setCommentDes(String commentDes) {
        this.commentDes = commentDes;
    }
        @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentID != null ? commentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentID == null && other.commentID != null) || (this.commentID != null && !this.commentID.equals(other.commentID))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Comment{" + "commentID=" + commentID + ", movieID=" + movieID + ", userName=" + userName + ", commentDes=" + commentDes + '}';
    }

}
