package Proiect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Frame  {
    public static JFrame frame = new JFrame("Food Tracker");
    // JFrame frame = new JFrame("Food tracker");

    Frame() {
        URL url = null;
        try {
            url = new URL("https://c.tenor.com/QIazwwp34v0AAAAC/hungry-starving.gif");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
       // frame.getContentPane().setBackground(new Icon(label));
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("background.JPG")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
