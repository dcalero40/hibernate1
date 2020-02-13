package nba;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jugadores", schema = "NBA", catalog = "")
public class JugadoresEntity {
    private int codigo;
    private String nombre;
    private String procedencia;
    private String altura;
    private Integer peso;
    private String posicion;
    private  String nombre_equipo;

    @Id
    @Column(name = "codigo", nullable = false)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name="Nombre_Equipo", nullable = true, length = 30)
    public String getNombre_equipo() {return nombre_equipo;}
    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    @Basic
    @Column(name = "Nombre", nullable = true, length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Procedencia", nullable = true, length = 20)
    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    @Basic
    @Column(name = "Altura", nullable = true, length = 4)
    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    @Basic
    @Column(name = "Peso", nullable = true)
    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    @Basic
    @Column(name = "Posicion", nullable = true, length = 5)
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadoresEntity that = (JugadoresEntity) o;
        return codigo == that.codigo &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(procedencia, that.procedencia) &&
                Objects.equals(altura, that.altura) &&
                Objects.equals(peso, that.peso) &&
                Objects.equals(posicion, that.posicion);
    }

    @Override
    public String toString() {
        return "JugadoresEntity{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", procedencia='" + procedencia + '\'' +
                ", altura='" + altura + '\'' +
                ", peso=" + peso +
                ", posicion='" + posicion + '\'' +
                ", nombre_equipo='" + nombre_equipo + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, procedencia, altura, peso, posicion);
    }
}
