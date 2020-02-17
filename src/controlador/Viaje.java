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
    
     public void renderizarTabla(JTable tablaViajes) {

        for (int i = 1; i < tablaViajes.getColumnCount(); i++) {
            DefaultTableColumnModel colModel = (DefaultTableColumnModel) tablaViajes.getColumnModel();
            TableColumn col = colModel.getColumn(i);
            int width = 0;
            TableCellRenderer renderer = col.getHeaderRenderer();
            for (int r = 0; r < tablaViajes.getRowCount(); r++) {
                renderer = tablaViajes.getCellRenderer(r, i);
                Component comp = renderer.getTableCellRendererComponent(tablaViajes, tablaViajes.getValueAt(r, i),
                        false, false, r, i);
                width = Math.max(width, comp.getPreferredSize().width);
            }
            col.setPreferredWidth(width + 2);
        }
        tablaViajes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaViajes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaViajes.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaViajes.getColumnModel().getColumn(0).setResizable(false);
    }

    public void actualizarTabla(ListaViaje listaViaje, JTable tablaViajes, DefaultTableModel modelo) {
        cargarTabla(tablaViajes, modelo);
        LinkedList<DATOS_DEL_VIAJE> Viajes = new LinkedList<>();
        Viajes = listaViaje.listadoViajes();
        for (DATOS_DEL_VIAJE m : Viajes) {
            modelo.addRow(new Object[]{m.getIndiceViaje(),m.getCi_conductor(),m.getApellidoConductor(),m.getAuto(), m.getLugar_origen(), m.getLugar_destino(), m.getFecha()});
        }
        tablaViajes.setModel(modelo);
        renderizarTabla(tablaViajes);
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
