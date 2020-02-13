package modelo;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Vector;
//clase coneccion

public class Genera_Cuenta {

    public ArrayList generaCuentas() {

        ArrayList<CUENTA> cuentasDebito = new ArrayList<CUENTA>();

        String número_cuenta;
        String cvv;
        float saldo;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("cuentas.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linea, "|");
                número_cuenta = st.nextToken();
                cvv = st.nextToken();
                saldo = Float.parseFloat(st.nextToken());
                CUENTA cd = new CUENTA(número_cuenta, cvv, saldo);
                cuentasDebito.add(cd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return cuentasDebito;
    }

    public void gurdaCuenta(ArrayList cuentasCredito) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("cuentas.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < cuentasCredito.size(); i++) {
                pw.println(cuentasCredito.get(i).toString());
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

    public String genNumTarjetaCedula(String numCedula) {

        String nombre;
        String cedula;
        String numTarjeta;
        String numTarjetaEncontrado = null;
        String fecha;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Tarjetas_usuarios.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "++");
                cedula = st.nextToken();
                nombre = st.nextToken();
                numTarjeta = st.nextToken();
                fecha = st.nextToken();
                if (numCedula.equals(cedula)) {
                    numTarjetaEncontrado = numTarjeta;
                    break;
                }
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
        if (numTarjetaEncontrado == null) {
            return "";
        } else {
            return numTarjetaEncontrado;
        }
    }

    public String genNumTarjetaNombre(String nombreBuscar) {
        String nombre;
        String cedula;
        String numTarjeta;
        String numTarjetaEncontrado = null;
        String fecha;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Tarjetas_usuarios.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "++");
                cedula = st.nextToken();
                nombre = st.nextToken();
                numTarjeta = st.nextToken();
                fecha = st.nextToken();
                if (nombreBuscar.equals(nombre)) {
                    numTarjetaEncontrado = numTarjeta;
                    break;
                }
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
        if (numTarjetaEncontrado == null) {
            return "";
        } else {
            return numTarjetaEncontrado;
        }

    }

    //clase para generar los datos los pasajeros buscando por cedula
    //todavia no se a podido validar todavia
    /*public PASAJERO generaDatosPasajero(String cedulaPasajero) {

        PASAJERO pasajero = null;
        String cedula;
        String nombre;
        String apellido;
        String celular;
        String correo;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("dataTarjeta.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "++");
                cedula = st.nextToken();
                nombre = st.nextToken();
                apellido = st.nextToken();
                celular = st.nextToken();
                st.nextToken();
                correo = st.nextToken();
                if (cedulaPasajero.equals(cedula)) {
                    pasajero = new PASAJERO(cedula, nombre, apellido, celular, "", correo, "", "");
                    break;
                }
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
        return pasajero;
    }*/
    public Vector<String> dataPasajero(String cedualPublicacion) {
        String cedula = null;
        String nombre;
        String apellido;
        String sexo;
        String correo;
        String cedula1;
        String contrasena;
        String fecha;
        String numTarjetaEncontrado = null;
        Vector<String> datos = new Vector<String>(8);

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Usuario_solo_Pasajeros.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "++");
                cedula = st.nextToken();
                nombre = st.nextToken();
                apellido = st.nextToken();
                sexo = st.nextToken();
                correo = st.nextToken();
                cedula1 = st.nextToken();
                contrasena = st.nextToken();
                fecha = st.nextToken();
                if (cedualPublicacion.equals(cedula)) {
                    datos.add(cedula);
                    datos.add(nombre);
                    datos.add(apellido);
                    datos.add(sexo);
                    datos.add(correo);
                    datos.add(cedula1);
                    datos.add(contrasena);
                    datos.add(fecha);
                    break;
                }
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
        return datos;
    }
}
