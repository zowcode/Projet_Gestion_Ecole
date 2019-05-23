/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author arnaud
 */
public class Inscription {
    private int id;
    private Eleve eleve;
    private Classe classe;

    public Inscription(int id, Eleve eleve, Classe classe) {
        this.id = id;
        this.eleve = eleve;
        this.classe = classe;
    }

    public Inscription(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    
}
