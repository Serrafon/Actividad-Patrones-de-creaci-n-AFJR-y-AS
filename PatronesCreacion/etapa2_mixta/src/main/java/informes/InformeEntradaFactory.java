package informes;

/** Fábrica concreta de la categoría ENTRADA. */
public class InformeEntradaFactory implements InformeFactory {

    @Override
    public String getCategoria() {
        return "ENTRADA";
    }

    @Override
    public Factura crearFactura(String nombre) {
        return new FacturaEntrada(nombre);
    }

    @Override
    public Compra crearCompra(String nombre) {
        return new CompraEntrada(nombre);
    }
}
