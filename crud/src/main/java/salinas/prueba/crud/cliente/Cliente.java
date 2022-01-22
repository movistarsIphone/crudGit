package salinas.prueba.crud.cliente;

public class Cliente {

    private long id;
    private String nombre;
    private String correo;

    public Cliente() {}

    public Cliente(String nombre, String correo) {
        super();
        this.nombre = nombre;
        this.correo = correo;
    }

    public Cliente(long id, String nombre, String correo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", correo=" + correo + "]";
    }
}
