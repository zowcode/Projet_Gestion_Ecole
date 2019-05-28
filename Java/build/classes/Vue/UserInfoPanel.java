package Vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import static javax.swing.BoxLayout.Y_AXIS;

/**
 *
 * @author arnaud
 */
public class UserInfoPanel extends JPanel{
    private JLabel identite_label;
    private JLabel type_label;
    private JLabel email_label;
    private JButton deco_btn;

    public UserInfoPanel(String email,String nom, String prenom, String type) {
       
       this.setSize(200,200);
       
       identite_label = new JLabel(prenom+" "+nom);
       type_label = new JLabel(type);
       email_label = new JLabel(email);
       
       deco_btn = new JButton("Deconnexion");
       
       this.setLayout(new BoxLayout(this,Y_AXIS));
       this.add(identite_label);
       this.add(email_label);
       this.add(type_label);
       this.add(deco_btn);
    }

    public JButton getDeco_btn() {
        return deco_btn;
    }
    
    
}
