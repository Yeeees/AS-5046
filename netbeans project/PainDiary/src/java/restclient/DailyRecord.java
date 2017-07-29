/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YLY
 */
@Entity
@Table(name = "DAILY_RECORD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DailyRecord.findAll", query = "SELECT d FROM DailyRecord d"),
    @NamedQuery(name = "DailyRecord.findByRecId", query = "SELECT d FROM DailyRecord d WHERE d.recId = :recId"),
    @NamedQuery(name = "DailyRecord.findByRecDate", query = "SELECT d FROM DailyRecord d WHERE d.recDate = :recDate"),
    @NamedQuery(name = "DailyRecord.findByRecTime", query = "SELECT d FROM DailyRecord d WHERE d.recTime = :recTime"),
    @NamedQuery(name = "DailyRecord.findByPainLvl", query = "SELECT d FROM DailyRecord d WHERE d.painLvl = :painLvl"),
    @NamedQuery(name = "DailyRecord.findByPainLoc", query = "SELECT d FROM DailyRecord d WHERE d.painLoc = :painLoc"),
    @NamedQuery(name = "DailyRecord.findByMoodLvl", query = "SELECT d FROM DailyRecord d WHERE d.moodLvl = :moodLvl"),
    @NamedQuery(name = "DailyRecord.findByPainTrigger", query = "SELECT d FROM DailyRecord d WHERE d.painTrigger = :painTrigger"),
    @NamedQuery(name = "DailyRecord.findByLatitude", query = "SELECT d FROM DailyRecord d WHERE d.latitude = :latitude"),
    @NamedQuery(name = "DailyRecord.findByLongitude", query = "SELECT d FROM DailyRecord d WHERE d.longitude = :longitude"),
    @NamedQuery(name = "DailyRecord.findByClimaticTemp", query = "SELECT d FROM DailyRecord d WHERE d.climaticTemp = :climaticTemp"),
    @NamedQuery(name = "DailyRecord.findByClimaticHumidity", query = "SELECT d FROM DailyRecord d WHERE d.climaticHumidity = :climaticHumidity"),
    @NamedQuery(name = "DailyRecord.findByClimaticWindsp", query = "SELECT d FROM DailyRecord d WHERE d.climaticWindsp = :climaticWindsp"),
    @NamedQuery(name = "DailyRecord.findByClimaticPress", query = "SELECT d FROM DailyRecord d WHERE d.climaticPress = :climaticPress")})
public class DailyRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REC_ID")
    private Integer recId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REC_DATE")
    @Temporal(TemporalType.DATE)
    private Date recDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REC_TIME")
    @Temporal(TemporalType.TIME)
    private Date recTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAIN_LVL")
    private int painLvl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PAIN_LOC")
    private String painLoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MOOD_LVL")
    private String moodLvl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "PAIN_TRIGGER")
    private String painTrigger;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LATITUDE")
    private String latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LONGITUDE")
    private String longitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CLIMATIC_TEMP")
    private String climaticTemp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CLIMATIC_HUMIDITY")
    private String climaticHumidity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CLIMATIC_WINDSP")
    private String climaticWindsp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CLIMATIC_PRESS")
    private String climaticPress;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
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
