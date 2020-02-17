/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author david
 */
public class DisponibilidadModelo {
    
    private String dato1;
    private String dato2;
    private String dato3;
    private String dato4;
    private String dato5;
    private String dato6;
    private String dato7;
    private String dato8;
    private String dato9;
    private String dato10;
    private String dato11;
    private String dato12;
    private String dato13;
    private String dato14;
    private String dato15;

    public DisponibilidadModelo(String dato1, String dato2, String dato3, String dato4, String dato5, String dato6, String dato7, String dato8, String dato9, String dato10, String dato11, String dato12, String dato13, String dato14, String dato15) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
        this.dato5 = dato5;
        this.dato6 = dato6;
        this.dato7 = dato7;
        this.dato8 = dato8;
        this.dato9 = dato9;
        this.dato10 = dato10;
        this.dato11 = dato11;
        this.dato12 = dato12;
        this.dato13 = dato13;
        this.dato14 = dato14;
        this.dato15 = dato15;
    }    

    @Override
    public String toString() {
        return dato1 + "++" + dato2 + "++" + dato3 + "++" + dato4 + "++" + dato5 + "++" + dato6 + "++" + dato7 + "++" + dato8 + "++" + dato9 + "++" + dato10 + "++" + dato11 + "++" + dato12 + "++" + dato13 + "++" + dato14 + "++" + dato15;
    }

    public String getDato1() {
        return dato1;
    }
    
    public void reduce(int cantidad){
        int n = Integer.parseInt(dato14);
        if(n>=cantidad){
            n= n- cantidad;
            dato14= n+"";
        }else{
            System.out.println("Cantidad Incorrecta");
        }
    }
    public void aumenta(int cantidad){
        int n = Integer.parseInt(dato14);
        n = n + cantidad;
        dato14= n+"";        
    } 
    
}
