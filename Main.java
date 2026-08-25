import java.util.Scanner;

public class Main {

    // Scanner unico, compartido por todas las funciones del programa.
    static Scanner scanner = new Scanner(System.in);

    /**
     * Metodo principal. Es el punto de entrada del programa.
     * Se encarga de mostrar el menu principal (Area / Volumen / Salir).
     */
    public static void main(String[] args) {

        int opcion;

        do {
            opcion = menu("1- Calcular Area\n2- Calcular Volumen\n3- Salir", 3);

            switch (opcion) {
                case 1:
                    menuAreas();
                    break;
                case 2:
                    menuVolumenes();
                    break;
                case 3:
                    salir();
                    break;
            }

        } while (opcion != 3);

        scanner.close();
    }

    // ==========================================================
    //                  FUNCIONES DE SOPORTE
    // ==========================================================

    /**
     * Borra todo el contenido de la consola usando codigos de escape ANSI.
     * Se llama antes de mostrar cada nueva pantalla para solo ver una informacion 
     */
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Detiene la ejecucion del programa hasta que el usuario presione Enter.
     * Se hacen DOS lecturas con nextLine():
     *   1) La primera "limpia" el salto de linea (\n) que quedo pendiente
     *      en el buffer despues de usar nextInt() o nextDouble().
     *   2) La segunda si espera realmente a que el usuario presione Enter.
     */
    public static void pausar() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }

    /**
     * Dibuja una linea decorativa usada como borde superior e inferior
     */
    public static void linea() {
        System.out.println("+-----------------------------------------------+");
    }

    /**
     * Imprime el encabezado principal del sistema dentro de un recuadro.
     */
    public static void encabezado(){
        linea();
        System.out.println("|     SISTEMA DE AREAS Y VOLUMENES               |");
        linea();
    }

    /**
     * Funcion encargada UNICAMENTE de mostrar un menu y leer la opcion
     * elegida por el usuario. No realiza ningun calculo ni redireccion:
     * su unica responsabilidad es preguntar y validar que el numero
     * digitado este dentro del rango permitido
     */
    public static int menu(String texto, int nroOpciones){
        int opcion;
        do{
            limpiarPantalla();
            encabezado();
            String[] lineas = texto.split("\n");
            for (String l : lineas) {
                System.out.println("|  " + l);
            }
            System.out.println("|");
            linea();
            System.out.print("Digite su opcion: ");
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > nroOpciones);
        return opcion;
    }

    /**
     * Pide al usuario un numero decimal y no continua hasta que digite
     * un valor mayor que cero. ya que no tiene sentido numeros negativos 
     */
    public static double leerPositivo(String mensaje) {
        double valor;
        do {
            System.out.print(mensaje);
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("El valor debe ser mayor que 0. Intente de nuevo.");
            }
        } while (valor <= 0);
        return valor;
    }

    /**
     * Muestra el resultado final de un calculo dentro de un recuadro,
     * junto con el nombre de la figura y la formula utilizada.
     * Se centraliza aqui para que todos los resultados (areas y volumenes)
     * se vean con el mismo estilo visual.
     */
    public static void mostrarResultado(String figura, String formula, double resultado) {
        System.out.println("|");
        System.out.println("|  Figura : " + figura);
        System.out.println("|  Formula: " + formula);
        System.out.println("|  Resultado: " + resultado);
        System.out.println("|");
        linea();
    }

    // ==========================================================
    //                  SUBMENUS DE NAVEGACION
    // ==========================================================

    /**
     * Muestra el submenu de figuras para calcular AREA y, segun la
     * figura elegida, llama a la funcion de calculo correspondiente.
     */
    public static void menuAreas() {
        int opcion;

        do {
            opcion = menu("1- Cuadrado\n2- Triangulo\n3- Circulo\n4- Hexagono\n5- Volver al menu principal", 5);

            switch (opcion) {
                case 1:
                    areaCuadrado();
                    pausar();
                    break;
                case 2:
                    areaTriangulo();
                    pausar();
                    break;
                case 3:
                    areaCirculo();
                    pausar();
                    break;
                case 4:
                    areaHexagono();
                    pausar();
                    break;
                case 5:
                    // Volver: solo termina el ciclo 
                    break;
            }

        } while (opcion != 5);
    }

    /**
     * Muestra el submenu de figuras para calcular VOLUMEN y, segun la
     * figura elegida, llama a la funcion de calculo correspondiente.
     */
    public static void menuVolumenes() {
        int opcion;

        do {
            opcion = menu("1- Cubo\n2- Cilindro\n3- Esfera\n4- Volver al menu principal", 4);

            switch (opcion) {
                case 1:
                    volumenCubo();
                    pausar();
                    break;
                case 2:
                    volumenCilindro();
                    pausar();
                    break;
                case 3:
                    volumenEsfera();
                    pausar();
                    break;
                case 4:
                    // Volver: solo termina el ciclo
                    break;
            }

        } while (opcion != 4);
    }

    // ==========================================================
    //                  CALCULOS DE AREA
    // ==========================================================

    /**
     * Calcula el area de un cuadrado. donde operacion es  area = lado al cuadrado.
     */
    public static void areaCuadrado() {
        limpiarPantalla();
        encabezado();
        System.out.println("|  AREA DEL CUADRADO");
        double lado = leerPositivo("Ingrese el lado: ");

        double area = lado * lado;
        mostrarResultado("CUADRADO", "lado^2", area);
    }

    /**
     * Calcula el area de un triangulo. Pide la base y la altura
     *  formila area = (base * altura) / 2.
     */
    public static void areaTriangulo() {
        limpiarPantalla();
        encabezado();
        System.out.println("|  AREA DEL TRIANGULO");
        double base = leerPositivo("Ingrese la base: ");
        double altura = leerPositivo("Ingrese la altura: ");

        double area = (base * altura) / 2;
        mostrarResultado("TRIANGULO", "(base * altura) / 2", area);
    }

    /**
     * Calcula el area de un circulo.
     *  formula: area = PI * radio al cuadrado.
     */
    public static void areaCirculo() {
        limpiarPantalla();
        encabezado();
        System.out.println("|  AREA DEL CIRCULO");
        double radio = leerPositivo("Ingrese el radio: ");

        double area = Math.PI * Math.pow(radio, 2);
        mostrarResultado("CIRCULO", "PI * radio^2", area);
    }

    /**
     * Calcula el area de un hexagono regular.
     *  formula area = (3 * raiz(3) / 2) * lado al cuadrado.
     */
    public static void areaHexagono() {
        limpiarPantalla();
        encabezado();
        System.out.println("|  AREA DEL HEXAGONO");
        double lado = leerPositivo("Ingrese el lado: ");

        double area = (3 * Math.sqrt(3) / 2) * Math.pow(lado, 2);
        mostrarResultado("HEXAGONO", "(3 * raiz(3) / 2) * lado^2", area);
    }

    // ==========================================================
    //                  CALCULOS DE VOLUMEN
    // ==========================================================

    /**
     * Calcula el volumen de un cubo. formula volumen = arista al cubo.
     */
    public static void volumenCubo() {
        limpiarPantalla();
        encabezado();
        System.out.println("|  VOLUMEN DEL CUBO");
        double arista = leerPositivo("Ingrese la arista: ");

        double volumen = Math.pow(arista, 3);
        mostrarResultado("CUBO", "arista^3", volumen);
    }

    /**
     * Calcula el volumen de un cilindro.
     * formula = PI * radio al cuadrado * altura.
     */
    public static void volumenCilindro() {
        limpiarPantalla();
        encabezado();
        System.out.println("|  VOLUMEN DEL CILINDRO");
        double radio = leerPositivo("Ingrese el radio: ");
        double altura = leerPositivo("Ingrese la altura: ");

        double volumen = Math.PI * Math.pow(radio, 2) * altura;
        mostrarResultado("CILINDRO", "PI * radio^2 * altura", volumen);
    }

    /**
     * Calcula el volumen de una esfera. formula  = (4/3) * PI * radio al cubo.
     */
    public static void volumenEsfera() {
        limpiarPantalla();
        encabezado();
        System.out.println("|  VOLUMEN DE LA ESFERA");
        double radio = leerPositivo("Ingrese el radio: ");

        double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
        mostrarResultado("ESFERA", "(4/3) * PI * radio^3", volumen);
    }

    /**
     * mensaje de despedida al dar salir al codigo
     */
    public static void salir() {
        limpiarPantalla();
        encabezado();
        System.out.println("|  Gracias por usar el sistema de calculo");
        System.out.println("|  de areas y volumenes.");
        linea();
    }
}