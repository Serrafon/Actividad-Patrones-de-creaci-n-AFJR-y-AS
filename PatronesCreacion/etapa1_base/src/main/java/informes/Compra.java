package informes;

/** Producto abstracto B: informes de tipo COMPRA (de cualquier categoría). */
public interface Compra extends Informe {

    @Override
    default String getTipo() {
        return "COMPRA";
    }
}
