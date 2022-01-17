package Proiect;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Objects;

public class MainPage extends Frame implements ActionListener {
    JMenuBar meniu = new JMenuBar();
    JMenu menu_alimente, menu_meniu, menu_user;
    JMenuItem menu_item_adauga_elem, menu_item_sterge_elem, menu_item_modifica_elem, menu_item_vizualizare_elem, meniu_creaza_masa, meniu_modifica_user;
    JLabel Titlu, grasimi, glucide, proteine, sare, fibre, nume_produs, valoare_energetica;
    JTextField f_grasimi, f_glucide, f_proteine, f_sare, f_fibre, f_nume_produs, f_valoare_evergetica;
    JTextField f_nume, f_email, f_greutate, f_greutate_dorita, f_inaltime, f_sex, f_varsta;
    JPasswordField f_parola;
    JButton adauga, sterge, button_stege_aliment, button_back, button_modifica_aliment, modifica_user;
    JLabel messageLabel = new JLabel();
    JTable tabel_alimente;
    JComboBox<String> nume_alimente;
    int id;

    MainPage(Integer id_user) {
        id = id_user;
        frame.getContentPane().removeAll();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
        menu_alimente = new JMenu("Aliment");
        menu_alimente.setMnemonic(KeyEvent.VK_A);
        menu_alimente.getAccessibleContext().setAccessibleDescription(
                "Creare/stergere de alimente");
        meniu.add(menu_alimente);

        menu_meniu = new JMenu("Meniu");
        menu_meniu.setMnemonic(KeyEvent.VK_A);
        menu_meniu.getAccessibleContext().setAccessibleDescription(
                "Creare/stergere de meniu");
        meniu.add(menu_meniu);

        meniu_modifica_user = new JMenuItem("Moidfica User",
                KeyEvent.VK_T);


        menu_user = new JMenu("User");
        menu_user.setMnemonic(KeyEvent.VK_A);
        menu_user.getAccessibleContext().setAccessibleDescription(
                "Creare/stergere de User");
        meniu.add(menu_user);
        meniu_modifica_user.getAccessibleContext().setAccessibleDescription(
                "Adauga aliment");
        menu_user.add(meniu_modifica_user);
        meniu_modifica_user.addActionListener(this);
        menu_item_adauga_elem = new JMenuItem("Adauga aliment",
                KeyEvent.VK_T);

        menu_item_adauga_elem.getAccessibleContext().setAccessibleDescription(
                "Adauga aliment");
        menu_alimente.add(menu_item_adauga_elem);
        menu_item_adauga_elem.addActionListener(this);

        menu_item_sterge_elem = new JMenuItem("Sterge aliment",
                KeyEvent.VK_T);

        menu_item_sterge_elem.getAccessibleContext().setAccessibleDescription(
                "Sterge aliment");
        menu_alimente.add(menu_item_sterge_elem);
        menu_item_sterge_elem.addActionListener(this);

        menu_item_modifica_elem = new JMenuItem("Modifica aliment",
                KeyEvent.VK_T);

        menu_item_modifica_elem.getAccessibleContext().setAccessibleDescription(
                "Modifica aliment");
        menu_alimente.add(menu_item_modifica_elem);
        menu_item_modifica_elem.addActionListener(this);

        menu_item_vizualizare_elem = new JMenuItem("Vizualizare alimente",
                KeyEvent.VK_T);
        menu_item_vizualizare_elem.getAccessibleContext().setAccessibleDescription(
                "Vizualicare alimente");
        menu_alimente.add(menu_item_vizualizare_elem);
        menu_item_vizualizare_elem.addActionListener(this);

        meniu_creaza_masa = new JMenuItem("Creeaza masa ",
                KeyEvent.VK_T);

        meniu_creaza_masa.getAccessibleContext().setAccessibleDescription(
                "Creeaza masa");
        menu_meniu.add(meniu_creaza_masa);
        meniu_creaza_masa.addActionListener(this);

        frame.setJMenuBar(meniu);
    }

