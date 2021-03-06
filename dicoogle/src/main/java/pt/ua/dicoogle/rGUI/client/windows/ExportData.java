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
package pt.ua.dicoogle.rGUI.client.windows;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import pt.ua.dicoogle.common.ExtensionFilter;
import pt.ua.dicoogle.core.ExportDataSupport;
import pt.ua.dicoogle.rGUI.client.UserRefs;
import pt.ua.dicoogle.rGUI.interfaces.controllers.ISearch;
import pt.ua.dicoogle.sdk.utils.TagValue;

/**
 * This class is used to select the tags that will be used to export to file
 *
 * @author Samuel da Costa Campos <samuelcampos@ua.pt>
 *
 */
public class ExportData extends javax.swing.JFrame implements Observer {

    private ISearch search;
    private HashMap<String, Integer> tags;
    private HashMap<Integer, TagValue> dimFields;
    private ArrayList<String> listAvaliable;
    private ExportDataSupport eds;

    private String query;
    private boolean keywords;
    private boolean local;
    private boolean network;
    private HashMap<String, Boolean> origins;
    
    /** Creates new form ExportData */
    public ExportData(String query, boolean keywords, HashMap<String, Boolean> origins) {
        initComponents();

        Image image = Toolkit.getDefaultToolkit().getImage(Thread.currentThread().getContextClassLoader().getResource("trayicon.gif"));
        this.setIconImage(image);
        
        jLabelExporting.setVisible(false);

        try {
            this.search = UserRefs.getInstance().getSearch();
            
            tags = search.getTagList();
            dimFields = search.getDIMFields();

            this.query = query;
            this.keywords = keywords;
            this.origins = origins;
            
            fillLists();

        } catch (RemoteException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
     public static Image getImage(final String pathAndFileName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
        return Toolkit.getDefaultToolkit().getImage(url);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelExporting = new javax.swing.JLabel();
        jTabbedPaneExport = new javax.swing.JTabbedPane();
        jPanelBasic = new javax.swing.JPanel();
        jButtonDown = new javax.swing.JButton();
        jButtonUp = new javax.swing.JButton();
        jTextFieldAvaliableFilter = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonRemove = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListExportTags = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAvaliableTags = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaTagList = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButtonExport = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Export Query Results");
        setMinimumSize(new java.awt.Dimension(679, 387));

        jLabelExporting.setIcon(new ImageIcon(getImage("ajax-loader.gif")));
        jLabelExporting.setText("Exporting...");

        jButtonDown.setText("Down");
        jButtonDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDownActionPerformed(evt);
            }
        });

