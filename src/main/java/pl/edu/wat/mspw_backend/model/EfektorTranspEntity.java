package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "efektor_transp", schema = "mspwTest", catalog = "")
public class EfektorTranspEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "DESANT", nullable = true)
    private Integer desant;
    @Basic
    @Column(name = "LADOW_MASA", nullable = true, precision = 0)
    private Double ladowMasa;
    @Basic
    @Column(name = "LADOW_WYM_X", nullable = true, precision = 0)
    private Double ladowWymX;
    @Basic
    @Column(name = "LADOW_WYM_Y", nullable = true, precision = 0)
    private Double ladowWymY;
    @Basic
    @Column(name = "LADOW_WYM_Z", nullable = true, precision = 0)
    private Double ladowWymZ;
    @Basic
    @Column(name = "POJEM", nullable = true, precision = 0)
    private Double pojem;
    @Basic
    @Column(name = "TRANSPORT_WODY", nullable = true)
    private Boolean transportWody;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDesant() {
        return desant;
    }

    public void setDesant(Integer desant) {
        this.desant = desant;
    }

    public Double getLadowMasa() {
        return ladowMasa;
    }

    public void setLadowMasa(Double ladowMasa) {
        this.ladowMasa = ladowMasa;
    }

    public Double getLadowWymX() {
        return ladowWymX;
    }

    public void setLadowWymX(Double ladowWymX) {
        this.ladowWymX = ladowWymX;
    }

    public Double getLadowWymY() {
        return ladowWymY;
    }

    public void setLadowWymY(Double ladowWymY) {
        this.ladowWymY = ladowWymY;
    }

    public Double getLadowWymZ() {
        return ladowWymZ;
    }

    public void setLadowWymZ(Double ladowWymZ) {
        this.ladowWymZ = ladowWymZ;
    }

    public Double getPojem() {
        return pojem;
    }

    public void setPojem(Double pojem) {
        this.pojem = pojem;
    }

    public Boolean getTransportWody() {
        return transportWody;
    }

    public void setTransportWody(Boolean transportWody) {
        this.transportWody = transportWody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EfektorTranspEntity that = (EfektorTranspEntity) o;

        if (id != that.id) return false;
        if (desant != null ? !desant.equals(that.desant) : that.desant != null) return false;
        if (ladowMasa != null ? !ladowMasa.equals(that.ladowMasa) : that.ladowMasa != null) return false;
        if (ladowWymX != null ? !ladowWymX.equals(that.ladowWymX) : that.ladowWymX != null) return false;
        if (ladowWymY != null ? !ladowWymY.equals(that.ladowWymY) : that.ladowWymY != null) return false;
        if (ladowWymZ != null ? !ladowWymZ.equals(that.ladowWymZ) : that.ladowWymZ != null) return false;
        if (pojem != null ? !pojem.equals(that.pojem) : that.pojem != null) return false;
        if (transportWody != null ? !transportWody.equals(that.transportWody) : that.transportWody != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (desant != null ? desant.hashCode() : 0);
        result = 31 * result + (ladowMasa != null ? ladowMasa.hashCode() : 0);
        result = 31 * result + (ladowWymX != null ? ladowWymX.hashCode() : 0);
        result = 31 * result + (ladowWymY != null ? ladowWymY.hashCode() : 0);
        result = 31 * result + (ladowWymZ != null ? ladowWymZ.hashCode() : 0);
        result = 31 * result + (pojem != null ? pojem.hashCode() : 0);
        result = 31 * result + (transportWody != null ? transportWody.hashCode() : 0);
        return result;
    }
}
