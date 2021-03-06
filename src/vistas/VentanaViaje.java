package vistas;

import controlador.Disponibilidad;
import modelo.Archivos;
import controlador.ListaViaje;
import controlador.Publicacion;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.PAGO_VIAJE;
import modelo.PASAJERO;

public final class VentanaViaje extends javax.swing.JDialog {

    ListaViaje listaViaje;
    Disponibilidad disponibilidad;
    Archivos archivo;
    String indiceViaje;
    VentanaPublicacion ventanaVi;
    String cedula;
    int precio;
    PASAJERO pasajero;
    String cedulaConductor;
    
    

    Publicacion publicacion = new Publicacion();

    public void VerViaje() {
        jLabel28.setText(pasajero.getNombre());
        jLabel5.setText(listaViaje.buscarViaje(indiceViaje).getLugar_origen());
        jLabel6.setText(listaViaje.buscarViaje(indiceViaje).getLugar_destino());
        jLabel7.setText(String.valueOf(listaViaje.buscarViaje(indiceViaje).getTotal_asientos_disponibles()));
        jLabel9.setText(String.valueOf(listaViaje.buscarViaje(indiceViaje).getPrecio()));
        jLabel10.setText(listaViaje.buscarViaje(indiceViaje).getConductor());
        cedu_conductor.setText(String.valueOf(listaViaje.buscarViaje(indiceViaje).getCi_conductor()));
        jLabel11.setText(listaViaje.buscarViaje(indiceViaje).getAuto());
        jLabel12.setText(listaViaje.buscarViaje(indiceViaje).getPlaca());
        lblFecha.setText(listaViaje.buscarViaje(indiceViaje).getFecha());
        lblSalida.setText(listaViaje.buscarViaje(indiceViaje).getHora_salida());
        lblLlegada.setText(listaViaje.buscarViaje(indiceViaje).getHora_llegada());
        cedulaConductor=listaViaje.buscarViaje(indiceViaje).getCi_conductor();

    }

    public VentanaViaje(java.awt.Frame parent, boolean modal, ListaViaje listaViajes, String indiceViaje, VentanaPublicacion jfm, PASAJERO pasajero) {
        super(parent, modal);
        this.listaViaje = listaViajes;
        this.indiceViaje = indiceViaje;
        this.ventanaVi = jfm;
        this.pasajero = pasajero;
        archivo = new Archivos();
        disponibilidad = new Disponibilidad(listaViajes.getRaiz());
        initComponents();
        this.setLocationRelativeTo(null);
        VerViaje();
        this.cedula = cedula;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblSalida = new javax.swing.JLabel();
        lblLlegada = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtNumAsi = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cedu_conductor = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("CI:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalles del viaje");
        setMinimumSize(new java.awt.Dimension(220, 220));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Anotación 2020-01-23 030344 (2).png"))); // NOI18N
        jLabel24.setToolTipText("");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 240, 70));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perfil (1).png"))); // NOI18N
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 70, 80));

        jLabel28.setText("Usuario");
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 120, 20));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 210, 100));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-105, 5, 690, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 110));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Origen:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Destino:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio Asiento");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 190, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fecha:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 120, 40));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 110, 30));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 130, 30));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 30, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 70, 30));

        jLabel11.setText("Vehiculo");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jLabel12.setText("Placa");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        jLabel10.setText("Conductor");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        botonCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 110, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("$");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 30, 30));
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 70, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Asientos Disponibles:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("CI conductor:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 120, 150, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Vehículo:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 150, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Placa:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, 40));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Hora de Salida:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 110, 40));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Hora de Llegada:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 120, 40));

        lblFecha.setText("jLabel4");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));
        lblFecha.getAccessibleContext().setAccessibleName("lblFecha");

        lblSalida.setText("jLabel4");
        jPanel1.add(lblSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));
        lblSalida.getAccessibleContext().setAccessibleName("lblSalida");

        lblLlegada.setText("jLabel4");
        jPanel1.add(lblLlegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, 20));
        lblLlegada.getAccessibleContext().setAccessibleName("lblLlegada");

        jButton1.setText("Unirse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 80, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Seleccione el número de asientos:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));
        jPanel1.add(txtNumAsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 80, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Conductor:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 150, 40));

        cedu_conductor.setText("jLabel4");
        jPanel1.add(cedu_conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 500, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (Integer.parseInt(this.txtNumAsi.getText()) > 0) {
            precio = publicacion.PrecioTotal(listaViaje.buscarViaje(indiceViaje).getPrecio(), Integer.parseInt(this.txtNumAsi.getText()));
            if (listaViaje.buscarViaje(indiceViaje).getTotal_asientos_disponibles() >= Integer.parseInt(this.txtNumAsi.getText())) {
                if (JOptionPane.showConfirmDialog(null, "El precio total del viaje es de: $" + precio + "\n¿Continuar?\n", "Precio total", JOptionPane.YES_NO_OPTION) == 0) {
                    if (pagarViaje() == true) {
                        this.disponibilidad.bajarDisponibilidad(indiceViaje, Integer.parseInt(this.txtNumAsi.getText()));
                        if(listaViaje.buscarViaje(indiceViaje).getTotal_asientos_disponibles()==0)
                        this.listaViaje.eliminarViaje(indiceViaje);
                        archivo.guardarArchivo(listaViaje);
                        this.dispose();
                    }
                  
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficientes asientos!");

            }
        }

        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean pagarViaje() {       
        
        PAGO_VIAJE pg = new PAGO_VIAJE();
        return pg.pagar(pasajero, precio, cedulaConductor, indiceViaje, this.txtNumAsi.getText());
       


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel cedu_conductor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLlegada;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JTextField txtNumAsi;
    // End of variables declaration//GEN-END:variables
}
