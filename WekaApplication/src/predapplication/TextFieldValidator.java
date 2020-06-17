/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

import java.util.LinkedList;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Rossen
 */
public class TextFieldValidator extends InputVerifier {

    private static LinkedList<String> invalidInputs = new LinkedList();
    private static String regex = "[0-9]+";
    @Override
    public boolean verify(JComponent input) {

        try {
            boolean value = ((JTextField) input).getText().matches(regex);
               if(!value){
                   return false;
               }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean verify(LinkedList<JTextField> inputs) {

        try {
            for (JComponent input : inputs) {
               boolean value = ((JTextField) input).getText().matches(regex);
               if(!value){
                   invalidInputs.add(input.getName()); 
                   return false;
               }
               System.out.println(input.getName()+" "+ value);
                // value = Double.parseDouble(((JTextField) input).getText());
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public LinkedList<String> getInvalidInputs() {
        return invalidInputs;
    }
}
