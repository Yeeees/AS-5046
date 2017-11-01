package luyangye.paindiary.RESTful;


import java.util.Collection;
import java.util.Date;

/**
 * Created by YLY on 22/04/2016.
 */
public class Registration {
    private Integer regId;

    private String username;

    private String passwd;


    private Date regDate;

    private Date regTime;

    private Collection<Users> usersCollection;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "regId")
    // private Collection<Doctor> doctorCollection;

    public Registration() {
    }

//    public Registration(Integer regId) {
//        this.regId = regId;
//    }

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


    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }


}
