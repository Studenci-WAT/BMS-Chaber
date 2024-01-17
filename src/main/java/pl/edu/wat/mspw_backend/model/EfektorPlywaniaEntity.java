package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "efektor_plywania", schema = "mspwTest", catalog = "")
public class EfektorPlywaniaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "PREDK_MAX_NA_WODZIE", nullable = true, precision = 0)
    private Double predkMaxNaWodzie;
    @Basic
    @Column(name = "PREDK_EKO_NA_WODZIE", nullable = true, precision = 0)
    private Double predkEkoNaWodzie;
    @Basic
    @Column(name = "PREDK_MAX_POD_WODA", nullable = true, precision = 0)
    private Double predkMaxPodWoda;
    @Basic
    @Column(name = "PREDK_EKO_POD_WODA", nullable = true, precision = 0)
    private Double predkEkoPodWoda;
    @Basic
    @Column(name = "DZIELNOSC", nullable = true)
    private Integer dzielnosc;
    @Basic
    @Column(name = "ZUZYCIE_PALIWA_PREDK_MAX_NA_WOD", nullable = true, precision = 0)
    private Double zuzyciePaliwaPredkMaxNaWod;
    @Basic
    @Column(name = "ZUZYCIE_PALIWA_PREDK_EKO_NA_WOD", nullable = true, precision = 0)
    private Double zuzyciePaliwaPredkEkoNaWod;
    @Basic
    @Column(name = "ZUZYCIE_PALIWA_PREDK_MAX_POD_WOD", nullable = true, precision = 0)
    private Double zuzyciePaliwaPredkMaxPodWod;
    @Basic
    @Column(name = "ZUZYCIE_PALIWA_PREDK_EKO_POD_WOD", nullable = true, precision = 0)
    private Double zuzyciePaliwaPredkEkoPodWod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPredkMaxNaWodzie() {
        return predkMaxNaWodzie;
    }

    public void setPredkMaxNaWodzie(Double predkMaxNaWodzie) {
        this.predkMaxNaWodzie = predkMaxNaWodzie;
    }

    public Double getPredkEkoNaWodzie() {
        return predkEkoNaWodzie;
    }

    public void setPredkEkoNaWodzie(Double predkEkoNaWodzie) {
        this.predkEkoNaWodzie = predkEkoNaWodzie;
    }

    public Double getPredkMaxPodWoda() {
        return predkMaxPodWoda;
    }

    public void setPredkMaxPodWoda(Double predkMaxPodWoda) {
        this.predkMaxPodWoda = predkMaxPodWoda;
    }

    public Double getPredkEkoPodWoda() {
        return predkEkoPodWoda;
    }

    public void setPredkEkoPodWoda(Double predkEkoPodWoda) {
        this.predkEkoPodWoda = predkEkoPodWoda;
    }

    public Integer getDzielnosc() {
        return dzielnosc;
    }

    public void setDzielnosc(Integer dzielnosc) {
        this.dzielnosc = dzielnosc;
    }

    public Double getZuzyciePaliwaPredkMaxNaWod() {
        return zuzyciePaliwaPredkMaxNaWod;
    }

    public void setZuzyciePaliwaPredkMaxNaWod(Double zuzyciePaliwaPredkMaxNaWod) {
        this.zuzyciePaliwaPredkMaxNaWod = zuzyciePaliwaPredkMaxNaWod;
    }

    public Double getZuzyciePaliwaPredkEkoNaWod() {
        return zuzyciePaliwaPredkEkoNaWod;
    }

    public void setZuzyciePaliwaPredkEkoNaWod(Double zuzyciePaliwaPredkEkoNaWod) {
        this.zuzyciePaliwaPredkEkoNaWod = zuzyciePaliwaPredkEkoNaWod;
    }

    public Double getZuzyciePaliwaPredkMaxPodWod() {
        return zuzyciePaliwaPredkMaxPodWod;
    }

    public void setZuzyciePaliwaPredkMaxPodWod(Double zuzyciePaliwaPredkMaxPodWod) {
        this.zuzyciePaliwaPredkMaxPodWod = zuzyciePaliwaPredkMaxPodWod;
    }

    public Double getZuzyciePaliwaPredkEkoPodWod() {
        return zuzyciePaliwaPredkEkoPodWod;
    }

    public void setZuzyciePaliwaPredkEkoPodWod(Double zuzyciePaliwaPredkEkoPodWod) {
        this.zuzyciePaliwaPredkEkoPodWod = zuzyciePaliwaPredkEkoPodWod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EfektorPlywaniaEntity that = (EfektorPlywaniaEntity) o;

        if (id != that.id) return false;
        if (predkMaxNaWodzie != null ? !predkMaxNaWodzie.equals(that.predkMaxNaWodzie) : that.predkMaxNaWodzie != null)
            return false;
        if (predkEkoNaWodzie != null ? !predkEkoNaWodzie.equals(that.predkEkoNaWodzie) : that.predkEkoNaWodzie != null)
            return false;
        if (predkMaxPodWoda != null ? !predkMaxPodWoda.equals(that.predkMaxPodWoda) : that.predkMaxPodWoda != null)
            return false;
        if (predkEkoPodWoda != null ? !predkEkoPodWoda.equals(that.predkEkoPodWoda) : that.predkEkoPodWoda != null)
            return false;
        if (dzielnosc != null ? !dzielnosc.equals(that.dzielnosc) : that.dzielnosc != null) return false;
        if (zuzyciePaliwaPredkMaxNaWod != null ? !zuzyciePaliwaPredkMaxNaWod.equals(that.zuzyciePaliwaPredkMaxNaWod) : that.zuzyciePaliwaPredkMaxNaWod != null)
            return false;
        if (zuzyciePaliwaPredkEkoNaWod != null ? !zuzyciePaliwaPredkEkoNaWod.equals(that.zuzyciePaliwaPredkEkoNaWod) : that.zuzyciePaliwaPredkEkoNaWod != null)
            return false;
        if (zuzyciePaliwaPredkMaxPodWod != null ? !zuzyciePaliwaPredkMaxPodWod.equals(that.zuzyciePaliwaPredkMaxPodWod) : that.zuzyciePaliwaPredkMaxPodWod != null)
            return false;
        if (zuzyciePaliwaPredkEkoPodWod != null ? !zuzyciePaliwaPredkEkoPodWod.equals(that.zuzyciePaliwaPredkEkoPodWod) : that.zuzyciePaliwaPredkEkoPodWod != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (predkMaxNaWodzie != null ? predkMaxNaWodzie.hashCode() : 0);
        result = 31 * result + (predkEkoNaWodzie != null ? predkEkoNaWodzie.hashCode() : 0);
        result = 31 * result + (predkMaxPodWoda != null ? predkMaxPodWoda.hashCode() : 0);
        result = 31 * result + (predkEkoPodWoda != null ? predkEkoPodWoda.hashCode() : 0);
        result = 31 * result + (dzielnosc != null ? dzielnosc.hashCode() : 0);
        result = 31 * result + (zuzyciePaliwaPredkMaxNaWod != null ? zuzyciePaliwaPredkMaxNaWod.hashCode() : 0);
        result = 31 * result + (zuzyciePaliwaPredkEkoNaWod != null ? zuzyciePaliwaPredkEkoNaWod.hashCode() : 0);
        result = 31 * result + (zuzyciePaliwaPredkMaxPodWod != null ? zuzyciePaliwaPredkMaxPodWod.hashCode() : 0);
        result = 31 * result + (zuzyciePaliwaPredkEkoPodWod != null ? zuzyciePaliwaPredkEkoPodWod.hashCode() : 0);
        return result;
    }
}
