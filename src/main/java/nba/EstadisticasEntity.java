package nba;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class EstadisticasEntity implements Serializable {
    private String temporada;
    private int jugador;
    private Double puntosPorPartido;
    private Double asistenciasPorPartido;
    private Double taponesPorPartido;
    private Double rebotesPorPartido;

    @Id
    @Column(name = "temporada", nullable = false, length = 5)
    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Id
    @Column(name = "jugador", nullable = false)
    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    @Basic
    @Column(name = "Puntos_por_partido", nullable = true, precision = 0)
    public Double getPuntosPorPartido() {
        return puntosPorPartido;
    }

    public void setPuntosPorPartido(Double puntosPorPartido) {
        this.puntosPorPartido = puntosPorPartido;
    }

    @Basic
    @Column(name = "Asistencias_por_partido", nullable = true, precision = 0)
    public Double getAsistenciasPorPartido() {
        return asistenciasPorPartido;
    }

    public void setAsistenciasPorPartido(Double asistenciasPorPartido) {
        this.asistenciasPorPartido = asistenciasPorPartido;
    }

    @Basic
    @Column(name = "Tapones_por_partido", nullable = true, precision = 0)
    public Double getTaponesPorPartido() {
        return taponesPorPartido;
    }

    public void setTaponesPorPartido(Double taponesPorPartido) {
        this.taponesPorPartido = taponesPorPartido;
    }

    @Basic
    @Column(name = "Rebotes_por_partido", nullable = true, precision = 0)
    public Double getRebotesPorPartido() {
        return rebotesPorPartido;
    }

    public void setRebotesPorPartido(Double rebotesPorPartido) {
        this.rebotesPorPartido = rebotesPorPartido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadisticasEntity that = (EstadisticasEntity) o;
        return jugador == that.jugador &&
                Objects.equals(temporada, that.temporada) &&
                Objects.equals(puntosPorPartido, that.puntosPorPartido) &&
                Objects.equals(asistenciasPorPartido, that.asistenciasPorPartido) &&
                Objects.equals(taponesPorPartido, that.taponesPorPartido) &&
                Objects.equals(rebotesPorPartido, that.rebotesPorPartido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temporada, jugador, puntosPorPartido, asistenciasPorPartido, taponesPorPartido, rebotesPorPartido);
    }
}
