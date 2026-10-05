
public class Producto {
    private String nombre;
    private int stock;
    private double precioCompra;
    private Proveedor proveedor;

    public Producto(String nombre, int stock, double precioCompra, Proveedor proveedor) {
        this.nombre = nombre;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.proveedor = proveedor;
    }

    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public double getPrecioCompra() { return precioCompra; }
    public Proveedor getProveedor() { return proveedor; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setStock(int stock) { this.stock = stock; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }
}
