package modelo;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class ARCHIVOS_PLANOS {

   
    String cedulaConductor,nombreConductor,apellidoConductor,cedulaC ,tipoAuto,Marca2,Marca3,Marca4,totalAsientos,placaVehiculo;
   String CedulaLogin="";
   
   String IdV, CedulaV ,NombreV ,ApellidoV ,NasientosV,MarcaV ,PlacaV ,COrigenV , CDestinoV , FechaV,HoraV,TEstipadoV,CostoV,AsientosUsV;
   String MatrizViaje[][];
    Scanner sc;
    Scanner sv;
    Scanner dv;
    public String getTotalAsientos() {
        return totalAsientos;
    }

    public String getCedulaLogin() {
        return CedulaLogin;
    }

    public void setCedulaLogin(String CedulaLogin) {
        this.CedulaLogin = CedulaLogin;
    }
   
   
    public Lista leerArchivo(String Cedula) {
        
        CedulaLogin=Cedula;
        
//        File DatosConductor = new File("Usuario_solo_Conductores");
        File DatosVehiculo = new File("Conductores_vehiculos.txt");
//        if (DatosConductor.exists() == false) {
//            return new Lista();
//        }
         if (DatosVehiculo.exists() == false) {
            return new Lista();
        }
        /* Lista listaConductor = new Lista();
         Lista listaVehiculo = new Lista();*/
       
        try {
////            sc = new Scanner(DatosConductor);
            sv = new Scanner(DatosVehiculo);
            while (sv.hasNextLine())
            {
                
                String linea2 = sv.nextLine();
//                String linea = sc.nextLine();
//                StringTokenizer tk = new StringTokenizer(linea, "++");
                StringTokenizer tk2 = new StringTokenizer(linea2, "++");
                cedulaConductor = tk2.nextToken();
                nombreConductor = tk2.nextToken();
                apellidoConductor = tk2.nextToken();
//              cedulaC = tk2.nextToken();
                placaVehiculo = tk2.nextToken();
                tipoAuto = tk2.nextToken();
                Marca2 = tk2.nextToken();
                Marca3 = tk2.nextToken();
                totalAsientos = tk2.nextToken();
                
                
               
            }//fin while
//            sc.close();
            sv.close();
        } catch (FileNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "No se encontró la Base de Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } 
        return null;
 
    }
    
    
    public void guardarrArchivo()
    {
      
         //comparacion entre Cedulas
// if (cedulaConductor == null ? cedulaC == null : cedulaConductor.equals(cedulaC) && CedulaLogin.equals(cedulaConductor)){
                     Random Id = new Random();
                     int id=Id.nextInt(10000);
                     
                     if (id > 9000){
                         id=id+100;
                     }
                     else {
                         id=id+1000;
                     }
                     
                DATOS_CONDUCTOR aux = new DATOS_CONDUCTOR(id, cedulaConductor, nombreConductor, apellidoConductor, totalAsientos, tipoAuto, placaVehiculo); //pasajeros
                //listaConductor.agregarConductor(aux);

                
                 File viajeTxt = new File("ViajeTemporal.txt");
                try {
                if (viajeTxt.createNewFile()) {
                    System.out.println("Se ha creado el archivo");
                }
                 } catch (IOException e) {
                System.out.println("No se creó el archivo");
                }
                try {

                BufferedWriter Escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(viajeTxt, true), "utf-8"));
                Escribir.write(aux.getId() + "++");
                Escribir.write(aux.getCedulaConductor() + "++");
                Escribir.write(aux.getNombreConductor() + "++");
                Escribir.write(aux.getApellidoConductor() + "++");
                Escribir.write(aux.getTotalAsientos() + "++");
                Escribir.write(aux.getTipoAuto()+ "++");
                Escribir.write(aux.getPlacaVehiculo()+ "++");
                System.out.println("Datos ingresados");
                Escribir.close();
               
//                sc.close();
                sv.close();
                
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
                     System.out.println(aux);                   
                
        
    }
}
