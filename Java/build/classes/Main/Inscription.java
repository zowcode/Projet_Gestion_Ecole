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
    
    

    public int getId() {
        return id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public Classe getClasse() {
        return classe;
    }
    
    
}
