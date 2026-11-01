package informes;

/** Producto concreto: compra de la categoría ENTRADA. */
public class CompraEntrada extends InformeBase implements Compra {

    public CompraEntrada(String nombre) {
        super(nombre);
    }

    @Override
    public String getCategoria() {
        return "ENTRADA";
    }

    @Override
    protected void ejecutarProcesado() {
        System.out.println("   -> Registrando mercancia comprada en el inventario [" + getNombre() + "]");
    }
}
