package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "spw_sys_ogn", schema = "mspwTest", catalog = "")
public class SpwSysOgnEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "LICZBA", nullable = true)
    private Integer liczba;
    @Basic
    @Column(name = "SPW_FK", nullable = true)
    private Integer spwFk;
    @Basic
    @Column(name = "SYSTEM_OGN_FK", nullable = true)
    private Integer systemOgnFk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getLiczba() {
        return liczba;
    }

    public void setLiczba(Integer liczba) {
        this.liczba = liczba;
    }

    public Integer getSpwFk() {
        return spwFk;
    }

    public void setSpwFk(Integer spwFk) {
        this.spwFk = spwFk;
    }

    public Integer getSystemOgnFk() {
        return systemOgnFk;
    }

    public void setSystemOgnFk(Integer systemOgnFk) {
        this.systemOgnFk = systemOgnFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpwSysOgnEntity that = (SpwSysOgnEntity) o;

        if (id != that.id) return false;
        if (liczba != null ? !liczba.equals(that.liczba) : that.liczba != null) return false;
        if (spwFk != null ? !spwFk.equals(that.spwFk) : that.spwFk != null) return false;
        if (systemOgnFk != null ? !systemOgnFk.equals(that.systemOgnFk) : that.systemOgnFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (liczba != null ? liczba.hashCode() : 0);
        result = 31 * result + (spwFk != null ? spwFk.hashCode() : 0);
        result = 31 * result + (systemOgnFk != null ? systemOgnFk.hashCode() : 0);
        return result;
    }
}
