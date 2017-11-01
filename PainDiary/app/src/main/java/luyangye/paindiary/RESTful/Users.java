package luyangye.paindiary.RESTful;

import java.util.Collection;
import java.util.Date;

/**
 * Created by YLY on 20/04/2016.
 */
public class Users {
   // private static final long serialVersionUID = 1L;

    private Integer userId;

    private String userFname;

    private String userLname;

    private Date userDob;

    private int userHeight;

    private int userWeight;

    private String userGender;

    private String userOccup;

    private String userAddress;

    private Collection<DailyRecord> dailyRecordCollection;

    private Doctor docId;//changed Doctor

    private Registration regId;//changed Registration

    public Users() {
    }

//   public Users(Integer userId) {
//        this.userId = userId;
//    }

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



}
