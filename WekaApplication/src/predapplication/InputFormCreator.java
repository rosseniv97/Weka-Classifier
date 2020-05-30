/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

/**
 *
 * @author Rossen
 */
import java.awt.*;
import java.util.LinkedList;
public class InputFormCreator extends Frame {
    LinkedList<IrisForm> formWindows;
    public InputFormCreator() {
        formWindows = new LinkedList();
    }
    
    public void createForm() {
        IrisForm form= new IrisForm();
        form.setLocation(700, 300);
        form.setSize(850, 550);
        form.setVisible(true);
        this.formWindows.add(form);
    }

}
