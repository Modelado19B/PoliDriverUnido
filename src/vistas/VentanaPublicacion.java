package vistas;

import modelo.Archivos;
import controlador.Filtro;
import controlador.ListaViaje;
import controlador.Publicacion;
import modelo.DATOS_DEL_VIAJE;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PASAJERO;
public class VentanaPublicacion extends javax.swing.JFrame {

    DefaultTableModel modelo;
    VentanaViaje verViaje;
    ListaViaje listaViaje;
    String nombrePasajero;
    String cedulaPasajero;
    PASAJERO pasajero;

    Publicacion publicacion = new Publicacion();
    Archivos archivos = new Archivos();
    Filtro filtro = new Filtro();
    
      

    public VentanaPublicacion(PASAJERO pasajero) {  //String nombre
        initComponents();
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);       
        this.setResizable(false);
        this.nombrePasajero = pasajero.getNombre()+" "+pasajero.getApellido();
        this.cedulaPasajero = pasajero.getCedula();
        this.pasajero = pasajero;
        jLabel6.setText(nombrePasajero);
        this.modelo = publicacion.cargarModelo(modelo);
        this.tablaViajes = publicacion.cargarTabla(tablaViajes, modelo);
        listaViaje=archivos.leerArchivo();
        publicacion.actualizarTabla(listaViaje,tablaViajes, modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoFiltro = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        botonVerViaje = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JtxtFiltro = new javax.swing.JTextField();
        optDestino = new javax.swing.JRadioButton();
        optOrigen = new javax.swing.JRadioButton();
        optFecha = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaViajes = new javax.swing.JTable();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("POLIDRIVER");
        jPanel5.add(jLabel2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PUBLICACION");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        botonVerViaje.setText("Ver Viaje");
        botonVerViaje.setEnabled(false);
        botonVerViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerViajeActionPerformed(evt);
            }
        });
        jPanel3.add(botonVerViaje);

        botonCancelar.setText("Salir");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(botonCancelar);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Anotación 2020-01-23 030344 (2).png"))); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 240, 70));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perfil (1).png"))); // NOI18N
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 70, 70));

        jLabel6.setText("Usuario");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 100, 30));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 0, 290, 90));

        jPanel6.add(jPanel7);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Filtrar:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 90, 20));

        JtxtFiltro.setEnabled(false);
        JtxtFiltro.setPreferredSize(new java.awt.Dimension(90, 26));
        JtxtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtxtFiltroActionPerformed(evt);
            }
        });
        JtxtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtxtFiltroKeyTyped(evt);
            }
        });
        jPanel2.add(JtxtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 270, -1));

        GrupoFiltro.add(optDestino);
        optDestino.setText("Destino");
        optDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDestinoActionPerformed(evt);
            }
        });
        jPanel2.add(optDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        GrupoFiltro.add(optOrigen);
        optOrigen.setText("Origen");
        optOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optOrigenActionPerformed(evt);
            }
        });
        jPanel2.add(optOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        GrupoFiltro.add(optFecha);
        optFecha.setText("Fecha");
        optFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optFechaActionPerformed(evt);
            }
        });
        jPanel2.add(optFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jPanel6.add(jPanel2);

        jPanel4.add(jPanel6);

        tablaViajes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaViajes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaViajes.getTableHeader().setResizingAllowed(false);
        tablaViajes.getTableHeader().setReorderingAllowed(false);
        tablaViajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaViajesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaViajes);

        jPanel4.add(jScrollPane2);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, "card2");

        getAccessibleContext().setAccessibleName("Lista de Metros");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
       if(JOptionPane.showConfirmDialog(null,"¿Desea salir?", "", JOptionPane.YES_NO_OPTION)==0){
            this.dispose();
        }
        
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void tablaViajesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaViajesMouseReleased
        
        if (tablaViajes.getSelectedRow() >= 0) {
            botonVerViaje.setEnabled(true);
        } else {
            botonVerViaje.setEnabled(false);
        }
    }//GEN-LAST:event_tablaViajesMouseReleased

    private void botonVerViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerViajeActionPerformed
        String indiceViaje = (String) this.tablaViajes.getValueAt(this.tablaViajes.getSelectedRow(), 0);
        verViaje = new VentanaViaje(this, rootPaneCheckingEnabled, this.listaViaje, indiceViaje, this, pasajero);
        verViaje.setVisible(true);
        modelo.setRowCount(0);
        publicacion.actualizarTabla(listaViaje, tablaViajes, modelo);
        
        
       
    }//GEN-LAST:event_botonVerViajeActionPerformed

    
    private void JtxtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtxtFiltroKeyTyped
        
        filtro.filtrar(evt, tablaViajes, JtxtFiltro, modelo, optOrigen, optDestino);
        
    }//GEN-LAST:event_JtxtFiltroKeyTyped

    private void optDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDestinoActionPerformed
        JtxtFiltro.setEnabled(true);
    }//GEN-LAST:event_optDestinoActionPerformed

    private void optOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optOrigenActionPerformed
        JtxtFiltro.setEnabled(true);

    }//GEN-LAST:event_optOrigenActionPerformed

    private void JtxtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtxtFiltroActionPerformed
        
    }//GEN-LAST:event_JtxtFiltroActionPerformed

    private void optFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optFechaActionPerformed
        JtxtFiltro.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_optFechaActionPerformed
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoFiltro;
    private javax.swing.JTextField JtxtFiltro;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonVerViaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton optDestino;
    private javax.swing.JRadioButton optFecha;
    private javax.swing.JRadioButton optOrigen;
    private javax.swing.JTable tablaViajes;
    // End of variables declaration//GEN-END:variables
}
