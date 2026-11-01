package informes;

/**
 * Fábrica abstracta: cada implementación representa una CATEGORÍA y es
 * capaz de crear toda la familia de informes (tipos) de esa categoría.
 */
public interface InformeFactory {

    /** Nombre de la categoría que representa la fábrica. */
    String getCategoria();

    Factura crearFactura(String nombre);

    Compra crearCompra(String nombre);

    /**
     * Nuevo producto de la Etapa 3. Solo la categoría ENTRADA lo soporta, por
     * eso se declara como método por defecto: las fábricas SALIDA y MIXTA no
     * necesitan modificarse y rechazan la petición con una excepción clara.
     */
    default Pedido crearPedido(String nombre) {
        throw new UnsupportedOperationException(
            "la categoria " + getCategoria() + " no admite informes de tipo PEDIDO");
    }
}
