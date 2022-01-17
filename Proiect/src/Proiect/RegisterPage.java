package Proiect;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.*;

public class RegisterPage extends Frame implements ActionListener {
    User user = new User();
    ButtonGroup group_scop = new ButtonGroup();
    ButtonGroup group_activitate = new ButtonGroup();
    ButtonGroup group_sex = new ButtonGroup();
    JTextField text_inaltime = new JTextField();
    JTextField text_greutate = new JTextField();
    JTextField userIDField = new JTextField();
    JTextField NumeField = new JTextField();
    JTextField text_greutate_dorita = new JTextField();
    JRadioButton rb1_slabit, rb2_mentinere, rb3_punere;
    JRadioButton rb1_sedentar, rb2_usor, rb3_moderat, rb4_intens;
    JRadioButton slabit025, slabit05, slabit075, slabit1kg;
    JRadioButton ing025, ing05;
    JRadioButton masculin, feminin;
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Username:");
    JLabel NumeLabel = new JLabel("Nume");
    JTextField AnNastere = new JTextField();
    JLabel userPasswordLabel = new JLabel("Password:");
    JButton RegisterButton = new JButton("Next");
    JLabel mesaj = new JLabel();
    JPasswordField verify_pass = new JPasswordField();
    JTextField text_email = new JTextField();
    JButton NextButton1 = new JButton("Next");
    JButton NextButton2 = new JButton("Next");
    JButton NextButton3 = new JButton("Next");
    JButton NextButton4 = new JButton("Next");
    JButton NextButton5 = new JButton("Next");
    JComboBox<Country> comboCountry;
    JLabel labelCountry;
    Country[] listCountry = createCountryList();

    //private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    RegisterPage() {
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel userVerifyPasswordLabel = new JLabel("Verify Password:");

        JLabel email = new JLabel("Email");


        email.setBounds(50, 225, 150, 25);
        text_email.setBounds(125, 225, 200, 25);
        mesaj.setBounds(50, 300, 350, 35);

        mesaj.setFont(new Font(null, Font.ITALIC, 17));
        userIDLabel.setBounds(50, 75, 75, 25);
        userIDField.setBounds(125, 75, 200, 25);
        userPasswordLabel.setBounds(50, 125, 75, 25);
        userPasswordField.setBounds(125, 125, 200, 25);
        userVerifyPasswordLabel.setBounds(50, 175, 150, 25);
        verify_pass.setBounds(125, 175, 200, 25);
        NumeLabel.setBounds(50, 275, 75, 25);
        NumeField.setBounds(125, 275, 200, 25);
        RegisterButton.setBounds(125, 315, 150, 25);
        RegisterButton.setBorder(new LineBorder(Color.DARK_GRAY));
        RegisterButton.setForeground(Color.yellow);
        RegisterButton.setContentAreaFilled(false);
        RegisterButton.setOpaque(false);

        userIDField.setBorder(new LineBorder(Color.DARK_GRAY));
        userIDField.setForeground(Color.yellow);
        userIDField.setOpaque(false);

        userPasswordField.setBorder(new LineBorder(Color.DARK_GRAY));
        userPasswordField.setForeground(Color.yellow);
        userPasswordField.setOpaque(false);

        verify_pass.setBorder(new LineBorder(Color.DARK_GRAY));
        verify_pass.setForeground(Color.yellow);
        verify_pass.setOpaque(false);

        text_email.setBorder(new LineBorder(Color.DARK_GRAY));
        text_email.setForeground(Color.yellow);
        text_email.setOpaque(false);

        NumeField.setBorder(new LineBorder(Color.DARK_GRAY));
        NumeField.setForeground(Color.yellow);
        NumeField.setOpaque(false);

        userIDLabel.setForeground(Color.yellow);
        userIDLabel.setFont(new Font("Times new roman", Font.BOLD, 12));

        userPasswordLabel.setForeground(Color.yellow);
        userPasswordLabel.setFont(new Font("Times new roman", Font.BOLD, 12));

        NumeLabel.setForeground(Color.yellow);
        NumeLabel.setFont(new Font("Times new roman", Font.BOLD, 12));

        email.setForeground(Color.yellow);
        email.setFont(new Font("Times new roman", Font.BOLD, 12));

