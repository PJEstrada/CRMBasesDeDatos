/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor asdf.
 */

package bd;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumnModel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;


/**
 *
 * @author Al
 */
public class Frame extends javax.swing.JFrame {
    /**
     * Creates new form Frame
     */
    ArrayList<JPanel> panelesNewUser = new ArrayList();
    ArrayList<String> nombresColumnasNewUser = new ArrayList();
    JPanel jPanel4 = new JPanel();
    ArrayList<Integer> idsSelectedInUpdate = new ArrayList();
    ArrayList<PairTypeNumber> tiposNuevoCliente = new ArrayList();
    ArrayList<String> nombresColumnas = new ArrayList();
    ClientLoader loader;
    FiltrosLoader loader2;
    ArrayList<PairTypeField> camposBuscar = new ArrayList();
    ArrayList<String> tablasCamposBuscar = new ArrayList();
    ArrayList<String> nombresTextBoxBusqueda = new ArrayList();
    ArrayList<String> nombresCheckBoxBusqueda = new ArrayList();
    ArrayList<String> columnasAmostrar = new ArrayList();
    ArrayList<String> nombresColumnasNativas = new ArrayList();
    
    ArrayList<String> nombresColumnasNativasActualizar = new ArrayList();
    ArrayList<String> nombresColumnasActualizar = new ArrayList();
    ArrayList<PairTypeNumber> tiposActualizarCliente = new ArrayList();
    ArrayList<JPanel> panelesUpdateUser = new ArrayList();
    
    ArrayList<classForUsers> totalPanelesActualizar = new ArrayList();
    ArrayList<ArrayList<classForUsers>> totalSubpaneles = new ArrayList();
    
    ArrayList<Integer> indicesActualizar = new ArrayList();
    ArrayList<Integer> indicesDelete = new ArrayList();  //<-------------------
    
    String imagenUpdate = "";
    
    HashMap componentesFiltroMap;
    File targetFile;
    BufferedImage targetImg;
    private static final int baseSize = 300;
    private static final String basePath ="Pictures";
    public Frame() {
        try{
            Postgre miPostgre = new Postgre();
        }catch(Exception e){}
        initComponents();
        createFiltros();
        String[] titulos = new String[camposBuscar.size()];
        String [][] contenido = new String[0][camposBuscar.size()];
        for(int i = 0; i<camposBuscar.size();i++){
            titulos[i] = camposBuscar.get(i).namefield;
        }
        iniciarTablaBusquedaHome(titulos, contenido);
        txtAreaAgregarColumna.setText("   Escriba el nombre y el tipo de la nueva columna y presione el botón \"Agregar Columna\". \n   "
                + "   Se agregará null en los clientes existentes por lo que se le recuerda que debe editarlos.");
        txtAreaAgregarColumna.setEnabled(false);
        jTabbedPane2.addChangeListener(new ChangeListener(){
        
            @Override
            public void stateChanged(ChangeEvent e) {
                //System.out.println("Tab: "+jTabbedPane2.getSelectedIndex());
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(jTabbedPane2.getSelectedIndex() == 3){
                    resetAreasForDelete();
                    jComboBox3.setModel(new DefaultComboBoxModel(getNameFromPostgre()));
                }
                else if(jTabbedPane2.getSelectedIndex() == 2){
                    resetAreasForUpdate();
                    imagenUpdate = "";
                    DefaultTableModel model = (DefaultTableModel)tableTweets.getModel();
                    model.setRowCount(0);                    
                    jComboBox1.setModel(new DefaultComboBoxModel(getNameFromPostgre()));
                    
                }
                else if(jTabbedPane2.getSelectedIndex() == 1){
                    resetAreasForNewUser();
                    createAreasForNewUser();
                    
                }
                else if(jTabbedPane2.getSelectedIndex()==0){
                    createFiltros();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        panel_filtroHome = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_buscarHome = new javax.swing.JButton();
        btn_limpiarHome = new javax.swing.JButton();
        panelNewUser = new javax.swing.JPanel();
        panelFoto = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        subPanelNewUser_A = new javax.swing.JScrollPane();
        subPanelNewUser = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        subPanelNewUser_A1 = new javax.swing.JScrollPane();
        subPanelNewUser1 = new javax.swing.JPanel();
        panelFoto1 = new javax.swing.JPanel();
        labelImage1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableTweets = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        subPanelNewUser_A2 = new javax.swing.JScrollPane();
        subPanelNewUser2 = new javax.swing.JPanel();
        panelFoto2 = new javax.swing.JPanel();
        labelImage2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
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
        jPanel1 = new javax.swing.JPanel();
        lblColumna1 = new javax.swing.JLabel();
        txtColumnaNueva1 = new javax.swing.JTextField();
        lblColumna2 = new javax.swing.JLabel();
        cmbBoxTipos = new javax.swing.JComboBox();
        btnAgregarColumna = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAreaAgregarColumna = new javax.swing.JTextArea();
        panelAgregarUsuario = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtAgregarUser = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAgregarPass = new javax.swing.JPasswordField();
        btnAgregarUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_filtroHomeLayout = new javax.swing.GroupLayout(panel_filtroHome);
        panel_filtroHome.setLayout(panel_filtroHomeLayout);
        panel_filtroHomeLayout.setHorizontalGroup(
            panel_filtroHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        panel_filtroHomeLayout.setVerticalGroup(
            panel_filtroHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panel_filtroHome);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        btn_buscarHome.setText("Buscar");
        btn_buscarHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarHomeActionPerformed(evt);
            }
        });

        btn_limpiarHome.setText("Limpiar Campos");
        btn_limpiarHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_buscarHome)
                .addGap(384, 384, 384)
                .addComponent(btn_limpiarHome)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscarHome)
                    .addComponent(btn_limpiarHome))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Home", jPanel3);

