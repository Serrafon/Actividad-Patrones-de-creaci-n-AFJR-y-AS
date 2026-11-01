package informes;

/** Producto abstracto A: informes de tipo FACTURA (de cualquier categoría). */
public interface Factura extends Informe {

    @Override
    default String getTipo() {
        return "FACTURA";
    }
}
