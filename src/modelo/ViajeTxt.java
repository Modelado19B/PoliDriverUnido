package modelo;

import java.io.*;
import java.util.*;

/**
 *
 * @author Personal
 */
public class ViajeTxt {

    String cedulaConductor;
    String nombreConductor;
    String apellidoConductor;
    String totalAsientos;
    String tipoAuto;
    String placaVehiculo;
    String id;
    String cuidadOrigen;
    String cuidadDestino;
    String fechaSalida;
    String horaSalida;
    String horaLlegada;
    String precio;
    String Asientos;
    //creamos el archivo, una lista para manejar los datos y un objeto para poder manipular los datos en la lista
    File viajeTxt = new File("ViajeTemporal.txt");
    File Base = new File("BaseDatos.txt");
    Random Id = new Random();

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fichero = null;
    PrintWriter escrive = null;
    //comprobamos la creación del archivo       

//insertamos datos en el archivo      
    public void listar() {
        Scanner sc;
        try {
            sc = new Scanner(viajeTxt);
            while (sc.hasNextLine()) {

                String linea = sc.nextLine();
                StringTokenizer tk = new StringTokenizer(linea, "++");
                cedulaConductor = tk.nextToken();
                nombreConductor = tk.nextToken();
                apellidoConductor = tk.nextToken();
                totalAsientos = tk.nextToken();
                tipoAuto = tk.nextToken();
                placaVehiculo = tk.nextToken();
                id = tk.nextToken();
                cuidadOrigen = tk.nextToken();
                cuidadDestino = tk.nextToken();
                fechaSalida = tk.nextToken();
                horaSalida = tk.nextToken();
                horaLlegada = tk.nextToken();
                precio = tk.nextToken();
                Asientos = tk.nextToken();

                System.err.println(sc);
            }
            sc.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sobrescribir() {
        try {
            BufferedWriter Escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Base, true), "utf-8"));
            Escribir.write(id + "++");
            Escribir.write(cuidadOrigen + "++");
            Escribir.write(cuidadDestino + "++");
            Escribir.write(fechaSalida + "++");
            Escribir.write(totalAsientos + "++");
            Escribir.write(Asientos + "++");
            Escribir.write(precio + "++");
            Escribir.write(nombreConductor + apellidoConductor + "++");
            Escribir.write(cedulaConductor + "++");
            Escribir.write(tipoAuto + "++");
            Escribir.write(placaVehiculo + "++");
            Escribir.write(horaSalida + "++");
            Escribir.write(horaLlegada + "{}\r\n");
            System.err.println("Escribir");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

   public void GuardarArchivo(Vector ln) {
        try {
            fichero = new FileWriter("ViajeTemporal.txt");
            escrive = new PrintWriter(fichero);
            for (int i = 0; i < ln.size(); i++) {
                escrive.println(ln.elementAt(i));
            }
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public void BorrarLinea(int n) {
        Vector lineas = new Vector();
        try {
            archivo = new File("ViajeTemporal.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int cont = 0;
            while ((linea = br.readLine()) != null) {
                cont++;
                if (cont != n) {
                    lineas.addElement(linea);//AGREGAR LINEAS A UN VECTOR
                }
            }
            br.close();
            fr.close();
            //Se guarda de nuevo el archivo
            GuardarArchivo(lineas);
            lineas.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// 

