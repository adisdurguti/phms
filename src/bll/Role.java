/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adis Durguti
 */
@Entity
@Table(name = "Role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRoleID", query = "SELECT r FROM Role r WHERE r.roleID = :roleID"),
    @NamedQuery(name = "Role.findByRoleType", query = "SELECT r FROM Role r WHERE r.roleType = :roleType")})
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "roleID")
    private Integer roleID;
    @Basic(optional = false)
    @Column(name = "roleType")
    private String roleType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private Collection<Perdoruesi> perdoruesiCollection;

    public Role() {
    }

    public Role(Integer roleID) {
        this.roleID = roleID;
    }

    public Role(Integer roleID, String roleType) {
        this.roleID = roleID;
        this.roleType = roleType;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @XmlTransient
    public Collection<Perdoruesi> getPerdoruesiCollection() {
        return perdoruesiCollection;
    }

    public void setPerdoruesiCollection(Collection<Perdoruesi> perdoruesiCollection) {
        this.perdoruesiCollection = perdoruesiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return roleType;
    }
    
}
