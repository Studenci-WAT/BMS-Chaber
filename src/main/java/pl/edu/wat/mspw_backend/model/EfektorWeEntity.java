package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "efektor_we", schema = "mspwTest", catalog = "")
public class EfektorWeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "NAMIERZ_PROMIEN", nullable = true)
    private Integer namierzPromien;
    @Basic
    @Column(name = "NAMIERZ_CZESTOTLMIN", nullable = true)
    private Integer namierzCzestotlmin;
    @Basic
    @Column(name = "NAMIERZ_CZESTOTL_MAX", nullable = true)
    private Integer namierzCzestotlMax;
    @Basic
    @Column(name = "NAMIERZ_CZAS", nullable = true)
    private Integer namierzCzas;
    @Basic
    @Column(name = "NAMIERZ_SZYBKOSC_PRZESZUK", nullable = true)
    private Integer namierzSzybkoscPrzeszuk;
    @Basic
    @Column(name = "ZAKLOC_PROMIEN", nullable = true)
    private Integer zaklocPromien;
    @Basic
    @Column(name = "ZAKLOC_CZESTOTL_MIN", nullable = true)
    private Integer zaklocCzestotlMin;
    @Basic
    @Column(name = "ZAKLOC_CZESTOTL_MAX", nullable = true)
    private Integer zaklocCzestotlMax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNamierzPromien() {
        return namierzPromien;
    }

    public void setNamierzPromien(Integer namierzPromien) {
        this.namierzPromien = namierzPromien;
    }

    public Integer getNamierzCzestotlmin() {
        return namierzCzestotlmin;
    }

    public void setNamierzCzestotlmin(Integer namierzCzestotlmin) {
        this.namierzCzestotlmin = namierzCzestotlmin;
    }

    public Integer getNamierzCzestotlMax() {
        return namierzCzestotlMax;
    }

    public void setNamierzCzestotlMax(Integer namierzCzestotlMax) {
        this.namierzCzestotlMax = namierzCzestotlMax;
    }

    public Integer getNamierzCzas() {
        return namierzCzas;
    }

    public void setNamierzCzas(Integer namierzCzas) {
        this.namierzCzas = namierzCzas;
    }

    public Integer getNamierzSzybkoscPrzeszuk() {
        return namierzSzybkoscPrzeszuk;
    }

    public void setNamierzSzybkoscPrzeszuk(Integer namierzSzybkoscPrzeszuk) {
        this.namierzSzybkoscPrzeszuk = namierzSzybkoscPrzeszuk;
    }

    public Integer getZaklocPromien() {
        return zaklocPromien;
    }

    public void setZaklocPromien(Integer zaklocPromien) {
        this.zaklocPromien = zaklocPromien;
    }

    public Integer getZaklocCzestotlMin() {
        return zaklocCzestotlMin;
    }

    public void setZaklocCzestotlMin(Integer zaklocCzestotlMin) {
        this.zaklocCzestotlMin = zaklocCzestotlMin;
    }

    public Integer getZaklocCzestotlMax() {
        return zaklocCzestotlMax;
    }

    public void setZaklocCzestotlMax(Integer zaklocCzestotlMax) {
        this.zaklocCzestotlMax = zaklocCzestotlMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EfektorWeEntity that = (EfektorWeEntity) o;

        if (id != that.id) return false;
        if (namierzPromien != null ? !namierzPromien.equals(that.namierzPromien) : that.namierzPromien != null)
            return false;
        if (namierzCzestotlmin != null ? !namierzCzestotlmin.equals(that.namierzCzestotlmin) : that.namierzCzestotlmin != null)
            return false;
        if (namierzCzestotlMax != null ? !namierzCzestotlMax.equals(that.namierzCzestotlMax) : that.namierzCzestotlMax != null)
            return false;
        if (namierzCzas != null ? !namierzCzas.equals(that.namierzCzas) : that.namierzCzas != null) return false;
        if (namierzSzybkoscPrzeszuk != null ? !namierzSzybkoscPrzeszuk.equals(that.namierzSzybkoscPrzeszuk) : that.namierzSzybkoscPrzeszuk != null)
            return false;
        if (zaklocPromien != null ? !zaklocPromien.equals(that.zaklocPromien) : that.zaklocPromien != null)
            return false;
        if (zaklocCzestotlMin != null ? !zaklocCzestotlMin.equals(that.zaklocCzestotlMin) : that.zaklocCzestotlMin != null)
            return false;
        if (zaklocCzestotlMax != null ? !zaklocCzestotlMax.equals(that.zaklocCzestotlMax) : that.zaklocCzestotlMax != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (namierzPromien != null ? namierzPromien.hashCode() : 0);
        result = 31 * result + (namierzCzestotlmin != null ? namierzCzestotlmin.hashCode() : 0);
        result = 31 * result + (namierzCzestotlMax != null ? namierzCzestotlMax.hashCode() : 0);
        result = 31 * result + (namierzCzas != null ? namierzCzas.hashCode() : 0);
        result = 31 * result + (namierzSzybkoscPrzeszuk != null ? namierzSzybkoscPrzeszuk.hashCode() : 0);
        result = 31 * result + (zaklocPromien != null ? zaklocPromien.hashCode() : 0);
        result = 31 * result + (zaklocCzestotlMin != null ? zaklocCzestotlMin.hashCode() : 0);
        result = 31 * result + (zaklocCzestotlMax != null ? zaklocCzestotlMax.hashCode() : 0);
        return result;
    }
}
