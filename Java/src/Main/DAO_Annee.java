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
public class DAO_Annee extends DAO<Annee>{
      
    @Override
    public boolean create(Annee obj) {
        return false;
    }

    @Override
    public boolean delete(Annee obj) {
        return false;
    }

    @Override
    public boolean update(Annee obj) {
         return false;
    }

    @Override
    public Annee find(int id) {
        return null;
    }
}
