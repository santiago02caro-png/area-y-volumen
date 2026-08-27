import java.util.Scanner;

public class Main {

    public static String[] nombre = new String[100];
    public static float[] sueldo = new float[100];
    public static String[] cargo = new String[100];
    public static int totalEmpleados = 0; 

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("DATOS DE LOS EMPLEADOS");

        totalEmpleados = llenarArreglos();

        int opcion;
        do {
            limpiarPantalla();
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> { crearEmpleado(); pausar(); }
                case 2 -> { listarEmpleados(); pausar(); }
                case 3 -> { actualizarEmpleado(); pausar(); }
                case 4 -> { eliminarEmpleado(); pausar(); }
                case 5 -> System.out.println("Saliendo del programa. ¡Hasta luego!");
                default -> { System.out.println("Opción no válida. Intente de nuevo."); pausar(); }
            }
            System.out.println();

        } while (opcion != 5);

        entrada.close();
    }

    // ponemos una pausa antes de borrar y como confirmacion para ir limpiando la pantalla dejamos enter
    public static void pausar() {
        System.out.println();
        System.out.print("Presione ENTER para volver al menú...");
        entrada.nextLine();
    }

    // ---------- Limpieza de pantalla ----------
    public static void limpiarPantalla() {
        // limpia usando secuencias ANSI 
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // Alternativa por si la terminal no soporta ANSI
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Menú principal
    public static void mostrarMenu() {
        System.out.println("===== MENÚ DE GESTIÓN DE EMPLEADOS =====");
        System.out.println("1. Crear empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Actualizar empleado");
        System.out.println("4. Eliminar empleado");
        System.out.println("5. Salir");
        System.out.println("=========================================");
    }

    // con esto al ejecutar nos pedira ingresar ususarios para registrsr antes de pasar al menu
    public static int llenarArreglos() {

        int n = leerEntero("¿Cuántos empleados desea registrar? ");

        if (n > 100) {
            n = 100;
            System.out.println("Solo se pueden registrar máximo 100 empleados. Se ajustó a 100.");
        }

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("EMPLEADO " + (i + 1));
            leerDatos(i);
        }

        return n;
    }

    // creacion de empleados no supera los 100
    public static void crearEmpleado() {

        if (totalEmpleados >= 100) {
            System.out.println("No se pueden registrar más empleados (límite alcanzado).");
            return;
        }

        System.out.println("--- Nuevo empleado ---");
        leerDatos(totalEmpleados);
        totalEmpleados++;
        System.out.println("Empleado registrado correctamente.");
    }

    // lee la lista de empleados 
    public static void listarEmpleados() {

        if (totalEmpleados == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        for (int i = 0; i < totalEmpleados; i++) {
            System.out.println("-------------------");
            System.out.println("Posición: " + i);
            verDatos(i);
        }
    }

    // actualizacion de empleados 
    public static void actualizarEmpleado() {

        listarEmpleados();
        if (totalEmpleados == 0) return;

        int pos = leerEntero("Ingrese la posición del empleado a actualizar: ");

        if (!posicionValida(pos)) {
            System.out.println("Posición inválida.");
            return;
        }

        System.out.print("Nuevo nombre (" + nombre[pos] + ") - deje vacío para no cambiar: ");
        String nuevoNombre = entrada.nextLine();
        if (!nuevoNombre.isBlank()) nombre[pos] = nuevoNombre;

        System.out.print("Nuevo cargo (" + cargo[pos] + ") - deje vacío para no cambiar: ");
        String nuevoCargo = entrada.nextLine();
        if (!nuevoCargo.isBlank()) cargo[pos] = nuevoCargo;

        System.out.print("Nuevo sueldo (" + sueldo[pos] + ") - deje vacío para no cambiar: ");
        String textoSueldo = entrada.nextLine();
        if (!textoSueldo.isBlank()) {
            try {
                sueldo[pos] = Float.parseFloat(textoSueldo);
            } catch (NumberFormatException e) {
                System.out.println("Valor no válido, se mantiene el sueldo anterior.");
            }
        }

        System.out.println("Empleado actualizado correctamente.");
    }

    // eliminar algun registro
    public static void eliminarEmpleado() {

        listarEmpleados();
        if (totalEmpleados == 0) return;

        int pos = leerEntero("Ingrese la posición del empleado a eliminar: ");

        if (!posicionValida(pos)) {
            System.out.println("Posición inválida.");
            return;
        }

        // Desplaza una posición hacia atrás para no dejar huecos vacios
        for (int i = pos; i < totalEmpleados - 1; i++) {
            nombre[i] = nombre[i + 1];
            cargo[i] = cargo[i + 1];
            sueldo[i] = sueldo[i + 1];
        }

        totalEmpleados--;
        System.out.println("Empleado eliminado correctamente.");
    }

    //  Métodos base de la clase 
    public static void asignarValores(String nom, String car, float sue, int pos) {
        nombre[pos] = nom;
        cargo[pos] = car;
        sueldo[pos] = sue;
    }

    public static void verDatos(int pos) {
        System.out.println("Nombre del empleado: " + nombre[pos]);
        System.out.println("Cargo del empleado: " + cargo[pos]);
        System.out.println("Sueldo del empleado: " + sueldo[pos]);
    }

    public static void leerDatos(int pos) {

        System.out.print("Escriba el nombre: ");
        nombre[pos] = entrada.nextLine();

        System.out.print("Escriba el cargo: ");
        cargo[pos] = entrada.nextLine();

        System.out.print("Escriba el sueldo: ");
        sueldo[pos] = leerFloat();
        entrada.nextLine(); 
    }

    // ayudas para lectura
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!entrada.hasNextInt()) {
            System.out.println("Por favor ingrese un número entero válido.");
            entrada.next();
            System.out.print(mensaje);
        }
        int valor = entrada.nextInt();
        entrada.nextLine(); 
        return valor;
    }

    public static float leerFloat() {
        while (!entrada.hasNextFloat()) {
            System.out.println("Por favor ingrese un número válido.");
            entrada.next();
        }
        return entrada.nextFloat();
    }

    public static boolean posicionValida(int pos) {
        return pos >= 0 && pos < totalEmpleados;
    }
}