/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Rossen
 */
public class TextFieldValidator extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {

        try {
            double value = Double.parseDouble(((JTextField) input).getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
