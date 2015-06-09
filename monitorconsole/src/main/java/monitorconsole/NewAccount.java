/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorconsole;

/**
 *
 * @author akis
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewAccount extends JFrame {

    private void addButtonsListeners(JButton jButton1, JButton jButton2) {
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
    }

    void addTextFieldListeners(final JTextField jLogin) {
        jLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jLogin.getText().equals("* Required field!")) {
                    jLogin.setText("");
                    jLogin.setForeground(Color.black);
                }
            }
        });
    }

    private void addPasswordFieldListeners(final JPasswordField jPasswordField1, final JPasswordField jPasswordField2) {
        jPasswordField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jPasswordField1.getForeground().getRed() == 255) {
                    jPasswordField1.setText("");
                    jPasswordField1.setForeground(Color.black);
                }
            }
        });
        jPasswordField2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jPasswordField2.getForeground().getRed() == 255) {
                    jPasswordField2.setText("");
                    jPasswordField2.setForeground(Color.black);
                }
            }
        });
    }

    private void drowButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        jButton1 = new JButton("OK");
        jButton2 = new JButton("Cancal");
        buttonPanel.add(jButton1);
        buttonPanel.add(jButton2);
        addButtonsListeners(jButton1, jButton2);
        center.add(buttonPanel, gbc);
        this.add(center, BorderLayout.PAGE_END);
    }

    private void drowLabels() {
        JPanel textPanel = new JPanel(new GridLayout(3, 2));
        jLoginLabel = new JLabel("Type new login");
        jLogin = new JTextField(10);
        addTextFieldListeners(jLogin);
        textPanel.add(jLoginLabel);
        textPanel.add(jLogin);

        jPasswordLabel = new JLabel("Type new password");
        textPanel.add(jPasswordLabel);
        textPanel.add(jPasswordField1);

        jPasswordLabel2 = new JLabel("Retype password");
        textPanel.add(jPasswordLabel2);
        jPasswordField2 = new JPasswordField();
        textPanel.add(jPasswordField2);

        addPasswordFieldListeners(jPasswordField1, jPasswordField2);

        textCenter.add(textPanel, gbc);
        this.add(textCenter, BorderLayout.NORTH);
    }

    public NewAccount() {
        this.setSize(300, 200);
        this.setTitle("Add new account");
        setLocationRelativeTo(null);
//        setLocation(MainWindow.centerWindow(this)[0], MainWindow.centerWindow(this)[1]);
        drowButtons();
        drowLabels();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton1)
                        .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(156, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(121, 121, 121))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!Validation.isLoginProper(jLogin)) {
            JOptionPane.showMessageDialog(null, "Please update required login field");
            return;
        }
        if (!Validation.ifPasswordsExist(jPasswordField1, jPasswordField2)) {
            JOptionPane.showMessageDialog(null, "Please update required password fields");
            return;
        }
        if (!Validation.ifStrongPassword(jPasswordField1)) {
            JOptionPane.showMessageDialog(null, "The password must contain 8 characters (including at least one special character, one number and capital letter)");
            return;
        }
        if (!Validation.checkIfPasswordsMatches(jPasswordField1, jPasswordField2)) {
            System.out.println("Wszystko ok haslo zakodowane!");
            //Zapisz do bazy i zamknij okno jak sprawdzisz ze wszystko ok
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Passwords do not match!");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    private JLabel jLoginLabel;
    private JLabel jPasswordLabel;
    private final JPasswordField jPasswordField1 = new JPasswordField();
    private JLabel jPasswordLabel2;
    private JPasswordField jPasswordField2 = new JPasswordField();
    JPanel center = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    private JButton jButton2;
    private JTextField jLogin;
    JPanel textCenter = new JPanel(new GridBagLayout());
    private javax.swing.JButton jButton1;

}
