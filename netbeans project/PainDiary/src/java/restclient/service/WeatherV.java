/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient.service;

import java.util.Date;

/**
 *
 * @author YLY
 */
public class WeatherV {
   
    private Date RecDate;
    private String WeatherVariable;
    private int PainLvl;

    public WeatherV() {
    }

    public WeatherV(Date RecDate, String WeatherVariable, int PainLvl) {
        this.RecDate = RecDate;
        this.WeatherVariable = WeatherVariable;
        this.PainLvl = PainLvl;
    }

    public void setRecDate(Date RecDate) {
        this.RecDate = RecDate;
    }

    public void setWeatherVariable(String WeatherVariable) {
        this.WeatherVariable = WeatherVariable;
    }

    public void setPainLvl(int PainLvl) {
        this.PainLvl = PainLvl;
    }

    public Date getRecDate() {
        return RecDate;
    }

    public String getWeatherVariable() {
        return WeatherVariable;
    }

    public int getPainLvl() {
        return PainLvl;
    }
}
