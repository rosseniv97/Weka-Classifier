/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

import java.util.LinkedList;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Rossen
 */
public class TextFieldValidator extends InputVerifier {

    private static LinkedList<String> invalidInputs = new LinkedList();
    private static final String REGEX = "[0-9.]+";

    @Override
    public boolean verify(JComponent input) {
        try {
            boolean value = ((JTextField) input).getText().matches(REGEX);
            if (!value) {
                invalidInputs.add(input.getName());
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean verify(LinkedList<JTextField> inputs) {
        boolean valid = true;
        try {
            for (JComponent input : inputs) {
                boolean value = ((JTextField) input).getText().matches(REGEX);
                if (!value) {
                    invalidInputs.add(input.getName());
                    valid = false;
                }
            }
            if (!valid) {
                return false;
            }

        } catch (Exception e) {
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
