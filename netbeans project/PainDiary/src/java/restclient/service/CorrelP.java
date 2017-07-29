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
public class CorrelP {
    private double correl;
    private double p;

    public CorrelP() {
    }

    public CorrelP(double correl, double p) {
        this.correl = correl;
        this.p = p;
    }

    public void setCorrel(double correl) {
        this.correl = correl;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getCorrel() {
        return correl;
    }

    public double getP() {
        return p;
    }
    
    
}
