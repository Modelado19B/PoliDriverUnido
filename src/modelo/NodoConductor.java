package modelo;

public class NodoConductor {

    private DATOS_CONDUCTOR conductor;
    private NodoConductor enlace;

    public NodoConductor() {
        this.conductor = new DATOS_CONDUCTOR();
        this.enlace = new NodoConductor();
    }

    public NodoConductor(DATOS_CONDUCTOR viaje) {
        this.conductor = viaje;
        this.enlace = null;
    }

    public NodoConductor(DATOS_CONDUCTOR viaje, NodoConductor enlace) {
        this.conductor = viaje;
        this.enlace = enlace;
    }

    public DATOS_CONDUCTOR getViaje() {
        return conductor;
    }

    public void setVIaje(DATOS_CONDUCTOR viaje) {
        this.conductor = viaje;
    }

    public NodoConductor getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoConductor enlace) {
        this.enlace = enlace;
    }

}
