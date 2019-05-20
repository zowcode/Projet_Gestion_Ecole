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
public class DAO_Inscription extends DAO<Inscription>{
    
    @Override
    public boolean create(Inscription obj) {
        return false;
    }

    @Override
    public boolean delete(Inscription obj) {
        return false;
    }

    @Override
    public boolean update(Inscription obj) {
         return false;
    }

    @Override
    public Inscription find(int id) {
        return null;
    }
}
