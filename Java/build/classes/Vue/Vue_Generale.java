/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.CurrentUser;
import Modele.DataManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;

/**
 *
 * @author arnau
 */
public class Vue_Generale extends JFrame implements ActionListener{
    protected final CurrentUser user;
    protected UserInfoPanel uip;
    protected JTree tree;
    protected JPanel BandeauHorizontal;
    protected JPanel BandeauVertical;
    protected JPanel MainContent;
    protected DataManager db;

    public Vue_Generale(DataManager db,CurrentUser user,String statut) {
        super("Espace "+statut);
        this.db = db;
        this.user = user;
        int height = 600;
        int width = 800;
        this.setLayout(new BorderLayout());
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        uip = new UserInfoPanel(user.getEmail(),user.getNom(),user.getPrenom(),"Statut : "+statut);
        uip.getDeco_btn().addActionListener(this);
        
        ImageIcon img = new ImageIcon ("logo_bandeau.jpg");
        JLabel logo = new JLabel(img);
    
        BandeauHorizontal = new JPanel();
        BandeauHorizontal.setLayout(new BorderLayout());
        BandeauHorizontal.setPreferredSize(new Dimension(150, 75));
        BandeauHorizontal.setBackground(new Color(0,113,121));
        BandeauHorizontal.add(logo, BorderLayout.WEST);
        this.getContentPane().add(BandeauHorizontal, BorderLayout.NORTH);
        BandeauHorizontal.add(uip,BorderLayout.EAST);
        
        BandeauVertical = new JPanel();
        BandeauVertical.setPreferredSize(new Dimension(150, 25));
        BandeauVertical.setBorder(BorderFactory.createLineBorder(Color.black));
        this.getContentPane().add(BandeauVertical, BorderLayout.WEST);
        
        MainContent = new JPanel();
        MainContent.setPreferredSize(new Dimension(150, 150));
        MainContent.setLayout(new BorderLayout());
        this.getContentPane().add(MainContent, BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == uip.getDeco_btn())
        {
            Vue_Connexion vc = new Vue_Connexion(db);
            this.setVisible(false);
        }
    }
    
}
