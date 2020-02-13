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
public class CONDUCTOR {
    private String nombre, apellido, cedula,sexo,correo,usuario,contraseña,tipoli,fechanac;
    private Date fechali;

    public CONDUCTOR(String nombre, String apellido, String cedula, String sexo, String correo, String usuario, String contraseña, String tipoli, String fechanac, Date fechali) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.sexo = sexo;
        this.correo = correo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipoli = tipoli;
        this.fechanac = fechanac;
        this.fechali = fechali;
    }

    public CONDUCTOR() {
    }

    public String getApellido() {
        return apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCedula() {
        return cedula;
    }

    public Date getFechali() {
        return fechali;
    }

    public String getFechanac() {
        return fechanac;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTipoli() {
        return tipoli;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechali(Date fechali) {
        this.fechali = fechali;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoli(String tipoli) {
        this.tipoli = tipoli;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
     
    public static void aniadirArchivoConductores(String data) {
        BufferedWriter bw = null;
        FileWriter fw = null;
	FileWriter flwriter = null;
        
		try {
                     File file = new File("Usuario_solo_Conductores.txt");

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