        jButtonUp.setText("Up");
        jButtonUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpActionPerformed(evt);
            }
        });

        jTextFieldAvaliableFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAvaliableFilterKeyReleased(evt);
            }
        });

        jLabel3.setText("Tags for export:");

        jLabel2.setText("Avaliable Tags:");

        jLabel1.setText("Select Tags to use for export:");

        jButtonRemove.setText("<-");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jButtonAdd.setText("->");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jListExportTags.setSize(new java.awt.Dimension(39, 136));
        jScrollPane2.setViewportView(jListExportTags);

        jScrollPane1.setViewportView(jListAvaliableTags);

        org.jdesktop.layout.GroupLayout jPanelBasicLayout = new org.jdesktop.layout.GroupLayout(jPanelBasic);
        jPanelBasic.setLayout(jPanelBasicLayout);
        jPanelBasicLayout.setHorizontalGroup(
            jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 992, Short.MAX_VALUE)
            .add(jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelBasicLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelBasicLayout.createSequentialGroup()
                            .add(jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jPanelBasicLayout.createSequentialGroup()
                                    .add(jLabel2)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jTextFieldAvaliableFilter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jButtonAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .add(jButtonRemove, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .add(jButtonUp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .add(jButtonDown, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .add(jLabel3))
                            .add(12, 12, 12))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelBasicLayout.createSequentialGroup()
                            .add(jLabel1)
                            .add(749, 749, 749)))
                    .addContainerGap()))
        );
        jPanelBasicLayout.setVerticalGroup(
            jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 461, Short.MAX_VALUE)
            .add(jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanelBasicLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jLabel1)
                    .add(jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelBasicLayout.createSequentialGroup()
                            .add(50, 50, 50)
                            .add(jButtonAdd)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jButtonRemove)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 182, Short.MAX_VALUE)
                            .add(jButtonUp)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jButtonDown))
                        .add(jPanelBasicLayout.createSequentialGroup()
                            .add(11, 11, 11)
                            .add(jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelBasicLayout.createSequentialGroup()
                                    .add(4, 4, 4)
                                    .add(jLabel3)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelBasicLayout.createSequentialGroup()
                                    .add(jPanelBasicLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel2)
                                        .add(jTextFieldAvaliableFilter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)))))
                    .add(79, 79, 79)))
        );

        jTabbedPaneExport.addTab("Basic", jPanelBasic);

        jTextAreaTagList.setColumns(20);
        jTextAreaTagList.setRows(5);
        jScrollPane3.setViewportView(jTextAreaTagList);

        jLabel4.setText("Write Tags to use for export (one per line):");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(jLabel4))
                    .add(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 860, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneExport.addTab("Expert", jPanel2);

        jButtonExport.setText("Export Data");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(612, 612, 612)
                .add(jLabelExporting)
                .add(101, 101, 101)
                .add(jButtonExport)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButtonCancel)
                .add(29, 29, 29))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPaneExport, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1013, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPaneExport, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 507, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 38, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonExport)
                    .add(jButtonCancel)
                    .add(jLabelExporting))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        int index =  jListAvaliableTags.getSelectedIndex();

        if (index == -1)
            return;

        // removes the selected element of the list of avaliable tags
        DefaultListModel model = (DefaultListModel) jListAvaliableTags.getModel();
        String tagName = (String) model.getElementAt(index);
        listAvaliable.remove(tagName);
        updateAvaliableList(jTextFieldAvaliableFilter.getText());

        // inserts the element in the list of tags to be exported
        model = (DefaultListModel) jListExportTags.getModel();
        model.addElement(tagName);
        jListExportTags.setModel(model);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        int index =  jListExportTags.getSelectedIndex();

        if (index == -1)
            return;

        // removes the selected element of the list of export tags
        DefaultListModel model = (DefaultListModel) jListExportTags.getModel();
        String tagName = (String) model.getElementAt(index);
        model.remove(index);
        jListExportTags.setModel(model);

        // inserts the element in the list of avaliable tags
        listAvaliable.add(tagName);

        //sort the list of avaliable tags
        Collections.sort(listAvaliable);

        updateAvaliableList(jTextFieldAvaliableFilter.getText());
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed

        DefaultListModel list = (DefaultListModel) jListExportTags.getModel();

        //if(list.isEmpty())
        //    return;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Export File Name");
        
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setApproveButtonText("Save");

        FileFilter fileType = new ExtensionFilter("Comma-separated values", ".csv");

        chooser.setFileFilter(fileType);
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            String filePath = chooser.getSelectedFile().toString();

            Enumeration<String> en = (Enumeration<String>) list.elements();
            ArrayList<String> tagList = new ArrayList<String>();
            if (jTabbedPaneExport.getSelectedIndex()==0)
            {
                
                // Basic
                while(en.hasMoreElements())
                    tagList.add(en.nextElement());
            }
            else if (jTabbedPaneExport.getSelectedIndex()==1)
            {
                
                String text = jTextAreaTagList.getText();
                String [] arr = text.split("\n");
            
                for (String s:arr)
                {
                    if (!s.isEmpty())
                    {
                        tagList.add(s);
                    }
                }
                
            }
            //System.out.println("Exporting with File Path: " + filePath);

            try {
                jLabelExporting.setVisible(true);

                this.eds = new ExportDataSupport(query, origins, keywords, tagList, filePath);
                //eds.addObserver(this);
                this.eds.InitiateExport(this);
                jListAvaliableTags.setEnabled(false);
                jListExportTags.setEnabled(false);
                jButtonAdd.setEnabled(false);
                jButtonRemove.setEnabled(false);
                jButtonExport.setEnabled(false);
                jButtonCancel.setEnabled(false);
                
            } catch (Exception ex) {
                Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonExportActionPerformed

    private void jTextFieldAvaliableFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAvaliableFilterKeyReleased
        updateAvaliableList(jTextFieldAvaliableFilter.getText());
    }//GEN-LAST:event_jTextFieldAvaliableFilterKeyReleased

    private void jButtonUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpActionPerformed
        int index =  jListExportTags.getSelectedIndex();

        if(index > 0){
            DefaultListModel model = (DefaultListModel) jListExportTags.getModel();
            Object element1 = model.getElementAt(index-1);
            Object element2 = model.getElementAt(index);

            model.set(index, element1);
            model.set(index-1, element2);

            jListExportTags.setModel(model);
            jListExportTags.setSelectedIndex(index-1);
        }
    }//GEN-LAST:event_jButtonUpActionPerformed

    private void jButtonDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDownActionPerformed
        int index =  jListExportTags.getSelectedIndex();
        DefaultListModel model = (DefaultListModel) jListExportTags.getModel();

        if(index > -1 && index < model.size()){

            Object element1 = model.getElementAt(index);
            Object element2 = model.getElementAt(index+1);

            model.set(index+1, element1);
            model.set(index, element2);

            jListExportTags.setModel(model);
            jListExportTags.setSelectedIndex(index+1);
        }
    }//GEN-LAST:event_jButtonDownActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDown;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelExporting;
    private javax.swing.JList jListAvaliableTags;
    private javax.swing.JList jListExportTags;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBasic;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPaneExport;
    private javax.swing.JTextArea jTextAreaTagList;
    private javax.swing.JTextField jTextFieldAvaliableFilter;
    // End of variables declaration//GEN-END:variables


    /**
     * Fill the list of avaliable tags and the default list of export tags with DIM Fields
     */
    private void fillLists(){
        DefaultListModel listModel = new DefaultListModel();

        ArrayList<TagValue> list = new ArrayList<TagValue>( dimFields.values());
        ArrayList<String> listDIM = new ArrayList<String>();
        
        for(TagValue tag : list)
            listDIM.add(tag.getAlias());

        Collections.sort(listDIM);

        for(String tag : listDIM)
            listModel.addElement(tag);

        jListExportTags.setModel(listModel);


        ArrayList<String> listTags = new ArrayList<String>(tags.keySet());
        listAvaliable = new ArrayList<String>();

        for(String tag: listTags)
            if(!listDIM.contains(tag))
                listAvaliable.add(tag);

        listAvaliable.add("FileName");
        listAvaliable.add("FilePath");

        //sort the list of avaliable tags
        Collections.sort(listAvaliable);

        updateAvaliableList(null);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o==null)
        {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, "Update, but it is null");
            return;
        }
        Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, "Update");
        Boolean finish = (Boolean) arg;
        
        class AuxThread extends Thread
        {
            private javax.swing.JFrame t;
            public void set(javax.swing.JFrame t)
            {
                this.t = t;
            }
            
            @Override
            public void run() 
            {
                
                JOptionPane.showMessageDialog(t, "Query results successfully exported!", "Export Query Results", JOptionPane.INFORMATION_MESSAGE);
                t.dispose();
            }
        };
        
        if (finish)
        {
            AuxThread _thread = new AuxThread();
            _thread.set(this);
            _thread.start();
            
            this.setVisible(false);
        }
    }

    /**
     * Update the avaliable tags jList based on a String prefix to filter tags
     * If you don't want to filter anything, send the prefix NULL or "" (empty string)
     *
     * @param prefix - string with the start of tag name to filter
     */
    private void updateAvaliableList(String prefix){
        DefaultListModel listModel = new DefaultListModel();

        for(String tag: listAvaliable){
            if(prefix != null && !prefix.equals("")){
                if(tag.toLowerCase().startsWith(prefix.toLowerCase()))
                    listModel.addElement(tag);
            }
            else
                listModel.addElement(tag);
        }

        jListAvaliableTags.setModel(listModel);
    }

}
