package informes;

/** Producto concreto: factura de la categoría MIXTA. */
public class FacturaMixta extends InformeBase implements Factura {

    public FacturaMixta(String nombre) {
        super(nombre);
    }

    @Override
    public String getCategoria() {
        return "MIXTA";
    }

    @Override
    protected void ejecutarProcesado() {
        System.out.println("   -> Conciliando facturas recibidas y emitidas en un solo informe [" + getNombre() + "]");
    }
}
