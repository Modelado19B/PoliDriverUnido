/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Component;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import modelo.DATOS_DEL_VIAJE;

/**
 *
 * @author Admini
 */
public class Viaje {

    public void actualizarTabla(ListaViaje listaViaje, JTable tablaViajes, DefaultTableModel modelo) {
        cargarTabla(tablaViajes, modelo);
        LinkedList<DATOS_DEL_VIAJE> Viajes = new LinkedList<>();
        Viajes = listaViaje.listadoViajes();
        for (DATOS_DEL_VIAJE m : Viajes) {
            if (m.getApellidoConductor().equals("VILA")) {
                modelo.addRow(new Object[]{m.getIndiceViaje(), m.getCi_conductor(), m.getApellidoConductor(), m.getAuto(), m.getLugar_origen(), m.getLugar_destino(), m.getFecha()});
            }
        }
        tablaViajes.setModel(modelo);
        tablaViajes.revalidate();

    }

    public JTable cargarTabla(JTable tablaViajes, DefaultTableModel modelo) {

        tablaViajes.setModel(modelo);
        return tablaViajes;

    }

    public DefaultTableModel cargarModelo(DefaultTableModel modelo) {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        modelo.addColumn("Indice");
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Auto");
        modelo.addColumn("Origen");
        modelo.addColumn("Destino");
        modelo.addColumn("Fecha");

        return modelo;

    }

}
