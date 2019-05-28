package Vue;

import Modele.CurrentUser;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author arnau
 */
public class General_Vue extends JFrame{
    private final CurrentUser user;

    public General_Vue(CurrentUser user) throws HeadlessException {
        this.user = user;
    }
    
    
}
