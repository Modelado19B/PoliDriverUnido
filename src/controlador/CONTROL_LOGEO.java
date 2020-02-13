/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.*;
import javax.swing.*;
import vistas.*;


/**
 *
 * @aer
 */
public class CONTROL_LOGEO {

    public boolean control_ingreso(JTextField usuario, JPasswordField contraseña, JFrame login, JRadioButton pasajero, JRadioButton conductor) {

        LOGEO logeo = new LOGEO();

        if (conductor.isSelected()) {

            if (logeo.ingresar_Sistema_Conductor(usuario.getText(), contraseña.getText()) == true) {
                ARCHIVOS_PLANOS ar = new ARCHIVOS_PLANOS();
                ar.leerArchivo(usuario.getText());
                FORMULARIO_VIAJE1 fv = new FORMULARIO_VIAJE1();
                fv.setLocationRelativeTo(null);
                fv.setVisible(true);
                login.setVisible(false);
                return true;
            } 
        }
        if (pasajero.isSelected()) {
            if (logeo.ingresar_Sistema_Pasajero(usuario.getText(), contraseña.getText()) == true) {
                
                VentanaPublicacion ventanapub = new VentanaPublicacion(logeo.Pasajero(usuario.getText()));
                ventanapub.setVisible(true);
                login.setVisible(false);
                return true;
            }
        }

    return false;}
}
