package Banquete;

public class Tipo_evento {
    protected int codigo;
    private String nombre;

    public Tipo_evento(){

    }
    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
