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
@Table(name = "categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
    @NamedQuery(name = "Categories.findByCatID", query = "SELECT c FROM Categories c WHERE c.catID = :catID"),
    @NamedQuery(name = "Categories.findByCatName", query = "SELECT c FROM Categories c WHERE c.catName = :catName")})
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CatID")
    private Integer catID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CatName")
    private String catName;
    @JoinTable(name = "movie_categories", joinColumns = {
        @JoinColumn(name = "CatID", referencedColumnName = "CatID"),
        @JoinColumn(name = "CatID", referencedColumnName = "CatID"),
        @JoinColumn(name = "CatID", referencedColumnName = "CatID"),
        @JoinColumn(name = "CatID", referencedColumnName = "CatID")}, inverseJoinColumns = {
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID"),
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID"),
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID"),
        @JoinColumn(name = "MovieID", referencedColumnName = "MovieID")})
    @ManyToMany
    private List<Movie> movieList;

    public Categories() {
    }

    public Categories(Integer catID) {
        this.catID = catID;
    }

    public Categories(Integer catID, String catName) {
        this.catID = catID;
        this.catName = catName;
    }

    public Integer getCatID() {
        return catID;
    }

    public void setCatID(Integer catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
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
        hash += (catID != null ? catID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.catID == null && other.catID != null) || (this.catID != null && !this.catID.equals(other.catID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Categories[ catID=" + catID + " ]";
    }
    
}
