package nba;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "partidos", schema = "NBA", catalog = "")
public class PartidosEntity {
    private int codigo;
    private Integer puntosLocal;
    private Integer puntosVisitante;
    private String temporada;

    @Id
    @Column(name = "codigo", nullable = false)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "puntos_local", nullable = true)
    public Integer getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(Integer puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    @Basic
    @Column(name = "puntos_visitante", nullable = true)
    public Integer getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(Integer puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    @Basic
    @Column(name = "temporada", nullable = true, length = 5)
    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidosEntity that = (PartidosEntity) o;
        return codigo == that.codigo &&
                Objects.equals(puntosLocal, that.puntosLocal) &&
                Objects.equals(puntosVisitante, that.puntosVisitante) &&
                Objects.equals(temporada, that.temporada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, puntosLocal, puntosVisitante, temporada);
    }
}
