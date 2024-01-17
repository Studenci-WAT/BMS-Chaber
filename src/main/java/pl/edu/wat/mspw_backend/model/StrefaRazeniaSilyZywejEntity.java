package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "strefa_razenia_sily_zywej", schema = "mspwTest", catalog = "")
public class StrefaRazeniaSilyZywejEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "AMO_FK", nullable = true)
    private Integer amoFk;
    @Basic
    @Column(name = "ODLEG_STRZEL", nullable = true, precision = 0)
    private Double odlegStrzel;
    @Basic
    @Column(name = "POW_RAZ_ODKR", nullable = true, precision = 0)
    private Double powRazOdkr;
    @Basic
    @Column(name = "POW_RAZ_ROZB_DORAZNA", nullable = true, precision = 0)
    private Double powRazRozbDorazna;
    @Basic
    @Column(name = "POW_RAZ_ROZB_PRZYGOT", nullable = true, precision = 0)
    private Double powRazRozbPrzygot;

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

    public Double getOdlegStrzel() {
        return odlegStrzel;
    }

    public void setOdlegStrzel(Double odlegStrzel) {
        this.odlegStrzel = odlegStrzel;
    }

    public Double getPowRazOdkr() {
        return powRazOdkr;
    }

    public void setPowRazOdkr(Double powRazOdkr) {
        this.powRazOdkr = powRazOdkr;
    }

    public Double getPowRazRozbDorazna() {
        return powRazRozbDorazna;
    }

    public void setPowRazRozbDorazna(Double powRazRozbDorazna) {
        this.powRazRozbDorazna = powRazRozbDorazna;
    }

    public Double getPowRazRozbPrzygot() {
        return powRazRozbPrzygot;
    }

    public void setPowRazRozbPrzygot(Double powRazRozbPrzygot) {
        this.powRazRozbPrzygot = powRazRozbPrzygot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StrefaRazeniaSilyZywejEntity that = (StrefaRazeniaSilyZywejEntity) o;

        if (id != that.id) return false;
        if (amoFk != null ? !amoFk.equals(that.amoFk) : that.amoFk != null) return false;
        if (odlegStrzel != null ? !odlegStrzel.equals(that.odlegStrzel) : that.odlegStrzel != null) return false;
        if (powRazOdkr != null ? !powRazOdkr.equals(that.powRazOdkr) : that.powRazOdkr != null) return false;
        if (powRazRozbDorazna != null ? !powRazRozbDorazna.equals(that.powRazRozbDorazna) : that.powRazRozbDorazna != null)
            return false;
        if (powRazRozbPrzygot != null ? !powRazRozbPrzygot.equals(that.powRazRozbPrzygot) : that.powRazRozbPrzygot != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amoFk != null ? amoFk.hashCode() : 0);
        result = 31 * result + (odlegStrzel != null ? odlegStrzel.hashCode() : 0);
        result = 31 * result + (powRazOdkr != null ? powRazOdkr.hashCode() : 0);
        result = 31 * result + (powRazRozbDorazna != null ? powRazRozbDorazna.hashCode() : 0);
        result = 31 * result + (powRazRozbPrzygot != null ? powRazRozbPrzygot.hashCode() : 0);
        return result;
    }
}
