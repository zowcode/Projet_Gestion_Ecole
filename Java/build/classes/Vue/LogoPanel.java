/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author arnau
 */
public class LogoPanel extends JPanel{

    private BufferedImage image;

    public LogoPanel() {
        this.setSize(new Dimension(953,213));
       try {                
          image = ImageIO.read(new File("logo.jpg"));
          if(image == null)
              System.out.println("null");
       } catch (IOException ex) {
            // handle exception...
       }
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);        
    }

}
    
