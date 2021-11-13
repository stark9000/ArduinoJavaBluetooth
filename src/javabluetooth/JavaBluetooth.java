/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabluetooth;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author saliya
 */
public class JavaBluetooth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JavaBluetooth.class.getName()).log(Level.SEVERE, null, ex);
        }
        new JavaBluetoothBC().setVisible(true);
    }

}
