=====================================================================
 ACTIVIDAD: PATRONES DE CREACION  -  SISTEMA PARA PROCESAR INFORMES
 Asignatura: Reutilizacion de Software (UNIR)
 Alumnos:    Andres Felipe Jimenez Ramirez
	     Andres Alberto Suarez Munoz
 Patron:     Abstract Factory (Java)
=====================================================================

1. QUE CONTIENE ESTE PROYECTO
---------------------------------------------------------------------
Sistema que procesa informes cuyo nombre sigue el formato
CAT_TIPO_nombre.txt (por ejemplo ENT_FAC_001.txt). La CATEGORIA
(ENT, SAL, MIX) elige la fabrica y el TIPO (FAC, COM, PED) elige el
producto que esa fabrica crea. El procesado se simula con mensajes
por pantalla.

El proyecto esta dividido en tres etapas independientes, una por
cada ejercicio del enunciado. Cada etapa es un modulo Maven con su
propio metodo main (clase informes.Main):

  Carpeta           Ejercicio  Contenido
  ----------------  ---------  --------------------------------------
  etapa1_base       Ej. 2      Categorias ENTRADA y SALIDA.
                               Tipos FACTURA y COMPRA.
  etapa2_mixta      Ej. 3      Etapa 1 + categoria MIXTA
                               (MIX_FAC_001.txt, MIX_COM_001.txt).
  etapa3_pedido     Ej. 3      Etapa 2 + tipo PEDIDO, solo en la
                               categoria ENTRADA (ENT_PED_001.txt).
  diagramas         Ej. 2 y 3  Diagramas UML en PNG (y fuente .dot).
                               No son necesarios para ejecutar.

Cada etapa contiene el codigo completo y puede ejecutarse sola; la
etapa 2 y la 3 son la evolucion de la anterior, no dependen de ella.

2. COMO ABRIRLO EN NETBEANS (probado en NetBeans 29)
---------------------------------------------------------------------
 1) Descomprimir el archivo .zip.
 2) Archivo > Abrir proyecto (Ctrl+Mayus+O).
 3) Seleccionar la carpeta "PatronesCreacion". NetBeans la reconoce
    como proyecto Maven y muestra las tres etapas como modulos.
 4) Para ejecutar una etapa: realizar clic derecho sobre el modulo
    ("Etapa 1", "Etapa 2" o "Etapa 3") > Run.
    Tambien es valido: abrir src/main/java/informes/Main.java > Run File.

Notas:
 - La primera vez NetBeans necesita internet para descargar los
   plugins de Maven. Mensajes como "Unpacking index for Central
   Repository" son normales y no afectan al proyecto.
 - Se recomienda ejecutar cada etapa por separado. Si se ejecuta el
   proyecto padre ("Patrones de creacion"), NetBeans puede pedir que
   se elija un modulo.
 - Requisito: JDK 11 o superior (desarrollado y probado con Java 21).

