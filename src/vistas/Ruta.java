package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.teamdev.jxmaps.swing.MapView;

import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.examples.ControlPanel;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.ControlPosition;

import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;

import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;
import com.teamdev.jxmaps.swing.MapView;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.concurrent.ThreadLocalRandom.current;

public class Ruta extends MapView {
    

    public static Map map;

    public CircleOptions settingsCircle;

    public PolylineOptions settingsLine;
    

    public Marker generateMarker(LatLng pos) {
        Marker marker = null;
        marker = new Marker(map);
        marker.setPosition(pos);
        return marker;
    }

 
    public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
      String cadena;
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
          System.out.println(cadena);
      }
      b.close();
}

    public void generarRuta(LatLng start, LatLng end, Boolean markers) {

        LatLng[] path = {start, end};
        Polyline polyline = new Polyline(map);
        polyline.setPath(path);

        if (markers) {
            generateMarker(start);
            generateMarker(end);
        }
        map = getMap();
//       MapOptions mapOptions = new MapOptions();
//        MapTypeControlOptions controlOptions = new MapTypeControlOptions();
//        controlOptions.setPosition(ControlPosition.BOTTOM_LEFT);
//        mapOptions.setMapTypeControlOptions(controlOptions);

//      map.setOptions(mapOptions);
        map.setCenter(new LatLng(-1.6709800, -78.6471200));
        map.setZoom(7);
        
        PolylineOptions options = new PolylineOptions();
        options.setStrokeColor("#1E90FF");
        options.setStrokeWeight(5);
        options.setStrokeOpacity(0.7);
        polyline.setOptions(options);


    }
  
    
    
    public float calcularDistancia(LatLng a, LatLng b) {
        DecimalFormat df = new DecimalFormat("#.##");
        float distancia1 = (float) Math.sqrt(Math.pow(a.getLat(), 2) + Math.pow(a.getLng(), 2));
        float distancia2 = (float) Math.sqrt(Math.pow(b.getLat(), 2) + Math.pow(b.getLng(), 2));
       
        float distancia = (float) ((Math.abs(distancia1 - distancia2)) * 1000 * 0.82216);
        return distancia;
    }

    public float calcularTiempo(float distancia) {

        int tiempo = 0;
        int velocidad = (int)  1.4;
        tiempo = (int) (distancia / velocidad);
        return tiempo;

    }

    public float calcularGananciaAPP(float distancia) {

        float valor = (float) (distancia * 0.06);
        float ganancia = (float) ((valor * 0.2 * 100) / 100);
//        System.out.println(ganancia);

        return ganancia;

    }

    public float calcularMonto(float distancia, float ganancia) {

        float valor = (float) (distancia * 0.0625);
        float monto = (valor + ganancia);

        return monto;

    }

    public String formatearMinutosAHoraMinuto(int tiempo) {
        String formato = "%2d Horas con %2d Min.";
        long horasReales = TimeUnit.MINUTES.toHours(tiempo);
        long minutosReales = TimeUnit.MINUTES.toMinutes(tiempo) - TimeUnit.HOURS.toMinutes(TimeUnit.MINUTES.toHours(tiempo));
        return String.format(formato, horasReales, minutosReales);
    }

    public Map darMap() {
        return map;
    }

    public Ruta(String pString) {

        pString = "";
        JFrame frame = new JFrame(pString);
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // frame.add(this, BorderLayout.CENTER);
        frame.setSize(750, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
        settingsCircle = new CircleOptions();
        settingsCircle.setFillColor("#FF0000");
        settingsCircle.setRadius(2000000);
        settingsCircle.setFillOpacity(0.35);

        settingsLine = new PolylineOptions();
        settingsLine.setGeodesic(true);
        settingsLine.setStrokeColor("#FF0000");
        settingsLine.setStrokeOpacity(1.0);
        settingsLine.setStrokeWeight(2.0);

        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    map = getMap();
                    MapOptions mapOptions = new MapOptions();
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    controlOptions.setPosition(ControlPosition.BOTTOM_LEFT);
                    mapOptions.setMapTypeControlOptions(controlOptions);

                    map.setOptions(mapOptions);
                    map.setCenter(new LatLng(-1.6709800, -78.6471200));
                    map.setZoom(7);
                    

                }
            }
        });

    }

    

}
