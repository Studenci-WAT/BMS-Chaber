package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stan_amo_spw", schema = "mspwTest", catalog = "")
public class StanAmoSpwEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "SPW_FK", nullable = true)
    private Integer spwFk;
    @Basic
    @Column(name = "AMO_FK", nullable = true)
    private Integer amoFk;
    @Basic
    @Column(name = "STAN_NORMATYW", nullable = true)
    private Integer stanNormatyw;

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

    public Integer getAmoFk() {
        return amoFk;
    }

    public void setAmoFk(Integer amoFk) {
        this.amoFk = amoFk;
    }

    public Integer getStanNormatyw() {
        return stanNormatyw;
    }

    public void setStanNormatyw(Integer stanNormatyw) {
        this.stanNormatyw = stanNormatyw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StanAmoSpwEntity that = (StanAmoSpwEntity) o;

        if (id != that.id) return false;
        if (spwFk != null ? !spwFk.equals(that.spwFk) : that.spwFk != null) return false;
        if (amoFk != null ? !amoFk.equals(that.amoFk) : that.amoFk != null) return false;
        if (stanNormatyw != null ? !stanNormatyw.equals(that.stanNormatyw) : that.stanNormatyw != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (spwFk != null ? spwFk.hashCode() : 0);
        result = 31 * result + (amoFk != null ? amoFk.hashCode() : 0);
        result = 31 * result + (stanNormatyw != null ? stanNormatyw.hashCode() : 0);
        return result;
    }
}
