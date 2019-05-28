/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.CurrentUser;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author arnau
 */
public class Vue_Generale extends JFrame implements ActionListener{
    protected final CurrentUser user;
    protected UserInfoPanel uip;

    public Vue_Generale(CurrentUser user,String statut) {
        super("Espace "+statut);
        this.user = user;
        int height = 600;
        int width = 800;
        this.setLayout(new BorderLayout());
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        uip = new UserInfoPanel(user.getEmail(),user.getNom(),user.getPrenom(),"Statut : "+statut);
        uip.getDeco_btn().addActionListener(this);
        this.getContentPane().add(uip,BorderLayout.EAST);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == uip.getDeco_btn())
        {
            Vue_Connexion vc = new Vue_Connexion();
            this.setVisible(false);
        }
    }
    
}
