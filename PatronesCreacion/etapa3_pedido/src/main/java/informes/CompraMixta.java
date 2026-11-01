package informes;

/** Producto concreto: compra de la categoría MIXTA. */
public class CompraMixta extends InformeBase implements Compra {

    public CompraMixta(String nombre) {
        super(nombre);
    }

    @Override
    public String getCategoria() {
        return "MIXTA";
    }

    @Override
    protected void ejecutarProcesado() {
        System.out.println("   -> Consolidando compras recibidas y ordenes emitidas [" + getNombre() + "]");
    }
}
