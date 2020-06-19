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

    private static LinkedList<String> invalidInputs = new LinkedList();

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
        boolean valid = true;
        try {
            for (JComboBox input : inputs) {
                int value = input.getSelectedIndex();
                if (value == 0) {
                    invalidInputs.add(input.getName());
                    valid = false;
                }
            }
            if (!valid) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public LinkedList<String> getInvalidInputs() {
        return invalidInputs;
    }

    public String getInvalidInputsMessage() {
        StringBuilder invalidInputsString = new StringBuilder();
        for (String input : invalidInputs) {
            invalidInputsString.append(input + "\n");
        }
        invalidInputs.clear();
        return invalidInputsString.toString();
    }
}
