/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YLY
 */
@Entity
@Table(name = "DOCTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByDocId", query = "SELECT d FROM Doctor d WHERE d.docId = :docId"),
    @NamedQuery(name = "Doctor.findByDocFname", query = "SELECT d FROM Doctor d WHERE d.docFname = :docFname"),
    @NamedQuery(name = "Doctor.findByDocLname", query = "SELECT d FROM Doctor d WHERE d.docLname = :docLname"),
    @NamedQuery(name = "Doctor.findByDocPhone", query = "SELECT d FROM Doctor d WHERE d.docPhone = :docPhone"),
    @NamedQuery(name = "Doctor.findByClinicAddress", query = "SELECT d FROM Doctor d WHERE d.clinicAddress = :clinicAddress"),
    @NamedQuery(name = "Doctor.findByClinicPhone", query = "SELECT d FROM Doctor d WHERE d.clinicPhone = :clinicPhone")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOC_ID")
    private Integer docId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOC_FNAME")
    private String docFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOC_LNAME")
    private String docLname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DOC_PHONE")
    private String docPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CLINIC_ADDRESS")
    private String clinicAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CLINIC_PHONE")
    private String clinicPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docId")
    private Collection<Users> usersCollection;
   // @JoinColumn(name = "REG_ID", referencedColumnName = "REG_ID")
    //@ManyToOne(optional = false)
    //private Registration regId;

    public Doctor() {
    }

    

    public Doctor(Integer docId, String docFname, String docLname, String docPhone, String clinicAddress, String clinicPhone) {
        this.docId = docId;
        this.docFname = docFname;
        this.docLname = docLname;
        this.docPhone = docPhone;
        this.clinicAddress = clinicAddress;
        this.clinicPhone = clinicPhone;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDocFname() {
        return docFname;
    }

    public void setDocFname(String docFname) {
        this.docFname = docFname;
    }

    public String getDocLname() {
        return docLname;
    }

    public void setDocLname(String docLname) {
        this.docLname = docLname;
    }

    public String getDocPhone() {
        return docPhone;
    }

    public void setDocPhone(String docPhone) {
        this.docPhone = docPhone;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public String getClinicPhone() {
        return clinicPhone;
    }

    public void setClinicPhone(String clinicPhone) {
        this.clinicPhone = clinicPhone;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    //public Registration getRegId() {
        //return regId;
    //}

    //public void setRegId(Registration regId) {
        //this.regId = regId;
    //}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docId != null ? docId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restclient.Doctor[ docId=" + docId + " ]";
    }
    
}
