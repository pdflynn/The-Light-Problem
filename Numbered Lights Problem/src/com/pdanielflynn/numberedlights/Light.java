package com.pdanielflynn.numberedlights;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.imageio.*;

/**
 * This class represents one of the lights that will be displayed on the GUI
 * 
 * @author Danny Flynn
 * @version 2019.04.11
 *
 */
public class Light extends JPanel {

    private JLabel light;

    private ImageIcon lightBulbOn;
    private ImageIcon lightBulbOff;

    private JLabel bulbName;

    private BufferedImage lightOn;
    private BufferedImage lightOff;

    private File onImage;
    private File offImage;
    
    private int lightNumber;


    /**
     * Create a new light object
     * 
     * @param num
     *            The number label of this light
     */
    public Light(int num) {
        
        lightNumber = num;

        onImage = new File("lightBulbOn.png");
        offImage = new File("lightBulbOff.png");

        try {
            lightOff = ImageIO.read(offImage);
            lightOn = ImageIO.read(onImage);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        lightBulbOn = new ImageIcon(lightOn);
        lightBulbOff = new ImageIcon(lightOff);

        light = new JLabel();
        light.setIcon(lightBulbOff);

        bulbName = new JLabel("#" + num);
        this.setLayout(new GridLayout());
        this.add(bulbName);
        this.add(light);
        
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(blackline);
        
    }


    /**
     * Toggle the light on or off
     */
    public void toggle() {
        if (light.getIcon().equals(lightBulbOn)) {
            light.setIcon(lightBulbOff);
        }
        else {
            light.setIcon(lightBulbOn);
        }
    }
    
    /**
     * Turn on this light
     */
    public void turnOn() {
        light.setIcon(lightBulbOn);
    }
    
    /**
     * Get this light's number
     * @return The number of this light
     */
    public int getNum() {
        return this.lightNumber;
    }

}
