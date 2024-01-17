package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "efektor_rozpoz", schema = "mspwTest", catalog = "")
public class EfektorRozpozEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "ROZPOZ_AKUST", nullable = true)
    private Boolean rozpozAkust;
    @Basic
    @Column(name = "ROZPOZ_AKUST_PROMIEN", nullable = true, precision = 0)
    private Double rozpozAkustPromien;
    @Basic
    @Column(name = "ROZPOZ_TERMICZ", nullable = true)
    private Boolean rozpozTermicz;
    @Basic
    @Column(name = "ROZPOZ_TERMICZ_PROMIEN_DZIEN", nullable = true, precision = 0)
    private Double rozpozTermiczPromienDzien;
    @Basic
    @Column(name = "ROZPOZ_TERMICZ_PROMIEN_NOC", nullable = true, precision = 0)
    private Double rozpozTermiczPromienNoc;
    @Basic
    @Column(name = "ROZPOZ_NOKTOW", nullable = true)
    private Boolean rozpozNoktow;
    @Basic
    @Column(name = "ROZPOZ_NOKTOW_PROMIEN", nullable = true, precision = 0)
    private Double rozpozNoktowPromien;
    @Basic
    @Column(name = "ROZPOZ_RADAR", nullable = true)
    private Boolean rozpozRadar;
    @Basic
    @Column(name = "ROZPOZ_RADAR_PROMIEN", nullable = true, precision = 0)
    private Double rozpozRadarPromien;
    @Basic
    @Column(name = "KLASA_PRZYRZ_OC", nullable = true)
    private Integer klasaPrzyrzOc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getRozpozAkust() {
        return rozpozAkust;
    }

    public void setRozpozAkust(Boolean rozpozAkust) {
        this.rozpozAkust = rozpozAkust;
    }

    public Double getRozpozAkustPromien() {
        return rozpozAkustPromien;
    }

    public void setRozpozAkustPromien(Double rozpozAkustPromien) {
        this.rozpozAkustPromien = rozpozAkustPromien;
    }

    public Boolean getRozpozTermicz() {
        return rozpozTermicz;
    }

    public void setRozpozTermicz(Boolean rozpozTermicz) {
        this.rozpozTermicz = rozpozTermicz;
    }

    public Double getRozpozTermiczPromienDzien() {
        return rozpozTermiczPromienDzien;
    }

    public void setRozpozTermiczPromienDzien(Double rozpozTermiczPromienDzien) {
        this.rozpozTermiczPromienDzien = rozpozTermiczPromienDzien;
    }

    public Double getRozpozTermiczPromienNoc() {
        return rozpozTermiczPromienNoc;
    }

    public void setRozpozTermiczPromienNoc(Double rozpozTermiczPromienNoc) {
        this.rozpozTermiczPromienNoc = rozpozTermiczPromienNoc;
    }

    public Boolean getRozpozNoktow() {
        return rozpozNoktow;
    }

    public void setRozpozNoktow(Boolean rozpozNoktow) {
        this.rozpozNoktow = rozpozNoktow;
    }

    public Double getRozpozNoktowPromien() {
        return rozpozNoktowPromien;
    }

    public void setRozpozNoktowPromien(Double rozpozNoktowPromien) {
        this.rozpozNoktowPromien = rozpozNoktowPromien;
    }

    public Boolean getRozpozRadar() {
        return rozpozRadar;
    }

    public void setRozpozRadar(Boolean rozpozRadar) {
        this.rozpozRadar = rozpozRadar;
    }

    public Double getRozpozRadarPromien() {
        return rozpozRadarPromien;
    }

    public void setRozpozRadarPromien(Double rozpozRadarPromien) {
        this.rozpozRadarPromien = rozpozRadarPromien;
    }

    public Integer getKlasaPrzyrzOc() {
        return klasaPrzyrzOc;
    }

    public void setKlasaPrzyrzOc(Integer klasaPrzyrzOc) {
        this.klasaPrzyrzOc = klasaPrzyrzOc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EfektorRozpozEntity that = (EfektorRozpozEntity) o;

        if (id != that.id) return false;
        if (rozpozAkust != null ? !rozpozAkust.equals(that.rozpozAkust) : that.rozpozAkust != null) return false;
        if (rozpozAkustPromien != null ? !rozpozAkustPromien.equals(that.rozpozAkustPromien) : that.rozpozAkustPromien != null)
            return false;
        if (rozpozTermicz != null ? !rozpozTermicz.equals(that.rozpozTermicz) : that.rozpozTermicz != null)
            return false;
        if (rozpozTermiczPromienDzien != null ? !rozpozTermiczPromienDzien.equals(that.rozpozTermiczPromienDzien) : that.rozpozTermiczPromienDzien != null)
            return false;
        if (rozpozTermiczPromienNoc != null ? !rozpozTermiczPromienNoc.equals(that.rozpozTermiczPromienNoc) : that.rozpozTermiczPromienNoc != null)
            return false;
        if (rozpozNoktow != null ? !rozpozNoktow.equals(that.rozpozNoktow) : that.rozpozNoktow != null) return false;
        if (rozpozNoktowPromien != null ? !rozpozNoktowPromien.equals(that.rozpozNoktowPromien) : that.rozpozNoktowPromien != null)
            return false;
        if (rozpozRadar != null ? !rozpozRadar.equals(that.rozpozRadar) : that.rozpozRadar != null) return false;
        if (rozpozRadarPromien != null ? !rozpozRadarPromien.equals(that.rozpozRadarPromien) : that.rozpozRadarPromien != null)
            return false;
        if (klasaPrzyrzOc != null ? !klasaPrzyrzOc.equals(that.klasaPrzyrzOc) : that.klasaPrzyrzOc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rozpozAkust != null ? rozpozAkust.hashCode() : 0);
        result = 31 * result + (rozpozAkustPromien != null ? rozpozAkustPromien.hashCode() : 0);
        result = 31 * result + (rozpozTermicz != null ? rozpozTermicz.hashCode() : 0);
        result = 31 * result + (rozpozTermiczPromienDzien != null ? rozpozTermiczPromienDzien.hashCode() : 0);
        result = 31 * result + (rozpozTermiczPromienNoc != null ? rozpozTermiczPromienNoc.hashCode() : 0);
        result = 31 * result + (rozpozNoktow != null ? rozpozNoktow.hashCode() : 0);
        result = 31 * result + (rozpozNoktowPromien != null ? rozpozNoktowPromien.hashCode() : 0);
        result = 31 * result + (rozpozRadar != null ? rozpozRadar.hashCode() : 0);
        result = 31 * result + (rozpozRadarPromien != null ? rozpozRadarPromien.hashCode() : 0);
        result = 31 * result + (klasaPrzyrzOc != null ? klasaPrzyrzOc.hashCode() : 0);
        return result;
    }
}
