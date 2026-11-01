package informes;

import java.util.Arrays;

/**
 * Prueba de la Etapa 3: se añade el tipo PEDIDO, disponible solo en la
 * categoría ENTRADA (ENT_PED_001.txt).
 */
public class Main {

    public static void main(String[] args) {
        String[] reports = {
            "ENT_FAC_001.txt",
            "ENT_COM_001.txt",
            "ENT_PED_001.txt",   // nuevo tipo PEDIDO en ENTRADA
            "SAL_FAC_001.txt",
            "SAL_COM_001.txt",
            "MIX_FAC_001.txt",
            "MIX_COM_001.txt",
            "SAL_PED_001.txt",   // PEDIDO no existe en SALIDA -> error controlado
            "MIX_PED_001.txt"    // PEDIDO no existe en MIXTA  -> error controlado
        };

        ProcesadorInformes procesador = new ProcesadorInformes();
        procesador.procesar(Arrays.asList(reports));
    }
}
