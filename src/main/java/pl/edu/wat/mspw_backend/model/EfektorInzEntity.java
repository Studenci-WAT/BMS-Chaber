package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "efektor_inz", schema = "mspwTest", catalog = "")
public class EfektorInzEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "DO_PRAC_ZIEMNYCH", nullable = true)
    private Boolean doPracZiemnych;
    @Basic
    @Column(name = "ELEMENT_PRZEPR_PROM", nullable = true)
    private Boolean elementPrzeprProm;
    @Basic
    @Column(name = "ELEMENT_PRZEPR_MOST", nullable = true)
    private Boolean elementPrzeprMost;
    @Basic
    @Column(name = "NOSNOSC", nullable = true, precision = 0)
    private Double nosnosc;
    @Basic
    @Column(name = "SZEROK_PRZEPRAWY", nullable = true, precision = 0)
    private Double szerokPrzeprawy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getDoPracZiemnych() {
        return doPracZiemnych;
    }

    public void setDoPracZiemnych(Boolean doPracZiemnych) {
        this.doPracZiemnych = doPracZiemnych;
    }

    public Boolean getElementPrzeprProm() {
        return elementPrzeprProm;
    }

    public void setElementPrzeprProm(Boolean elementPrzeprProm) {
        this.elementPrzeprProm = elementPrzeprProm;
    }

    public Boolean getElementPrzeprMost() {
        return elementPrzeprMost;
    }

    public void setElementPrzeprMost(Boolean elementPrzeprMost) {
        this.elementPrzeprMost = elementPrzeprMost;
    }

    public Double getNosnosc() {
        return nosnosc;
    }

    public void setNosnosc(Double nosnosc) {
        this.nosnosc = nosnosc;
    }

    public Double getSzerokPrzeprawy() {
        return szerokPrzeprawy;
    }

    public void setSzerokPrzeprawy(Double szerokPrzeprawy) {
        this.szerokPrzeprawy = szerokPrzeprawy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EfektorInzEntity that = (EfektorInzEntity) o;

        if (id != that.id) return false;
        if (doPracZiemnych != null ? !doPracZiemnych.equals(that.doPracZiemnych) : that.doPracZiemnych != null)
            return false;
        if (elementPrzeprProm != null ? !elementPrzeprProm.equals(that.elementPrzeprProm) : that.elementPrzeprProm != null)
            return false;
        if (elementPrzeprMost != null ? !elementPrzeprMost.equals(that.elementPrzeprMost) : that.elementPrzeprMost != null)
            return false;
        if (nosnosc != null ? !nosnosc.equals(that.nosnosc) : that.nosnosc != null) return false;
        if (szerokPrzeprawy != null ? !szerokPrzeprawy.equals(that.szerokPrzeprawy) : that.szerokPrzeprawy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (doPracZiemnych != null ? doPracZiemnych.hashCode() : 0);
        result = 31 * result + (elementPrzeprProm != null ? elementPrzeprProm.hashCode() : 0);
        result = 31 * result + (elementPrzeprMost != null ? elementPrzeprMost.hashCode() : 0);
        result = 31 * result + (nosnosc != null ? nosnosc.hashCode() : 0);
        result = 31 * result + (szerokPrzeprawy != null ? szerokPrzeprawy.hashCode() : 0);
        return result;
    }
}
