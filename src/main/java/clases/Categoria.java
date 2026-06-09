package clases;
public class Categoria {
    private int categoria_id; 
    private String nombre;

    public Categoria() {
    }

    public Categoria(int categoria_id, String nombre) {
        this.categoria_id = categoria_id;
        this.nombre = nombre;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" + "categoria_id=" + categoria_id + ", nombre=" + nombre + '}';
    }
    
    
}
