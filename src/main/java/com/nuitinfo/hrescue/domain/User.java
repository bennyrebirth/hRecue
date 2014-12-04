/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuitinfo.hrescue.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jerry Philippe RAKOTOBE
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 45)
    @Column(name = "last_latitude")
    private String lastLatitude;
    @Size(max = 45)
    @Column(name = "last_longitude")
    private String lastLongitude;
    @Size(max = 128)
    @Column(name = "last_address")
    private String lastAddress;
    @Size(max = 128)
    @Column(name = "address")
    private String address;
    @Size(max = 16)
    @Column(name = "postal_code")
    private String postalCode;
    @Size(max = 96)
    @Column(name = "city")
    private String city;
    @Size(max = 128)
    @Column(name = "country")
    private String country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<InformationHasUser> informationHasUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<UserRelation> userRelationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationId")
    private List<UserRelation> userRelationList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<UserHasVaccin> userHasVaccinList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderId")
    private List<Message> messageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Message> messageList1;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Role roleId;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String password, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastLatitude() {
        return lastLatitude;
    }

    public void setLastLatitude(String lastLatitude) {
        this.lastLatitude = lastLatitude;
    }

    public String getLastLongitude() {
        return lastLongitude;
    }

    public void setLastLongitude(String lastLongitude) {
        this.lastLongitude = lastLongitude;
    }

    public String getLastAddress() {
        return lastAddress;
    }

    public void setLastAddress(String lastAddress) {
        this.lastAddress = lastAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<InformationHasUser> getInformationHasUserList() {
        return informationHasUserList;
    }

    public void setInformationHasUserList(List<InformationHasUser> informationHasUserList) {
        this.informationHasUserList = informationHasUserList;
    }

    public List<UserRelation> getUserRelationList() {
        return userRelationList;
    }

    public void setUserRelationList(List<UserRelation> userRelationList) {
        this.userRelationList = userRelationList;
    }

    public List<UserRelation> getUserRelationList1() {
        return userRelationList1;
    }

    public void setUserRelationList1(List<UserRelation> userRelationList1) {
        this.userRelationList1 = userRelationList1;
    }

    public List<UserHasVaccin> getUserHasVaccinList() {
        return userHasVaccinList;
    }

    public void setUserHasVaccinList(List<UserHasVaccin> userHasVaccinList) {
        this.userHasVaccinList = userHasVaccinList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Message> getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(List<Message> messageList1) {
        this.messageList1 = messageList1;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nuitinfo.hrescue.domain.User[ id=" + id + " ]";
    }
    
}
