package informes;

/**
 * Producto abstracto raíz: cualquier informe que maneja el sistema.
 * El cliente (ProcesadorInformes) solo conoce esta interfaz.
 */
public interface Informe {

    /** Nombre completo del archivo, por ejemplo ENT_FAC_001.txt */
    String getNombre();

    /** Categoría del informe: ENTRADA, SALIDA, ... */
    String getCategoria();

    /** Tipo del informe: FACTURA, COMPRA, ... */
    String getTipo();

    /** Procesa el informe según su categoría y su tipo. */
    void procesar();
}