        labelImage.setText("                                                Fotografia del Cliente");

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Buscar Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        subPanelNewUser_A.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout subPanelNewUserLayout = new javax.swing.GroupLayout(subPanelNewUser);
        subPanelNewUser.setLayout(subPanelNewUserLayout);
        subPanelNewUserLayout.setHorizontalGroup(
            subPanelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        subPanelNewUserLayout.setVerticalGroup(
            subPanelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
        );

        subPanelNewUser_A.setViewportView(subPanelNewUser);

        jButton2.setText("Agregar Nuevo Usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Instrucciones:\n\t1. Llenar los campos con la informacion\n\t   que se pide en cada uno de estos.\n\t   Por lo menos deben ser llenados\n\t   aquellos que son obligatorios (*)\n\t2. Agregar una fotografia del cliente\n\t   haciendo uso del boton \"Buscar Foto\".\n\t   Este es un campo obligatorio.\n\t3. Presionar \"Agregar Nuevo Usuario\"\n\nNota:\n\tSi desea agregar un nuevo campo,\n\tpor favor dirijase a la pestaña de\n\t\"Agregar Nuevo Campo\".");
        jTextArea1.setEnabled(false);
        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout panelNewUserLayout = new javax.swing.GroupLayout(panelNewUser);
        panelNewUser.setLayout(panelNewUserLayout);
        panelNewUserLayout.setHorizontalGroup(
            panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNewUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subPanelNewUser_A, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNewUserLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelNewUserLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelNewUserLayout.setVerticalGroup(
            panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNewUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subPanelNewUser_A, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                    .addGroup(panelNewUserLayout.createSequentialGroup()
                        .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane4)
                        .addGap(41, 41, 41)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Agregar Cliente", panelNewUser);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Elegir el cliente a actualizar:");

        subPanelNewUser_A1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout subPanelNewUser1Layout = new javax.swing.GroupLayout(subPanelNewUser1);
        subPanelNewUser1.setLayout(subPanelNewUser1Layout);
        subPanelNewUser1Layout.setHorizontalGroup(
            subPanelNewUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        subPanelNewUser1Layout.setVerticalGroup(
            subPanelNewUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
        );

        subPanelNewUser_A1.setViewportView(subPanelNewUser1);

        labelImage1.setText("                                                Fotografia del Cliente");

        javax.swing.GroupLayout panelFoto1Layout = new javax.swing.GroupLayout(panelFoto1);
        panelFoto1.setLayout(panelFoto1Layout);
        panelFoto1Layout.setHorizontalGroup(
            panelFoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFoto1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFoto1Layout.setVerticalGroup(
            panelFoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFoto1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton3.setText("Listo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cambiar Foto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tableTweets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tweet", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableTweets);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(618, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(29, 29, 29)
                        .addComponent(jButton3)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(168, 168, 168))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(subPanelNewUser_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)
                    .addComponent(panelFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subPanelNewUser_A1, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(panelFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(472, 472, 472)))
                    .addContainerGap()))
        );

        jTabbedPane2.addTab("Actualizar Cliente", jPanel5);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Elegir el cliente a eliminar:");

        subPanelNewUser_A2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout subPanelNewUser2Layout = new javax.swing.GroupLayout(subPanelNewUser2);
        subPanelNewUser2.setLayout(subPanelNewUser2Layout);
        subPanelNewUser2Layout.setHorizontalGroup(
            subPanelNewUser2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        subPanelNewUser2Layout.setVerticalGroup(
            subPanelNewUser2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
        );

        subPanelNewUser_A2.setViewportView(subPanelNewUser2);

        labelImage2.setText("                                                Fotografia del Cliente");

        javax.swing.GroupLayout panelFoto2Layout = new javax.swing.GroupLayout(panelFoto2);
        panelFoto2.setLayout(panelFoto2Layout);
        panelFoto2Layout.setHorizontalGroup(
            panelFoto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFoto2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFoto2Layout.setVerticalGroup(
            panelFoto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFoto2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(789, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(54, 54, 54)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(147, 147, 147))))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(subPanelNewUser_A2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)
                    .addComponent(panelFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addComponent(jButton5)
                .addContainerGap(478, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(subPanelNewUser_A2, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(panelFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(472, 472, 472)))
                    .addContainerGap()))
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
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
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
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
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

        lblColumna1.setText("Nombre de la nueva columna:");

        lblColumna2.setText("Tipo de la nueva columna:");

        cmbBoxTipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "String", "Int", "Float", "Date" }));
        cmbBoxTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxTiposActionPerformed(evt);
            }
        });

        btnAgregarColumna.setText("Agregar Columna");
        btnAgregarColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarColumnaActionPerformed(evt);
            }
        });

        txtAreaAgregarColumna.setEditable(false);
        txtAreaAgregarColumna.setColumns(20);
        txtAreaAgregarColumna.setRows(5);
        jScrollPane5.setViewportView(txtAreaAgregarColumna);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColumna1)
                            .addComponent(txtColumnaNueva1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColumna2)
                            .addComponent(cmbBoxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(205, 205, 205))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addComponent(btnAgregarColumna)))
                        .addContainerGap(160, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblColumna1)
                        .addGap(18, 18, 18)
                        .addComponent(txtColumnaNueva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblColumna2)
                        .addGap(18, 18, 18)
                        .addComponent(cmbBoxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110)
                .addComponent(btnAgregarColumna)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Agregar Columna", jPanel1);

        jLabel15.setText("Usuario");

        jLabel16.setText("Contraseña");

        btnAgregarUser.setText("Agregar Usuario");
        btnAgregarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAgregarUsuarioLayout = new javax.swing.GroupLayout(panelAgregarUsuario);
        panelAgregarUsuario.setLayout(panelAgregarUsuarioLayout);
        panelAgregarUsuarioLayout.setHorizontalGroup(
            panelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarUsuarioLayout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addGroup(panelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregarUsuarioLayout.createSequentialGroup()
                        .addGroup(panelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(99, 99, 99)
                        .addGroup(panelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAgregarUser)
                            .addComponent(txtAgregarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelAgregarUsuarioLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnAgregarUser)))
                .addContainerGap(413, Short.MAX_VALUE))
        );
        panelAgregarUsuarioLayout.setVerticalGroup(
            panelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarUsuarioLayout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addGroup(panelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtAgregarUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelAgregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtAgregarPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btnAgregarUser)
                .addContainerGap(520, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Agregar Usuario", panelAgregarUsuario);

        JLabel tempLabel1 = new JLabel("Home");
        JLabel tempLabel2 = new JLabel("Agregar Cliente");
        JLabel tempLabel3 = new JLabel("Actualizar Cliente");
        JLabel tempLabel4 = new JLabel("Eliminar Cliente");
        JLabel tempLabel5 = new JLabel("Social");
        JLabel tempLabel6 = new JLabel("Agregar Columna");
        JLabel tempLabel7 = new JLabel("Agregar Usuario");
        tempLabel1.setIcon(new ImageIcon("img/home.png"));
        jTabbedPane2.setTabComponentAt(0, tempLabel1);
        tempLabel2.setIcon(new ImageIcon("img/addClient.png"));
        jTabbedPane2.setTabComponentAt(1, tempLabel2);
        tempLabel3.setIcon(new ImageIcon("img/updateClient.png"));
        jTabbedPane2.setTabComponentAt(2, tempLabel3);
        tempLabel4.setIcon(new ImageIcon("img/deleteClient.png"));
        jTabbedPane2.setTabComponentAt(3, tempLabel4);
        tempLabel5.setIcon(new ImageIcon("img/social.png"));
        jTabbedPane2.setTabComponentAt(4, tempLabel5);
        tempLabel6.setIcon(new ImageIcon("img/addColumn.png"));
        jTabbedPane2.setTabComponentAt(5, tempLabel6);
        tempLabel7.setIcon(new ImageIcon("img/addUser.png"));
        jTabbedPane2.setTabComponentAt(6, tempLabel7);

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
        //el codigo va aqui
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
        try{
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
        
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error al conectar al servidor");
        }
        

      
    }//GEN-LAST:event_buscarActionPerformed

    private void fieldNumHashtagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNumHashtagsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNumHashtagsActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        resetAreasForUpdate();
        DefaultTableModel model = (DefaultTableModel)tableTweets.getModel();
        model.setRowCount(0);          
        subPanelNewUser1.removeAll();
        subPanelNewUser1.revalidate();
        subPanelNewUser1.repaint();
        totalPanelesActualizar = new ArrayList();
        indicesActualizar = new ArrayList();
        totalSubpaneles = new ArrayList();
        //setVisitible(true);
        //subPanelNewUser_A1.removeAll();
        //System.out.println("Selected: " + jComboBox1.getSelectedItem());
        //System.out.println(", Position: " + jComboBox1.getSelectedIndex());
        PairNameIdClient seleccionado = (PairNameIdClient) jComboBox1.getSelectedItem();
        int id = -1;
        int idContacto=-1;
        int idEmpresa = -1;
        int idIndustria = -1;
        int idSocial=-1;
        if(seleccionado==null){
             id = -1;
        }
        else{
             id = seleccionado.id;
             idContacto = seleccionado.idContacto;
             idEmpresa = seleccionado.idEmpresa;
             idIndustria = seleccionado.idIndustria;
             idSocial = seleccionado.idSocial;             
             
        }
        

        indicesActualizar.add(id);
        indicesActualizar.add(idContacto);
        indicesActualizar.add(idEmpresa);
        indicesActualizar.add(idIndustria);
        indicesActualizar.add(idSocial);
        
        //System.out.println("Todos los ids son: "+id +" "+idContacto+" "+idEmpresa+" "+idIndustria+" "+idSocial);
        /* Llenando la tabla de Tweets*/
        String[] cols = new String [] {"Tweet","Fecha", };          
        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
        try{
            MongoDB mongo = new MongoDB();
            tweets = mongo.obtenerTweetsCliente(id);
       
        
            String[][] filasT = new String[tweets.size()][cols.length];
            for(int i =0 ;i< tweets.size(); i++){
                String[] filaI = new String[2];
                ArrayList<String> t = new ArrayList<String>();
                t.add(tweets.get(i).texto);
                t.add(tweets.get(i).fecha.toString());
                filaI = t.toArray(filaI);
                filasT[i] = filaI;        
            }            
            this.tableTweets.setModel(new javax.swing.table.DefaultTableModel(filasT,cols));
            TableColumnModel cm = this.tableTweets.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer(); 
            cm.getColumn(0).setCellRenderer(textAreaRenderer);             
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null,
                        "Ocurrio un error al conectarse con la base de datos.", "Error de conexion",
                        JOptionPane.ERROR_MESSAGE);
        
        }


        //ahora se arman las querys para poder llevar a cabo los select
        String queryCliente = "SELECT * FROM cliente WHERE id = "+id;
        String queryContacto = "SELECT * FROM contacto WHERE id = "+idContacto;
        String queryEmpresa = "SELECT * FROM empresa WHERE id = "+idEmpresa;
        String queryIndustria = "SELECT * FROM industria WHERE id = "+idIndustria;
        String querySocial = "SELECT * FROM socialdata WHERE id = "+idSocial; 
        ArrayList<classForUsers> paraCliente = new ArrayList();
        ArrayList<classForUsers> paraContacto = new ArrayList();
        ArrayList<classForUsers> paraEmpresa = new ArrayList();
        ArrayList<classForUsers> paraIndustria = new ArrayList();
        ArrayList<classForUsers> paraSocial = new ArrayList();
        int numeroEnCliente = 0;
        String pathFoto = "";
        //PairNameData
        Statement stCliente;
        Statement stContacto;
        Statement stEmpresa;
        Statement stIndustria;
        Statement stSocial;

        
        try {
            //cliente
            stCliente = Postgre.bdConnection.createStatement();
            ResultSet rsCliente = stCliente.executeQuery(queryCliente);
            ResultSetMetaData mCliente = rsCliente.getMetaData();
            numeroEnCliente = mCliente.getColumnCount()-6;
            while(rsCliente.next()){
                for(int i = 1; i <= mCliente.getColumnCount();i++){
                    if(mCliente.getColumnName(i).contains("id") && !mCliente.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    else if(mCliente.getColumnName(i).contains("foto")){
                        pathFoto = rsCliente.getString(i);
                        //System.out.println("Bueno aca encontre este path: "+pathFoto);
                        continue;
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){h
                        continue;
                    }*/
                    String data = rsCliente.getString(i);
                    String nombreC = mCliente.getColumnName(i);
                    String tipo = mCliente.getColumnTypeName(i);
                    classForUsers clienteUsar = new classForUsers(nombreC,data,tipo);
                    paraCliente.add(clienteUsar);
                }
            }
            //contacto
            stContacto = Postgre.bdConnection.createStatement();
            ResultSet rsContacto = stContacto.executeQuery(queryContacto);
            ResultSetMetaData mContacto = rsContacto.getMetaData();
            while(rsContacto.next()){
                for(int i = 1; i <= mContacto.getColumnCount();i++){
                    if(mContacto.getColumnName(i).contains("id") && !mContacto.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){
                        continue;
                    }*/
                    String data = rsContacto.getString(i);
                    String nombreC = mContacto.getColumnName(i);
                    String tipo = mContacto.getColumnTypeName(i);
                    classForUsers contactoUsar = new classForUsers(nombreC,data,tipo);
                    paraContacto.add(contactoUsar);
                }
            }
            //empresa
            stEmpresa = Postgre.bdConnection.createStatement();
            ResultSet rsEmpresa = stEmpresa.executeQuery(queryEmpresa);
            ResultSetMetaData mEmpresa = rsEmpresa.getMetaData();
            while(rsEmpresa.next()){
                for(int i = 1; i <= mEmpresa.getColumnCount();i++){
                    if(mEmpresa.getColumnName(i).contains("id") && !mEmpresa.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){
                        continue;
                    }*/
                    String data = rsEmpresa.getString(i);
                    String nombreC = mEmpresa.getColumnName(i);
                    String tipo = mEmpresa.getColumnTypeName(i);
                    classForUsers empresaUsar = new classForUsers(nombreC,data,tipo);
                    paraEmpresa.add(empresaUsar);
                }
            }
            //industria
            stIndustria = Postgre.bdConnection.createStatement();
            ResultSet rsIndustria = stIndustria.executeQuery(queryIndustria);
            ResultSetMetaData mIndustria = rsIndustria.getMetaData();
            while(rsIndustria.next()){
                for(int i = 1; i <= mIndustria.getColumnCount();i++){
                    if(mIndustria.getColumnName(i).contains("id") && !mIndustria.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){
                        continue;
                    }*/
                    String data = rsIndustria.getString(i);
                    String nombreC = mIndustria.getColumnName(i);
                    String tipo = mIndustria.getColumnTypeName(i);
                    classForUsers industriaUsar = new classForUsers(nombreC,data,tipo);
                    paraIndustria.add(industriaUsar);
                }
            }
            //social
            stSocial = Postgre.bdConnection.createStatement();
            ResultSet rsSocial = stSocial.executeQuery(querySocial);
            ResultSetMetaData mSocial = rsSocial.getMetaData();
            while(rsSocial.next()){
                for(int i = 1; i <= mSocial.getColumnCount();i++){
                    if(mSocial.getColumnName(i).contains("id") && !mSocial.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){
                        continue;
                    }*/
                    String data = rsSocial.getString(i);
                    String nombreC = mSocial.getColumnName(i);
                    String tipo = mSocial.getColumnTypeName(i);
                    classForUsers socialUsar = new classForUsers(nombreC,data,tipo);
                    paraSocial.add(socialUsar);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Ahora ya teniendo la data se tienen que crear los paneles
        //primero se une todo
        ArrayList<classForUsers> totalPaneles = new ArrayList();
        totalPaneles.addAll(paraCliente);
        totalPaneles.addAll(paraContacto);
        totalPaneles.addAll(paraEmpresa);
        totalPaneles.addAll(paraIndustria);
        totalPaneles.addAll(paraSocial);
        totalSubpaneles.add(paraCliente);
        totalSubpaneles.add(paraContacto);
        totalSubpaneles.add(paraEmpresa);
        totalSubpaneles.add(paraIndustria);
        totalSubpaneles.add(paraSocial);
        totalPanelesActualizar.addAll(totalPaneles);
        createAreasForUpdateUser(totalPaneles,numeroEnCliente,true);
        //y se pone la fotita
        //System.out.println(pathFoto);
        pathFoto = pathFoto.replace('\\', '/');
        //System.out.println(pathFoto);
        File filePict = new File(pathFoto);
        setTargetUpdate(filePict);
        System.out.println("el pinche path es aca hehehehehehe: "+pathFoto);
        jButton4.setEnabled(true);
        jButton3.setEnabled(true);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Funcion
        browseButtonActionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Se arma la query
        String valuesCliente = "";
        String valuesContacto = "";
        String valuesEmpresa = "";
        String valuesIndustria = "";
        String valuesSocialData = "";
        // Primero se comeienza a tomar cada uno de los valores
        ArrayList<ArrayList<String>> nuevosValores = getValueForNewUser();
        //System.out.println("El size del coso es "+nuevosValores.size());
        //una vez recolectado los valores se procede a realizar una verificacion de los mismo
        ArrayList<String> dataProbar = new ArrayList();
        int indiceDeArrayFila = 0;
        int indiceInterno = 0;
        String mensajeNoNull = "";
        for(ArrayList<String> fila: nuevosValores){ //llenamos la data
            indiceInterno = 0;
            for(String dato: fila){
                if(indiceDeArrayFila == 0 && dato.equals("NULL")){
                    //se va a lanzar error porque este campo es obligatorio
                    mensajeNoNull += "El campo de "+nombresColumnas.get(indiceInterno)+" es obligatorio.\n";
                    indiceInterno++;
                    continue;
                }
                if(indiceInterno==4 && (!dato.equalsIgnoreCase("masculino")  && !dato.equalsIgnoreCase("femenino" ))){
                    JOptionPane.showMessageDialog(null,
                            "Ingrese \"masculino\" o \"femenino\" en el campo de genero.", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    return;               
                }
                if(indiceInterno==2){
                    try{
                        Integer val = Integer.parseInt(dato);
                        if(val<0 || val>10){
                            JOptionPane.showMessageDialog(null,
                                    "El valor del rating debe estar entre 0 y 10", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                            return;                             
                        }
                    }
                    catch(Exception e){
                         continue; 
                    }
                    
                }
                dataProbar.add(dato);
                indiceInterno++;
            }
            if(indiceDeArrayFila == 0 && !mensajeNoNull.isEmpty()){
                JOptionPane.showMessageDialog(null,
                        mensajeNoNull, "Error en Campos Obligatorios",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            indiceDeArrayFila++;
        }
        
        ArrayList<PairTypeNumber> arreglar = loader.checkCamposNuevo(tiposNuevoCliente, dataProbar);
        if(!arreglar.isEmpty()){
            //Si no esta vacio entonces hay cosas que arreglar entonces TODO!!!!!!!!!
            String mensajeDeErrorCompleto ="";
            ArrayList<Integer> numberComponer = new ArrayList();
            for(PairTypeNumber deber: arreglar){
                mensajeDeErrorCompleto+=deber.nameType+"\n";
                numberComponer.add(deber.numberType);
                
            }
            //ahora se deben borrar los textfield con ese indice
            //hmmmm para esto tengo que recorrer otra vez los paneles y aha D:
            int indiceJPanel = 0;
            for(int k = 1; k < panelesNewUser.size(); k++){
                JPanel panel = panelesNewUser.get(k);
                for(int i = 0; i < panel.getComponentCount(); i++) {
                    if(panel.getComponent(i) instanceof JTextField) {
                       JTextField campo = (JTextField)panel.getComponent(i);
                       if(numberComponer.contains(indiceJPanel)){
                            campo.setText("");
                       }
                       indiceJPanel++;
                    }
                 }  
            }
            //Por ultimo solo tengo que lanzar el mensaje de error x)
            JOptionPane.showMessageDialog(null,
                        mensajeDeErrorCompleto, "Error en Campos",
                        JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            int indexIntoArrayOfArray = 0;
            int numeroTipo = 0;
            boolean necesitaComillas = false;
            for(ArrayList<String> i : nuevosValores){

                for(int k = 0; k<i.size(); k++){
                    String tipo = tiposNuevoCliente.get(numeroTipo).nameType;
                    if(tipo.contains("VARCHAR") || tipo.contains("TEXT") || tipo.contains("DATE")){
                        necesitaComillas = true;
                    }
                    String j = i.get(k);
                    //System.out.println(j);
                    if(j.equals("NULL")){
                        if(indexIntoArrayOfArray == 0){
                            if(k == i.size()-1){
                                valuesCliente += "NULL";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                            else{
                                valuesCliente+="NULL, ";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                        }
                        else if(indexIntoArrayOfArray == 1){
                            if(k == i.size()-1){
                                valuesContacto += "NULL";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                            else{
                                valuesContacto+="NULL, ";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                        }
                        else if(indexIntoArrayOfArray == 2){
                            if(k == i.size()-1){
                                valuesEmpresa += "NULL";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                            else{
                                valuesEmpresa+="NULL, ";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                        }
                        else if(indexIntoArrayOfArray == 3){
                            if(k == i.size()-1){
                                valuesIndustria += "NULL";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                            else{
                                valuesIndustria+="NULL, ";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                        }
                        else if(indexIntoArrayOfArray == 4){
                            if(k == i.size()-1){
                                valuesSocialData += "NULL";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                            else{
                                valuesSocialData+="NULL, ";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                        }
                        continue;
                        
                    }
                    if(indexIntoArrayOfArray == 0){
                        if(necesitaComillas){
                            valuesCliente+="\'"+j+"\', ";
                            numeroTipo++;
                            necesitaComillas = false;
                        }
                        else{
                            valuesCliente+=j+", ";
                            numeroTipo++;
                        }

                    }
                    else if(indexIntoArrayOfArray == 1){
                        if(necesitaComillas){
                            if(k == i.size()-1){
                                valuesContacto += "\'"+j+"\'";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                            else{
                                valuesContacto+="\'"+j+"\', ";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                        }
                        else{
                            if(k == i.size()-1){
                                valuesContacto += j;
                                numeroTipo++;
                            }
                            else{
                                valuesContacto+=j+", ";
                                numeroTipo++;
                            }
                        }
                    }
                    else if(indexIntoArrayOfArray == 2){
                        if(necesitaComillas){
                            if(k == i.size()-1){
                                valuesEmpresa+="\'"+j+"\'";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                            else{
                                valuesEmpresa+="\'"+j+"\', ";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                        }
                        else{
                            if(k == i.size()-1){
                                valuesEmpresa+=j;
                                numeroTipo++;
                            }
                            else{
                                valuesEmpresa+=j+", ";
                                numeroTipo++;
                            }
                        }

                    }
                    else if(indexIntoArrayOfArray == 3){
                        if(necesitaComillas){
                            if(k == i.size()-1){
                                valuesIndustria+="\'"+j+"\'";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                            else{
                                valuesIndustria+="\'"+j+"\', ";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                        }
                        else{
                            if(k == i.size()-1){
                                valuesIndustria+=j;
                                numeroTipo++;
                            }
                            else{
                                valuesIndustria+=j+", ";
                                numeroTipo++;
                            }
                        }

                    }
                    else if(indexIntoArrayOfArray == 4){
                        if(necesitaComillas){
                            if(k == i.size()-1){
                                valuesSocialData+="\'"+j+"\'";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                            else{
                                valuesSocialData+="\'"+j+"\', ";
                                numeroTipo++;
                                necesitaComillas = false;
                            }
                        }
                        else{
                            if(k == i.size()-1){
                                valuesSocialData+=j;
                                numeroTipo++;
                            }
                            else{
                                valuesSocialData+=j+", ";
                                numeroTipo++;
                            }
                        }

                    }
                }
                if(indexIntoArrayOfArray == 0){
                    try{
                        //System.out.println(targetFile.getAbsolutePath());
                        valuesCliente+="\'"+targetFile.getAbsolutePath()+"\'"; 
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,
                            "Se debe elegir una fotografia. \nEste es un campo obligatorio", "Error en Campo de Fotografia",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                }
                else{

                }
                indexIntoArrayOfArray++;
                //System.out.println("----------------------");
            }
            String camposCliente = "";
            for(int kk = 0; kk< nombresColumnasNativas.size(); kk++){
                String camposDelTotal = nombresColumnasNativas.get(kk);
                if(kk == nombresColumnasNativas.size()-1){
                    camposCliente+= camposDelTotal;
                    continue;
                }
                camposCliente += camposDelTotal+", ";
            }
            camposCliente+=",foto, contacto_idcontacto, empresa_idempresa, industria_idindustria, socialdata_idsocialdata";
            String queryInstert = "INSERT INTO cliente ("+camposCliente+ ") VALUES ("+valuesCliente+", ";
            String queryInsertContacto="INSERT INTO contacto "+"(telefono_cliente,direccion_cliente, correo, celular, departamento)"+ " VALUES ("+valuesContacto+");";
            String queryInsertEmpresa="INSERT INTO empresa "+"(nombre_empresa, cargo, direccion_empresa, telefono_empresa)"+" VALUES ("+valuesEmpresa+");";
            String queryInsertIndustria="INSERT INTO industria "+"(nombre_industria, descripcion)"+" VALUES ("+valuesIndustria+");";
            String queryInsertSocialData="INSERT INTO socialData "+"(facebook, twitter, \"google+\",youtube, tumblr)"+" VALUES ("+valuesSocialData+");";

            //executing the queries
            Statement st;
            Statement st2;
            Statement st3;
            Statement st4;
            Statement stFinal;

            String idContacto="";
            String idEmpresa="";
            String idIndustria="";
            String idSocialData="";
            try {
                //contacto
                st = Postgre.bdConnection.createStatement();
                st.execute(queryInsertContacto,Statement.RETURN_GENERATED_KEYS);
                //ResultSetMetaData m = rs.getMetaData();
                ResultSet keyset = st.getGeneratedKeys();
                if(keyset.next()){
                    idContacto = keyset.getInt(1)+"";
                }
                //empresa
                st2 = Postgre.bdConnection.createStatement();
                st2.execute(queryInsertEmpresa,Statement.RETURN_GENERATED_KEYS);
                ResultSet keyset2 = st2.getGeneratedKeys();
                if(keyset2.next()){
                    idEmpresa = keyset2.getInt(1)+"";;
                }
                //industria
                st3 = Postgre.bdConnection.createStatement();
                st3.execute(queryInsertIndustria,Statement.RETURN_GENERATED_KEYS);
                ResultSet keyset3 = st3.getGeneratedKeys();
                if(keyset3.next()){
                    idIndustria = keyset3.getInt(1)+"";
                }
                //socialData
                st4 = Postgre.bdConnection.createStatement();
                st4.execute(queryInsertSocialData,Statement.RETURN_GENERATED_KEYS);
                ResultSet keyset4 = st4.getGeneratedKeys();
                if(keyset4.next()){
                    idSocialData = keyset4.getInt(1)+"";
                }
                //
                queryInstert+=idContacto+", "+idEmpresa+", "+idIndustria+", "+idSocialData+");";

                //Ahora si se ejecuta la del inser final
               stFinal = Postgre.bdConnection.createStatement();
               stFinal.execute(queryInstert,Statement.RETURN_GENERATED_KEYS);
               ResultSet keysetFinal = stFinal.getGeneratedKeys();
               int idCliente = -1;
               if(keysetFinal.next()){
                   idCliente = keysetFinal.getInt(1);
                   //System.out.println("ID DEL CLIENTE: "+idCliente);
                   
               }
               //Agregando tweets del cliente
               MongoDB mongo = new MongoDB();
               Twitter twitter = new Twitter();
               //Obtenemos ultimo id insertado
               String twitterQuery = " SELECT nombre,twitter from cliente JOIN socialdata ON (cliente.socialdata_idsocialdata= socialdata.id ) WHERE cliente.id = "+idCliente;
               Statement stTwitter = Postgre.bdConnection.createStatement();
               ResultSet rsTwitter = st.executeQuery(twitterQuery);   
               String nombreCliente = "";
               String userName = "";
               if(rsTwitter.next()){
                    nombreCliente = rsTwitter.getString(1);
                    userName = rsTwitter.getString(2);
               
               }
               ArrayList<Tweet> tweets = new ArrayList<Tweet>();
               if(userName!=null &&!userName.equals("")){
                  tweets =  Twitter.obtener15TweetDelUsuario(userName, idCliente, nombreCliente);
               }
               if(!tweets.isEmpty()){
                   mongo.addTweets(tweets);
               }
               
               
                
               
                JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente.");
                resetAreasForNewUser();
                return;               

            } catch (SQLException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,
                        "Este cliente ya existe.", "Error al Insertar",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e){
                //JOptionPane.showMessageDialog(this, "Error de conexion");
                JOptionPane.showMessageDialog(null,
                        "Ocurrio un error al conectarse con la base de datos.", "Error de conexion",
                        JOptionPane.ERROR_MESSAGE);
            }


            //System.out.println(queryInstert);
            //System.out.println(queryInsertContacto);
            //System.out.println(queryInsertEmpresa);
            //System.out.println(queryInsertIndustria);
            //System.out.println(queryInsertSocialData);

            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void createComponentesFiltroMap() {
        componentesFiltroMap = new HashMap<String,Component>();
        
        Component[] components = panel_filtroHome.getComponents();
        for (int i=0; i < components.length; i++) {
            if(!(components[i].getName()==null)){
                Component[] components2 = ((Container)components[i]).getComponents();
                for(int j = 0; j<components2.length;j++){
                    if(!(components2[j].getName()==null)){
                        componentesFiltroMap.put(components2[j].getName(), components2[j]);
                    }
                }
            }
        }
        
    }
    
    public Component getFiltroComponentByName(String name) {
        if (componentesFiltroMap.containsKey(name)) {
                return (Component) componentesFiltroMap.get(name);
        }
        else return null;
    }
    
    private void btn_buscarHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarHomeActionPerformed
        Boolean huboerror = false;
        Boolean primero = true;
        Boolean primeroSelect = true;
        String query3 = "";
        String query2 = "FROM (((cliente JOIN contacto ON (cliente.contacto_idcontacto = contacto.id))\n" +
                        "JOIN empresa ON (cliente.empresa_idempresa = empresa.id))\n" +
                        "JOIN industria ON (cliente.industria_idindustria = industria.id)\n" +
                        "JOIN socialdata ON (cliente.socialdata_idsocialdata = socialdata.id))";
        String query1 = "";
                        
        createComponentesFiltroMap() ;
//        for(int i = 0; i<camposBuscar.size();i++){
//            System.out.println(camposBuscar.get(i).typeField);
//        }
        for(int i = 0; i<nombresTextBoxBusqueda.size();i++){
            if(!(((JTextField)getFiltroComponentByName(nombresTextBoxBusqueda.get(i))).getText().equals(""))){
                if(primero){
                    query3 += "WHERE (";
                    primero = false;
                }
                else{
                    query3 += " AND (";
                }
                List<String> ingresos = Arrays.asList( ((JTextField)getFiltroComponentByName(nombresTextBoxBusqueda.get(i))).getText().split("\\s*,\\s*")); 
                for(int j = 0;j<ingresos.size();j++){
                    
                    String type_campo = camposBuscar.get(i).typeField;
                    String nombre_campo = camposBuscar.get(i).namefield;
                    String tabla_campo = tablasCamposBuscar.get(i);
                    if(type_campo.equals("text")){
                        boolean correcto = loader2.validateField(ingresos.get(j), 1);
                        if(correcto){
                            if(j==ingresos.size()-1){
                                query3 += tabla_campo+"."+nombre_campo+" iLIKE \'"+ingresos.get(j)+"\' )";
                            }
                            else{
                                query3 += tabla_campo+"."+nombre_campo+" iLIKE \'"+ingresos.get(j)+"\' OR ";
                            }
                            
                        }
                        else{
                            huboerror = true;
                            ((JTextField)getFiltroComponentByName(nombresTextBoxBusqueda.get(i))).setText("");
                            JOptionPane.showMessageDialog(this, "En el campo "+nombre_campo+" no se especifico un string valido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                            j = ingresos.size();
                            i = nombresTextBoxBusqueda.size();
                        }
                    }
                    else if(type_campo.contains("int")){
                        boolean correcto = loader2.validateField(ingresos.get(j), 2);
                        if(correcto){
                            if(j==ingresos.size()-1){
                                query3 += tabla_campo+"."+nombre_campo+" = "+ingresos.get(j)+" )";
                            }
                            else{
                                query3 += tabla_campo+"."+nombre_campo+" = "+ingresos.get(j)+" OR ";
                            }
                            
                        }
                        else{
                            huboerror = true;
                            ((JTextField)getFiltroComponentByName(nombresTextBoxBusqueda.get(i))).setText("");
                            JOptionPane.showMessageDialog(this, "En el campo "+nombre_campo+" no se especifico un entero valido.","Error",
                        JOptionPane.ERROR_MESSAGE);
                            j = ingresos.size();
                            i = nombresTextBoxBusqueda.size();
                        }
                    }
                    else if(type_campo.contains("float")){
                        boolean correcto = loader2.validateField(ingresos.get(j), 3);
                        if(correcto){
                            if(j==ingresos.size()-1){
                                query3 += tabla_campo+"."+nombre_campo+" = "+ingresos.get(j)+" )";
                            }
                            else{
                                query3 += tabla_campo+"."+nombre_campo+" = "+ingresos.get(j)+" OR ";
                            }
                            
                        }
                        else{
                            huboerror = true;
                            ((JTextField)getFiltroComponentByName(nombresTextBoxBusqueda.get(i))).setText("");
                            JOptionPane.showMessageDialog(this, "En el campo "+nombre_campo+" no se especifico un decimal valido.","Error",
                        JOptionPane.ERROR_MESSAGE);
                            j = ingresos.size();
                            i = nombresTextBoxBusqueda.size();
                        }
                    }
                    else if(type_campo.equals("date")){
                        boolean correcto = loader2.validateField(ingresos.get(j), 4);
                        if(correcto){
                            if(j==ingresos.size()-1){
                                query3 += tabla_campo+"."+nombre_campo+" = \'"+ingresos.get(j)+"\' )";
                            }
                            else{
                                query3 += tabla_campo+"."+nombre_campo+" = \'"+ingresos.get(j)+"\' OR ";
                            }
                            
                        }
                        else{
                            huboerror = true;
                            ((JTextField)getFiltroComponentByName(nombresTextBoxBusqueda.get(i))).setText("");
                            JOptionPane.showMessageDialog(this, "En el campo "+nombre_campo+" no se especifico una fecha valida.","Error",
                        JOptionPane.ERROR_MESSAGE);
                            j = ingresos.size();
                            i = nombresTextBoxBusqueda.size();
                        }
                    }
                }
                
            }
        }
        if(!huboerror){
            for(int i = 0; i<nombresCheckBoxBusqueda.size();i++){
                if(((JCheckBox)getFiltroComponentByName(nombresCheckBoxBusqueda.get(i))).isSelected()){
                    String nombre_campo = camposBuscar.get(i).namefield;
                    String tabla_campo = tablasCamposBuscar.get(i);
                    if(primeroSelect){
                        query1 += "SELECT "+tabla_campo+"."+nombre_campo;
                        primeroSelect = false;
                        columnasAmostrar.add(nombre_campo);
                    }
                    else{
                        query1 += ", "+tabla_campo+"."+nombre_campo;
                        columnasAmostrar.add(nombre_campo);
                    }
                }
            }
            if(primeroSelect){
                query1 = "SELECT *";
            }
            String query = query1+"\n"+query2+"\n"+query3;
            //System.out.println(query);
            metaDataBusqueda(query);
            
        }
        
    }//GEN-LAST:event_btn_buscarHomeActionPerformed

    private void btn_limpiarHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarHomeActionPerformed
        for(int i = 0; i<nombresTextBoxBusqueda.size();i++){
            ((JTextField)getFiltroComponentByName(nombresTextBoxBusqueda.get(i))).setText("");
        }
        
        for(int i = 0; i<nombresCheckBoxBusqueda.size();i++){
            ((JCheckBox)getFiltroComponentByName(nombresCheckBoxBusqueda.get(i))).setSelected(false);
        }
    }//GEN-LAST:event_btn_limpiarHomeActionPerformed

    private void cmbBoxTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxTiposActionPerformed
        
    }//GEN-LAST:event_cmbBoxTiposActionPerformed

    private void btnAgregarColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarColumnaActionPerformed
        String tipo = "";
        String nombreNuevaColumna = txtColumnaNueva1.getText().toLowerCase();
        if(nombreNuevaColumna.equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para la nueva columna","Error",
                        JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Que no se repita el nombre de la columna
            if(this.existeColumna(nombreNuevaColumna)){
                JOptionPane.showMessageDialog(this, "En la Tabla Cliente ya existe una columna de nombre: "+nombreNuevaColumna,"Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(nombreNuevaColumna.contains("-")||nombreNuevaColumna.contains("+")
                    ||nombreNuevaColumna.contains("*")||nombreNuevaColumna.contains("/")||nombreNuevaColumna.contains("drop")
                    ||nombreNuevaColumna.contains("select")||nombreNuevaColumna.contains("update")||nombreNuevaColumna.contains("insert")){
                JOptionPane.showMessageDialog(this, "El nombre de la columna posee caracteres no validos ","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(cmbBoxTipos.getSelectedIndex()==0){
                    crearColumna(nombreNuevaColumna,"text");
                    this.txtColumnaNueva1.setText("");
                }
                else if(cmbBoxTipos.getSelectedIndex()==1){
                    crearColumna(nombreNuevaColumna,"integer");
                    this.txtColumnaNueva1.setText("");
                }
                else if(cmbBoxTipos.getSelectedIndex()==2){
                    crearColumna(nombreNuevaColumna,"double precision");
                    this.txtColumnaNueva1.setText("");
                }
                else if(cmbBoxTipos.getSelectedIndex()==3){
                    crearColumna(nombreNuevaColumna,"date");
                    this.txtColumnaNueva1.setText("");
                }
                
            }
            
        }
    }//GEN-LAST:event_btnAgregarColumnaActionPerformed
    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        subPanelNewUser2.removeAll();
        subPanelNewUser2.revalidate();
        subPanelNewUser2.repaint();
        totalPanelesActualizar = new ArrayList();
        indicesDelete = new ArrayList();
        //setVisitible(true);
        //subPanelNewUser_A1.removeAll();
        //System.out.println("Selected: " + jComboBox3.getSelectedItem());
        //System.out.println(", Position: " + jComboBox3.getSelectedIndex());
        PairNameIdClient seleccionado = (PairNameIdClient) jComboBox3.getSelectedItem();
        int id = -1;
        int idContacto =-1;
        int idEmpresa =-1;
        int idIndustria = -1;
        int idSocial = -1;
        if(seleccionado != null){
             id = seleccionado.id;
             idContacto = seleccionado.idContacto;
             idEmpresa = seleccionado.idEmpresa;
             idIndustria = seleccionado.idIndustria;
             idSocial = seleccionado.idSocial;       
        }

        indicesDelete.add(id);
        indicesDelete.add(idContacto);
        indicesDelete.add(idEmpresa);
        indicesDelete.add(idIndustria);
        indicesDelete.add(idSocial);
        //System.out.println("Los indices son: "+indicesDelete);
        //System.out.println("Todos los ids son: "+id +" "+idContacto+" "+idEmpresa+" "+idIndustria+" "+idSocial);
        //ahora se arman las querys para poder llevar a cabo los select
        String queryCliente = "SELECT * FROM cliente WHERE id = "+id;
        String queryContacto = "SELECT * FROM contacto WHERE id = "+idContacto;
        String queryEmpresa = "SELECT * FROM empresa WHERE id = "+idEmpresa;
        String queryIndustria = "SELECT * FROM industria WHERE id = "+idIndustria;
        String querySocial = "SELECT * FROM socialdata WHERE id = "+idSocial; 
        ArrayList<classForUsers> paraCliente = new ArrayList();
        ArrayList<classForUsers> paraContacto = new ArrayList();
        ArrayList<classForUsers> paraEmpresa = new ArrayList();
        ArrayList<classForUsers> paraIndustria = new ArrayList();
        ArrayList<classForUsers> paraSocial = new ArrayList();
        int numeroEnCliente = 0;
        String pathFoto = "";
        //PairNameData
        Statement stCliente;
        Statement stContacto;
        Statement stEmpresa;
        Statement stIndustria;
        Statement stSocial;
        try {
            //cliente
            stCliente = Postgre.bdConnection.createStatement();
            ResultSet rsCliente = stCliente.executeQuery(queryCliente);
            ResultSetMetaData mCliente = rsCliente.getMetaData();
            numeroEnCliente = mCliente.getColumnCount()-6;
            while(rsCliente.next()){
                for(int i = 1; i <= mCliente.getColumnCount();i++){
                    if(mCliente.getColumnName(i).contains("id") && !mCliente.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    else if(mCliente.getColumnName(i).contains("foto")){
                        pathFoto = rsCliente.getString(i);
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){
                        continue;
                    }*/
                    String data = rsCliente.getString(i);
                    String nombreC = mCliente.getColumnName(i);
                    String tipo = mCliente.getColumnTypeName(i);
                    classForUsers clienteUsar = new classForUsers(nombreC,data,tipo);
                    paraCliente.add(clienteUsar);
                }
            }
            //contacto
            stContacto = Postgre.bdConnection.createStatement();
            ResultSet rsContacto = stContacto.executeQuery(queryContacto);
            ResultSetMetaData mContacto = rsContacto.getMetaData();
            while(rsContacto.next()){
                for(int i = 1; i <=mContacto.getColumnCount();i++){
                    if(mContacto.getColumnName(i).contains("id") && !mContacto.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){
                        continue;
                    }*/
                    String data = rsContacto.getString(i);
                    String nombreC = mContacto.getColumnName(i);
                    String tipo = mContacto.getColumnTypeName(i);
                    classForUsers contactoUsar = new classForUsers(nombreC,data,tipo);
                    paraContacto.add(contactoUsar);
                }
            }
            //empresa
            stEmpresa = Postgre.bdConnection.createStatement();
            ResultSet rsEmpresa = stEmpresa.executeQuery(queryEmpresa);
            ResultSetMetaData mEmpresa = rsEmpresa.getMetaData();
            while(rsEmpresa.next()){
                for(int i = 1; i <= mEmpresa.getColumnCount();i++){
                    if(mEmpresa.getColumnName(i).contains("id") && !mEmpresa.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){
                        continue;
                    }*/
                    String data = rsEmpresa.getString(i);
                    String nombreC = mEmpresa.getColumnName(i);
                    String tipo = mEmpresa.getColumnTypeName(i);
                    classForUsers empresaUsar = new classForUsers(nombreC,data,tipo);
                    paraEmpresa.add(empresaUsar);
                }
            }
            //industria
            stIndustria = Postgre.bdConnection.createStatement();
            ResultSet rsIndustria = stIndustria.executeQuery(queryIndustria);
            ResultSetMetaData mIndustria = rsIndustria.getMetaData();
            while(rsIndustria.next()){
                for(int i = 1; i <= mIndustria.getColumnCount();i++){
                    if(mIndustria.getColumnName(i).contains("id") && !mIndustria.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){
                        continue;
                    }*/
                    String data = rsIndustria.getString(i);
                    String nombreC = mIndustria.getColumnName(i);
                    String tipo = mIndustria.getColumnTypeName(i);
                    classForUsers industriaUsar = new classForUsers(nombreC,data,tipo);
                    paraIndustria.add(industriaUsar);
                }
            }
            //social
            stSocial = Postgre.bdConnection.createStatement();
            ResultSet rsSocial = stSocial.executeQuery(querySocial);
            ResultSetMetaData mSocial = rsSocial.getMetaData();
            while(rsSocial.next()){
                for(int i = 1; i <= mSocial.getColumnCount();i++){
                    if(mSocial.getColumnName(i).contains("id") && !mSocial.getColumnName(i).equals("apellido")){
                        continue;
                    }
                    /*else if(m2.getColumnName(i).contains("foto")){
                        continue;
                    }*/
                    String data = rsSocial.getString(i);
                    String nombreC = mSocial.getColumnName(i);
                    String tipo = mSocial.getColumnTypeName(i);
                    classForUsers socialUsar = new classForUsers(nombreC,data,tipo);
                    paraSocial.add(socialUsar);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Ahora ya teniendo la data se tienen que crear los paneles
        //primero se une todo
        ArrayList<classForUsers> totalPaneles = new ArrayList();
        totalPaneles.addAll(paraCliente);
        totalPaneles.addAll(paraContacto);
        totalPaneles.addAll(paraEmpresa);
        totalPaneles.addAll(paraIndustria);
        totalPaneles.addAll(paraSocial);
        totalPanelesActualizar.addAll(totalPaneles);
        createAreasForUpdateUser(totalPaneles,numeroEnCliente,false);
        //y se pone la fotita
        //System.out.println(pathFoto);
        pathFoto = pathFoto.replace('\\', '/');
        //System.out.println(pathFoto);
        File filePict = new File(pathFoto);
        setTargetDelete(filePict);
        jButton5.setEnabled(true);
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //bueeeeeeeeeeeeeeeno. Primero tomemos todos los id
        //Si llego a necesitar los id estan en indicesActualizar
        //Para ver la data esta en totalPanelesActualzar
        //para ver la data separada por parte totalSubpaneles
        
        //se debe actualizar el totalSubpnales
        
        
        ArrayList<ArrayList<String>> valoresRevisar = getValueForUpdateUser();
        //ahora se cargan los valores de totalSubpaneles en un arraylist de arraylist
        ArrayList<ArrayList<String>> valoresAntiguos = new ArrayList();
        for(ArrayList<classForUsers> coso1: totalSubpaneles){ // en esta parte solamente estoy jalando los datos antiguos
            ArrayList<String> valo = new ArrayList();
            for(classForUsers coso2 : coso1){
                valo.add(coso2.datosEnColumna);
            }
            valoresAntiguos.add(valo);
        }
        ArrayList<String> dataProbar = new ArrayList();
        int indiceInterno = 0;
        int indiceDeArrayFila = 0;
        String mensajeNoNull = "";
        for(ArrayList<String> fila: valoresRevisar){ //llenamos la data
            indiceInterno = 0;
            for(String dato: fila){
                if(indiceDeArrayFila == 0 && dato.equals("NULL")){
                    //se va a lanzar error porque este campo es obligatorio
                    mensajeNoNull += "El campo de "+nombresColumnas.get(indiceInterno)+" es obligatorio.\n";
                    indiceInterno++;
                    continue;
                }
                dataProbar.add(dato);
                indiceInterno++;
            }
            if(indiceDeArrayFila == 0 && !mensajeNoNull.isEmpty()){
                JOptionPane.showMessageDialog(null,
                        mensajeNoNull, "Error en Campos Obligatorios",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            indiceDeArrayFila++;
        }

        //se revisa antes de hacer cualquier otra cosa
         ArrayList<PairTypeNumber> arreglar = loader.checkCamposNuevo(tiposActualizarCliente, dataProbar);
         if(!arreglar.isEmpty()){
            //Si no esta vacio entonces hay cosas que arreglar entonces TODO!!!!!!!!!
            String mensajeDeErrorCompleto ="";
            ArrayList<Integer> numberComponer = new ArrayList();
            for(PairTypeNumber deber: arreglar){
                mensajeDeErrorCompleto+=deber.nameType+"\n";
                numberComponer.add(deber.numberType);
                
            }
            //ahora se deben borrar los textfield con ese indice
            //hmmmm para esto tengo que recorrer otra vez los paneles y aha D:
            int indiceJPanel = 0;
            for(int k = 1; k < panelesUpdateUser.size(); k++){
                JPanel panel = panelesUpdateUser.get(k);
                for(int i = 0; i < panel.getComponentCount(); i++) {
                    if(panel.getComponent(i) instanceof JTextField) {
                       JTextField campo = (JTextField)panel.getComponent(i);
                       if(numberComponer.contains(indiceJPanel)){
                            campo.setText("");
                       }
                       indiceJPanel++;
                    }
                 }  
            }
            //Por ultimo solo tengo que lanzar el mensaje de error x)
            JOptionPane.showMessageDialog(null,
                        mensajeDeErrorCompleto, "Error en Campos",
                        JOptionPane.ERROR_MESSAGE);
            return;
        }
        //va ahora que ya tengo los antiguos y los nuevos, tengo que comenzar a recorrer ambos para compararlos
        /*
            0 = cliente
            1 = contacto
            2 = empresa
            3 = industria
            4 = social
        */
        ArrayList<PairTypeNumber> camposNuevos = new ArrayList();
        ArrayList<String> querysUpdate = new ArrayList();
        for(int i = 0; i< valoresRevisar.size(); i++){
            String queryUpdate = "";
            for(int j = 0; j<valoresRevisar.get(i).size(); j++){
                System.out.println(i+" "+j);
                String compararNuevo = valoresRevisar.get(i).get(j);
                String compararAntiguo = totalSubpaneles.get(i).get(j).datosEnColumna;
                if(!compararNuevo.equals(compararAntiguo)){
                    //Si son diferentes hay que armar la query
                    //tiposActualizarCliente
                    String tabla = "";
                    switch(i){
                        case (0):
                            tabla = "cliente";
                            break;
                        case (1):
                            tabla = "contacto";
                            break;
                        case (2):
                            tabla = "empresa";
                            break;
                        case (3):
                            tabla = "industria";
                            break;
                        case (4):
                            tabla = "socialdata";
                            break;
                        default:
                            break;
                    }
                    String tipo = totalSubpaneles.get(i).get(j).tipoColumna;
                    //una vez sabiendo el tipo se tiene que validar la nueva data
                    
                    if(tipo.contains("text") || tipo.contains("varchar")){
                        queryUpdate="UPDATE "+tabla+" SET "+" "+totalSubpaneles.get(i).get(j).nombreColumna+" = \'"+compararNuevo+"\' WHERE id = "+indicesActualizar.get(i)+";";
                        querysUpdate.add(queryUpdate);
                    }
                    else{
                        queryUpdate="UPDATE "+tabla+" SET "+" "+totalSubpaneles.get(i).get(j).nombreColumna+" = "+compararNuevo+" WHERE id = "+indicesActualizar.get(i)+";";
                        querysUpdate.add(queryUpdate);
                    }
                    
                    //Si cambiaron el usuario de twitter
                    if(i==4 && j ==1){
                        try{
                            
                            MongoDB mongo = new MongoDB();
                            Twitter twitter = new Twitter();
                        //Debemos borrar los tweeets con el usuario anterior
                            mongo.eliminarTweetsClientes(indicesActualizar.get(0));
                                 
                        //Luego agregamos los tweets del nuevo usuario
                            //Obtenemos usuario y nombre del cliente
                            String twitterQuery = " SELECT nombre,twitter from cliente JOIN socialdata ON (cliente.socialdata_idsocialdata= socialdata.id ) WHERE cliente.id = "+indicesActualizar.get(0);
                            Statement stTwitter = Postgre.bdConnection.createStatement();
                            ResultSet rsTwitter = stTwitter.executeQuery(twitterQuery);   
                            String nombreCliente = "";
                            String userName = "";
                            if(rsTwitter.next()){
                                 nombreCliente = rsTwitter.getString(1);
                                 userName = rsTwitter.getString(2);

                            }
                            userName = compararNuevo;
                            ArrayList<Tweet> tweets = new ArrayList<Tweet>();
                            if(userName!=null && !userName.equals("")&&indicesActualizar.get(0)!=null && nombreCliente!=null){
                               tweets =  Twitter.obtener15TweetDelUsuario(userName, indicesActualizar.get(0), nombreCliente);
                            }
                            if(!tweets.isEmpty()){
                                mongo.addTweets(tweets);
                            }

                                      
                        }
                        catch(Exception e){
                            
                             JOptionPane.showMessageDialog(this, "Error de Conexión a Datos Sociales");
                        }
                    }
                    //Si actualizaron rating
                    if(i==0 && j==2){
                        try{
                        Integer val = Integer.parseInt(compararNuevo);
                        if(val<0 || val>10){
                            JOptionPane.showMessageDialog(null,
                                    "El valor del rating debe estar entre 0 y 10", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                            return;                             
                        }
                        }
                        catch(Exception e){
                             continue; 
                        }
                                           
                    
                    }
                    
                    if(i==0&&j==4){
                        if(!compararNuevo.equalsIgnoreCase("masculino")  && !compararNuevo.equalsIgnoreCase("femenino" )){
                            JOptionPane.showMessageDialog(null,
                                    "Ingrese \"masculino\" o \"femenino\" en el campo de genero.", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                            return;                           
                        }
                           
                    }
                    
                }
            }
        }
        //creo que solo falta la imagen entonces hay que buscarla en el coso de totalSubpaneles
        String pathAntiguo = "";
        for(classForUsers c : totalSubpaneles.get(0)){
            if(c.nombreColumna.equals("foto")){
                pathAntiguo = c.datosEnColumna;
            }
        }
        //ahora hay que tomar el nuevo path del cosito
        if(!pathAntiguo.equals(imagenUpdate) && !imagenUpdate.equals("")){
            String qeF = "UPDATE cliente SET foto = \'"+imagenUpdate+"\' WHERE id = "+indicesActualizar.get(0)+";";
            querysUpdate.add(qeF);
        }
        //bueno, ahora que ya tengo todas las queries que tengo que actualizar tendria que pasar a ejecutarlas yare yare
        Statement st;
        for(String query: querysUpdate){
            try{
                st = Postgre.bdConnection.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData m = rs.getMetaData();
            }
            catch(Exception e){}
        }
        if(querysUpdate.size()>0){
            JOptionPane.showMessageDialog(this, "Cliente editado correctamente.");
        }
        else{
            JOptionPane.showMessageDialog(this, "No exitieron cambios a realizar.");
        }
        //se supondria que se repopula la lista esa
        jComboBox1.setModel(new DefaultComboBoxModel(getNameFromPostgre()));        
        /*jPanel5.revalidate();
        jPanel5.repaint();
        setVisible(true);*/
        resetAreasForUpdate();
        
        DefaultTableModel model = (DefaultTableModel)this.tableTweets.getModel();
        model.setRowCount(0);             
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        browseButtonActionPerformedUpdate(evt);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAgregarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUserActionPerformed
        String usuario = txtAgregarUser.getText();
        String pass = txtAgregarPass.getText();
        if(pass==null){
            pass = "";
        }
        if(usuario.equals("")&&pass.equals("")){
            JOptionPane.showMessageDialog(null,
                            "Ingrese ambos campos para poder guardar el nuevo usuario", "Error al registrar un nuevo usuario",
                            JOptionPane.ERROR_MESSAGE);
        }
        else{
            boolean existe = existeUsuarioUser(usuario);
            if(existe){
                JOptionPane.showMessageDialog(null,
                            "Ya existe el usuario "+usuario, "Error al registrar un nuevo usuario",
                            JOptionPane.ERROR_MESSAGE);
            }
            else{
                agregarUsuarioUser(usuario,pass);
                JOptionPane.showMessageDialog(null,"Usuario creado con éxito");
            }
        }
    }//GEN-LAST:event_btnAgregarUserActionPerformed
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int option= JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea eliminar al cliente?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION);        
        if(option==JOptionPane.YES_OPTION){
            //Se hace la query
           //System.out.println("El indice que hay que boorar es "+indicesDelete.get(0));
           String queryD = "DELETE FROM cliente WHERE id = "+indicesDelete.get(0)+";";
           Statement st;
           try{
               st = Postgre.bdConnection.createStatement();
               ResultSet rs = st.executeQuery(queryD);
           }catch(Exception e){}

           try{
               //Agregando tweets del cliente
               MongoDB mongo = new MongoDB();
               Twitter twitter = new Twitter();
               mongo.eliminarTweetsClientes(indicesDelete.get(0));
           }
           catch(Exception e){

           }


           resetAreasForDelete();
           JOptionPane.showMessageDialog(this, "Cliente borrado exitosamente."); //este es un comentario x)
       
        
        }

    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fc = new JFileChooser(basePath);
        fc.setFileFilter(new JPEGImageFileFilter());
        int res = fc.showOpenDialog(null);
        try {
            if (res == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //System.out.println(file.getAbsolutePath());
                setTarget(file);
            } 
            else {
                JOptionPane.showMessageDialog(null,
                        "Debe elegir una imagen para un cliente nuevo.", "Cancelando...",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception iOException) {
        }

    }
    
    private void browseButtonActionPerformedUpdate(java.awt.event.ActionEvent evt) {
        JFileChooser fc = new JFileChooser(basePath);
        fc.setFileFilter(new JPEGImageFileFilter());
        int res = fc.showOpenDialog(null);
        try {
            if (res == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                imagenUpdate = file.getAbsolutePath();
                //System.out.println(file.getAbsolutePath());
                setTargetUpdate(file);
            } 
            else {
                JOptionPane.showMessageDialog(null,
                        "Debe elegir una imagen para un cliente nuevo.", "Cancelando...",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception iOException) {
        }

    }
    
    public void setTarget(File reference)
    {
        try {
            targetFile = reference;
            targetImg = rescale(ImageIO.read(reference));
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //panelFoto.setLayout(new BorderLayout(0, 0));
        labelImage.setText("");
        labelImage.setIcon(new ImageIcon(targetImg));
        labelImage.setHorizontalAlignment(SwingConstants.CENTER);
        setVisible(true);
    }
    
    public void setTargetUpdate(File reference)
    {
        try {
            targetFile = reference;
            targetImg = rescale(ImageIO.read(reference));

            //panelFoto.setLayout(new BorderLayout(0, 0));
            labelImage1.setText("");
            labelImage1.setIcon(new ImageIcon(targetImg));
            labelImage1.setHorizontalAlignment(SwingConstants.CENTER);
            setVisible(true);            
        } catch (IOException ex) {
            labelImage2.setIcon(null);
            labelImage1.setText("Fotografía del Cliente");
        }

    }
    
    public void setTargetDelete(File reference)
    {
        try {
            targetFile = reference;
            targetImg = rescale(ImageIO.read(reference));

            //panelFoto.setLayout(new BorderLayout(0, 0));
            labelImage2.setText("");
            labelImage2.setIcon(new ImageIcon(targetImg));
            labelImage2.setHorizontalAlignment(SwingConstants.CENTER);
            setVisible(true);            
        } catch (IOException ex) {
             labelImage2.setIcon(null);
             labelImage2.setText("Fotografía del Cliente");
        }

    }
    
    public BufferedImage rescale(BufferedImage originalImage)
    {
        BufferedImage resizedImage = new BufferedImage(baseSize, baseSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, baseSize, baseSize, null);
        g.dispose();
        return resizedImage;
    }
    
    private ArrayList<ArrayList<String>> getValueForNewUser(){
        ArrayList<ArrayList<String>> valores = new ArrayList();
        ArrayList<String> valTemp = new ArrayList();
        for(int k = 1; k < panelesNewUser.size(); k++){
            JPanel panel = panelesNewUser.get(k);
            for(int i = 0; i < panel.getComponentCount(); i++) {
                if(panel.getComponent(i) instanceof JTextField) {
                   JTextField campo = (JTextField)panel.getComponent(i);
                   String valoresT = campo.getText();
                   if(valoresT.isEmpty()){
                       valoresT = "NULL";
                   }
                   valTemp.add(valoresT);
                }
                if(panel.getComponentCount() == 1){
                    valores.add(valTemp);
                    valTemp = new ArrayList();
                }
             }  
        }
        //se agrega el ultimo
        valores.add(valTemp);
        return valores;
    }
    
    private ArrayList<ArrayList<String>> getValueForUpdateUser(){
        ArrayList<ArrayList<String>> valores = new ArrayList();
        ArrayList<String> valTemp = new ArrayList();
        for(int k = 1; k < panelesUpdateUser.size(); k++){
            JPanel panel = panelesUpdateUser.get(k);
            for(int i = 0; i < panel.getComponentCount(); i++) {
                if(panel.getComponent(i) instanceof JTextField) {
                   JTextField campo = (JTextField)panel.getComponent(i);
                   String valoresT = campo.getText();
                   if(valoresT.isEmpty()){
                       valoresT = "NULL";
                   }
                   valTemp.add(valoresT);
                }
                if(panel.getComponentCount() == 1){
                    valores.add(valTemp);
                    valTemp = new ArrayList();
                }
             }  
        }
        //se agrega el ultimo
        valores.add(valTemp);
        return valores;
    }
    
    private void resetAreasForNewUser(){
        for(int k = 1; k < panelesNewUser.size(); k++){
            JPanel panel = panelesNewUser.get(k);
            for(int i = 0; i < panel.getComponentCount(); i++) {
                if(panel.getComponent(i) instanceof JTextField) {
                   JTextField campo = (JTextField)panel.getComponent(i);
                   campo.setText("");
                }
             }  
        }
        labelImage.setIcon(null);
        labelImage.setText("                                                    Fotografia del Cliente");
    }
    private void resetAreasForUpdate(){
        subPanelNewUser1.removeAll();
        subPanelNewUser1.revalidate();
        subPanelNewUser1.repaint();
        jButton4.setEnabled(false);
        jButton3.setEnabled(false);
        labelImage1.setIcon(null);
        labelImage1.setText("                                                Fotografia del Cliente");
    }
    private void resetAreasForDelete(){
        subPanelNewUser2.removeAll();
        subPanelNewUser2.revalidate();
        subPanelNewUser2.repaint();
        jComboBox3.setModel(new DefaultComboBoxModel(getNameFromPostgre()));
        jButton5.setEnabled(false);
        labelImage2.setIcon(null);
        labelImage2.setText("                                                Fotografia del Cliente");
    }
    private PairNameIdClient[] getNameFromPostgre(){
        ArrayList<PairNameIdClient> namePersona = new ArrayList();
        namePersona.add(null);
        String query = "SELECT id, contacto_idcontacto, empresa_idempresa, industria_idindustria, socialdata_idsocialdata, nombre,apellido FROM cliente";
        Statement st;
        try {
            st = Postgre.bdConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData m = rs.getMetaData();
            
            while(rs.next()){
                String nombreAdd = rs.getString(6)+" "+rs.getString(7);
                int numeroId = Integer.parseInt(rs.getString(1));
                int numero2 = Integer.parseInt(rs.getString(2));
                int numero3 = Integer.parseInt(rs.getString(3));
                int numero4 = Integer.parseInt(rs.getString(4));
                int numero5 = Integer.parseInt(rs.getString(5));
                PairNameIdClient nuevoPar = new PairNameIdClient(numeroId, numero2, numero3, numero4, numero5,nombreAdd);
                namePersona.add(nuevoPar);
                idsSelectedInUpdate.add(numeroId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        PairNameIdClient[] nombresToReturn = new PairNameIdClient[namePersona.size()];
        namePersona.toArray(nombresToReturn);
        return nombresToReturn;
    }
    //metodo para llenar el elementos al add user
    private void createAreasForNewUser(){
        ArrayList<PairTypeField> nombresLabels = new ArrayList();
        String query = "SELECT \n" +
                    "	* " +
                    "		\n" +
                        "FROM (((cliente JOIN contacto ON (cliente.contacto_idcontacto = contacto.id))\n" +
                        "JOIN empresa ON (cliente.empresa_idempresa = empresa.id))\n" +
                        "JOIN industria ON (cliente.industria_idindustria = industria.id)\n" +
                        "JOIN socialdata ON (cliente.socialdata_idsocialdata = socialdata.id)) WHERE cliente.id = -1";
       String countClient = "SELECT * FROM cliente WHERE id = -1";
        Statement st;
        Statement st2;
        nombresColumnasNewUser = new ArrayList();
        int numeroFinalCliente = 0;
        try {
            st = Postgre.bdConnection.createStatement();
            st2 = Postgre.bdConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSet rs2 = st2.executeQuery(countClient);
            ResultSetMetaData m = rs.getMetaData();
            ResultSetMetaData m2 = rs2.getMetaData();
            numeroFinalCliente = m2.getColumnCount()-6;
            for(int i = 1; i< m.getColumnCount()+1;i++){
                String tipoColumna = m.getColumnTypeName(i);
                String nombreColumna = m.getColumnName(i);
                nombresColumnasNewUser.add(nombreColumna);
                PairTypeField par = new PairTypeField(tipoColumna,nombreColumna);
                nombresLabels.add(par);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        loader  = new ClientLoader(numeroFinalCliente);
        ArrayList<JPanel> previo= loader.componentesNuevoCliente(nombresLabels);
        tiposNuevoCliente = loader.tiposNuevoCliente;
        nombresColumnas = loader.nombresColumnas;
        nombresColumnasNativas = loader.nombresColumnasNativas;
        if(panelesNewUser.size() != previo.size()){
            subPanelNewUser.removeAll();
            subPanelNewUser.revalidate();
            subPanelNewUser.repaint();
            panelesNewUser = new ArrayList(); //se resetea
            panelesNewUser.addAll(previo); //se carga la nueva data
            //subPanelNewUser_A.remove(subPanelNewUser);
            subPanelNewUser.setLayout(new GridLayout(0, 1));
            for(JPanel pa : panelesNewUser){
                subPanelNewUser.add(pa);
                subPanelNewUser.revalidate();
                subPanelNewUser.repaint();
            }
            //System.out.println(panelesNewUser.size());
            //subPanelNewUser_A.add(subPanelNewUser);
            //subPanelNewUser_A.revalidate();
            //subPanelNewUser_A.repaint();
            setVisible(true);
        }
        
    }
    private void createAreasForUpdateUser(ArrayList<classForUsers> parametro, int filasC, boolean canEdit){
        loader = new ClientLoader(filasC);
        ArrayList<JPanel> nuevo = loader.componentesEditarCliente(parametro, canEdit);
        if(canEdit){
            tiposActualizarCliente = loader.tiposActualizarCliente;
            nombresColumnasActualizar = loader.nombresColumnasActualizar;
            nombresColumnasNativasActualizar = loader.nombresColumnasNativasActualizar;
            //if(panelesUpdateUser.size() != nuevo.size()){
                panelesUpdateUser = new ArrayList();
                panelesUpdateUser.addAll(nuevo);
                subPanelNewUser1.setLayout(new GridLayout(0,1));
                for(JPanel pa: panelesUpdateUser){
                    subPanelNewUser1.add(pa);
                    subPanelNewUser1.revalidate();
                    subPanelNewUser1.repaint();
                }
                setVisible(true);
        }
        else{
            //if(panelesUpdateUser.size() != nuevo.size()){
                subPanelNewUser2.setLayout(new GridLayout(0,1));
                for(JPanel pa: nuevo){
                    subPanelNewUser2.add(pa);
                    subPanelNewUser2.revalidate();
                    subPanelNewUser2.repaint();
                }
                setVisible(true);
        }
       // }
    }
    private void createFiltros(){
        //ArrayList<PairTypeField> nombresColumna = new ArrayList();
        panel_filtroHome.removeAll();
        String query = "SELECT *" +
                        "FROM (((cliente JOIN contacto ON (cliente.contacto_idcontacto = contacto.id))\n" +
                        "JOIN empresa ON (cliente.empresa_idempresa = empresa.id))\n" +
                        "JOIN industria ON (cliente.industria_idindustria = industria.id)\n" +
                        "JOIN socialdata ON (cliente.socialdata_idsocialdata = socialdata.id)) WHERE cliente.id = -1";
        String countClient = "SELECT * FROM cliente WHERE id = -1";
        Statement st;
        Statement st2;
        int numeroFinalFiltro = 0;
        try{
            st = Postgre.bdConnection.createStatement();
            st2 = Postgre.bdConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSet rs2 = st2.executeQuery(countClient);
            ResultSetMetaData m = rs.getMetaData();
            ResultSetMetaData m2 = rs2.getMetaData();
            numeroFinalFiltro = m2.getColumnCount()-6;
            camposBuscar = new ArrayList();
            for(int i = 1; i<m.getColumnCount()+1;i++){
                if(m.getColumnName(i).contains("id") && !m.getColumnName(i).equals("apellido")){
                    continue;
                }
                else if(m.getColumnName(i).contains("foto")){
                    continue;
                }
                PairTypeField tempPair = new PairTypeField(m.getColumnTypeName(i),m.getColumnName(i));
                camposBuscar.add(tempPair);
            }
            
            
        }catch (SQLException ex){
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        loader2 = new FiltrosLoader(numeroFinalFiltro);
        ArrayList<JPanel> paneles = loader2.componentesFiltro(camposBuscar);
        nombresTextBoxBusqueda = new ArrayList();
        nombresTextBoxBusqueda.addAll(loader2.nombreTextBox);
        tablasCamposBuscar = new ArrayList();
        tablasCamposBuscar.addAll(loader2.tablasRetorno);
        nombresCheckBoxBusqueda = new ArrayList();
        nombresCheckBoxBusqueda.addAll(loader2.nombreCheckBox);
        panel_filtroHome.setLayout(new GridLayout(0, 1));
        for(JPanel pa : paneles){
            panel_filtroHome.add(pa);
            panel_filtroHome.revalidate();
            panel_filtroHome.repaint();
        }
        
        setVisible(true);
    }
    
    private void metaDataBusqueda(String query){
        Statement st, st2;
        ResultSet rs, rs2;
        ResultSetMetaData m , m2;
        int numFilas = 0;
        try{
            st = Postgre.bdConnection.createStatement();
            st2 = Postgre.bdConnection.createStatement();
            rs = st.executeQuery(query);
            rs2 = st2.executeQuery(query);
            m = rs.getMetaData();
            m2 = rs.getMetaData();
            
            while(rs.next()){
                
                numFilas+=1;       
            }
            int contadorColumnas = 0;
            for(int i = 0; i < m.getColumnCount();i++){
                if(m.getColumnName(i+1).contains("id") && !m.getColumnName(i+1).equals("apellido")){
                    continue;
                }
                else if(m.getColumnName(i+1).contains("foto")){
                    continue;
                }
                contadorColumnas+=1;
            }
            String[] titulos = new String[contadorColumnas];
            int count = 0;
            for(int i = 0; i < m.getColumnCount();i++){
                if(m.getColumnName(i+1).contains("id") && !m.getColumnName(i+1).equals("apellido")){
                    continue;
                }
                else if(m.getColumnName(i+1).contains("foto")){
                    continue;
                }
                titulos[count] =m.getColumnName(i+1);
                count++;
            }
            String[][] contenido = new String[numFilas][contadorColumnas];
            while(rs2.next()){
                count = 0;
                for(int i = 0; i < m2.getColumnCount();i++){
                    if(m2.getColumnName(i+1).contains("id") && !m2.getColumnName(i+1).equals("apellido")){
                    continue;
                    }
                    else if(m2.getColumnName(i+1).contains("foto")){
                        continue;
                    }
                    contenido[rs2.getRow()-1][count] = rs2.getString(i+1);
                    count++;
                }
            }
            iniciarTablaBusquedaHome(titulos, contenido);
        }catch(SQLException ex){
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void iniciarTablaBusquedaHome(String[] titulos, String[][] contenido){
        
        jTable1.removeColumnSelectionInterval(0, jTable1.getColumnCount()-1);
        this.jTable1.setModel(new javax.swing.table.DefaultTableModel(contenido,titulos));
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //recorrer columnas y ponerles un tamaño estandarizado
    } 
    
    public boolean existeColumna(String nombre){
        ArrayList<String> Columnas = new ArrayList();
        String query = "SELECT * FROM cliente WHERE id = -1";
        Statement st;
        Boolean existe = false;
        try {
            st = Postgre.bdConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData m = rs.getMetaData();
            
            for(int i = 1; i<=m.getColumnCount();i++){
                if(m.getColumnName(i).equals(nombre)){
                    existe = true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
    public void crearColumna(String nombre, String tipo){
        ArrayList<String> Columnas = new ArrayList();
        Statement st;
        String n2 = nombre.replaceAll("\\s+","");
        String query = "";
        //if(tipo.equals("date")){
            query = "ALTER TABLE cliente ADD "+n2+" "+tipo;
        //}
        //else{
        //    query = "ALTER TABLE cliente ADD "+nombre+" "+tipo+"("+tam+")";
        //}
        
        try {
            st = Postgre.bdConnection.createStatement();
            //System.out.println(query);
            st.execute(query);
            JOptionPane.showMessageDialog(null,
                        "Columna agregada con exito.");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean existeUsuarioUser(String nombre){
        ArrayList<String> Columnas = new ArrayList();
        String query = "SELECT usuario FROM usuario WHERE usuario = \'"+nombre+"\' ";
        Statement st;
        Boolean existe = false;
        try {
            st = Postgre.bdConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData m = rs.getMetaData();
            while(rs.next()){
                if(nombre.equals(rs.getString(1))){
                    existe = true;
                }        
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
    public void agregarUsuarioUser(String user, String pass){
        ArrayList<String> Columnas = new ArrayList();
        String query = "INSERT INTO usuario (usuario,password) VALUES (\'"+user+"\', md5(\'"+pass+"\'))";
        Statement st;
        try {
            st = Postgre.bdConnection.createStatement();
            st.execute(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                
                Frame pantallaPrincipal = new Frame();
                pantallaPrincipal.setVisible(false);
                LogIn pantallaInicio = new LogIn(pantallaPrincipal);
                pantallaInicio.setVisible(true);
                if(pantallaInicio.aceptado){
                    pantallaInicio.setVisible(false);
                    pantallaPrincipal.setVisible(true);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarColumna;
    private javax.swing.JButton btnAgregarUser;
    private javax.swing.JButton btn_buscarHome;
    private javax.swing.JButton btn_limpiarHome;
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox cmbBoxTipos;
    private javax.swing.JTextField fieldClientes;
    private javax.swing.JTextField fieldHashtags;
    private javax.swing.JTextField fieldMentions;
    private javax.swing.JTextField fieldNumHashtags;
    private javax.swing.JTextField fieldTexto;
    private javax.swing.JTextField fieldUsernames;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelImage1;
    private javax.swing.JLabel labelImage2;
    private javax.swing.JLabel lblColumna1;
    private javax.swing.JLabel lblColumna2;
    private javax.swing.JPanel panelAgregarUsuario;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JPanel panelFoto1;
    private javax.swing.JPanel panelFoto2;
    private javax.swing.JPanel panelNewUser;
    private javax.swing.JPanel panelSocial;
    private javax.swing.JPanel panel_filtroHome;
    private javax.swing.JTable resultsTable;
    private javax.swing.JPanel subPanelNewUser;
    private javax.swing.JPanel subPanelNewUser1;
    private javax.swing.JPanel subPanelNewUser2;
    private javax.swing.JScrollPane subPanelNewUser_A;
    private javax.swing.JScrollPane subPanelNewUser_A1;
    private javax.swing.JScrollPane subPanelNewUser_A2;
    private javax.swing.JTable tableTweets;
    private javax.swing.JPasswordField txtAgregarPass;
    private javax.swing.JTextField txtAgregarUser;
    private javax.swing.JTextArea txtAreaAgregarColumna;
    private javax.swing.JTextField txtColumnaNueva1;
    // End of variables declaration//GEN-END:variables
}
