package informes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cliente del patrón Abstract Factory. Lee los nombres de los archivos,
 * elige la fábrica según la categoría y delega la creación en ella.
 * Solo trabaja con las interfaces InformeFactory e Informe.
 */
public class ProcesadorInformes {

    private final Map<String, InformeFactory> fabricas = new HashMap<>();

    public ProcesadorInformes() {
        registrar("ENT", new InformeEntradaFactory());
        registrar("SAL", new InformeSalidaFactory());
    }

    private void registrar(String codigoCategoria, InformeFactory fabrica) {
        fabricas.put(codigoCategoria, fabrica);
    }

    /** Procesa una lista de nombres de archivo con formato CAT_TIPO_nombre.txt */
    public void procesar(List<String> nombres) {
        for (String nombre : nombres) {
            try {
                crear(nombre).procesar();
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                System.out.println("[ERROR] " + nombre + ": " + e.getMessage());
            }
        }
    }

    /** Crea el informe adecuado a partir del nombre del archivo. */
    public Informe crear(String nombre) {
        String[] partes = nombre.split("_", 3);
        if (partes.length < 3 || !nombre.endsWith(".txt")) {
            throw new IllegalArgumentException("formato invalido, se esperaba CAT_TIPO_nombre.txt");
        }
        InformeFactory fabrica = fabricas.get(partes[0]);
        if (fabrica == null) {
            throw new IllegalArgumentException("categoria desconocida '" + partes[0] + "'");
        }
        return TipoInforme.desdeCodigo(partes[1]).crear(fabrica, nombre);
    }
}