3. COMO EJECUTARLO SIN NETBEANS (consola, solo requiere el JDK)
---------------------------------------------------------------------
Desde la carpeta PatronesCreacion, sustituyendo etapa1_base por
etapa2_mixta o etapa3_pedido segun la etapa a revisar:

  Linux / macOS:
    mkdir -p out
    javac -encoding UTF-8 -d out etapa1_base/src/main/java/informes/*.java
    java -cp out informes.Main

  Windows (CMD):
    mkdir out
    javac -encoding UTF-8 -d out etapa1_base\src\main\java\informes\*.java
    java -cp out informes.Main


4. SALIDA ESPERADA DE CADA ETAPA
---------------------------------------------------------------------
Las lineas que empiezan por [ERROR] son INTENCIONALES: demuestran que
el sistema rechaza de forma controlada los nombres no validos sin
detener el procesado del resto.

--- Etapa 1 (etapa1_base) ---
    Procesando informe de ENTRADA de tipo FACTURA
       -> Registrando factura recibida y actualizando cuentas por pagar [ENT_FAC_001.txt]
    Procesando informe de ENTRADA de tipo COMPRA
       -> Registrando mercancia comprada en el inventario [ENT_COM_001.txt]
    Procesando informe de SALIDA de tipo FACTURA
       -> Emitiendo factura al cliente y actualizando cuentas por cobrar [SAL_FAC_001.txt]
    Procesando informe de SALIDA de tipo COMPRA
       -> Generando orden de compra hacia el proveedor [SAL_COM_001.txt]
    Procesando informe de ENTRADA de tipo FACTURA
       -> Registrando factura recibida y actualizando cuentas por pagar [ENT_FAC_002.txt]
    [ERROR] MIX_FAC_001.txt: categoria desconocida 'MIX'
    [ERROR] XXX_COM_001.txt: categoria desconocida 'XXX'
    [ERROR] informe.txt: formato invalido, se esperaba CAT_TIPO_nombre.txt

--- Etapa 2 (etapa2_mixta) ---
    Procesando informe de ENTRADA de tipo FACTURA
       -> Registrando factura recibida y actualizando cuentas por pagar [ENT_FAC_001.txt]
    Procesando informe de ENTRADA de tipo COMPRA
       -> Registrando mercancia comprada en el inventario [ENT_COM_001.txt]
    Procesando informe de SALIDA de tipo FACTURA
       -> Emitiendo factura al cliente y actualizando cuentas por cobrar [SAL_FAC_001.txt]
    Procesando informe de SALIDA de tipo COMPRA
       -> Generando orden de compra hacia el proveedor [SAL_COM_001.txt]
    Procesando informe de MIXTA de tipo FACTURA
       -> Conciliando facturas recibidas y emitidas en un solo informe [MIX_FAC_001.txt]
    Procesando informe de MIXTA de tipo COMPRA
       -> Consolidando compras recibidas y ordenes emitidas [MIX_COM_001.txt]
    [ERROR] XXX_COM_001.txt: categoria desconocida 'XXX'
    [ERROR] informe.txt: formato invalido, se esperaba CAT_TIPO_nombre.txt

--- Etapa 3 (etapa3_pedido) ---
    Procesando informe de ENTRADA de tipo FACTURA
       -> Registrando factura recibida y actualizando cuentas por pagar [ENT_FAC_001.txt]
    Procesando informe de ENTRADA de tipo COMPRA
       -> Registrando mercancia comprada en el inventario [ENT_COM_001.txt]
    Procesando informe de ENTRADA de tipo PEDIDO
       -> Registrando pedido del cliente y reservando existencias [ENT_PED_001.txt]
    Procesando informe de SALIDA de tipo FACTURA
       -> Emitiendo factura al cliente y actualizando cuentas por cobrar [SAL_FAC_001.txt]
    Procesando informe de SALIDA de tipo COMPRA
       -> Generando orden de compra hacia el proveedor [SAL_COM_001.txt]
    Procesando informe de MIXTA de tipo FACTURA
       -> Conciliando facturas recibidas y emitidas en un solo informe [MIX_FAC_001.txt]
    Procesando informe de MIXTA de tipo COMPRA
       -> Consolidando compras recibidas y ordenes emitidas [MIX_COM_001.txt]
    [ERROR] SAL_PED_001.txt: la categoria SALIDA no admite informes de tipo PEDIDO
    [ERROR] MIX_PED_001.txt: la categoria MIXTA no admite informes de tipo PEDIDO

5. ESTRUCTURA DEL CODIGO (paquete informes)
---------------------------------------------------------------------
Roles del patron Abstract Factory:

  Fabrica abstracta ... InformeFactory
                        (crearFactura, crearCompra; en la etapa 3
                        tambien crearPedido como metodo default)
  Fabricas concretas .. InformeEntradaFactory, InformeSalidaFactory,
                        InformeMixtaFactory (desde la etapa 2)
  Productos abstractos  Factura, Compra, Pedido (desde la etapa 3);
                        todos extienden la interfaz Informe
  Productos concretos . FacturaEntrada, CompraEntrada, FacturaSalida,
                        CompraSalida, FacturaMixta, CompraMixta,
                        PedidoEntrada
  Cliente ............. ProcesadorInformes: lee los nombres, elige la
                        fabrica segun la categoria y delega la
                        creacion. Solo conoce interfaces.

Clases de apoyo:
  InformeBase ......... clase abstracta con procesar() final: imprime
                        "Procesando informe de <CATEGORIA> de tipo
                        <TIPO>" y llama a ejecutarProcesado(), donde
                        cada producto concreto pone su comportamiento.
  TipoInforme ......... enum (FAC, COM, PED) que traduce el codigo del
                        tipo a la llamada de la fabrica, sin if/switch.
  Main ................ prueba de funcionamiento de cada etapa.

6. QUE CAMBIA ENTRE ETAPAS (para evaluar la evolucion, Ejercicio 3)
---------------------------------------------------------------------
Etapa 1 -> Etapa 2 (categoria MIXTA):
  - Archivos nuevos: InformeMixtaFactory, FacturaMixta, CompraMixta.
  - Codigo existente modificado: UNA linea en el constructor de
    ProcesadorInformes (registrar("MIX", new InformeMixtaFactory())).
  - Main se amplia solo para probar la nueva categoria.

Etapa 2 -> Etapa 3 (tipo PEDIDO en ENTRADA):
  - Archivos nuevos: Pedido, PedidoEntrada.
  - Modificados: InformeFactory (metodo default crearPedido),
    InformeEntradaFactory (lo sobrescribe) y TipoInforme (constante
    PED).
  - InformeSalidaFactory, InformeMixtaFactory y ProcesadorInformes no
    cambian. Al ser PEDIDO exclusivo de ENTRADA, pedirlo a SALIDA o a
    MIXTA lanza UnsupportedOperationException, capturada y mostrada
    como [ERROR].

Los detalles, los diagramas UML de cada etapa y la justificacion del
diseno estan en el documento PDF entregado
(Actividad Patrones de creación AFJR y AS.pdf).

7. COMO PROBAR OTROS INFORMES
---------------------------------------------------------------------
Editar el arreglo "reports" en el metodo main de la clase Main de la
etapa elegida y volver a ejecutar. Formato: CAT_TIPO_nombre.txt, con
CAT en {ENT, SAL, MIX} y TIPO en {FAC, COM, PED}.
Los informes son nombres de archivo simulados; no es necesario crear
archivos .txt reales.
