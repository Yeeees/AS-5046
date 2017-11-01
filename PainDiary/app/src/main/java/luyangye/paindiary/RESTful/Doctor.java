package luyangye.paindiary.RESTful;

import java.util.Collection;

/**
 * Created by YLY on 22/04/2016.
 */
public class Doctor {
    private Integer docId;

    private String docFname;

    private String docLname;

    private String docPhone;

    private String clinicAddress;

    private String clinicPhone;

    private Collection<Users> usersCollection;


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

}
