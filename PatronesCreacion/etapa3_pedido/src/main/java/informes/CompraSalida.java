package informes;

/** Producto concreto: compra de la categoría SALIDA. */
public class CompraSalida extends InformeBase implements Compra {

    public CompraSalida(String nombre) {
        super(nombre);
    }

    @Override
    public String getCategoria() {
        return "SALIDA";
    }

    @Override
    protected void ejecutarProcesado() {
        System.out.println("   -> Generando orden de compra hacia el proveedor [" + getNombre() + "]");
    }
}
