public class Direccion {
    private int id;
    private String calle;
    private int altura;
    private int id_alumno;

    public Direccion(int id, String calle, int altura, int id_alumno){
        this.id=id;
        this.calle=calle;
        this.altura=altura;
        this.id_alumno=id_alumno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", altura=" + altura +
                ", id_alumno=" + id_alumno +
                '}';
    }
}
