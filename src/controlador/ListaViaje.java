package controlador;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import modelo.DATOS_DEL_VIAJE;

public class ListaViaje {

    private Nodo raiz;

    public ListaViaje() {
        this.raiz = null;
    }

    public ListaViaje(Nodo raiz) {
        this.raiz = raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public boolean listaVacia() {
        return this.raiz == null;
    }



    public DATOS_DEL_VIAJE buscarViaje(String indiceViaje) {
        boolean b = false;
        DATOS_DEL_VIAJE aux = null;
        if (this.listaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay Viajes en la lista!");
            return null;
        } else {
            Nodo p = this.raiz;
            Nodo q = p;
            while (p != null) {
                if (p.getViaje().getIndiceViaje().equals(indiceViaje)) {
                    aux = p.getViaje();
                    b = true;
                    break;
                } else {
                    q = p;
                    p = p.getEnlace();
                }
            }
        }
        if (b == false) {
            JOptionPane.showMessageDialog(null, "Viaje no Encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return aux;
    }

    public void agregarViaje(DATOS_DEL_VIAJE nuevo) {
        if (nuevo.getIndiceViaje() == null) {
            nuevo.setIndiceViaje(this.generarIndiceViaje());
        }
        boolean b = false;
        if (this.listaVacia()) {
            this.raiz = new Nodo(nuevo);
        } else {
            Nodo p = this.raiz;
            Nodo q = p;
            Nodo r = new Nodo(nuevo);
            while (p != null) {
                if (r.getViaje().getFecha().equals(p.getViaje().getFecha())) {
                    if (r.getViaje().getLugar_origen().equals(p.getViaje().getLugar_origen())
                            && r.getViaje().getLugar_destino().equals(p.getViaje().getLugar_destino())) {
                        JOptionPane.showMessageDialog(null, "El Viaje ya se encuentra en la lista!",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                    } else if (p == this.raiz) {
                        this.raiz = r;
                        r.setEnlace(p);
                        b = true;
                        break;
                    } else {
                        q.setEnlace(r);
                        r.setEnlace(p);
                        b = true;
                        break;
                    }
                } else if (r.getViaje().fechaClase().before(p.getViaje().fechaClase())) {
                    if (p == this.raiz) {
                        this.raiz = r;
                        r.setEnlace(p);
                        b = true;
                        break;
                    } else {
                        q.setEnlace(r);
                        r.setEnlace(p);
                        b = true;
                        break;
                    }
                } else {
                    q = p;
                    p = p.getEnlace();
                }
            }
            if (b == false) {
                q.setEnlace(r);
            }
        }
    }

  public void eliminarViaje(String dato) {
        boolean b = false;
        if (this.listaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay Viajes en la lista!");
            return;
        } else {
            Nodo p = this.raiz;
            Nodo q = p;
            Nodo r;
            while (p != null) {
                if (p.getViaje().getIndiceViaje().equals(dato)) {
                    if (p == this.raiz) {
                        if (p.getEnlace() == null) {
                            this.raiz = null;
                            b = true;
                            break;
                        } else {
                            this.raiz = p.getEnlace();
                            b = true;
                            break;
                        }
                    } else if (p.getEnlace() == null) {
                        q.setEnlace(null);
                        b = true;
                        break;
                    } else {
                        r = p.getEnlace();
                        q.setEnlace(r);
                        b = true;
                        break;
                    }
                } else {
                    q = p;
                    p = p.getEnlace();
                }
            }
        }
        if (b == false) {
            JOptionPane.showMessageDialog(null, "DATOS_DEL_VIAJE no Encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    }

    public LinkedList<DATOS_DEL_VIAJE> listadoViajes() {
        LinkedList<DATOS_DEL_VIAJE> aux = new LinkedList<>();
        Nodo p = this.raiz;
        while (p != null) {
            aux.add(p.getViaje());
            p = p.getEnlace();
        }
        return aux;
    }

    private String generarIndiceViaje() {
        int num1 = 65;
        int num2 = 90;

        int numAleatorio1 = (int) Math.floor(Math.random() * (num2 - num1) + num1);
        int numAleatorio2 = (int) Math.floor(Math.random() * (num2 - num1) + num1);
        int numA = (int) (Math.random() * 99) + 1;

        return String.valueOf((char) numAleatorio1) + String.valueOf((char) numAleatorio2) + numA;
    }

    @Override
    public String toString() {
        String result = "";
        Nodo aux = this.raiz;
        while (aux != null) {
            DATOS_DEL_VIAJE t = aux.getViaje();
            result += t.toString() + "\n";
            aux = aux.getEnlace();
        }
        return result;
    }

}
