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
@Table(name = "REGISTRATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r"),
    @NamedQuery(name = "Registration.findByRegId", query = "SELECT r FROM Registration r WHERE r.regId = :regId"),
    @NamedQuery(name = "Registration.findByUsername", query = "SELECT r FROM Registration r WHERE r.username = :username"),
    @NamedQuery(name = "Registration.findByPasswd", query = "SELECT r FROM Registration r WHERE r.passwd = :passwd"),
    @NamedQuery(name = "Registration.findByRegDate", query = "SELECT r FROM Registration r WHERE r.regDate = :regDate"),
    @NamedQuery(name = "Registration.findByRegTime", query = "SELECT r FROM Registration r WHERE r.regTime = :regTime")})
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REG_ID")
    private Integer regId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PASSWD")
    private String passwd;
    @Basic(optional = false)
   @NotNull
    @Column(name = "REG_DATE")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REG_TIME")
    @Temporal(TemporalType.TIME)
    private Date regTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
    private Collection<Users> usersCollection;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
   // private Collection<Doctor> doctorCollection;

    public Registration() {
    }

    public Registration(Integer regId) {
        this.regId = regId;
    }

    public Registration(Integer regId, String username, String passwd, Date regDate, Date regTime) {
        this.regId = regId;
        this.username = username;
        this.passwd = passwd;
        this.regDate = regDate;
        this.regTime = regTime;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    //@XmlTransient
    //public Collection<Doctor> getDoctorCollection() {
    //    return doctorCollection;
   // }

   // public void setDoctorCollection(Collection<Doctor> doctorCollection) {
    //    this.doctorCollection = doctorCollection;
   // }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regId != null ? regId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restclient.Registration[ regId=" + regId + " ]";
    }
    
}
