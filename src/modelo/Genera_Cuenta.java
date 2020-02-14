package modelo;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Vector;
//clase coneccion

public class Genera_Cuenta {

    public ArrayList generaCuentas() {

        ArrayList<Cuenta> cuentasDebito = new ArrayList<Cuenta>();

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
                Cuenta cd = new Cuenta(número_cuenta, cvv, saldo);
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

    public PASAJERO generaDatosPasajero(String cedulaBuscar) {

        PASAJERO pasajero = null;

        String nombre = "";
        String apellido = "";
        String cedula = "";
        String sexo = "";
        String correo = "";
        String usuario = "";
        String contraseña = "";
        String fechanac = "";

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Usuario_solo_Pasajeros.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "++");
                cedula = st.nextToken();
                nombre = st.nextToken();
                apellido = st.nextToken();
                sexo = st.nextToken();
                correo = st.nextToken();
                usuario = st.nextToken();
                contraseña = st.nextToken();
                fechanac = st.nextToken();

                if (cedulaBuscar.equals(cedula)) {
                    pasajero = new PASAJERO(nombre, apellido, cedula, sexo, correo, usuario, contraseña, fechanac);
                    System.out.println(nombre + "++" + apellido + "++" + cedula + "++" + sexo + "++" + correo + "++" + usuario + "++" + contraseña + "++" + fechanac);
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
    }

    public CONDUCTOR generaDatosConductor(String cedulaBuscar) {

        String nombre, apellido, cedula, sexo, correo, usuario, contraseña, fechanac;

        CONDUCTOR conductor = null;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Usuario_solo_Conductores.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "++");
                cedula = st.nextToken();
                nombre = st.nextToken();
                apellido = st.nextToken();
                sexo = st.nextToken();
                correo = st.nextToken();
                usuario = st.nextToken();

                if (cedulaBuscar.equals(cedula)) {
                    conductor = new CONDUCTOR(nombre, apellido, cedula, sexo, correo, usuario, "", "", "", null);
                    //System.out.println(nombre + "++" + apellido + "++" + cedula + "++" + sexo + "++" + correo + "++" + usuario + "++" + contraseña + "++" + fechanac);
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
        return conductor;
    }
    //esto puede no servir
    public String genNumCuenta(String numCedula) {

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
}

