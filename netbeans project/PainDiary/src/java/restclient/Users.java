/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YLY
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByUserFname", query = "SELECT u FROM Users u WHERE u.userFname = :userFname"),
    @NamedQuery(name = "Users.findByUserLname", query = "SELECT u FROM Users u WHERE u.userLname = :userLname"),
    @NamedQuery(name = "Users.findByUserDob", query = "SELECT u FROM Users u WHERE u.userDob = :userDob"),
    @NamedQuery(name = "Users.findByUserHeight", query = "SELECT u FROM Users u WHERE u.userHeight = :userHeight"),
    @NamedQuery(name = "Users.findByUserWeight", query = "SELECT u FROM Users u WHERE u.userWeight = :userWeight"),
    @NamedQuery(name = "Users.findByUserGender", query = "SELECT u FROM Users u WHERE u.userGender = :userGender"),
    @NamedQuery(name = "Users.findByUserOccup", query = "SELECT u FROM Users u WHERE u.userOccup = :userOccup"),
    @NamedQuery(name = "Users.findByUserAddress", query = "SELECT u FROM Users u WHERE u.userAddress = :userAddress"),
        
    @NamedQuery(name = "Users.findByUserLnameANDDocLname", query = "SELECT u FROM Users u JOIN Doctor d WHERE u.userLname = :userLname AND d.docLname = :docLname")

    })


    
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USER_FNAME")
    private String userFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USER_LNAME")
    private String userLname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_DOB")
    @Temporal(TemporalType.DATE)
    private Date userDob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_HEIGHT")
    private int userHeight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_WEIGHT")
    private int userWeight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USER_GENDER")
    private String userGender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USER_OCCUP")
    private String userOccup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USER_ADDRESS")
    private String userAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<DailyRecord> dailyRecordCollection;
    @JoinColumn(name = "DOC_ID", referencedColumnName = "DOC_ID")
    @ManyToOne(optional = false)
    private Doctor docId;//changed Doctor
    @JoinColumn(name = "REG_ID", referencedColumnName = "REG_ID")
    @ManyToOne(optional = false)
    private Registration regId;//changed Registration

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String userFname, String userLname, Date userDob, int userHeight, int userWeight, String userGender, String userOccup, String userAddress) {
        this.userId = userId;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userDob = userDob;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.userGender = userGender;
        this.userOccup = userOccup;
        this.userAddress = userAddress;
        
        this.docId = docId;
        this.regId = regId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public Date getUserDob() {
        return userDob;
    }

    public void setUserDob(Date userDob) {
        this.userDob = userDob;
    }

    public int getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(int userHeight) {
        this.userHeight = userHeight;
    }

    public int getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(int userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserOccup() {
        return userOccup;
    }

    public void setUserOccup(String userOccup) {
        this.userOccup = userOccup;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @XmlTransient
    public Collection<DailyRecord> getDailyRecordCollection() {
        return dailyRecordCollection;
    }

    public void setDailyRecordCollection(Collection<DailyRecord> dailyRecordCollection) {
        this.dailyRecordCollection = dailyRecordCollection;
    }

    public Doctor getDocId() {
        return docId;
    }

    public void setDocId(Doctor docId) {
        this.docId = docId;
    }

    public Registration getRegId() {
        return regId;
    }

    public void setRegId(Registration regId) {
        this.regId = regId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restclient.Users[ userId=" + userId + " ]";
    }
    
}
