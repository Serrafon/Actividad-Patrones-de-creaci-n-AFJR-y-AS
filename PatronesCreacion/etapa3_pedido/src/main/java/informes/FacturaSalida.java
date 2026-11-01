package informes;

/** Producto concreto: factura de la categoría SALIDA. */
public class FacturaSalida extends InformeBase implements Factura {

    public FacturaSalida(String nombre) {
        super(nombre);
    }

    @Override
    public String getCategoria() {
        return "SALIDA";
    }

    @Override
    protected void ejecutarProcesado() {
        System.out.println("   -> Emitiendo factura al cliente y actualizando cuentas por cobrar [" + getNombre() + "]");
    }
}
