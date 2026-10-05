import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = leerEntero("Capacidad del almacén (tamaño N del arreglo): ", 1, 1000);
        Almacen almacen = new Almacen(n);

        int opcion;
        do {
            System.out.println("\n______ MENÚ PRINCIPAL ______");
            System.out.println("1. Vista: Formulario de surtido (01)");
            System.out.println("2. Vista: Almacén / Reporte (02)");
            System.out.println("3. Salir");
            opcion = leerEntero("Elige una opción: ", 1, 3);

            switch (opcion) {
                case 1: vistaFormulario(almacen); break;
                case 2: vistaAlmacen(almacen); break;
                case 3: System.out.println("Fin del programa."); break;
            }
        } while (opcion != 3);
    }

    static void vistaFormulario(Almacen almacen) {
        System.out.println("\n___ FORMULARIO DE SURTIDO ___");
        if (!almacen.hayEspacio()) {
            System.out.println("Almacén Lleno.");
            return;
        }
        String nombre = leerTexto("Nombre del producto: ");
        int stock = leerEntero("Cantidad / Stock: ", 0, Integer.MAX_VALUE);
        double precio = leerDouble("Precio de compra acordado: ");
        Proveedor prov = capturarProveedor();

        almacen.agregarProducto(new Producto(nombre, stock, precio, prov));
        System.out.println("Producto registrado correctamente.");
    }

    static void vistaAlmacen(Almacen almacen) {
        almacen.mostrarReporte();
        if (almacen.getCantidad() == 0) {
            return;
        }
        String resp = leerTexto("¿Desea cambiar proveedor de algún producto? (s/n): ");
        if (resp.equalsIgnoreCase("s")) {
            int num = leerEntero("Número del producto: ", 1, almacen.getCantidad());
            System.out.println("Nuevos datos del proveedor para \"" + almacen.getProducto(num - 1).getNombre() + "\":");
            Proveedor nuevo = capturarProveedor();
            almacen.cambiarProveedor(num - 1, nuevo);
            System.out.println("Proveedor actualizado.");
            almacen.mostrarReporte();
        }
    }

    static Proveedor capturarProveedor() {
        String repartidor = leerTexto("Nombre del repartidor: ");
        String telefono = leerTexto("Teléfono del repartidor: ");
        String empresa = leerTexto("Empresa (proveedor): ");
        return new Proveedor(repartidor, telefono, empresa);
    }

    static String leerTexto(String msg) {
        String t;
        do {
            System.out.print(msg);
            t = sc.nextLine().trim();
        } while (t.isEmpty());
        return t;
    }

    static int leerEntero(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v >= min && v <= max) return v;
            } catch (NumberFormatException e) { }
            System.out.println("Valor inválido, intenta de nuevo.");
        }
    }

    static double leerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                double v = Double.parseDouble(sc.nextLine().trim());
                if (v >= 0) return v;
            } catch (NumberFormatException e) { }
            System.out.println("Valor inválido, intenta de nuevo.");
        }
    }
}
