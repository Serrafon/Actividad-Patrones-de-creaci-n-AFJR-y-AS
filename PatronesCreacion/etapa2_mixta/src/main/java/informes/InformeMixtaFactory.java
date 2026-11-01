package informes;

/** Fábrica concreta de la categoría MIXTA (nueva en la Etapa 2). */
public class InformeMixtaFactory implements InformeFactory {

    @Override
    public String getCategoria() {
        return "MIXTA";
    }

    @Override
    public Factura crearFactura(String nombre) {
        return new FacturaMixta(nombre);
    }

    @Override
    public Compra crearCompra(String nombre) {
        return new CompraMixta(nombre);
    }
}
