package nba;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equipos", schema = "NBA", catalog = "")
public class EquiposEntity {
    private String nombre;
    private String ciudad;
    private String conferencia;
    private String division;

    @Id
    @Column(name = "Nombre", nullable = false, length = 20)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Ciudad", nullable = true, length = 20)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Basic
    @Column(name = "Conferencia", nullable = true, length = 4)
    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    @Basic
    @Column(name = "Division", nullable = true, length = 9)
    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquiposEntity that = (EquiposEntity) o;
        return Objects.equals(nombre, that.nombre) &&
                Objects.equals(ciudad, that.ciudad) &&
                Objects.equals(conferencia, that.conferencia) &&
                Objects.equals(division, that.division);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ciudad, conferencia, division);
    }
}
