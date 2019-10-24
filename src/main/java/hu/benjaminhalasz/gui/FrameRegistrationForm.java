/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.benjaminhalasz.gui;

import hu.benjaminhalasz.model.Application;
import hu.benjaminhalasz.model.Person;
import javax.swing.JFrame;

/**
 *
 * @author benjaminhalasz
 */
public final class FrameRegistrationForm {

    private static Person person = new Person();
  private static Application application = new Application();
   // private static JPanel mainPanel;
    private static JFrame frame;

    public FrameRegistrationForm() {
    
    }

    public FrameRegistrationForm(Person p, Application a) {
    person = p;
    
        
        
    }

    public static void go() {
        frame = new JFrame();
        frame.getContentPane().add(new PanelRegistrationForm(person));
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                try {
                    go();
                } catch (NullPointerException ex) {
                    System.out.println(" " + ex.getMessage());
                    ex.printStackTrace();
                }
               
            }
        });
    }
}
