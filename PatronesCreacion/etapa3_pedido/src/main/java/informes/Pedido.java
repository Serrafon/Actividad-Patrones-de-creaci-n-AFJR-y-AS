package informes;

/** Producto abstracto C (nuevo en la Etapa 3): informes de tipo PEDIDO. */
public interface Pedido extends Informe {

    @Override
    default String getTipo() {
        return "PEDIDO";
    }
}
