package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fun_intens_strzel_op", schema = "mspwTest", catalog = "")
public class FunIntensStrzelOpEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "KATEG_STRZEL_FK", nullable = true)
    private Integer kategStrzelFk;
    @Basic
    @Column(name = "KLASA_STRZEL", nullable = true)
    private Integer klasaStrzel;
    @Basic
    @Column(name = "KATEG_CELU_FK", nullable = true)
    private Integer kategCeluFk;
    @Basic
    @Column(name = "KLASA_CELU", nullable = true)
    private Integer klasaCelu;
    @Basic
    @Column(name = "POZIOM_WYSZK_STRZEL", nullable = true)
    private Integer poziomWyszkStrzel;
    @Basic
    @Column(name = "TYP_OPERACJI_STRZEL_FK", nullable = true)
    private Integer typOperacjiStrzelFk;
    @Basic
    @Column(name = "TYP_OPERACJI_CELU_FK", nullable = true)
    private Integer typOperacjiCeluFk;
    @Basic
    @Column(name = "ODLEG", nullable = true, precision = 0)
    private Double odleg;
    @Basic
    @Column(name = "INTENS", nullable = true, precision = 0)
    private Double intens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getKategStrzelFk() {
        return kategStrzelFk;
    }

    public void setKategStrzelFk(Integer kategStrzelFk) {
        this.kategStrzelFk = kategStrzelFk;
    }

    public Integer getKlasaStrzel() {
        return klasaStrzel;
    }

    public void setKlasaStrzel(Integer klasaStrzel) {
        this.klasaStrzel = klasaStrzel;
    }

    public Integer getKategCeluFk() {
        return kategCeluFk;
    }

    public void setKategCeluFk(Integer kategCeluFk) {
        this.kategCeluFk = kategCeluFk;
    }

    public Integer getKlasaCelu() {
        return klasaCelu;
    }

    public void setKlasaCelu(Integer klasaCelu) {
        this.klasaCelu = klasaCelu;
    }

    public Integer getPoziomWyszkStrzel() {
        return poziomWyszkStrzel;
    }

    public void setPoziomWyszkStrzel(Integer poziomWyszkStrzel) {
        this.poziomWyszkStrzel = poziomWyszkStrzel;
    }

    public Integer getTypOperacjiStrzelFk() {
        return typOperacjiStrzelFk;
    }

    public void setTypOperacjiStrzelFk(Integer typOperacjiStrzelFk) {
        this.typOperacjiStrzelFk = typOperacjiStrzelFk;
    }

    public Integer getTypOperacjiCeluFk() {
        return typOperacjiCeluFk;
    }

    public void setTypOperacjiCeluFk(Integer typOperacjiCeluFk) {
        this.typOperacjiCeluFk = typOperacjiCeluFk;
    }

    public Double getOdleg() {
        return odleg;
    }

    public void setOdleg(Double odleg) {
        this.odleg = odleg;
    }

    public Double getIntens() {
        return intens;
    }

    public void setIntens(Double intens) {
        this.intens = intens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunIntensStrzelOpEntity that = (FunIntensStrzelOpEntity) o;

        if (id != that.id) return false;
        if (kategStrzelFk != null ? !kategStrzelFk.equals(that.kategStrzelFk) : that.kategStrzelFk != null)
            return false;
        if (klasaStrzel != null ? !klasaStrzel.equals(that.klasaStrzel) : that.klasaStrzel != null) return false;
        if (kategCeluFk != null ? !kategCeluFk.equals(that.kategCeluFk) : that.kategCeluFk != null) return false;
        if (klasaCelu != null ? !klasaCelu.equals(that.klasaCelu) : that.klasaCelu != null) return false;
        if (poziomWyszkStrzel != null ? !poziomWyszkStrzel.equals(that.poziomWyszkStrzel) : that.poziomWyszkStrzel != null)
            return false;
        if (typOperacjiStrzelFk != null ? !typOperacjiStrzelFk.equals(that.typOperacjiStrzelFk) : that.typOperacjiStrzelFk != null)
            return false;
        if (typOperacjiCeluFk != null ? !typOperacjiCeluFk.equals(that.typOperacjiCeluFk) : that.typOperacjiCeluFk != null)
            return false;
        if (odleg != null ? !odleg.equals(that.odleg) : that.odleg != null) return false;
        if (intens != null ? !intens.equals(that.intens) : that.intens != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (kategStrzelFk != null ? kategStrzelFk.hashCode() : 0);
        result = 31 * result + (klasaStrzel != null ? klasaStrzel.hashCode() : 0);
        result = 31 * result + (kategCeluFk != null ? kategCeluFk.hashCode() : 0);
        result = 31 * result + (klasaCelu != null ? klasaCelu.hashCode() : 0);
        result = 31 * result + (poziomWyszkStrzel != null ? poziomWyszkStrzel.hashCode() : 0);
        result = 31 * result + (typOperacjiStrzelFk != null ? typOperacjiStrzelFk.hashCode() : 0);
        result = 31 * result + (typOperacjiCeluFk != null ? typOperacjiCeluFk.hashCode() : 0);
        result = 31 * result + (odleg != null ? odleg.hashCode() : 0);
        result = 31 * result + (intens != null ? intens.hashCode() : 0);
        return result;
    }
}
