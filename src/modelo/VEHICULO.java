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

/**
 *
 * @author User
 */
public class VEHICULO {
    private String cedula,titularv,placa,marca,modelo,color,asientos;

    public VEHICULO() {
    }

    public VEHICULO(String cedula, String titularv, String placa, String marca, String modelo, String color, String asientos) {
        this.cedula = cedula;
        this.titularv = titularv;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.asientos = asientos;
    }

    public String getAsientos() {
        return asientos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTitularv() {
        return titularv;
    }

    public void setAsientos(String asientos) {
        this.asientos = asientos;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTitularv(String titularv) {
        this.titularv = titularv;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
 
   public static void aniadirArchivoConductores_vehiculo(String data) {
        BufferedWriter bw = null;
        FileWriter fw = null;
	FileWriter flwriter = null;
        
		try {
                     File file = new File("Conductores_vehiculos.txt");

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
