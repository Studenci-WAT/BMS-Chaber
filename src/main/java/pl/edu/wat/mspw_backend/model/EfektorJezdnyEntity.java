package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "efektor_jezdny", schema = "mspwTest", catalog = "")
public class EfektorJezdnyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "RODZAJ_PODWOZIA_FK", nullable = true)
    private Integer rodzajPodwoziaFk;
    @Basic
    @Column(name = "ZUZYCIE_PALIWA_PREDK_EKO_DROGA", nullable = true, precision = 0)
    private Double zuzyciePaliwaPredkEkoDroga;
    @Basic
    @Column(name = "ZUZYCIE_PALIWA_PREDK_EKO_TEREN", nullable = true, precision = 0)
    private Double zuzyciePaliwaPredkEkoTeren;
    @Basic
    @Column(name = "ZUZYCIE_PALIWA_MAX", nullable = true, precision = 0)
    private Double zuzyciePaliwaMax;
    @Basic
    @Column(name = "PREDK_MAX_DROGA", nullable = true, precision = 0)
    private Double predkMaxDroga;
    @Basic
    @Column(name = "PREDK_MAX_TEREN", nullable = true, precision = 0)
    private Double predkMaxTeren;
    @Basic
    @Column(name = "PREDK_EKO_DROGA", nullable = true, precision = 0)
    private Double predkEkoDroga;
    @Basic
    @Column(name = "PREDK_EKO_TEREN", nullable = true, precision = 0)
    private Double predkEkoTeren;
    @Basic
    @Column(name = "SZEROK_POKONYW_ROWOW", nullable = true, precision = 0)
    private Double szerokPokonywRowow;
    @Basic
    @Column(name = "GLEBOK_BRODZ", nullable = true, precision = 0)
    private Double glebokBrodz;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRodzajPodwoziaFk() {
        return rodzajPodwoziaFk;
    }

    public void setRodzajPodwoziaFk(Integer rodzajPodwoziaFk) {
        this.rodzajPodwoziaFk = rodzajPodwoziaFk;
    }

    public Double getZuzyciePaliwaPredkEkoDroga() {
        return zuzyciePaliwaPredkEkoDroga;
    }

    public void setZuzyciePaliwaPredkEkoDroga(Double zuzyciePaliwaPredkEkoDroga) {
        this.zuzyciePaliwaPredkEkoDroga = zuzyciePaliwaPredkEkoDroga;
    }

    public Double getZuzyciePaliwaPredkEkoTeren() {
        return zuzyciePaliwaPredkEkoTeren;
    }

    public void setZuzyciePaliwaPredkEkoTeren(Double zuzyciePaliwaPredkEkoTeren) {
        this.zuzyciePaliwaPredkEkoTeren = zuzyciePaliwaPredkEkoTeren;
    }

    public Double getZuzyciePaliwaMax() {
        return zuzyciePaliwaMax;
    }

    public void setZuzyciePaliwaMax(Double zuzyciePaliwaMax) {
        this.zuzyciePaliwaMax = zuzyciePaliwaMax;
    }

    public Double getPredkMaxDroga() {
        return predkMaxDroga;
    }

    public void setPredkMaxDroga(Double predkMaxDroga) {
        this.predkMaxDroga = predkMaxDroga;
    }

    public Double getPredkMaxTeren() {
        return predkMaxTeren;
    }

    public void setPredkMaxTeren(Double predkMaxTeren) {
        this.predkMaxTeren = predkMaxTeren;
    }

    public Double getPredkEkoDroga() {
        return predkEkoDroga;
    }

    public void setPredkEkoDroga(Double predkEkoDroga) {
        this.predkEkoDroga = predkEkoDroga;
    }

    public Double getPredkEkoTeren() {
        return predkEkoTeren;
    }

    public void setPredkEkoTeren(Double predkEkoTeren) {
        this.predkEkoTeren = predkEkoTeren;
    }

    public Double getSzerokPokonywRowow() {
        return szerokPokonywRowow;
    }

    public void setSzerokPokonywRowow(Double szerokPokonywRowow) {
        this.szerokPokonywRowow = szerokPokonywRowow;
    }

    public Double getGlebokBrodz() {
        return glebokBrodz;
    }

    public void setGlebokBrodz(Double glebokBrodz) {
        this.glebokBrodz = glebokBrodz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EfektorJezdnyEntity that = (EfektorJezdnyEntity) o;

        if (id != that.id) return false;
        if (rodzajPodwoziaFk != null ? !rodzajPodwoziaFk.equals(that.rodzajPodwoziaFk) : that.rodzajPodwoziaFk != null)
            return false;
        if (zuzyciePaliwaPredkEkoDroga != null ? !zuzyciePaliwaPredkEkoDroga.equals(that.zuzyciePaliwaPredkEkoDroga) : that.zuzyciePaliwaPredkEkoDroga != null)
            return false;
        if (zuzyciePaliwaPredkEkoTeren != null ? !zuzyciePaliwaPredkEkoTeren.equals(that.zuzyciePaliwaPredkEkoTeren) : that.zuzyciePaliwaPredkEkoTeren != null)
            return false;
        if (zuzyciePaliwaMax != null ? !zuzyciePaliwaMax.equals(that.zuzyciePaliwaMax) : that.zuzyciePaliwaMax != null)
            return false;
        if (predkMaxDroga != null ? !predkMaxDroga.equals(that.predkMaxDroga) : that.predkMaxDroga != null)
            return false;
        if (predkMaxTeren != null ? !predkMaxTeren.equals(that.predkMaxTeren) : that.predkMaxTeren != null)
            return false;
        if (predkEkoDroga != null ? !predkEkoDroga.equals(that.predkEkoDroga) : that.predkEkoDroga != null)
            return false;
        if (predkEkoTeren != null ? !predkEkoTeren.equals(that.predkEkoTeren) : that.predkEkoTeren != null)
            return false;
        if (szerokPokonywRowow != null ? !szerokPokonywRowow.equals(that.szerokPokonywRowow) : that.szerokPokonywRowow != null)
            return false;
        if (glebokBrodz != null ? !glebokBrodz.equals(that.glebokBrodz) : that.glebokBrodz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rodzajPodwoziaFk != null ? rodzajPodwoziaFk.hashCode() : 0);
        result = 31 * result + (zuzyciePaliwaPredkEkoDroga != null ? zuzyciePaliwaPredkEkoDroga.hashCode() : 0);
        result = 31 * result + (zuzyciePaliwaPredkEkoTeren != null ? zuzyciePaliwaPredkEkoTeren.hashCode() : 0);
        result = 31 * result + (zuzyciePaliwaMax != null ? zuzyciePaliwaMax.hashCode() : 0);
        result = 31 * result + (predkMaxDroga != null ? predkMaxDroga.hashCode() : 0);
        result = 31 * result + (predkMaxTeren != null ? predkMaxTeren.hashCode() : 0);
        result = 31 * result + (predkEkoDroga != null ? predkEkoDroga.hashCode() : 0);
        result = 31 * result + (predkEkoTeren != null ? predkEkoTeren.hashCode() : 0);
        result = 31 * result + (szerokPokonywRowow != null ? szerokPokonywRowow.hashCode() : 0);
        result = 31 * result + (glebokBrodz != null ? glebokBrodz.hashCode() : 0);
        return result;
    }
}
