package informes;

/**
 * Traduce el código de tipo del nombre del archivo (FAC, COM, ...) a la
 * llamada correspondiente de la fábrica. Se usa un enum con comportamiento
 * por constante para no tener cadenas de if/switch en el cliente.
 */
public enum TipoInforme {

    FAC {
        @Override
        public Informe crear(InformeFactory fabrica, String nombre) {
            return fabrica.crearFactura(nombre);
        }
    },
    COM {
        @Override
        public Informe crear(InformeFactory fabrica, String nombre) {
            return fabrica.crearCompra(nombre);
        }
    },
    PED {
        @Override
        public Informe crear(InformeFactory fabrica, String nombre) {
            return fabrica.crearPedido(nombre);
        }
    };

    public abstract Informe crear(InformeFactory fabrica, String nombre);

    public static TipoInforme desdeCodigo(String codigo) {
        try {
            return valueOf(codigo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("tipo de informe desconocido '" + codigo + "'");
        }
    }
}
