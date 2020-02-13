/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author User
 */
public class TARJETA {
    private String cedula,titular,numeroTarjeta, fechaTarjeta;

    public TARJETA() {
    }

    public TARJETA(String cedula, String titular, String numeroTarjeta, String fechaTarjeta) {
        this.cedula = cedula;
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaTarjeta = fechaTarjeta;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public String getFechaTarjeta() {
        return fechaTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setFechaTarjeta(String fechaTarjeta) {
        this.fechaTarjeta = fechaTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void aniadirArchivoTarjetas(String data) {
        BufferedWriter bw = null;
        FileWriter fw = null;
	FileWriter flwriter = null;
        
		try {
        
                     File file = new File("Tarjetas_usuarios.txt");

                   if (!file.exists()) {
                       
                       file.createNewFile();
                   }

                        fw = new FileWriter(file.getAbsoluteFile(), true);
                        bw = new BufferedWriter(fw);
                        bw.write(data);
                        System.out.println("información agregada!");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                            try {

                                if (bw != null)
                                    bw.close();
                                if (fw != null)
                                    fw.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                          }
    }
    
}
