package informes;

import java.util.Arrays;

/** Prueba de la Etapa 1: categorías ENTRADA y SALIDA, tipos FACTURA y COMPRA. */
public class Main {

    public static void main(String[] args) {
        String[] reports = {
            "ENT_FAC_001.txt",
            "ENT_COM_001.txt",
            "SAL_FAC_001.txt",
            "SAL_COM_001.txt",
            "ENT_FAC_002.txt",
            "MIX_FAC_001.txt",   // categoría aún no soportada
            "XXX_COM_001.txt",   // categoría inexistente
            "informe.txt"        // formato inválido
        };

        ProcesadorInformes procesador = new ProcesadorInformes();
        procesador.procesar(Arrays.asList(reports));
    }
}
