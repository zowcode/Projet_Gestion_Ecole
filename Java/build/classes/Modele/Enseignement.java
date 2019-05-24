/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author arnau
 */
public class Enseignement {
    private int id;
    private Classe classe;
    private Enseignant enseignant;
    private Discipline discipline;

    public Enseignement(int id, Classe classe, Enseignant enseignant, Discipline discipline) {
        this.id = id;
        this.classe = classe;
        this.enseignant = enseignant;
        this.discipline = discipline;
    }

    public Enseignement(int id) {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public Classe getClasse() {
        return classe;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    
    
}
