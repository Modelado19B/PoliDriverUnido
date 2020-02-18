package modelo;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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

    /*
    public Cuenta generaCuentas(String numeroCuenta) {

        String número_cuenta;
        String cvv;
        float saldo;
        Cuenta cd = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        boolean estado=false;

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
                if (numeroCuenta.equals(número_cuenta)) {
                    cd = new Cuenta(número_cuenta, cvv, saldo);
                    estado = true;
                    break;
                }
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
        if (!estado) {
            System.out.println("No se encontro la informacion de: " + numeroCuenta);
        }
        return cd;
    }
     */
    public void guardaCuenta(ArrayList cuentasCredito) {
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
        String numTarjetaEncontrado = "";
        String fecha;
        boolean estado = false;

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
                    estado = true;
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
        if (!estado) {
            System.out.println("No se encontro la informacion de: 5 " + numCedula);
        }
        return numTarjetaEncontrado;

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

        boolean estado = false;

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
                    estado = true;
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
        if (!estado) {
            System.out.println("No se encontro la informacion de: 3 " + cedulaBuscar);
        }
        return pasajero;
    }

    public CONDUCTOR generaDatosConductor(String cedulaBuscar) {

        String nombre, apellido, cedula, sexo, correo, usuario, contraseña, fechanac;

        boolean estado = false;

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
                    estado = true;
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
        if (!estado) {
            System.out.println("No se encontro la informacion de: 2 " + cedulaBuscar);
        }
        return conductor;
    }

    public String genNumCuenta(String numCedula) {

        String nombre;
        String cedula;
        String numTarjeta;
        String numTarjetaEncontrado = "";
        String fecha;
        boolean estado = false;

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
                    estado = true;
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
        if (!estado) {
            System.out.println("No se encontro la informacion de: 1 " + numCedula);
        }
        return numTarjetaEncontrado;
    }

    public boolean verificarNumeroCuenta(String numeroCuenta) {

        String número_cuenta;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        boolean estado = false;

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
                if (numeroCuenta.equals(número_cuenta)) {
                    estado = true;
                    break;
                }
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
        if (estado) {
            JOptionPane.showMessageDialog(null, "La cuenta: " + numeroCuenta + " ya existe");
        }
        return estado;
    }

    public ArrayList generaViajesPasajeros(String numCedula) {
        ArrayList<modeloTabla> listaTabla = new ArrayList<modeloTabla>();

        String viaje, cedula, numero;
        modeloTabla modelo;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("detallesViaje.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linea, "++");
                viaje = st.nextToken();
                cedula = st.nextToken();
                numero = st.nextToken();
                if (numCedula.equals(cedula)) {
                    modelo = new modeloTabla(viaje, cedula, numero);
                    listaTabla.add(modelo);
                }
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
        return listaTabla;
    }

    public String generarOrigen(String viajeBuscar) {

        String viaje = "";
        String ciudad = "";

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("ViajeTemporal.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linea, "++");
                viaje = st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                if (viaje.equals(viajeBuscar)) {
                    ciudad = st.nextToken();
                    break;
                }

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
        return ciudad;
    }

    public String generarDestino(String viajeBuscar) {

        String viaje = "";
        String ciudad = "";

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("ViajeTemporal.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linea, "++");
                viaje = st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                if (viaje.equals(viajeBuscar)) {
                    ciudad = st.nextToken();
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
        return ciudad;
    }

    public String generarCedulaConductor(String viajeBuscar) {

        String viaje = "";
        String cedula = "";

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("ViajeTemporal.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linea, "++");
                viaje = st.nextToken();
                if (viaje.equals(viajeBuscar)) {
                    cedula = st.nextToken();
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
        return cedula;
    }

    public String generarMonto(String viajeBuscar) {

        String viaje = "";
        String monto = "";

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("ViajeTemporal.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linea, "++");
                viaje = st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                if (viaje.equals(viajeBuscar)) {
                    monto = st.nextToken();
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
        return monto;
    }

    private ArrayList generaViajesPasajeros() {
        ArrayList<modeloTabla> listaTabla = new ArrayList<modeloTabla>();

        String viaje, cedula, numero;
        modeloTabla modelo;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("detallesViaje.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linea, "++");
                viaje = st.nextToken();
                cedula = st.nextToken();
                numero = st.nextToken();
                modelo = new modeloTabla(viaje, cedula, numero);
                listaTabla.add(modelo);

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
        return listaTabla;
    }

    public void actualizaLista(String viaje, String cedula, String numero) {
        ArrayList<modeloTabla> listaViajesPasajero = generaViajesPasajeros();
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("detallesViaje.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < listaViajesPasajero.size(); i++) {
                if (!(listaViajesPasajero.get(i).getViaje().equals(viaje)
                        && listaViajesPasajero.get(i).getCedula().equals(cedula)
                        && listaViajesPasajero.get(i).getNumero().equals(numero))) {
                    pw.println(listaViajesPasajero.get(i).toString());
                }
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

    public void genArchivoViajes(String viaje, String cedula, String numero) {
        ArrayList<modeloTabla> listaViajesPasajero = generaViajesPasajeros();
        modeloTabla mt = new modeloTabla(viaje, cedula, numero);
        listaViajesPasajero.add(mt);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("detallesViaje.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < listaViajesPasajero.size(); i++) {
                pw.println(listaViajesPasajero.get(i).toString());
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

}
