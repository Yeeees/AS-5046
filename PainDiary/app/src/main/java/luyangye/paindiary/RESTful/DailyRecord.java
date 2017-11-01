package luyangye.paindiary.RESTful;

import java.util.Date;

/**
 * Created by YLY on 22/04/2016.
 */
public class DailyRecord {
    private Integer recId;

    private Date recDate;

    private Date recTime;

    private int painLvl;

    private String painLoc;

    private String moodLvl;

    private String painTrigger;

    private String latitude;

    private String longitude;

    private String climaticTemp;

    private String climaticHumidity;

    private String climaticWindsp;

    private String climaticPress;

    private Users userId;

    public DailyRecord() {
    }

    public DailyRecord(Integer recId) {
        this.recId = recId;
    }

    public DailyRecord(Integer recId, Date recDate, Date recTime, int painLvl, String painLoc, String moodLvl, String painTrigger, String latitude, String longitude, String climaticTemp, String climaticHumidity, String climaticWindsp, String climaticPress) {
        this.recId = recId;
        this.recDate = recDate;
        this.recTime = recTime;
        this.painLvl = painLvl;
        this.painLoc = painLoc;
        this.moodLvl = moodLvl;
        this.painTrigger = painTrigger;
        this.latitude = latitude;
        this.longitude = longitude;
        this.climaticTemp = climaticTemp;
        this.climaticHumidity = climaticHumidity;
        this.climaticWindsp = climaticWindsp;
        this.climaticPress = climaticPress;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public Date getRecTime() {
        return recTime;
    }

    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

    public int getPainLvl() {
        return painLvl;
    }

    public void setPainLvl(int painLvl) {
        this.painLvl = painLvl;
    }

    public String getPainLoc() {
        return painLoc;
    }

    public void setPainLoc(String painLoc) {
        this.painLoc = painLoc;
    }

    public String getMoodLvl() {
        return moodLvl;
    }

    public void setMoodLvl(String moodLvl) {
        this.moodLvl = moodLvl;
    }

    public String getPainTrigger() {
        return painTrigger;
    }

    public void setPainTrigger(String painTrigger) {
        this.painTrigger = painTrigger;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getClimaticTemp() {
        return climaticTemp;
    }

    public void setClimaticTemp(String climaticTemp) {
        this.climaticTemp = climaticTemp;
    }

    public String getClimaticHumidity() {
        return climaticHumidity;
    }

    public void setClimaticHumidity(String climaticHumidity) {
        this.climaticHumidity = climaticHumidity;
    }

    public String getClimaticWindsp() {
        return climaticWindsp;
    }

    public void setClimaticWindsp(String climaticWindsp) {
        this.climaticWindsp = climaticWindsp;
    }

    public String getClimaticPress() {
        return climaticPress;
    }

    public void setClimaticPress(String climaticPress) {
        this.climaticPress = climaticPress;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recId != null ? recId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DailyRecord)) {
            return false;
        }
        DailyRecord other = (DailyRecord) object;
        if ((this.recId == null && other.recId != null) || (this.recId != null && !this.recId.equals(other.recId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restclient.DailyRecord[ recId=" + recId + " ]";
    }

}
