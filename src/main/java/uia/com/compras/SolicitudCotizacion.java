package uia.com.compras;

import java.util.ArrayList;
import java.util.HashMap;

public class SolicitudCotizacion {
    public void hazCotizaciones(SolicitudOrdenCompra newItem){
        ArrayList<HashMap<String, String>> cotizaciones = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < newItem.getItems().size(); i++){
            cotizaciones.get(i).get(newItem.getVendedor());
        }
    }
}
