/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author arnau
 */
public class Bulletin {
    private int id;
    private String appreciation;
    private Inscription inscription;
    private Trimestre trimestre;

    public int getId() {
        return id;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }
    
    
}