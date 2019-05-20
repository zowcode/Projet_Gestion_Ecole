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
public class DAO_Enseignement extends DAO<Enseignement>{
    
    @Override
    public boolean create(Enseignement obj) {
        return false;
    }

    @Override
    public boolean delete(Enseignement obj) {
        return false;
    }

    @Override
    public boolean update(Enseignement obj) {
         return false;
    }

    @Override
    public Enseignement find(int id) {
        return null;
    }
}
