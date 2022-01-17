package Proiect;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstPage extends Frame implements ActionListener {
    JLabel first = new JLabel();

    JButton Login = new JButton("Login");

    JButton Register = new JButton("Inregistrare");


    FirstPage() throws MalformedURLException {
        frame.getContentPane().removeAll();
        frame.repaint();
        Login.setBounds(125, 150, 150, 25);

        Login.setFocusable(false);

        Login.addActionListener(this);

        Register.setBounds(125, 180, 150, 25);

        Register.setFocusable(false);

        Register.addActionListener(this);
        first.setBounds(0, 0, 200, 35);

        first.setFont(new Font(null, Font.PLAIN, 25));
        Login.setForeground(Color.yellow);
        Register.setForeground(Color.yellow);
        Register.setOpaque(false);
        Register.setContentAreaFilled(false);
        Login.setOpaque(false);
        Login.setContentAreaFilled(false);
        Login.setBorder(new LineBorder(Color.DARK_GRAY));
        Register.setBorder(new LineBorder(Color.DARK_GRAY));
        //frame.add(first);
        frame.add(Login);
        frame.add(Register);

    }

    /* public class JPanelWithBackground extends JPanel {

         private Image backgroundImage;

         // Some code to initialize the background image.
         // Here, we use the constructor to load the image. This
         // can vary depending on the use case of the panel.
         public JPanelWithBackground(String fileName) throws IOException {
             backgroundImage = ImageIO.read(new File(fileName));
         }

         public void paintComponent(Graphics g) {
             super.paintComponent(g);

             // Draw the background image.
             g.drawImage(backgroundImage, 0, 0, this);
         }
     }
 */

    class ImagePanel extends JPanel {

        Image image;

        public ImagePanel() throws MalformedURLException {
            //image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\nahoi\\Desktop\\back.gif");
            //image = Toolkit.getDefaultToolkit().createImage("C:/back.gif");
            //URL url = new URL("https://c.tenor.com/QIazwwp34v0AAAAC/hungry-starving.gif");

            //Icon icon = new ImageIcon(url);
            //JLabel label = new JLabel(icon);
            //label.setBackground(Color.blue);
            //frame.getContentPane().add(label);
            frame.pack();
            //JPanelWithBackground();

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            IdSiParola idandPasswords = new IdSiParola();

            LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
        } else if (e.getSource() == Register) {
            RegisterPage paginaRegister = new RegisterPage();
        }

    }

}
