package Proiect;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class LoginPage extends Frame implements ActionListener {


    JButton loginButton = new JButton("Login");

    JButton resetButton = new JButton("Reset");

    JTextField userIDField = new JTextField();

    JPasswordField userPasswordField = new JPasswordField();

    JLabel userIDLabel = new JLabel("UserID:");

    JLabel userPasswordLabel = new JLabel("Password:");

    JLabel messageLabel = new JLabel();

    HashMap<String, String> logininfo;
    User user = new User();
    int id;

    LoginPage(HashMap<String, String> loginInfoOriginal) {

        frame.getContentPane().removeAll();
        frame.repaint();
        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(50, 100, 75, 25);

        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);

        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);

        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(100, 200, 100, 25);

        loginButton.setFocusable(false);

        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);

        resetButton.setFocusable(false);

        resetButton.addActionListener(this);

        resetButton.setForeground(Color.yellow);
        loginButton.setForeground(Color.yellow);
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        resetButton.setOpaque(false);
        resetButton.setContentAreaFilled(false);
        resetButton.setBorder(new LineBorder(Color.DARK_GRAY));

        userIDLabel.setForeground(Color.yellow);
        userIDLabel.setFont(new Font("Times new roman", Font.BOLD, 12));

        userPasswordLabel.setForeground(Color.yellow);
        userIDLabel.setFont(new Font("Times new roman", Font.BOLD, 12));
        loginButton.setBorder(new LineBorder(Color.DARK_GRAY));

        frame.add(userIDLabel);

        frame.add(userPasswordLabel);

        frame.add(messageLabel);

        frame.add(userIDField);

        frame.add(userPasswordField);

        frame.add(loginButton);

        frame.add(resetButton);


    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {

            userIDField.setText("");

            userPasswordField.setText("");

        }

        if (e.getSource() == loginButton) {
            login();
        }

    }

    private void login() {
        String userName = userIDField.getText();
        String password = userPasswordField.getText();

        try {
            Connection conn = ConnectionDB.CreateConnection();
            //Statement st = conn.createStatement();
            PreparedStatement st = (PreparedStatement) conn
                    .prepareStatement("Select Username, Password from [User_2] where Username=? and Password=?");

            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                // frame.getContentPane().removeAll();
                //frame.repaint();

                JOptionPane.showMessageDialog(messageLabel, "You have successfully logged in");
                user.setUsername(userName);
                String querry = "Select Id from [User_2] where [Username] =" + "'" + userName + "'";
                st = (PreparedStatement) conn
                        .prepareStatement(querry);
                ResultSet rs2 = st.executeQuery();
                if (rs2.next()) {

                    id = rs2.getInt("Id");
                }
                System.out.println("id" + id);
                MainPage ah = new MainPage(id);
            } else {
                JOptionPane.showMessageDialog(messageLabel, "Wrong Username & Password");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public User getUser() {
        return user;
    }
}