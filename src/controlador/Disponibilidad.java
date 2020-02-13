package controlador;

public class Disponibilidad {

    private Nodo viajeRaiz;

    public Disponibilidad(Nodo viajeRaiz) {
        this.viajeRaiz = viajeRaiz;
    }

    
    public void bajarDisponibilidad(String indiceViaje, int asientos) {
        Nodo p = this.viajeRaiz;
        while (p != null) {
            if (p.getViaje().getIndiceViaje().equals(indiceViaje)) {
                int num = p.getViaje().getTotal_asientos_disponibles();
                for (int i = 1; i <= asientos; i++) {
                    num -= 1;
                }
                p.getViaje().setTotal_asientos_disponibles(num);
                break;

            } else {
                p = p.getEnlace();
            }
        }
    }

}
