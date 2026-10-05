
public class Almacen {
    private Producto[] productos;
    private int cantidad;

    public Almacen(int capacidad) {
        productos = new Producto[capacidad];
        cantidad = 0;
    }

    public boolean hayEspacio() {
        return cantidad < productos.length;
    }

    public int getCantidad() { return cantidad; }

    public Producto getProducto(int indice) { return productos[indice]; }

    public boolean agregarProducto(Producto p) {
        if (!hayEspacio()) {
            return false;
        }
        productos[cantidad] = p;
        cantidad++;
        return true;
    }

    public void cambiarProveedor(int indice, Proveedor nuevo) {
        productos[indice].setProveedor(nuevo);
    }

    public void mostrarReporte() {
        System.out.println("\n________________________________ ENTRADA DE PRODUCTOS __________________________________");
        if (cantidad == 0) {
            System.out.println("No hay productos registrados.");
            System.out.println("______________________________________________________________________________________");
            return;
        }
        System.out.printf("%-4s %-16s %-7s %-10s %-16s %-12s %-16s%n",
                "No.", "Producto", "Stock", "Precio", "Repartidor", "Teléfono", "Empresa");
        System.out.println("_______________________________________________________________________________________");
        for (int i = 0; i < cantidad; i++) {
            Producto p = productos[i];
            Proveedor pr = p.getProveedor();
            System.out.printf("%-4d %-16s %-7d $%-9.2f %-16s %-12s %-16s%n",
                    (i + 1), p.getNombre(), p.getStock(), p.getPrecioCompra(),
                    pr.getNombreRepartidor(), pr.getTelefono(), pr.getEmpresa());
        }
        System.out.println("_______________________________________________________________________________________");
    }
}
