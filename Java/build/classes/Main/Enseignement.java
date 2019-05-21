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
    
    
}
