package dam.m6.uf2;public class Atleta {

    private int cod;
    private String nombre;
    private int codDeporte;

    public Atleta() {
    }

    public Atleta(String nombre, int codDeporte) {
        this.nombre = nombre;
        this.codDeporte = codDeporte;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodDeporte() {
        return codDeporte;
    }

    public void setCodDeporte(int codDeporte) {
        this.codDeporte = codDeporte;
    }

    @Override
    public String toString() {
        return cod + " - " + nombre + " (Deporte: " + codDeporte + ")";
    }
}
