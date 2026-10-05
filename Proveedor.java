public class Proveedor {
    private String nombreRepartidor;
    private String telefono;
    private String empresa;

    public Proveedor(String nombreRepartidor, String telefono, String empresa) {
        this.nombreRepartidor = nombreRepartidor;
        this.telefono = telefono;
        this.empresa = empresa;
    }

    public String getNombreRepartidor() { return nombreRepartidor; }
    public String getTelefono() { return telefono; }
    public String getEmpresa() { return empresa; }

    public void setNombreRepartidor(String nombreRepartidor) { this.nombreRepartidor = nombreRepartidor; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
}
