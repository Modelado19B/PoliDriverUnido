package modelo;

import controlador.ListaViaje;
import controlador.Nodo;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DATOS_DEL_VIAJE;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// import modelo.Pasajero;

public class Archivos {

    public boolean guardarArchivo(ListaViaje lista) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        File f = new File("ViajeTemporal.txt");
        BufferedWriter bfwriter;
        try {
            if (!f.exists()) {
                f.createNewFile();
                bfwriter = new BufferedWriter(new FileWriter(f, true));
            } else {
                f.delete();
                File n = new File("ViajeTemporal.txt");
                bfwriter = new BufferedWriter(new FileWriter(n, true));
            }

            Nodo aux = lista.getRaiz();

            while (aux != null) {
                DATOS_DEL_VIAJE t = aux.getViaje();
                bfwriter.write(t.toString() + "\n");
                aux = aux.getEnlace();
            }
            bfwriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ListaViaje leerArchivo() {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File("ViajeTemporal.txt");
        if (file.exists() == false) {
            return new ListaViaje();
        }
        ListaViaje lista = new ListaViaje();
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                StringTokenizer tk = new StringTokenizer(linea, "++");
                String indiceViaje = tk.nextToken();
                String ci_conductor=tk.nextToken();
                String conductor = tk.nextToken();
                String apellidoConductor = tk.nextToken();
                int total_asientos = Integer.parseInt(tk.nextToken());
                String auto = tk.nextToken();
                String placa = tk.nextToken();
                String origen = tk.nextToken();
                String destino = tk.nextToken();
                Date fecha = sd.parse(tk.nextToken());
                String horaSalida = tk.nextToken();
                String horaLlegada = tk.nextToken();
                int precio = Integer.parseInt(tk.nextToken());
                int disponibles = Integer.parseInt(tk.nextToken()); 
                
                //ColaPasajeros pasajeros = this.leerPasajeros(tk.nextToken(), total_asientos);              
               
                DATOS_DEL_VIAJE aux = new DATOS_DEL_VIAJE(indiceViaje,ci_conductor,conductor,apellidoConductor,total_asientos, auto, placa, origen,destino, fecha,horaSalida, horaLlegada,precio,disponibles); //pasajeros
                lista.agregarViaje(aux);
            }
            sc.close();
        } catch (FileNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "No se encontró la Base de Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
