/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

import java.util.LinkedList;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 *
 * @author Rossen
 */
public class ComboBoxValidator extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        try {
             int value = ((JComboBox) input).getSelectedIndex();
                if (value == 0) {
                    return false;
                }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean verify(LinkedList<JComboBox> inputs) {
        try {
            for (JComponent input : inputs) {
                int value = ((JComboBox) input).getSelectedIndex();
                if (value == 0) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
