/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient.service;

/**
 *
 * @author YLY
 */
public class CountPainLoc {
    private String location;
    private int Count;

    public CountPainLoc() {
    }

    public CountPainLoc(String location, int Count) {
        this.location = location;
        this.Count = Count;
    }

    public String getlocation() {
        return location;
    }

    public int getCount() {
        return Count;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }
}
