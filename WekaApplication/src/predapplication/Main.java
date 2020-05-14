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
public class Main extends Frame {
    InputForm formWindow;
    public Main() {
        formWindow = new InputForm();
    }

    public static void main(String[] args) {
        // Invoke the constructor (to setup the GUI) by allocating an instance
        new Main();
    }
}
