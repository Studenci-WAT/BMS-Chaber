package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "efektor_latania", schema = "mspwTest", catalog = "")
public class EfektorLataniaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "PREDK_MIN", nullable = true, precision = 0)
    private Double predkMin;
    @Basic
    @Column(name = "PREDK_EKO", nullable = true, precision = 0)
    private Double predkEko;
    @Basic
    @Column(name = "PREDK_MAX", nullable = true, precision = 0)
    private Double predkMax;
    @Basic
    @Column(name = "WYSOK_MIN", nullable = true, precision = 0)
    private Double wysokMin;
    @Basic
    @Column(name = "WYSOK_PRZELOT", nullable = true, precision = 0)
    private Double wysokPrzelot;
    @Basic
    @Column(name = "WYSOK_MAX", nullable = true, precision = 0)
    private Double wysokMax;
    @Basic
    @Column(name = "ZUZYCIE_PREDK_MIN", nullable = true, precision = 0)
    private Double zuzyciePredkMin;
    @Basic
    @Column(name = "ZUZYCIE_PREDK_PRZELOT", nullable = true, precision = 0)
    private Double zuzyciePredkPrzelot;
    @Basic
    @Column(name = "ZUZYCIE_PREDK_MAX", nullable = true, precision = 0)
    private Double zuzyciePredkMax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPredkMin() {
        return predkMin;
    }

    public void setPredkMin(Double predkMin) {
        this.predkMin = predkMin;
    }

    public Double getPredkEko() {
        return predkEko;
    }

    public void setPredkEko(Double predkEko) {
        this.predkEko = predkEko;
    }

    public Double getPredkMax() {
        return predkMax;
    }

    public void setPredkMax(Double predkMax) {
        this.predkMax = predkMax;
    }

    public Double getWysokMin() {
        return wysokMin;
    }

    public void setWysokMin(Double wysokMin) {
        this.wysokMin = wysokMin;
    }

    public Double getWysokPrzelot() {
        return wysokPrzelot;
    }

    public void setWysokPrzelot(Double wysokPrzelot) {
        this.wysokPrzelot = wysokPrzelot;
    }

    public Double getWysokMax() {
        return wysokMax;
    }

    public void setWysokMax(Double wysokMax) {
        this.wysokMax = wysokMax;
    }

    public Double getZuzyciePredkMin() {
        return zuzyciePredkMin;
    }

    public void setZuzyciePredkMin(Double zuzyciePredkMin) {
        this.zuzyciePredkMin = zuzyciePredkMin;
    }

    public Double getZuzyciePredkPrzelot() {
        return zuzyciePredkPrzelot;
    }

    public void setZuzyciePredkPrzelot(Double zuzyciePredkPrzelot) {
        this.zuzyciePredkPrzelot = zuzyciePredkPrzelot;
    }

    public Double getZuzyciePredkMax() {
        return zuzyciePredkMax;
    }

    public void setZuzyciePredkMax(Double zuzyciePredkMax) {
        this.zuzyciePredkMax = zuzyciePredkMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EfektorLataniaEntity that = (EfektorLataniaEntity) o;

        if (id != that.id) return false;
        if (predkMin != null ? !predkMin.equals(that.predkMin) : that.predkMin != null) return false;
        if (predkEko != null ? !predkEko.equals(that.predkEko) : that.predkEko != null) return false;
        if (predkMax != null ? !predkMax.equals(that.predkMax) : that.predkMax != null) return false;
        if (wysokMin != null ? !wysokMin.equals(that.wysokMin) : that.wysokMin != null) return false;
        if (wysokPrzelot != null ? !wysokPrzelot.equals(that.wysokPrzelot) : that.wysokPrzelot != null) return false;
        if (wysokMax != null ? !wysokMax.equals(that.wysokMax) : that.wysokMax != null) return false;
        if (zuzyciePredkMin != null ? !zuzyciePredkMin.equals(that.zuzyciePredkMin) : that.zuzyciePredkMin != null)
            return false;
        if (zuzyciePredkPrzelot != null ? !zuzyciePredkPrzelot.equals(that.zuzyciePredkPrzelot) : that.zuzyciePredkPrzelot != null)
            return false;
        if (zuzyciePredkMax != null ? !zuzyciePredkMax.equals(that.zuzyciePredkMax) : that.zuzyciePredkMax != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (predkMin != null ? predkMin.hashCode() : 0);
        result = 31 * result + (predkEko != null ? predkEko.hashCode() : 0);
        result = 31 * result + (predkMax != null ? predkMax.hashCode() : 0);
        result = 31 * result + (wysokMin != null ? wysokMin.hashCode() : 0);
        result = 31 * result + (wysokPrzelot != null ? wysokPrzelot.hashCode() : 0);
        result = 31 * result + (wysokMax != null ? wysokMax.hashCode() : 0);
        result = 31 * result + (zuzyciePredkMin != null ? zuzyciePredkMin.hashCode() : 0);
        result = 31 * result + (zuzyciePredkPrzelot != null ? zuzyciePredkPrzelot.hashCode() : 0);
        result = 31 * result + (zuzyciePredkMax != null ? zuzyciePredkMax.hashCode() : 0);
        return result;
    }
}
