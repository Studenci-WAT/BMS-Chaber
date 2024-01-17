package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stan_mps_spw", schema = "mspwTest", catalog = "")
public class StanMpsSpwEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "SPW_FK", nullable = true)
    private Integer spwFk;
    @Basic
    @Column(name = "MPS_FK", nullable = true)
    private Integer mpsFk;
    @Basic
    @Column(name = "STAN_NORMATYW", nullable = true, precision = 0)
    private Double stanNormatyw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSpwFk() {
        return spwFk;
    }

    public void setSpwFk(Integer spwFk) {
        this.spwFk = spwFk;
    }

    public Integer getMpsFk() {
        return mpsFk;
    }

    public void setMpsFk(Integer mpsFk) {
        this.mpsFk = mpsFk;
    }

    public Double getStanNormatyw() {
        return stanNormatyw;
    }

    public void setStanNormatyw(Double stanNormatyw) {
        this.stanNormatyw = stanNormatyw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StanMpsSpwEntity that = (StanMpsSpwEntity) o;

        if (id != that.id) return false;
        if (spwFk != null ? !spwFk.equals(that.spwFk) : that.spwFk != null) return false;
        if (mpsFk != null ? !mpsFk.equals(that.mpsFk) : that.mpsFk != null) return false;
        if (stanNormatyw != null ? !stanNormatyw.equals(that.stanNormatyw) : that.stanNormatyw != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (spwFk != null ? spwFk.hashCode() : 0);
        result = 31 * result + (mpsFk != null ? mpsFk.hashCode() : 0);
        result = 31 * result + (stanNormatyw != null ? stanNormatyw.hashCode() : 0);
        return result;
    }
}
