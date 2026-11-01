package informes;

/** Producto concreto (nuevo en la Etapa 3): pedido de la categoría ENTRADA. */
public class PedidoEntrada extends InformeBase implements Pedido {

    public PedidoEntrada(String nombre) {
        super(nombre);
    }

    @Override
    public String getCategoria() {
        return "ENTRADA";
    }

    @Override
    protected void ejecutarProcesado() {
        System.out.println("   -> Registrando pedido del cliente y reservando existencias [" + getNombre() + "]");
    }
}
