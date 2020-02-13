/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import modelo.PASAJERO;
import modelo.TARJETA;

public class CONTROL_USUARIOS {
    
private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
private static final String ID = "^[A-Z]+";

    public static boolean validar_email(String email) 
        {
            Pattern pattern = Pattern.compile(PATTERN_EMAIL);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }

    
    public static boolean validar_letras (String id)
        {
            Pattern pattern = Pattern.compile(ID);
            Matcher matcher = pattern.matcher(id);
            return matcher.matches();
        }
    
    
    

    public boolean validar_campos_pasajero(JTextField nombre,JTextField apellido,JTextField cedula,JTextField correo)
        {
            if(validar_letras(nombre.getText())==false){
                nombre.setBackground(Color.red);
                return false;
            } 
             if(validar_letras(apellido.getText())==false){
                apellido.setBackground(Color.red);
                return false;
            } if(cedula.getText().isEmpty()==true)
            {
                cedula.setBackground(Color.red);
                return false;
            } if (validar_email(correo.getText())==false){
                correo.setBackground(Color.red);
                return false;
            } 
              
            return true;
        }
    public void pintar_campos_pasajero(JTextField nombre,JTextField apellido,JTextField cedula,JTextField correo,JLabel texto){
        
        nombre.setBackground(Color.GREEN);
        apellido.setBackground(Color.GREEN);
        cedula.setBackground(Color.GREEN);
        correo.setBackground(Color.GREEN);
        texto.setText("Cédula:");
        texto.setBackground(Color.GREEN);
    }
    public boolean control_guardado_pasajero(String nombre1,String apellido1, String cedula1,String sexo1, String correo1,String fechanac,String Usuario1,String contraseña1 ){
        
        PASAJERO pas = new PASAJERO(nombre1, apellido1, cedula1, sexo1, correo1, Usuario1, contraseña1, fechanac);
        pas.aniadirArchivoPasajero(cedula1+"++"+nombre1+"++"+ apellido1+"++"+ sexo1+"++"+ correo1+"++"+ Usuario1+"++"+ contraseña1+"++"+fechanac+"\n");
        
    return true;
    } 
    public boolean control_guardadotarjeta(String cedula, String titular, String numero_tarjeta,String fechade_expi){
        
        TARJETA tar = new TARJETA(cedula, titular, numero_tarjeta,fechade_expi );
        tar.aniadirArchivoTarjetas(cedula+"++"+titular+"++"+numero_tarjeta+"++"+fechade_expi+"\n");
    return true;
    }
    public boolean control_guardado_conductor(String nombre1,String apellido1, String cedula1,String sexo1, String correo1,String fechanac,String Usuario1,String contraseña1, String tipo, Date fechali ){
        
       CONDUCTOR con = new CONDUCTOR(nombre1, apellido1, cedula1, sexo1, correo1, Usuario1, contraseña1, tipo, fechanac, fechali);
       con.aniadirArchivoConductores(cedula1+"++"+nombre1+"++"+apellido1+"++"+sexo1+"++"+correo1+"++"+Usuario1+"++"+contraseña1+"++"+fechanac+"++"+tipo+"++"+fechali+"\n");
    return true;
    }
    public boolean control_guardado_conductor_vehiculo(String cedula,String nombre1,String apellido1, String placa,String marca1, String modelo1, String color1, String asientos ){
        
        VEHICULO conve = new VEHICULO(cedula, nombre1, placa, marca1, modelo1, color1, asientos);
       conve.aniadirArchivoConductores_vehiculo(cedula+"++"+nombre1+"++"+apellido1+"++"+placa+"++"+marca1+"++"+modelo1+"++"+color1+"++"+asientos+"\n");
    return true;
    }
    
    
    public boolean validar_campos_vehiculo(JTextField Placa,JTextField Marca, JTextField modelo, JTextField color ){
        if(validar_letras(Marca.getText())==false){
            Marca.setBackground(Color.red);
            return false;            
        }if(validar_letras(modelo.getText())==false){
            modelo.setBackground(Color.red);
            return false;
        }if(validar_letras(color.getText())==false){
            color.setBackground(Color.red);
            return false;
        }
    return true; 
    } 
    public boolean validar_cedula(String cedula){
       StringTokenizer tokens;
        String cedula1="";
        String usuario = "";
        String contraseña1= "";
        String tipo = "";
        String apellido1="";
        String sexo1="";
        String correo1="";
        String Usuario1="";
        String fechanac="";
        String tipoli="";
        String fechalic="";
                
        
        try {

            FileReader fr = new FileReader("Usuario_solo_Pasajeros.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena;

            while ((cadena = br.readLine()) != null) {
                tokens = new StringTokenizer(cadena, "++");
                while (tokens.hasMoreElements()) {
                    cedula1 = tokens.nextToken();
                    usuario = tokens.nextToken();
                    apellido1 = tokens.nextToken();
                    sexo1= tokens.nextToken();
                    correo1= tokens.nextToken();
                    Usuario1= tokens.nextToken();
                    contraseña1= tokens.nextToken();
                    fechanac= tokens.nextToken();
                 
                    
                    if (cedula1.equals(cedula1)==true){
                        return false;
                        
                    }
                }
            }

        } catch (Exception e) {
        }
     
    return true;
    }
    
    public static void aniadirArchivoCuenta(String data) {
        BufferedWriter bw = null;
        FileWriter fw = null;
	FileWriter flwriter = null;
        
		try {
                     File file = new File("cuentas.txt");

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
    public boolean control_guardado_cuenta(String tarjeta){
        
       
       aniadirArchivoCuenta(tarjeta+"|111|1000.0"+"\n");
    return true;
    }
    
}
