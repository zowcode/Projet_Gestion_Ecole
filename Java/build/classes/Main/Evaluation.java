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
public class Evaluation {
    private int id;
    private int note;
    private String appreciation;
    private DetailBulletin detail_bulletin;

    public Evaluation(int id, int note, String appreciation, DetailBulletin detail_bulletin) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
        this.detail_bulletin = detail_bulletin;
    }
    
    

    public int getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public DetailBulletin getDetail_bulletin() {
        return detail_bulletin;
    }
    
    
}
