package com.pdanielflynn.numberedlights;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Danny Flynn
 * @version 2019.04.11
 *
 */
public class Display {
    private JFrame window;
    private GridLayout layout;
    private Light[] lights = new Light[101];

    private JButton nextDay;
    private JButton reset;

    private int currentDay;
    private JLabel currentDayLabel;


    /**
     * Makes a new Display containing 100 lights
     */
    public Display() {
        currentDay = 1;

        // Set up the JFrame window
        window = new JFrame("The Light Problem");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 1000);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        layout = new GridLayout(11, 10);
        window.setLayout(layout);

        // Add all of the lights to the GUI
        for (int i = 1; i <= 100; i++) {
            lights[i] = new Light(i);
            lights[i].toggle();
            window.add(lights[i]);
        }
        
        // Create buttons
        nextDay = new JButton("Next Day");
        reset = new JButton("Reset");

        window.add(nextDay);
        window.add(reset);

        // Add action listeners for buttons
        nextDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                executeDay();
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                reset();
            }
        });

        // Add current day label
        currentDayLabel = new JLabel("Current Day: " + 0);
        window.add(currentDayLabel);

        window.setVisible(true);
    }


    /**
     * Returns the lights array
     * 
     * @return The lights array
     */
    public Light[] getLights() {
        return this.lights;
    }


    /**
     * Executes the current day of light-swapping
     */
    public void executeDay() {
        for (int i = 1; i <= 100; i++) {
            if ((i % currentDay) == 0) {
                lights[i].toggle();
                ;
            }
        }
        currentDay++;
        currentDayLabel.setText("Current Day: " + (currentDay - 1));
        window.repaint();
    }


    /**
     * Resets the display to allow for another run
     */
    public void reset() {
        currentDay = 1;
        currentDayLabel.setText("Current Day: " + 0);
        for (int i = 1; i <= 100; i++) {
            lights[i].turnOn();
        }
        window.repaint();
    }
}
