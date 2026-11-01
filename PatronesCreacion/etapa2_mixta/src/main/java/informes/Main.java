package informes;

import java.util.Arrays;

/** Prueba de la Etapa 2: se añade la categoría MIXTA (MIX_FAC y MIX_COM). */
public class Main {

    public static void main(String[] args) {
        String[] reports = {
            "ENT_FAC_001.txt",
            "ENT_COM_001.txt",
            "SAL_FAC_001.txt",
            "SAL_COM_001.txt",
            "MIX_FAC_001.txt",   // nueva categoría MIXTA
            "MIX_COM_001.txt",   // nueva categoría MIXTA
            "XXX_COM_001.txt",   // categoría inexistente
            "informe.txt"        // formato inválido
        };

        ProcesadorInformes procesador = new ProcesadorInformes();
        procesador.procesar(Arrays.asList(reports));
    }
}