    public void adauga_alimnet() {
        frame.getContentPane().removeAll();
        frame.repaint();
        // frame.setVisible(true);
        frame.setSize(700, 700);
        //frame.setLayout(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Titlu = new JLabel("Adauga element:");
        Titlu.setForeground(Color.red);
        Titlu.setFont(new Font("Times new roman", Font.BOLD, 20));
        nume_produs = new JLabel("Name produs:");
        nume_produs.setForeground(Color.yellow);
        valoare_energetica = new JLabel("Valoare energetica:");
        valoare_energetica.setForeground(Color.yellow);
        grasimi = new JLabel("Grasimi:");
        grasimi.setForeground(Color.yellow);
        glucide = new JLabel("Glucide:");
        glucide.setForeground(Color.yellow);
        fibre = new JLabel("Fibre:");
        fibre.setForeground(Color.yellow);
        proteine = new JLabel("Proteine");
        proteine.setForeground(Color.yellow);
        sare = new JLabel("Sare");
        sare.setForeground(Color.yellow);
        f_nume_produs = new JTextField();
        f_valoare_evergetica = new JTextField();
        f_grasimi = new JTextField();
        f_glucide = new JTextField();
        f_fibre = new JTextField();
        f_proteine = new JTextField();
        f_sare = new JTextField();
        adauga = new JButton("Adauga");
        sterge = new JButton("Sterge");
        adauga.setBorder(new LineBorder(Color.yellow));
        sterge.setBorder(new LineBorder(Color.yellow));
        adauga.setForeground(Color.yellow);
        sterge.setForeground(Color.yellow);
        adauga.addActionListener(this);
        sterge.addActionListener(this);
        adauga.setOpaque(false);
        adauga.setContentAreaFilled(false);
        sterge.setOpaque(false);
        sterge.setContentAreaFilled(false);
        adauga.setBorder(new LineBorder(Color.DARK_GRAY));
        sterge.setBorder(new LineBorder(Color.DARK_GRAY));

        Titlu.setBounds(100, 30, 400, 30);
        nume_produs.setBounds(80, 70, 200, 30);
        valoare_energetica.setBounds(80, 110, 200, 30);
        grasimi.setBounds(80, 150, 200, 30);
        glucide.setBounds(80, 190, 200, 30);
        fibre.setBounds(80, 230, 200, 30);
        proteine.setBounds(80, 270, 200, 30);
        sare.setBounds(80, 310, 200, 30);
        f_nume_produs.setBounds(300, 70, 200, 30);
        f_valoare_evergetica.setBounds(300, 110, 200, 30);
        f_grasimi.setBounds(300, 150, 200, 30);
        f_glucide.setBounds(300, 190, 200, 30);
        f_fibre.setBounds(300, 230, 200, 30);
        f_proteine.setBounds(300, 270, 200, 30);
        f_sare.setBounds(300, 310, 200, 30);
        adauga.setBounds(50, 350, 100, 30);
        sterge.setBounds(170, 350, 100, 30);
        frame.add(Titlu);
        frame.add(nume_produs);
        frame.add(valoare_energetica);
        frame.add(grasimi);
        frame.add(glucide);
        frame.add(fibre);
        frame.add(proteine);
        frame.add(sare);
        frame.add(f_nume_produs);
        frame.add(f_valoare_evergetica);
        frame.add(f_grasimi);
        frame.add(f_glucide);
        frame.add(f_fibre);
        frame.add(f_proteine);
        frame.add(f_sare);
        frame.add(adauga);
        frame.add(sterge);
        //  frame.setVisible(true);

    }

    public void vizualirea_elem() {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setSize(1000, 600);
        SwingUtilities.updateComponentTreeUI(frame);
        tabel_alimente.setBounds(30, 50, 500, 300);
        JScrollPane sp = new JScrollPane(tabel_alimente);
        sp.setBounds(30, 50, 700, 300);
        //frame.add(tabel_alimente);
        frame.getContentPane().add(sp);
    }

