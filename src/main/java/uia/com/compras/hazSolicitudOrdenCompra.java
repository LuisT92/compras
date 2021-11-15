package uia.com.compras;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class hazSolicitudOrdenCompra extends PeticionOrdenCompra {
    boolean viable;

    @JsonCreator
    public hazSolicitudOrdenCompra(@JsonProperty("id") int id, @JsonProperty("name") String name,
                                   @JsonProperty("codigo") String codigo, @JsonProperty("unidad") String unidad,
                                   @JsonProperty("cantidad") int cantidad, String tipo, boolean viable) {
        super(id, name, codigo, unidad, cantidad, tipo);
        this.viable = viable;
    }

    public boolean getViable() {
        return viable;
    }

    public void setViable(boolean viable) {
        this.viable = viable;
    }

    public hazSolicitudOrdenCompra() {
        super();
    }

    public void monto(ListaReportesNivelStock miReporteNS) {
        hazSolicitudOrdenCompra nodo;
        for (int i = 0; i < miReporteNS.getItems().size(); i++) {
            InfoComprasUIA miNodo = miReporteNS.getItems().get(i);
            List<InfoComprasUIA> miLista;
            if (miNodo.getPedidoProveedor() > 10) {
                nodo = new hazSolicitudOrdenCompra(miNodo.getId(), miNodo.getName(), miNodo.getDescripcion(),
                        "PZA", miNodo.getPedidoProveedor(), "itemsOPC", true);
            }
        }
    }

    public void cotizacion_viable(ListaReportesNivelStock miReporteNS) {
        for (int i = 0; i < miReporteNS.getItems().size(); i++) {
            if (getViable() == true) {
                agregaItems(miReporteNS);
            }
        }
    }
}
