package modelo;


public class DATOS_CONDUCTOR {

    private String cedulaConductor, nombreConductor, apellidoConductor, totalAsientos, tipoAuto, placaVehiculo;
    private int    id;
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCedulaConductor() {
        return cedulaConductor;
    }

    public void setCedulaConductor(String cedulaConductor) {
        this.cedulaConductor = cedulaConductor;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public String getApellidoConductor() {
        return apellidoConductor;
    }

    public void setApellidoConductor(String apellidoConductor) {
        this.apellidoConductor = apellidoConductor;
    }

    public String getTotalAsientos() {
        return totalAsientos;
    }

    public void setTotalAsientos(String totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public String getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }
  

    public DATOS_CONDUCTOR() {

    }

    public DATOS_CONDUCTOR( int id,String cedulaConductor, String nombreConductor, String apellidoConductor, String totalAsientos, String tipoAuto, String placaVehiculo) {
        this.id = id;
        this.cedulaConductor = cedulaConductor;
        this.nombreConductor = nombreConductor;
        this.apellidoConductor = apellidoConductor;
        this.totalAsientos = totalAsientos;
        this.tipoAuto = tipoAuto;
        this.placaVehiculo = placaVehiculo;
  
    }

    @Override
    public String toString() {
        return "DATOS_CONDUCTOR{" +"id=" + id + ", cedulaConductor=" + cedulaConductor + ", nombreConductor=" + nombreConductor + ", apellidoConductor=" + apellidoConductor + ", totalAsientos=" + totalAsientos + ", tipoAuto=" + tipoAuto + ", placaVehiculo=" + placaVehiculo + '}';
    }


        

}
