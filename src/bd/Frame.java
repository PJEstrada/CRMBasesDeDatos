/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Al
 */
public class Frame extends javax.swing.JFrame {
    /**
     * Creates new form Frame
     */
    ArrayList<Integer> idsSelectedInUpdate = new ArrayList();
    ClientLoader loader = new ClientLoader();
    public Frame() {
        try{
            Postgre miPostgre = new Postgre();
        }catch(Exception e){}
        initComponents();
        jTabbedPane2.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Tab: "+jTabbedPane2.getSelectedIndex());
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(jTabbedPane2.getSelectedIndex() == 2){
                    jComboBox1.setModel(new DefaultComboBoxModel(getNameFromPostgre()));
                }
                else if(jTabbedPane2.getSelectedIndex() == 1){
                    createAreasForNewUser();
                    
                }
            }  
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        panelNewUser = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        scrollPane2 = new java.awt.ScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        scrollPane3 = new java.awt.ScrollPane();
        jPanel7 = new javax.swing.JPanel();
        panelSocial = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        fieldTexto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldClientes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldUsernames = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fieldHashtags = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fieldMentions = new javax.swing.JTextField();
        fieldNumHashtags = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1052, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Home", jPanel3);

        javax.swing.GroupLayout panelNewUserLayout = new javax.swing.GroupLayout(panelNewUser);
        panelNewUser.setLayout(panelNewUserLayout);
        panelNewUserLayout.setHorizontalGroup(
            panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1052, Short.MAX_VALUE)
        );
        panelNewUserLayout.setVerticalGroup(
            panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Agregar Cliente", panelNewUser);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Elegir el cliente a actualizar:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(752, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Actualizar Cliente", jPanel5);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Elegir el cliente a eliminar:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(752, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Eliminar Cliente", jPanel6);

        jLabel3.setText("Tweets Conteniendo:");

        jLabel4.setText("De Los Clientes: ");

        fieldClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldClientesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Separar por comas para varios clientes");

        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tweet", "Cliente", "ID del Cliente", "User Name", "Fecha", "Hashtags", "Mentions"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultsTable.setRowHeight(100);
        jScrollPane1.setViewportView(resultsTable);

        jLabel6.setText("Con Usernames:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("Separar por comas para varios usernames");

        fieldUsernames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUsernamesActionPerformed(evt);
            }
        });

        jLabel8.setText("Con Hashtags:");

        fieldHashtags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldHashtagsActionPerformed(evt);
            }
        });

        jLabel9.setText("Con Mentions:");

        fieldMentions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldMentionsActionPerformed(evt);
            }
        });

        fieldNumHashtags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNumHashtagsActionPerformed(evt);
            }
        });

        jLabel10.setText("# de Hastags por Tweet:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("Separar por comas para varios hashtags");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setText("Separar por comas para varios mentions");

        buscar.setText("Buscar!");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bd/tittle.png"))); // NOI18N

        javax.swing.GroupLayout panelSocialLayout = new javax.swing.GroupLayout(panelSocial);
        panelSocial.setLayout(panelSocialLayout);
        panelSocialLayout.setHorizontalGroup(
            panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panelSocialLayout.createSequentialGroup()
                .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSocialLayout.createSequentialGroup()
                        .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSocialLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(fieldHashtags))
                            .addComponent(fieldTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSocialLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSocialLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelSocialLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSocialLayout.createSequentialGroup()
                        .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelSocialLayout.createSequentialGroup()
                                .addComponent(fieldClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel5)
                            .addGroup(panelSocialLayout.createSequentialGroup()
                                .addComponent(fieldMentions, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSocialLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSocialLayout.createSequentialGroup()
                                .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldNumHashtags, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldUsernames))
                                .addGap(13, 13, 13))))
                    .addGroup(panelSocialLayout.createSequentialGroup()
                        .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(panelSocialLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panelSocialLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSocialLayout.setVerticalGroup(
            panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSocialLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldUsernames, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(fieldTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(fieldClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSocialLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSocialLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fieldHashtags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(fieldMentions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumHashtags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Social", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEliminarClienteActionPerformed
    
    //recargar elementos al 
    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void fieldClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldClientesActionPerformed

    private void fieldUsernamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUsernamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUsernamesActionPerformed

    private void fieldHashtagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldHashtagsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldHashtagsActionPerformed

    private void fieldMentionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldMentionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldMentionsActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String texto = this.fieldTexto.getText();
        List<String> clientes = Arrays.asList( this.fieldClientes.getText().split("\\s*,\\s*")); 
        ArrayList<String> clientes2 = new ArrayList<String>();
        if(!this.fieldClientes.getText().equals("")){
            clientes2.addAll(clientes);
        }
        
        
        List<String> users = Arrays.asList( this.fieldUsernames.getText().split("\\s*,\\s*")); 
        ArrayList<String> users2 = new ArrayList<String>();
        if(!this.fieldUsernames.getText().equals("")){
            users2.addAll(users); 
        }
           
        
        List<String> hashtags = Arrays.asList( this.fieldHashtags.getText().split("\\s*,\\s*")); 
        ArrayList<String> hashtags2 = new ArrayList<String>();
        if(!this.fieldHashtags.getText().equals("")){
            hashtags2.addAll(hashtags); 
        }        
         
        
        List<String> mentions = Arrays.asList( this.fieldMentions.getText().split("\\s*,\\s*")); 
        ArrayList<String> mentions2 = new ArrayList<String>();
        if(!this.fieldMentions.getText().equals("")){
            mentions2.addAll(mentions); 
        }            
        int numHashtags = -1;
        if(this.fieldNumHashtags.getText().equals("")){
            numHashtags = -1;
        }
        else{
            try{
                numHashtags = Integer.parseInt(this.fieldNumHashtags.getText());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "El campo # de hastags solo acepta numeros enteros");
                return;
            }
            
        }
        
        MongoDB mongo = new MongoDB();
        ArrayList<Tweet> tweets = mongo.buscarTweets(texto, clientes2, users2, hashtags2, mentions2, numHashtags);
        String[] cols =     new String [] {
                "Tweet", "ID del Cliente","Cliente" , "Username","Fecha", "Hashtags","Numero Hashtags", "Mentions"
                
            };          
        
        String[][] filasT = new String[tweets.size()][cols.length];
        for(int i =0 ;i< tweets.size(); i++){
            String[] filaI = new String[tweets.get(i).toStringArrayList().size()];
            filaI = tweets.get(i).toStringArrayList().toArray(filaI);
            filasT[i] = filaI;        
        }
        this.resultsTable.setModel(new javax.swing.table.DefaultTableModel(filasT,cols));
        TableColumnModel cm = this.resultsTable.getColumnModel();
        TextAreaRenderer textAreaRenderer = new TextAreaRenderer(); 
        cm.getColumn(0).setCellRenderer(textAreaRenderer);
        cm.getColumn(5).setCellRenderer(textAreaRenderer);
        cm.getColumn(7).setCellRenderer(textAreaRenderer);

      
    }//GEN-LAST:event_buscarActionPerformed

    private void fieldNumHashtagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNumHashtagsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNumHashtagsActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    private String[] getNameFromPostgre(){
        ArrayList<String> namePersona = new ArrayList();
        String query = "SELECT id, nombre FROM cliente";
        Statement st;
        try {
            st = Postgre.bdConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData m = rs.getMetaData();
            
            while(rs.next()){
                String nombreAdd = rs.getString(2);
                namePersona.add(nombreAdd);
                int numeroId = Integer.parseInt(rs.getString(1));
                idsSelectedInUpdate.add(numeroId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] nombresToReturn = new String[namePersona.size()];
        namePersona.toArray(nombresToReturn);
        return nombresToReturn;
    }
    //metodo para llenar el elementos al add user
    private void createAreasForNewUser(){
        ArrayList<PairTypeField> nombresLabels = new ArrayList();
        String query = "SELECT \n" +
                    "	cliente.nombre, cliente.apellido, cliente.dpi, cliente.rating, cliente.genero,\n" +
                    "	cliente.fecha_nacimiento, cliente.foto,\n" +
                    "	contacto.telefono as telefono_personal, contacto.direccion, contacto.correo, contacto.celular, \n" +
                    "	contacto.departamento, \n" +
                    "	socialdata.facebook, socialdata.twitter, socialdata.\"google+\", socialdata.youtube,\n" +
                    "	socialdata.tumblr,\n" +
                    "	empresa.nombre, empresa.cargo, empresa.direccion, empresa.telefono as telefono_empresa,\n" +
                    "	industria.nombre as nombre_empresa, industria.descripcion\n" +
                    "		\n" +
                        "FROM (((cliente JOIN contacto ON (cliente.contacto_idcontacto = contacto.id))\n" +
                        "JOIN empresa ON (cliente.empresa_idempresa = empresa.id))\n" +
                        "JOIN industria ON (cliente.industria_idindustria = industria.id)\n" +
                        "JOIN socialdata ON (cliente.socialdata_idsocialdata = socialdata.id)) WHERE cliente.id = -1";
        Statement st;
        try {
            st = Postgre.bdConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData m = rs.getMetaData();
            for(int i = 1; i< m.getColumnCount();i++){
                String tipoColumna = m.getColumnTypeName(i);
                String nombreColumna = m.getColumnName(i);
                PairTypeField par = new PairTypeField(tipoColumna,nombreColumna);
                nombresLabels.add(par);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<JPanel> paneles = loader.componentesNuevoCliente(nombresLabels);
        panelNewUser.setLayout(new GridLayout(0, 1));
        for(JPanel pa : paneles){
            panelNewUser.add(pa);
            panelNewUser.revalidate();
            panelNewUser.repaint();
            setVisible(true);
        }
    }
    
    private String[] getNombresColumnas(){
        ArrayList<String> nombresColumna = new ArrayList();
        String query = "SELECT * FROM cliente WHERE id = -1";
        Statement st;
        try{
            st = Postgre.bdConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData m = rs.getMetaData();
            for(int i = 0; i<m.getColumnCount();i++){
                nombresColumna.add(m.getColumnName(i));
            }
            
            
        }catch (SQLException ex){
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] nombresToReturn = new String[nombresColumna.size()];
        nombresColumna.toArray(nombresToReturn);
        return nombresToReturn;
    }
    
    private String[] getTipoColumnas(){
        ArrayList<String> tipoColumna = new ArrayList();
        String query = "SELECT * FROM cliente WHERE id = -1";
        Statement st;
        try{
            st = Postgre.bdConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData m = rs.getMetaData();
            for(int i = 0; i<m.getColumnCount();i++){
                tipoColumna.add(m.getColumnName(i));
            }
        }catch(SQLException ex){
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] tipoToReturn = new String[tipoColumna.size()];
        tipoColumna.toArray(tipoToReturn);
        return tipoToReturn;
    }
    
    private ResultSetMetaData metaDataBusqueda(String query){
        Statement st;
        ResultSet rs;
        ResultSetMetaData m =  null;
        try{
            st = Postgre.bdConnection.createStatement();
            rs = st.executeQuery(query);
            m = rs.getMetaData();
        }catch(SQLException ex){
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JTextField fieldClientes;
    private javax.swing.JTextField fieldHashtags;
    private javax.swing.JTextField fieldMentions;
    private javax.swing.JTextField fieldNumHashtags;
    private javax.swing.JTextField fieldTexto;
    private javax.swing.JTextField fieldUsernames;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel panelNewUser;
    private javax.swing.JPanel panelSocial;
    private javax.swing.JTable resultsTable;
    private java.awt.ScrollPane scrollPane2;
    private java.awt.ScrollPane scrollPane3;
    // End of variables declaration//GEN-END:variables
}
