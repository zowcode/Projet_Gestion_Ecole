/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.UserConnexionManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author arnau
 */
public class Vue_Connexion extends JFrame implements ActionListener{
    private JPanel logo;
    private JPanel form;
    private JButton send_btn;
    private UserConnexionManager connect;
    private JTextField champ_email;
    private JPasswordField champ_mdp;
    

    
    public Vue_Connexion()
    {
        super("Connexion");
        connect = new UserConnexionManager();
        int height = 600;
        int width = 800;
        this.setSize(width,height);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon img = new ImageIcon("logo.jpg");
        JLabel logo_label = new JLabel(img);
        
        logo = new JPanel();
        logo.setVisible(true);
        
        form = new JPanel();
        form.setSize(new Dimension(400,300));
        form.setLayout(new FlowLayout());
        
        send_btn = new JButton("Se connecter");
        send_btn.addActionListener(this);
        
        champ_email = new JTextField();
        JLabel email_label = new JLabel("Adresse email");
        champ_mdp = new JPasswordField();
        JLabel mdp_label = new JLabel("Mot de Passe");
        champ_email.setPreferredSize(new Dimension(150,20 ));
        champ_mdp.setPreferredSize(new Dimension(150,20 ));
        
        logo.add(logo_label);
        form.add(email_label);
        form.add(champ_email);
        form.add(mdp_label);
        form.add(champ_mdp);
        form.add(send_btn);
        
        
        this.getContentPane().add(logo,BorderLayout.NORTH);
        this.getContentPane().add(form,BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == send_btn)
        {
            try {
                if(connect.Create_Frame(champ_email.getText(),champ_mdp.getText()))
                {
                    this.setVisible(false);
                }else
                {
                    champ_email.setText("");
                    champ_mdp.setText("");
                    JOptionPane.showMessageDialog(this, "Adresse email ou mot de passe incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(Vue_Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
