/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.*;
import vistas.*;
import modelo.*;
import controlador.CONTROL_USUARIOS;
/**
 *
 * @author User
 */
public class LOGEO {
    
    public boolean credencialesConductores(String user, String pass) {
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

            FileReader fr = new FileReader("Usuario_solo_Conductores.txt");
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
                    tipoli =tokens.nextToken();
                    fechalic = tokens.nextToken();
                    if (cedula1.equals(user)==true&&contraseña1.equals(pass)){
                        return true;
                    }
                }
            }
            
        } catch (Exception e) {
        }
                
return false;}

public boolean credencialesPasajeros(String user, String pass) {
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
                    if (cedula1.equals(user)==true&&contraseña1.equals(pass)==true){
                        return true;
                    }
                }
            }
            
        } catch (Exception e) {
        }
                
return false;}    
    
    
public boolean ingresar_Sistema_Conductor(String usuario,String contraseña)
    {
        
            
        if(credencialesConductores(usuario, contraseña)==true)
            {                 
                return true;
            }   
        return false;
            
    }
public boolean ingresar_Sistema_Pasajero(String usuario,String contraseña)
    {
        
            
        if(credencialesPasajeros(usuario, contraseña)==true)
            {                 
                return true;
            }   
        return false;
            
    }

public PASAJERO Pasajero(String user) {
        StringTokenizer tokens;
        String cedula1="";
        String nombre = "";
        String contraseña1= "";
        String tipo = "";
        String apellido1="";
        String sexo1="";
        String correo1="";
        String Usuario1="";
        String fechanac="";
        try {

            FileReader fr = new FileReader("Usuario_solo_Pasajeros.txt");
            BufferedReader br = new BufferedReader(fr);
            String cadena;

            while ((cadena = br.readLine()) != null) {
                tokens = new StringTokenizer(cadena, "++");
                while (tokens.hasMoreElements()) {
                    cedula1 = tokens.nextToken();
                    nombre = tokens.nextToken();
                    apellido1 = tokens.nextToken();
                    sexo1= tokens.nextToken();
                    correo1= tokens.nextToken();
                    Usuario1= tokens.nextToken();
                    contraseña1= tokens.nextToken();
                    fechanac= tokens.nextToken();  
                    if (cedula1.equals(user)==true){
                        
                       PASAJERO pasajero = new PASAJERO(nombre, apellido1, cedula1, sexo1, correo1, Usuario1, contraseña1, fechanac);
                       return pasajero;
                    }
                }
            }
            
        } catch (Exception e) {
        }
                
return null;}
}
            