        userVerifyPasswordLabel.setForeground(Color.yellow);
        userVerifyPasswordLabel.setFont(new Font("Times new roman", Font.BOLD, 12));


        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(RegisterButton);
        frame.add(email);
        frame.add(mesaj);
        frame.add(text_email);
        frame.add(userVerifyPasswordLabel);
        frame.add(verify_pass);
        frame.add(NumeField);
        frame.add(NumeLabel);
        RegisterButton.addActionListener(this);
    }

    public void set1_intrebari() {
        JLabel goal = new JLabel("Care este scopul folosirii aplicatiei:");
        rb1_slabit = new JRadioButton("Slabit");
        rb2_mentinere = new JRadioButton("Mnetinere greutate");
        rb3_punere = new JRadioButton("Punere in greutate");
        group_scop.add(rb1_slabit);
        group_scop.add(rb2_mentinere);
        group_scop.add(rb3_punere);

        rb1_slabit.setForeground(Color.yellow);
        rb1_slabit.setFont(new Font("Times new roman", Font.BOLD, 12));

        rb2_mentinere.setForeground(Color.yellow);
        rb2_mentinere.setFont(new Font("Times new roman", Font.BOLD, 12));

        rb3_punere.setForeground(Color.yellow);
        rb3_punere.setFont(new Font("Times new roman", Font.BOLD, 12));

        rb1_slabit.setBorder(new LineBorder(Color.DARK_GRAY));
        rb1_slabit.setForeground(Color.yellow);
        rb1_slabit.setOpaque(false);

        rb2_mentinere.setBorder(new LineBorder(Color.DARK_GRAY));
        rb2_mentinere.setForeground(Color.yellow);
        rb2_mentinere.setOpaque(false);

        rb3_punere.setBorder(new LineBorder(Color.DARK_GRAY));
        rb3_punere.setForeground(Color.yellow);
        rb3_punere.setOpaque(false);

        goal.setForeground(Color.yellow);
        goal.setFont(new Font("Times new roman", Font.BOLD, 12));

        frame.getContentPane().removeAll();
        frame.repaint();
        goal.setBounds(50, 50, 200, 25);
        rb1_slabit.setBounds(50, 100, 150, 25);
        rb2_mentinere.setBounds(50, 150, 150, 25);
        rb3_punere.setBounds(50, 200, 150, 25);
        NextButton1.setBounds(125, 250, 150, 25);
        mesaj.setBounds(50, 300, 350, 35);

        mesaj.setFont(new Font(null, Font.ITALIC, 17));
        NextButton1.setBorder(new LineBorder(Color.DARK_GRAY));
        NextButton1.setForeground(Color.yellow);
        NextButton1.setContentAreaFilled(false);
        NextButton1.setOpaque(false);
        frame.add(goal);
        frame.add(rb1_slabit);
        frame.add(rb2_mentinere);
        frame.add(rb3_punere);
        frame.add(NextButton1);
        frame.add(mesaj);
        NextButton1.addActionListener(this);
    }

    public void set2_intrebari() {
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel ACTIV = new JLabel("Cat esti de activ:");
        rb1_sedentar = new JRadioButton("Sedentar");
        rb2_usor = new JRadioButton("Usoara");
        rb3_moderat = new JRadioButton("Moderata");
        rb4_intens = new JRadioButton("Intensa");

        ACTIV.setForeground(Color.yellow);
        ACTIV.setFont(new Font("Times new roman", Font.BOLD, 12));

        rb1_sedentar.setForeground(Color.yellow);
        rb1_sedentar.setFont(new Font("Times new roman", Font.BOLD, 12));

        rb2_usor.setForeground(Color.yellow);
        rb2_usor.setFont(new Font("Times new roman", Font.BOLD, 12));

        rb3_moderat.setForeground(Color.yellow);
        rb3_moderat.setFont(new Font("Times new roman", Font.BOLD, 12));

        rb4_intens.setForeground(Color.yellow);
        rb4_intens.setFont(new Font("Times new roman", Font.BOLD, 12));

        rb1_sedentar.setBorder(new LineBorder(Color.DARK_GRAY));
        rb1_sedentar.setForeground(Color.yellow);
        rb1_sedentar.setOpaque(false);

        rb2_usor.setBorder(new LineBorder(Color.DARK_GRAY));
        rb2_usor.setForeground(Color.yellow);
        rb2_usor.setOpaque(false);

        rb3_moderat.setBorder(new LineBorder(Color.DARK_GRAY));
        rb3_moderat.setForeground(Color.yellow);
        rb3_moderat.setOpaque(false);

        rb4_intens.setBorder(new LineBorder(Color.DARK_GRAY));
        rb4_intens.setForeground(Color.yellow);
        rb4_intens.setOpaque(false);

        group_activitate.add(rb1_sedentar);
        group_activitate.add(rb2_usor);
        group_activitate.add(rb3_moderat);
        group_activitate.add(rb4_intens);
        ACTIV.setBounds(50, 50, 150, 25);
        rb1_sedentar.setBounds(50, 100, 150, 25);
        rb2_usor.setBounds(50, 150, 150, 25);
        rb3_moderat.setBounds(50, 200, 150, 25);
        rb4_intens.setBounds(50, 250, 150, 25);
        NextButton2.setBounds(125, 300, 150, 25);
        mesaj.setBounds(50, 350, 350, 35);
        NextButton2.setBorder(new LineBorder(Color.DARK_GRAY));
        NextButton2.setForeground(Color.yellow);
        NextButton2.setContentAreaFilled(false);
        NextButton2.setOpaque(false);
        mesaj.setFont(new Font(null, Font.ITALIC, 17));
        frame.add(ACTIV);
        frame.add(rb1_sedentar);
        frame.add(rb2_usor);
        frame.add(rb3_moderat);
        frame.add(rb4_intens);
        frame.add(NextButton2);
        frame.add(mesaj);
        NextButton2.addActionListener(this);
    }

    private Country[] createCountryList() {
        String[] countryCodes = Locale.getISOCountries();
        Country[] listCountry = new Country[countryCodes.length];

        for (int i = 0; i < countryCodes.length; i++) {
            Locale locale = new Locale("", countryCodes[i]);
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();

            listCountry[i] = new Country(code, name);
        }

        Arrays.sort(listCountry);

        return listCountry;
    }

    public void set3_intrebari() {
        comboCountry = new JComboBox<>(listCountry);
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel sex = new JLabel("Sex:");
        masculin = new JRadioButton("Masculin");
        feminin = new JRadioButton("Feminin");

        masculin.setForeground(Color.yellow);
        masculin.setFont(new Font("Times new roman", Font.BOLD, 12));

        feminin.setForeground(Color.yellow);
        feminin.setFont(new Font("Times new roman", Font.BOLD, 12));

        masculin.setBorder(new LineBorder(Color.DARK_GRAY));
        masculin.setForeground(Color.yellow);
        masculin.setOpaque(false);

        feminin.setBorder(new LineBorder(Color.DARK_GRAY));
        feminin.setForeground(Color.yellow);
        feminin.setOpaque(false);


        // ButtonGroup group = new ButtonGroup();
        group_sex.add(masculin);
        group_sex.add(feminin);
        JLabel birthday = new JLabel("Varsta:");

        birthday.setForeground(Color.yellow);
        birthday.setFont(new Font("Times new roman", Font.BOLD, 12));

        AnNastere.setForeground(Color.yellow);
        AnNastere.setFont(new Font("Times new roman", Font.BOLD, 12));

        AnNastere.setBorder(new LineBorder(Color.DARK_GRAY));
        AnNastere.setForeground(Color.yellow);
        AnNastere.setOpaque(false);

        //AnNastere.setText("YY/MM/YYYY");
        sex.setBounds(50, 50, 100, 25);
        masculin.setBounds(50, 75, 150, 25);
        feminin.setBounds(50, 100, 150, 25);
        birthday.setBounds(50, 150, 150, 25);
        AnNastere.setBounds(50, 175, 150, 25);

        labelCountry = new JLabel("Select your country: ");
        labelCountry.setBounds(50, 200, 150, 25);

        labelCountry.setBorder(new LineBorder(Color.DARK_GRAY));
        labelCountry.setForeground(Color.yellow);
        labelCountry.setOpaque(false);

        labelCountry.setForeground(Color.yellow);
        labelCountry.setFont(new Font("Times new roman", Font.BOLD, 12));

        comboCountry.setBorder(new LineBorder(Color.DARK_GRAY));
        comboCountry.setForeground(Color.DARK_GRAY);
        comboCountry.setOpaque(false);
        comboCountry.setOpaque(false);

        comboCountry.setForeground(Color.DARK_GRAY);
        comboCountry.setFont(new Font("Times new roman", Font.BOLD, 10));

        comboCountry.setBounds(50, 225, 150, 25);
        NextButton3.setBounds(50, 275, 150, 25);
        mesaj.setBounds(50, 350, 350, 35);
        NextButton3.setBorder(new LineBorder(Color.DARK_GRAY));
        NextButton3.setForeground(Color.yellow);
        NextButton3.setContentAreaFilled(false);
        NextButton3.setOpaque(false);
        mesaj.setFont(new Font(null, Font.ITALIC, 17));
        frame.add(masculin);
        frame.add(feminin);
        frame.add(birthday);
        frame.add(AnNastere);
        frame.add(sex);
        frame.add(labelCountry);
        frame.add(comboCountry);
        frame.add(NextButton3);
        frame.add(mesaj);

        NextButton3.addActionListener(this);
    }

    public void set4_intrebari() {
        frame.getContentPane().removeAll();
        frame.repaint();

        JLabel inaltime = new JLabel("Inaltime");

        JLabel greutate = new JLabel("Greutate");

        inaltime.setBorder(new LineBorder(Color.DARK_GRAY));
        inaltime.setForeground(Color.yellow);
        inaltime.setOpaque(false);

        inaltime.setForeground(Color.yellow);
        inaltime.setFont(new Font("Times new roman", Font.BOLD, 12));

        greutate.setBorder(new LineBorder(Color.DARK_GRAY));
        greutate.setForeground(Color.yellow);
        greutate.setOpaque(false);

        greutate.setForeground(Color.yellow);
        greutate.setFont(new Font("Times new roman", Font.BOLD, 12));

        inaltime.setBounds(50, 50, 150, 25);
        text_inaltime.setBounds(50, 75, 150, 25);
        greutate.setBounds(50, 125, 150, 25);
        text_greutate.setBounds(50, 150, 150, 25);
        NextButton4.setBounds(50, 200, 150, 25);
        mesaj.setBounds(50, 300, 350, 35);
        NextButton4.setBorder(new LineBorder(Color.DARK_GRAY));
        NextButton4.setForeground(Color.yellow);
        NextButton4.setContentAreaFilled(false);
        NextButton4.setOpaque(false);

        text_inaltime.setBorder(new LineBorder(Color.DARK_GRAY));
        text_inaltime.setForeground(Color.yellow);
        text_inaltime.setOpaque(false);

        text_inaltime.setForeground(Color.yellow);
        text_inaltime.setFont(new Font("Times new roman", Font.BOLD, 12));

        text_greutate.setBorder(new LineBorder(Color.DARK_GRAY));
        text_greutate.setForeground(Color.yellow);
        text_greutate.setOpaque(false);

        text_greutate.setForeground(Color.yellow);
        text_greutate.setFont(new Font("Times new roman", Font.BOLD, 12));


        mesaj.setFont(new Font(null, Font.ITALIC, 17));
        NextButton4.addActionListener(this);
        frame.add(inaltime);
        frame.add(mesaj);
        frame.add(text_inaltime);
        frame.add(greutate);
        frame.add(text_greutate);
        frame.add(NextButton4);

    }

    public void set5_intrebari_slabit() {
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel greutate_dorita = new JLabel("Greutate dorita");

        greutate_dorita.setForeground(Color.yellow);
        greutate_dorita.setFont(new Font("Times new roman", Font.BOLD, 12));

        greutate_dorita.setBounds(50, 50, 150, 25);
        text_greutate_dorita.setBounds(50, 75, 100, 25);
        JLabel weekly_goal = new JLabel("Care este idealul unei saptamani");
        weekly_goal.setBounds(50, 150, 150, 25);
        slabit025 = new JRadioButton("Slabeste 0.25 kg saptamanal");
        slabit05 = new JRadioButton("Slabeste 0.5 kg saptamanal");
        slabit075 = new JRadioButton("Slabeste 0.75 kg saptamanal");
        slabit1kg = new JRadioButton("Slabeste 1 kg saptamanal");

        weekly_goal.setForeground(Color.yellow);
        weekly_goal.setFont(new Font("Times new roman", Font.BOLD, 12));

        slabit025.setForeground(Color.yellow);
        slabit025.setFont(new Font("Times new roman", Font.BOLD, 12));

        slabit025.setBorder(new LineBorder(Color.DARK_GRAY));
        slabit025.setForeground(Color.yellow);
        slabit025.setOpaque(false);

        slabit05.setForeground(Color.yellow);
        slabit05.setFont(new Font("Times new roman", Font.BOLD, 12));

        slabit05.setBorder(new LineBorder(Color.DARK_GRAY));
        slabit05.setForeground(Color.yellow);
        slabit05.setOpaque(false);

        slabit075.setForeground(Color.yellow);
        slabit075.setFont(new Font("Times new roman", Font.BOLD, 12));

        slabit075.setBorder(new LineBorder(Color.DARK_GRAY));
        slabit075.setForeground(Color.yellow);
        slabit075.setOpaque(false);

        slabit1kg.setForeground(Color.yellow);
        slabit1kg.setFont(new Font("Times new roman", Font.BOLD, 12));

        slabit1kg.setBorder(new LineBorder(Color.DARK_GRAY));
        slabit1kg.setForeground(Color.yellow);
        slabit1kg.setOpaque(false);


        ButtonGroup group = new ButtonGroup();
        group.add(slabit025);
        group.add(slabit05);
        group.add(slabit075);
        group.add(slabit1kg);
        slabit025.setBounds(50, 175, 200, 20);
        slabit05.setBounds(50, 195, 200, 20);
        slabit075.setBounds(50, 215, 200, 20);
        slabit1kg.setBounds(50, 235, 200, 20);
        NextButton5.setBounds(50, 260, 200, 25);
        mesaj.setBounds(50, 300, 350, 35);
        NextButton5.setBorder(new LineBorder(Color.DARK_GRAY));
        NextButton5.setForeground(Color.yellow);
        NextButton5.setContentAreaFilled(false);
        NextButton5.setOpaque(false);
        mesaj.setFont(new Font(null, Font.ITALIC, 17));

        NextButton5.addActionListener(this);
        frame.add(greutate_dorita);
        frame.add(text_greutate_dorita);
        frame.add(weekly_goal);
        frame.add(slabit025);
        frame.add(slabit05);
        frame.add(slabit075);
        frame.add(slabit1kg);
        frame.add(NextButton5);
        frame.add(mesaj);
    }

    public void set5_intrebari_ingrasare() {
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel greutate_dorita = new JLabel("Greutate dorita");

        greutate_dorita.setForeground(Color.yellow);
        greutate_dorita.setFont(new Font("Times new roman", Font.BOLD, 12));

        greutate_dorita.setBounds(50, 50, 150, 25);
        text_greutate_dorita.setBounds(50, 75, 100, 25);
        JLabel weekly_goal = new JLabel("Care este idealul unei saptamani");
        weekly_goal.setBounds(50, 150, 150, 25);
        ing025 = new JRadioButton("Punerere in greutate 0.25 kg saptamanal");
        ing05 = new JRadioButton("punere in greutate 0.5 kg saptamanal");

        weekly_goal.setForeground(Color.yellow);
        weekly_goal.setFont(new Font("Times new roman", Font.BOLD, 12));

        ing025.setForeground(Color.yellow);
        ing025.setFont(new Font("Times new roman", Font.BOLD, 12));

        ing025.setBorder(new LineBorder(Color.DARK_GRAY));
        ing025.setForeground(Color.yellow);
        ing025.setOpaque(false);

        ing05.setForeground(Color.yellow);
        ing05.setFont(new Font("Times new roman", Font.BOLD, 12));

        ing05.setBorder(new LineBorder(Color.DARK_GRAY));
        ing05.setForeground(Color.yellow);
        ing05.setOpaque(false);

        ButtonGroup group = new ButtonGroup();
        group.add(ing025);
        group.add(ing05);

        ing025.setBounds(50, 175, 200, 20);
        ing05.setBounds(50, 195, 200, 20);
        NextButton5.setBounds(50, 260, 200, 25);
        mesaj.setBounds(50, 300, 350, 35);
        NextButton5.setBorder(new LineBorder(Color.DARK_GRAY));
        NextButton5.setForeground(Color.yellow);
        NextButton5.setContentAreaFilled(false);
        NextButton5.setOpaque(false);
        mesaj.setFont(new Font(null, Font.ITALIC, 17));

        NextButton5.addActionListener(this);
        frame.add(greutate_dorita);
        frame.add(text_greutate_dorita);
        frame.add(weekly_goal);
        frame.add(ing025);
        frame.add(ing05);
        frame.add(NextButton5);
        frame.add(mesaj);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RegisterButton) {
            if (!(userIDField.getText().isEmpty() || userPasswordField.getText().isEmpty() || verify_pass.getText().isEmpty() || text_email.getText().isEmpty() || NumeField.getText().isEmpty())) {

                String passText = new String(userPasswordField.getPassword());
                String verifypassText = new String(verify_pass.getPassword());
                if (passText.equals(verifypassText)) {
                    mesaj.setText("");
                    set1_intrebari();


                } else {
                    mesaj.setForeground(Color.red);

                    mesaj.setText("Parolele nu corespund!");
                }
            } else {
                mesaj.setForeground(Color.red);

                mesaj.setText("Toate campurile trebuiesc completate!");
            }
        }
        if (e.getSource() == NextButton1) {
            if ((rb1_slabit.isSelected() || rb2_mentinere.isSelected() || rb3_punere.isSelected()) && (text_email.getText().endsWith("@yahoo.com") || text_email.getText().endsWith("@gmail.com"))) {
                mesaj.setText("");
                set2_intrebari();
            } else {
                mesaj.setForeground(Color.red);
                if (!text_email.getText().endsWith("@yahoo.com") || !text_email.getText().endsWith("@gmail.com"))
                    mesaj.setText("Emailul nu este valid");
                else
                    mesaj.setText("Trebuie selectat minim 1 camp!");
            }
        }
        if (e.getSource() == NextButton2) {
            if (rb1_sedentar.isSelected() || rb2_usor.isSelected() || rb3_moderat.isSelected() || rb4_intens.isSelected()) {
                mesaj.setText("");
                set3_intrebari();
            } else {
                mesaj.setForeground(Color.red);

                mesaj.setText("Trebuie selectat minim 1 camp!");
            }
        }
        if (e.getSource() == NextButton3) {
            if (((masculin.isSelected() || feminin.isSelected()) && !AnNastere.getText().isEmpty())) {
                mesaj.setText("");
                set4_intrebari();
            } else {
                mesaj.setForeground(Color.red);

                mesaj.setText("Toate campurile trebuiesc completate!");
            }
        }
        if (e.getSource() == NextButton4) {

            if (!(text_greutate.getText().isEmpty() || text_inaltime.getText().isEmpty())) {
                mesaj.setText("");
                if (rb1_slabit.isSelected()) {
                    set5_intrebari_slabit();
                } else if (rb3_punere.isSelected()) {
                    set5_intrebari_ingrasare();
                }
            } else {
                mesaj.setForeground(Color.red);

                mesaj.setText("Toate campurile trebuiesc completate!");
            }
        }
        if (e.getSource() == NextButton5 || (rb2_mentinere.isSelected() && !text_inaltime.getText().isEmpty())) {
            try {

                Connection conn = ConnectionDB.CreateConnection();
                try {
                    try {
                        user.setGreutate_dorita(Integer.parseInt(text_greutate_dorita.getText()));
                        user.setGreutate_dorita(Integer.parseInt(text_greutate_dorita.getText()));
                        user.setGreutate(Integer.parseInt(text_greutate.getText()));
                        user.setInaltime(Integer.parseInt(text_inaltime.getText()));
                    } catch (Exception nfe) {
                        System.err.println("Invalid string");
                        //nfe.printStackTrace();
                    }
                    user.setEmail(text_email.getText());
                    user.setTara(comboCountry.getSelectedItem().toString());
                    user.setScop(getSelectedButtonText(group_scop));
                    user.setActivitate(getSelectedButtonText(group_activitate));
                    user.setSex(getSelectedButtonText(group_sex));

                    Statement st = conn.createStatement();
                    String passText = new String(userPasswordField.getPassword());
                    //String Query = " INSERT INTO DateConectare () VALUES ( '" + userIDField.getText() + "', " + passText + " ) ";
                    user.setNume(NumeField.getText());
                    user.setVarsta(Integer.parseInt(AnNastere.getText()));
                    String Query = " INSERT INTO [User_2] ( [Username],[Password]) VALUES ( '" + userIDField.getText() + "', '" + passText + "')";
                    String scope = "SCOPE_IDENTITY()";
                    String query_date = " INSERT INTO [Date_User] ( [Id],[Nume],[Email],[Activitate],[Scop],[Greutate],[Greutate_dorita],[Inaltime],[Sex],[Varsta],[Tara]) VALUES ( " + scope + ", '" + user.getNume() + "', '" + user.getEmail() + "', '" + user.getActivitate() + "', '" + user.getScop() + "', " + user.getGreutate() + ", "
                            + user.getGreutate_dorita() + ", " + user.getInaltime() + ", '" + user.getSex() + "', " + user.getVarsta() + " , '" + user.getTara() + "' ) ";
                    System.out.println(query_date);
                    System.out.println(Query);
                    st.execute(Query);
                    st.execute(query_date);

                    //st.execute(query_user);
                } catch (SQLException d) {
                    d.printStackTrace();
                }
                FirstPage primapagina = new FirstPage();
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
