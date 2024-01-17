package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fun_wsp_mobil_dla_wykr", schema = "mspwTest", catalog = "")
public class FunWspMobilDlaWykrEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "WSP", nullable = true, precision = 0)
    private Double wsp;
    @Basic
    @Column(name = "MOBIL_CELU_ISTOTNA", nullable = true)
    private Boolean mobilCeluIstotna;
    @Basic
    @Column(name = "MOBIL_STRZEL_ISTOTNA", nullable = true)
    private Boolean mobilStrzelIstotna;
    @Basic
    @Column(name = "POZIOM_WYSZK", nullable = true)
    private Integer poziomWyszk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getWsp() {
        return wsp;
    }

    public void setWsp(Double wsp) {
        this.wsp = wsp;
    }

    public Boolean getMobilCeluIstotna() {
        return mobilCeluIstotna;
    }

    public void setMobilCeluIstotna(Boolean mobilCeluIstotna) {
        this.mobilCeluIstotna = mobilCeluIstotna;
    }

    public Boolean getMobilStrzelIstotna() {
        return mobilStrzelIstotna;
    }

    public void setMobilStrzelIstotna(Boolean mobilStrzelIstotna) {
        this.mobilStrzelIstotna = mobilStrzelIstotna;
    }

    public Integer getPoziomWyszk() {
        return poziomWyszk;
    }

    public void setPoziomWyszk(Integer poziomWyszk) {
        this.poziomWyszk = poziomWyszk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunWspMobilDlaWykrEntity that = (FunWspMobilDlaWykrEntity) o;

        if (id != that.id) return false;
        if (wsp != null ? !wsp.equals(that.wsp) : that.wsp != null) return false;
        if (mobilCeluIstotna != null ? !mobilCeluIstotna.equals(that.mobilCeluIstotna) : that.mobilCeluIstotna != null)
            return false;
        if (mobilStrzelIstotna != null ? !mobilStrzelIstotna.equals(that.mobilStrzelIstotna) : that.mobilStrzelIstotna != null)
            return false;
        if (poziomWyszk != null ? !poziomWyszk.equals(that.poziomWyszk) : that.poziomWyszk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wsp != null ? wsp.hashCode() : 0);
        result = 31 * result + (mobilCeluIstotna != null ? mobilCeluIstotna.hashCode() : 0);
        result = 31 * result + (mobilStrzelIstotna != null ? mobilStrzelIstotna.hashCode() : 0);
        result = 31 * result + (poziomWyszk != null ? poziomWyszk.hashCode() : 0);
        return result;
    }
}
