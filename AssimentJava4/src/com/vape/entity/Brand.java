/*
 * Hello This My Class
 * Design By NguyenDuong.Dev
 */
package com.vape.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author NguyenDuong.Dev
 */
@Entity
@Table(name = "brand")
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b")})
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "brandid")
    private Integer brandid;
    @Size(max = 255)
    @Column(name = "namebrand")
    private String namebrand;
    @Column(name = "datecreate")
    @Temporal(TemporalType.DATE)
    private Date datecreate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandid")
    private List<Product> productList;

    public Brand() {
    }

    public Brand(Integer brandid) {
        this.brandid = brandid;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getNamebrand() {
        return namebrand;
    }

    public void setNamebrand(String namebrand) {
        this.namebrand = namebrand;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandid != null ? brandid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        if ((this.brandid == null && other.brandid != null) || (this.brandid != null && !this.brandid.equals(other.brandid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vape.entity.Brand[ brandid=" + brandid + " ]";
    }
    
}
