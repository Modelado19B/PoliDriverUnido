/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author david
 */
public class ActualizaDisponibilidad {

    public ArrayList genDisponivilidad() {
        ArrayList<DisponibilidadModelo> modelos = new ArrayList<DisponibilidadModelo>();

        DisponibilidadModelo modelo = null;

        String numero = "";
        boolean estado = false;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("ViajeTemporal.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "++");
                modelo = new DisponibilidadModelo(
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken());
                modelos.add(modelo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return modelos;
    }    
    
    public void guardaDisponibilidad(ArrayList modelos) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("ViajeTemporal.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < modelos.size(); i++) {
                pw.println(modelos.get(i).toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        };
    }   
    
    public void reduce(String viaje,int cantidad){
        ArrayList<DisponibilidadModelo> modelos = genDisponivilidad();
        for (int i = 0; i < modelos.size(); i++) {
            if(modelos.get(i).getDato1().equals(viaje)){
                modelos.get(i).reduce(cantidad);
            }
        }
        guardaDisponibilidad(modelos);
    }
    
    public void aumenta(String viaje,int cantidad){
        ArrayList<DisponibilidadModelo> modelos = genDisponivilidad();
        for (int i = 0; i < modelos.size(); i++) {
            if(modelos.get(i).getDato1().equals(viaje)){
                modelos.get(i).aumenta(cantidad);
            }
        }
        guardaDisponibilidad(modelos);
    }

}
