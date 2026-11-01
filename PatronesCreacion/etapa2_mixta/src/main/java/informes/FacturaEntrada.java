package informes;

/** Producto concreto: factura de la categoría ENTRADA. */
public class FacturaEntrada extends InformeBase implements Factura {

    public FacturaEntrada(String nombre) {
        super(nombre);
    }

    @Override
    public String getCategoria() {
        return "ENTRADA";
    }

    @Override
    protected void ejecutarProcesado() {
        System.out.println("   -> Registrando factura recibida y actualizando cuentas por pagar [" + getNombre() + "]");
    }
}
