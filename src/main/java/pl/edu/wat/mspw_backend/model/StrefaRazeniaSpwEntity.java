package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "strefa_razenia_spw", schema = "mspwTest", catalog = "")
public class StrefaRazeniaSpwEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "AMO_FK", nullable = true)
    private Integer amoFk;
    @Basic
    @Column(name = "POW_RAZ_CEL_ODKR", nullable = true, precision = 0)
    private Double powRazCelOdkr;
    @Basic
    @Column(name = "POW_RAZ_CEL_ZAKR", nullable = true, precision = 0)
    private Double powRazCelZakr;
    @Basic
    @Column(name = "ODLEG_STRZEL", nullable = true, precision = 0)
    private Double odlegStrzel;
    @Basic
    @Column(name = "KATEG_SPW_FK", nullable = true)
    private Integer kategSpwFk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAmoFk() {
        return amoFk;
    }

    public void setAmoFk(Integer amoFk) {
        this.amoFk = amoFk;
    }

    public Double getPowRazCelOdkr() {
        return powRazCelOdkr;
    }

    public void setPowRazCelOdkr(Double powRazCelOdkr) {
        this.powRazCelOdkr = powRazCelOdkr;
    }

    public Double getPowRazCelZakr() {
        return powRazCelZakr;
    }

    public void setPowRazCelZakr(Double powRazCelZakr) {
        this.powRazCelZakr = powRazCelZakr;
    }

    public Double getOdlegStrzel() {
        return odlegStrzel;
    }

    public void setOdlegStrzel(Double odlegStrzel) {
        this.odlegStrzel = odlegStrzel;
    }

    public Integer getKategSpwFk() {
        return kategSpwFk;
    }

    public void setKategSpwFk(Integer kategSpwFk) {
        this.kategSpwFk = kategSpwFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StrefaRazeniaSpwEntity that = (StrefaRazeniaSpwEntity) o;

        if (id != that.id) return false;
        if (amoFk != null ? !amoFk.equals(that.amoFk) : that.amoFk != null) return false;
        if (powRazCelOdkr != null ? !powRazCelOdkr.equals(that.powRazCelOdkr) : that.powRazCelOdkr != null)
            return false;
        if (powRazCelZakr != null ? !powRazCelZakr.equals(that.powRazCelZakr) : that.powRazCelZakr != null)
            return false;
        if (odlegStrzel != null ? !odlegStrzel.equals(that.odlegStrzel) : that.odlegStrzel != null) return false;
        if (kategSpwFk != null ? !kategSpwFk.equals(that.kategSpwFk) : that.kategSpwFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amoFk != null ? amoFk.hashCode() : 0);
        result = 31 * result + (powRazCelOdkr != null ? powRazCelOdkr.hashCode() : 0);
        result = 31 * result + (powRazCelZakr != null ? powRazCelZakr.hashCode() : 0);
        result = 31 * result + (odlegStrzel != null ? odlegStrzel.hashCode() : 0);
        result = 31 * result + (kategSpwFk != null ? kategSpwFk.hashCode() : 0);
        return result;
    }
}