    public void box_nume_alimente() {
        try {
            Connection conn = ConnectionDB.CreateConnection();
            PreparedStatement st = (PreparedStatement) conn
                    .prepareStatement("Select * from [Aliment_2] where [Id_ALIMENT] = " +"'"+id+"'");

            PreparedStatement st_nr_randuri = (PreparedStatement) conn
                    .prepareStatement("Select count(*) as nr from [Aliment_2] where [Id_ALIMENT] = " +"'"+id+"'");

            ResultSet rs_nr_randuri = st_nr_randuri.executeQuery();
            int nr_randuri = 0;
            try {
                rs_nr_randuri.next();
                String nr = rs_nr_randuri.getString("nr");
                nr_randuri = Integer.parseInt(nr);
            } catch (Exception E) {
                E.printStackTrace();
            }
            ResultSet rs = st.executeQuery();
            String[] string_nume_alimente = new String[nr_randuri];
            int k = 0;
            while (rs.next()) {
                //  String[] data = {rs.getString("Nume"), rs.getString("Valoare Energetica"), rs.getString("Grasimi"),
                //        rs.getString("Glucide"), rs.getString("Fibre"), rs.getString("Proteine"), rs.getString("Sare")};
                String nume = rs.getString("Nume");

                string_nume_alimente[k++] = nume;
            }
            try {
                nume_alimente = new JComboBox<String>(string_nume_alimente);
            } catch (Exception eroare) {
                eroare.printStackTrace();
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void sterge_aliment() {
        box_nume_alimente();
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setSize(500, 500);
        SwingUtilities.updateComponentTreeUI(frame);

        nume_alimente.setBounds(30, 50, 300, 30);
        button_stege_aliment = new JButton("Sterge");
        button_back = new JButton("Inapoi");
        button_back.setBounds(100, 100, 100, 25);
        button_stege_aliment.setBounds(250, 100, 100, 25);
        button_stege_aliment.addActionListener(this);
        button_back.addActionListener(this);
        frame.add(button_back);
        frame.add(button_stege_aliment);
        frame.add(nume_alimente);
    }

    public void modifica_alimente() {
        box_nume_alimente();
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setSize(600, 500);
        SwingUtilities.updateComponentTreeUI(frame);

        nume_alimente.setBounds(30, 50, 300, 30);

        nume_produs = new JLabel("Name produs:");
        nume_produs.setForeground(Color.yellow);
        valoare_energetica = new JLabel("Valoare energetica:");
        valoare_energetica.setForeground(Color.yellow);
        grasimi = new JLabel("Grasimi:");
        grasimi.setForeground(Color.yellow);
        glucide = new JLabel("Glucide:");
        glucide.setForeground(Color.yellow);
        fibre = new JLabel("Fibre:");
        fibre.setForeground(Color.yellow);
        proteine = new JLabel("Proteine");
        proteine.setForeground(Color.yellow);
        sare = new JLabel("Sare");
        sare.setForeground(Color.yellow);
        f_nume_produs = new JTextField();
        f_valoare_evergetica = new JTextField();
        f_grasimi = new JTextField();
        f_glucide = new JTextField();
        f_fibre = new JTextField();
        f_proteine = new JTextField();
        f_sare = new JTextField();
        button_modifica_aliment = new JButton("Modifica");
        sterge = new JButton("Sterge");
        button_modifica_aliment.setBorder(new LineBorder(Color.yellow));
        sterge.setBorder(new LineBorder(Color.yellow));
        button_modifica_aliment.setForeground(Color.yellow);
        sterge.setForeground(Color.yellow);
        button_modifica_aliment.addActionListener(this);
        sterge.addActionListener(this);
        button_modifica_aliment.setOpaque(false);
        button_modifica_aliment.setContentAreaFilled(false);
        sterge.setOpaque(false);
        sterge.setContentAreaFilled(false);
        button_modifica_aliment.setBorder(new LineBorder(Color.DARK_GRAY));
        sterge.setBorder(new LineBorder(Color.DARK_GRAY));

        nume_produs.setBounds(80, 70, 200, 30);
        valoare_energetica.setBounds(80, 110, 200, 30);
        grasimi.setBounds(80, 150, 200, 30);
        glucide.setBounds(80, 190, 200, 30);
        fibre.setBounds(80, 230, 200, 30);
        proteine.setBounds(80, 270, 200, 30);
        sare.setBounds(80, 310, 200, 30);
        nume_alimente.setBounds(300, 30, 200, 30);
        f_valoare_evergetica.setBounds(300, 110, 200, 30);
        f_grasimi.setBounds(300, 150, 200, 30);
        f_glucide.setBounds(300, 190, 200, 30);
        f_fibre.setBounds(300, 230, 200, 30);
        f_proteine.setBounds(300, 270, 200, 30);
        f_sare.setBounds(300, 310, 200, 30);
        f_nume_produs.setBounds(300, 70, 200, 30);
        button_modifica_aliment.setBounds(50, 350, 100, 30);
        sterge.setBounds(170, 350, 100, 30);
        frame.add(nume_produs);
        frame.add(valoare_energetica);
        frame.add(grasimi);
        frame.add(glucide);
        frame.add(fibre);
        frame.add(proteine);
        frame.add(sare);
        frame.add(nume_alimente);
        frame.add(f_valoare_evergetica);
        frame.add(f_grasimi);
        frame.add(f_glucide);
        frame.add(f_nume_produs);
        frame.add(f_fibre);
        frame.add(f_proteine);
        frame.add(f_sare);
        frame.add(button_modifica_aliment);
        frame.add(sterge);
    }

    public void creeaza_masa() {
        frame.getContentPane().removeAll();
        frame.repaint();
        // frame.setVisible(true);
        frame.setSize(700, 700);


    }

    public void modifica_user() {
        frame.getContentPane().removeAll();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
        JLabel nume = null, parola = null, inaltime = null, greutate = null, greutate_dorita = null, sex, varsta = null, email = null;
        // frame.setVisible(true);
        System.out.println(id);
        frame.setSize(700, 550);
        try {

            Connection conn = ConnectionDB.CreateConnection();
            PreparedStatement st = (PreparedStatement) conn
                    .prepareStatement("Select * from [Date_User] WHERE Id=" + "'" + id + "'");
            ResultSet rs = st.executeQuery();
            st = (PreparedStatement) conn
                    .prepareStatement("Select Password from [User_2] WHERE Id=" + "'" + id + "'");
            ResultSet rs_user = st.executeQuery();
            while (rs.next() && rs_user.next()) {
                String nume_bd = rs.getString("Nume");
                String parola_bd = rs_user.getString("Password");
                String Email_nd = rs.getString("Email");
                int greutate_bd = rs.getInt("Greutate");
                int Greutate_dorita_bd = rs.getInt("Greutate_dorita");
                int inaltime_bd = rs.getInt("Inaltime");
                int varsta_bd = rs.getInt("Varsta");
                String sex_bd = rs.getString("Sex");
                parola = new JLabel("Parola: " + parola_bd);
                inaltime = new JLabel("Inaltime: " + String.valueOf(inaltime_bd));
                email = new JLabel("Email: " + Email_nd);
                greutate = new JLabel("Greutate: " + String.valueOf(greutate_bd));
                greutate_dorita = new JLabel("Greutate Dorita: " + String.valueOf(Greutate_dorita_bd));
                varsta = new JLabel("Varsta: " + String.valueOf(varsta_bd));

                nume = new JLabel("Nume: " + nume_bd);
                System.out.println("Username: " + nume_bd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        f_nume = new JTextField();
        f_parola = new JPasswordField();
        f_email = new JTextField();
        f_greutate = new JTextField();
        f_greutate_dorita = new JTextField();
        f_inaltime = new JTextField();
        f_varsta = new JTextField();
        modifica_user = new JButton("Modifica");

        parola.setBounds(50, 50, 200, 50);
        nume.setBounds(50, 100, 200, 50);
        email.setBounds(50, 150, 200, 50);
        greutate.setBounds(50, 200, 200, 50);
        greutate_dorita.setBounds(50, 250, 200, 50);
        inaltime.setBounds(50, 300, 200, 50);
        varsta.setBounds(50, 350, 200, 50);
        f_nume.setBounds(300, 110, 200, 25);
        f_parola.setBounds(300, 60, 200, 25);
        f_email.setBounds(300, 160, 200, 25);
        f_greutate.setBounds(300, 210, 200, 25);
        f_greutate_dorita.setBounds(300, 260, 200, 25);
        f_inaltime.setBounds(300, 310, 200, 25);
        f_varsta.setBounds(300, 360, 200, 25);
        modifica_user.setBounds(250, 410, 200, 25);
        modifica_user.addActionListener(this);
        parola.setForeground(Color.yellow);
        parola.setFont(new Font("Times new roman", Font.BOLD, 12));

        nume.setForeground(Color.yellow);
        nume.setFont(new Font("Times new roman", Font.BOLD, 12));

        email.setForeground(Color.yellow);
        email.setFont(new Font("Times new roman", Font.BOLD, 12));

        greutate.setForeground(Color.yellow);
        greutate.setFont(new Font("Times new roman", Font.BOLD, 12));

        greutate_dorita.setForeground(Color.yellow);
        greutate_dorita.setFont(new Font("Times new roman", Font.BOLD, 12));

        inaltime.setForeground(Color.yellow);
        inaltime.setFont(new Font("Times new roman", Font.BOLD, 12));

        varsta.setForeground(Color.yellow);
        varsta.setFont(new Font("Times new roman", Font.BOLD, 12));


        modifica_user.setForeground(Color.yellow);
        modifica_user.setOpaque(false);
        modifica_user.setContentAreaFilled(false);

        frame.add(nume);
        frame.add(parola);
        frame.add(email);
        frame.add(greutate);
        frame.add(greutate_dorita);
        frame.add(inaltime);
        frame.add(varsta);
        frame.add(f_nume);
        frame.add(f_parola);
        frame.add(f_email);
        frame.add(f_greutate);
        frame.add(f_greutate_dorita);
        frame.add(f_inaltime);
        frame.add(f_varsta);
        frame.add(modifica_user);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu_item_adauga_elem) {
            adauga_alimnet();
        }
        if (e.getSource() == adauga) {
            if (!(f_nume_produs.getText().isEmpty() || f_valoare_evergetica.getText().isEmpty() || f_grasimi.getText().isEmpty() || f_glucide.getText().isEmpty() || f_fibre.getText().isEmpty() || f_proteine.getText().isEmpty() || f_sare.getText().isEmpty())) {
                Connection conn = ConnectionDB.CreateConnection();
                try {
                    Statement st = conn.createStatement();
                    String Query = " INSERT INTO [Aliment_2] ( [Id_ALIMENT],[Nume],[Valoare Energetica],[Grasimi],[Glucide],[Fibre],[Proteine],[Sare] ) VALUES ( " + id + ",'" + f_nume_produs.getText() + "', " + f_valoare_evergetica.getText() + ", " + f_grasimi.getText() + ", " + f_glucide.getText() + ", " + f_fibre.getText() + ", " + f_proteine.getText() + ", " + f_sare.getText() + " ) ";
                    System.out.println(Query);
                    st.execute(Query);
                    messageLabel.setForeground(Color.BLACK);
                    JOptionPane.showMessageDialog(messageLabel, "Aliment adaugat cu succes!");
                    MainPage main = new MainPage(id);
                } catch (SQLException SQL_EXCEPTION) {
                    SQL_EXCEPTION.printStackTrace();
                }
            } else {
                messageLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(messageLabel, "Toate campurile trebuiesc completate!");
            }
        }
        if (e.getSource() == menu_item_vizualizare_elem) {
            try {
                Connection conn = ConnectionDB.CreateConnection();
                PreparedStatement st = (PreparedStatement) conn
                        .prepareStatement("Select Nume,[Valoare Energetica],Grasimi,Glucide,Fibre,Proteine,Sare from [Aliment_2] where Id_ALIMENT=" + id);

                ResultSet rs = st.executeQuery();
                String[] columnNames = {"Nume Aliment", "Valoare Energetica", "Grasimi", "Glucide", "Fibre", "Proteine", "Sare"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                tabel_alimente = new JTable(tableModel);
                //tableModel.addColumn("Nume");
                int k = 0;
                while (rs.next()) {
                    //  String[] data = {rs.getString("Nume"), rs.getString("Valoare Energetica"), rs.getString("Grasimi"),
                    //        rs.getString("Glucide"), rs.getString("Fibre"), rs.getString("Proteine"), rs.getString("Sare")};
                    String nume = rs.getString("Nume");
                    String val = rs.getString("Valoare Energetica");
                    String grasimi = rs.getString("Grasimi");
                    String glucide = rs.getString("Glucide");
                    String fibre = rs.getString("Fibre");
                    String proteine = rs.getString("Proteine");
                    String sare = rs.getString("Sare");
                    String[] data = {nume, val, grasimi, glucide, fibre, proteine, sare};
                    tableModel.addRow(data);

                }
                //  tanel_alimente = new JTable(tableModel);

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

            vizualirea_elem();
        }
        if (e.getSource() == sterge) {
            f_nume_produs.setText("");
            f_valoare_evergetica.setText("");
            f_grasimi.setText("");
            f_glucide.setText("");
            f_fibre.setText("");
            f_proteine.setText("");
            f_sare.setText("");
        }
        if (e.getSource() == menu_item_sterge_elem) {
            sterge_aliment();
        }
        if (e.getSource() == button_stege_aliment) {
            Connection conn = ConnectionDB.CreateConnection();
            try {
                Statement st = Objects.requireNonNull(conn).createStatement();
                String nume_aliment_sters = Objects.requireNonNull(nume_alimente.getSelectedItem()).toString();
                String Query = "DELETE FROM [Aliment_2] WHERE (Nume=" + "'" + nume_aliment_sters + "' and [Id_ALIMENT]=" + "'" + id + "')" ;
                System.out.println(Query);
                st.execute(Query);
                messageLabel.setForeground(Color.BLACK);
                JOptionPane.showMessageDialog(messageLabel, "Aliment sters cu succes!");
                MainPage main = new MainPage(id);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }
        if (e.getSource() == button_back) {
            MainPage ah = new MainPage(id);
        }
        if (e.getSource() == menu_item_modifica_elem) {
            modifica_alimente();
        }
        if (e.getSource() == button_modifica_aliment) {
            Connection conn = ConnectionDB.CreateConnection();
            try {
                Statement st = Objects.requireNonNull(conn).createStatement();
                //String Query = "DELETE FROM [Aliment] WHERE Nume=" + "'" + nume_aliment_sters + "'";
                if (!f_sare.getText().isEmpty()) {
                    String Query = "UPDATE [Aliment_2] SET Sare=" + "'" + f_sare.getText() + "'" + "WHERE (Nume=" + "'" + nume_alimente.getSelectedItem().toString() + "' and Id_ALIMENT=" +"'"+id+"')";
                    st.execute(Query);
                }
                if (!f_proteine.getText().isEmpty()) {
                    String Query = "UPDATE [Aliment_2] SET Proteine=" + "'" + f_proteine.getText() + "'" + "WHERE (Nume=" + "'" + nume_alimente.getSelectedItem().toString() + "'and Id_ALIMENT=" +"'"+id+"')";
                    st.execute(Query);
                }
                if (!f_fibre.getText().isEmpty()) {
                    String Query = "UPDATE [Aliment_2] SET Fibre=" + "'" + f_fibre.getText() + "'" + "WHERE (Nume=" + "'" + nume_alimente.getSelectedItem().toString() + "'and Id_ALIMENT=" +"'"+id+"')";
                    st.execute(Query);
                }
                if (!f_glucide.getText().isEmpty()) {
                    String Query = "UPDATE [Aliment_2] SET Glucide=" + "'" + f_glucide.getText() + "'" + "WHERE (Nume=" + "'" + nume_alimente.getSelectedItem().toString() + "'and Id_ALIMENT=" +"'"+id+"')";
                    st.execute(Query);
                }
                if (!f_grasimi.getText().isEmpty()) {
                    String Query = "UPDATE [Aliment_2] SET Grasimi=" + "'" + f_grasimi.getText() + "'" + "WHERE (Nume=" + "'" + nume_alimente.getSelectedItem().toString() + "'and Id_ALIMENT=" +"'"+id+"')";
                    st.execute(Query);
                }
                if (!f_valoare_evergetica.getText().isEmpty()) {
                    String Query = "UPDATE [Aliment_2] SET [Valoare Energetica]=" + "'" + f_valoare_evergetica.getText() + "'" + "WHERE (Nume=" + "'" + nume_alimente.getSelectedItem().toString() + "'and Id_ALIMENT=" +"'"+id+"')";
                    st.execute(Query);
                }
                if (!f_nume_produs.getText().isEmpty()) {
                    String Query = "UPDATE [Aliment_2] SET [Nume]=" + "'" + f_nume_produs.getText() + "'" + "WHERE Nume=" + "'" + nume_alimente.getSelectedItem().toString() + "'and Id_ALIMENT= " +"'"+id+"'";
                    st.execute(Query);
                }
                messageLabel.setForeground(Color.BLACK);
                JOptionPane.showMessageDialog(messageLabel, "Aliment modificat cu succes!");
                MainPage main = new MainPage(id);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }
        if (e.getSource() == meniu_creaza_masa) {
            creeaza_masa();
        }
        if (e.getSource() == meniu_modifica_user) {
            modifica_user();
        }
        if (e.getSource() == modifica_user) {
            Connection conn = ConnectionDB.CreateConnection();
            try {
                Statement st = Objects.requireNonNull(conn).createStatement();
                if (!f_nume.getText().isEmpty()) {
                    String Query = "UPDATE [Date_User] SET Nume=" + "'" + f_nume.getText() + "'" + "WHERE Id=" + "'" + id + "'";
                    st.execute(Query);
                }
                if (!f_parola.getText().isEmpty()) {
                    String Query = "UPDATE [User_2] SET Password=" + "'" + f_parola.getText() + "'" + "WHERE Id=" + "'" + id + "'";
                    st.execute(Query);
                }
                if (!f_email.getText().isEmpty()) {
                    String Query = "UPDATE [Date_User] SET Email=" + "'" + f_email.getText() + "'" + "WHERE Id=" + "'" + id + "'";
                    st.execute(Query);
                }
                if (!f_greutate.getText().isEmpty()) {
                    String Query = "UPDATE [Date_User] SET Greutate=" + "'" + f_greutate.getText() + "'" + "WHERE Id=" + "'" + id + "'";
                    st.execute(Query);
                }
                if (!f_greutate_dorita.getText().isEmpty()) {
                    String Query = "UPDATE [Date_User] SET Greutate_dorita=" + "'" + f_greutate_dorita.getText() + "'" + "WHERE Id=" + "'" + id + "'";
                    st.execute(Query);
                }
                if (!f_inaltime.getText().isEmpty()) {
                    String Query = "UPDATE [Date_User] SET Inaltime=" + "'" + f_inaltime.getText() + "'" + "WHERE Id=" + "'" + id + "'";
                    st.execute(Query);
                }
                if (!f_varsta.getText().isEmpty()) {
                    String Query = "UPDATE [Date_User] SET Varsta=" + "'" + f_varsta.getText() + "'" + "WHERE Id=" + "'" + id + "'";
                    st.execute(Query);
                }
                messageLabel.setForeground(Color.BLACK);
                JOptionPane.showMessageDialog(messageLabel, "Datele au fost modificate cu succes!");
                MainPage main = new MainPage(id);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }


    }
}
