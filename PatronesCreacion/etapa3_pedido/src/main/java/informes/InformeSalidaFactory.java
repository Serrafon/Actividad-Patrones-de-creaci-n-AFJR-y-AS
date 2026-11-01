package informes;

/** Fábrica concreta de la categoría SALIDA. */
public class InformeSalidaFactory implements InformeFactory {

    @Override
    public String getCategoria() {
        return "SALIDA";
    }

    @Override
    public Factura crearFactura(String nombre) {
        return new FacturaSalida(nombre);
    }

    @Override
    public Compra crearCompra(String nombre) {
        return new CompraSalida(nombre);
    }
}
