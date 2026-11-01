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
}
