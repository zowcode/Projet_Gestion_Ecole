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

    public Bulletin(int id, String appreciation, Inscription inscription, Trimestre trimestre) {
        this.id = id;
        this.appreciation = appreciation;
        this.inscription = inscription;
        this.trimestre = trimestre;
    }

    public Bulletin(int id, String appreciation) {
        this.id = id;
        this.appreciation = appreciation;
    }
    
    
    
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

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }


    
    
}
