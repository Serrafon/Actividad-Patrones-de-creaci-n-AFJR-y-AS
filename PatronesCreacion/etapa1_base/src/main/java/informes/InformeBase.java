package informes;

/**
 * Clase base con el comportamiento común de todos los informes concretos.
 * Evita repetir el nombre y el mensaje de cabecera del procesado.
 */
public abstract class InformeBase implements Informe {

    private final String nombre;

    protected InformeBase(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public final void procesar() {
        System.out.println("Procesando informe de " + getCategoria() + " de tipo " + getTipo());
        ejecutarProcesado();
    }

    /** Cada informe concreto define su propio modo de ser procesado. */
    protected abstract void ejecutarProcesado();
}
