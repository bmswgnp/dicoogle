/**
 * Copyright (C) 2014  Universidade de Aveiro, DETI/IEETA, Bioinformatics Group - http://bioinformatics.ua.pt/
 *
 * This file is part of Dicoogle/dicoogle.
 *
 * Dicoogle/dicoogle is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dicoogle/dicoogle is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Dicoogle.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * UsersManager.java
 *
 * Created on 6/Abr/2010, 14:07:58
 */
package pt.ua.dicoogle.rGUI.client.windows;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pt.ua.dicoogle.rGUI.client.AdminRefs;
import pt.ua.dicoogle.rGUI.interfaces.controllers.IUsersManager;
import pt.ua.dicoogle.rGUI.server.users.HashService;

/**
 *
 * @author samuelcampos
 */
public class UsersManager extends javax.swing.JFrame {

    private static Semaphore sem = new Semaphore(1, true);
    private static UsersManager instance = null;
    private IUsersManager userManager;

    public static synchronized UsersManager getInstance() {
        try {
            sem.acquire();
            if (instance == null) {
                instance = new UsersManager();
            }
            sem.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
    public static Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }
    

    /** Creates new form UsersManager */
    private UsersManager() {
        initComponents();

        userManager = AdminRefs.getInstance().getUsersManager();

        load();
        
        Image image = Toolkit.getDefaultToolkit().getImage(Thread.currentThread().getContextClassLoader().getResource("trayicon.gif"));
        this.setIconImage(image);

        this.setTitle("User Accounts");

        jButtonRemove.setEnabled(false);
        jButtonReset.setEnabled(false);
    }

    private void load() {
        try {
            DefaultListModel model = (DefaultListModel) jListUsers.getModel();
            model.clear();

            ArrayList<String> list = userManager.getUsernames();
            
            for (int i = 0; i < list.size(); i++)
                model.addElement(list.get(i));

            jListUsers.setModel(model);

            jCheckBoxEncrypt.setSelected(userManager.getEncryptUsersFile());
        } catch (RemoteException ex) {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultListModel modelUsers = new DefaultListModel();
        jListUsers = new javax.swing.JList(modelUsers);
        jLabel1 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox = new javax.swing.JCheckBox();
        jTextUsername = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonWrite = new javax.swing.JButton();
        jCheckBoxEncrypt = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(413, 223));

        jListUsers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListUsersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListUsers);

        jLabel1.setText("List of Users:");

        jButtonAdd.setIcon(new ImageIcon(getImage("add.png")));
        jButtonAdd.setText("Add User");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRemove.setIcon(new ImageIcon(getImage("remove.png")));
        jButtonRemove.setText("Remove User");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        jCheckBox.setText("Administrator");

        jTextUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextUsernameKeyPressed(evt);
            }
        });

        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyPressed(evt);
            }
        });

        jButtonWrite.setIcon(new ImageIcon(getImage("floopy-icon.png")));
        jButtonWrite.setText("Save Configurations");
        jButtonWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWriteActionPerformed(evt);
            }
        });

        jCheckBoxEncrypt.setText("Encrypt the users file");
        jCheckBoxEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEncryptActionPerformed(evt);
            }
        });

        jButtonReset.setIcon(new ImageIcon(getImage("reset.png")));
        jButtonReset.setText("Reset Pass");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jButtonAdd)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonRemove, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonReset, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonWrite))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel2)
                                        .add(jLabel3))
                                    .add(24, 24, 24)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(jCheckBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(jPasswordField)
                                        .add(jTextUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jCheckBoxEncrypt))
                        .add(38, 38, 38)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(13, 13, 13)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(jTextUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(jPasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jCheckBox)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 39, Short.MAX_VALUE)
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jCheckBoxEncrypt)
                        .add(30, 30, 30))
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 181, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonRemove)
                    .add(jButtonReset)
                    .add(jButtonWrite)
                    .add(jButtonAdd))
                .add(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListUsersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListUsersValueChanged
        try {
            if(!jListUsers.isSelectionEmpty()){
                String username = (String) jListUsers.getSelectedValue();
                jTextUsername.setText(username);

                jCheckBox.setSelected(userManager.isAdmin(username));
                
                jCheckBox.setEnabled(false);
                //jPasswordField.setEnabled(false);
                jButtonAdd.setEnabled(false);
                jButtonRemove.setEnabled(true);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListUsersValueChanged

    private void jTextUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextUsernameKeyPressed
        jCheckBox.setEnabled(true);
        jPasswordField.setEnabled(true);
        jButtonAdd.setEnabled(true);
        jButtonRemove.setEnabled(false);
        jButtonReset.setEnabled(false);
        jListUsers.clearSelection();
    }//GEN-LAST:event_jTextUsernameKeyPressed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
            String passPlainText = new String(jPasswordField.getPassword());

            if (passPlainText.length() == 0){
                JOptionPane.showMessageDialog(this, "Password must have characters!",
                    "Password Empty", JOptionPane.INFORMATION_MESSAGE);

                return;
            }

            String passHash = HashService.getSHA1Hash(passPlainText);

            if(!userManager.addUser(jTextUsername.getText(), passHash, jCheckBox.isSelected()))
                JOptionPane.showMessageDialog(this, "Username already exists or invalid username or password!",
                    "Error Adding User", JOptionPane.ERROR_MESSAGE);

            load();
            
        } catch (RemoteException ex) {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        try {
            if (!userManager.deleteUser(jTextUsername.getText())) {
                JOptionPane.showMessageDialog(this, "Username doesn't exists or this user is the last administrator!", "Error Removing User", JOptionPane.ERROR_MESSAGE);
            }

            jCheckBox.setEnabled(true);
            jPasswordField.setEnabled(true);
            jButtonAdd.setEnabled(true);
            jButtonRemove.setEnabled(false);
            jButtonReset.setEnabled(false);
            jListUsers.clearSelection();
            
            load();
        } catch (RemoteException ex) {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWriteActionPerformed
        AdminRefs.getInstance().saveSettings();
}//GEN-LAST:event_jButtonWriteActionPerformed

    private void jCheckBoxEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEncryptActionPerformed
        try {
            userManager.setEncryptUsersFile(jCheckBoxEncrypt.isSelected());
        } catch (RemoteException ex) {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxEncryptActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        try {
            String passPlainText = new String(jPasswordField.getPassword());
            
            if (passPlainText.length() == 0) {
                JOptionPane.showMessageDialog(this, "Password must have characters!", "Password Empty", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String passHash = HashService.getSHA1Hash(passPlainText);
            
            if (!userManager.resetPassword(jTextUsername.getText(), passHash)) {
                JOptionPane.showMessageDialog(this, "Password was not changed!", "Error Reseting Password", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this, "Password successfully changed!", "Password Reseted", JOptionPane.INFORMATION_MESSAGE);
            
            jCheckBox.setEnabled(true);
            jPasswordField.setEnabled(true);
            jButtonAdd.setEnabled(true);
            jButtonRemove.setEnabled(false);
            jButtonReset.setEnabled(false);
            jListUsers.clearSelection();

        } catch (RemoteException ex) {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyPressed
        if(jListUsers.getSelectedValue() != null){
            jButtonReset.setEnabled(true);
        }
    }//GEN-LAST:event_jPasswordFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonWrite;
    private javax.swing.JCheckBox jCheckBox;
    private javax.swing.JCheckBox jCheckBoxEncrypt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListUsers;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextUsername;
    // End of variables declaration//GEN-END:variables
}
