package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fun_wsp_widocz_dla_strzel", schema = "mspwTest", catalog = "")
public class FunWspWidoczDlaStrzelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "TYP_PRZYRZADOW_OC_FK", nullable = true)
    private Integer typPrzyrzadowOcFk;
    @Basic
    @Column(name = "WSP", nullable = true, precision = 0)
    private Double wsp;
    @Basic
    @Column(name = "POZIOM_ZADYM_ISTOTNY", nullable = true)
    private Boolean poziomZadymIstotny;
    @Basic
    @Column(name = "POZIOM_ZAMGL_ISTOTNY", nullable = true)
    private Boolean poziomZamglIstotny;
    @Basic
    @Column(name = "POZIOM_OPAD_ISTOTNY", nullable = true)
    private Boolean poziomOpadIstotny;
    @Basic
    @Column(name = "POZIOM_MASK_ISTOTNY", nullable = true)
    private Boolean poziomMaskIstotny;
    @Basic
    @Column(name = "DZIEN", nullable = true)
    private Boolean dzien;
    @Basic
    @Column(name = "POZIOM_WYSZK", nullable = true)
    private Integer poziomWyszk;
    @Basic
    @Column(name = "POZIOM_FORT", nullable = true)
    private Integer poziomFort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTypPrzyrzadowOcFk() {
        return typPrzyrzadowOcFk;
    }

    public void setTypPrzyrzadowOcFk(Integer typPrzyrzadowOcFk) {
        this.typPrzyrzadowOcFk = typPrzyrzadowOcFk;
    }

    public Double getWsp() {
        return wsp;
    }

    public void setWsp(Double wsp) {
        this.wsp = wsp;
    }

    public Boolean getPoziomZadymIstotny() {
        return poziomZadymIstotny;
    }

    public void setPoziomZadymIstotny(Boolean poziomZadymIstotny) {
        this.poziomZadymIstotny = poziomZadymIstotny;
    }

    public Boolean getPoziomZamglIstotny() {
        return poziomZamglIstotny;
    }

    public void setPoziomZamglIstotny(Boolean poziomZamglIstotny) {
        this.poziomZamglIstotny = poziomZamglIstotny;
    }

    public Boolean getPoziomOpadIstotny() {
        return poziomOpadIstotny;
    }

    public void setPoziomOpadIstotny(Boolean poziomOpadIstotny) {
        this.poziomOpadIstotny = poziomOpadIstotny;
    }

    public Boolean getPoziomMaskIstotny() {
        return poziomMaskIstotny;
    }

    public void setPoziomMaskIstotny(Boolean poziomMaskIstotny) {
        this.poziomMaskIstotny = poziomMaskIstotny;
    }

    public Boolean getDzien() {
        return dzien;
    }

    public void setDzien(Boolean dzien) {
        this.dzien = dzien;
    }

    public Integer getPoziomWyszk() {
        return poziomWyszk;
    }

    public void setPoziomWyszk(Integer poziomWyszk) {
        this.poziomWyszk = poziomWyszk;
    }

    public Integer getPoziomFort() {
        return poziomFort;
    }

    public void setPoziomFort(Integer poziomFort) {
        this.poziomFort = poziomFort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunWspWidoczDlaStrzelEntity that = (FunWspWidoczDlaStrzelEntity) o;

        if (id != that.id) return false;
        if (typPrzyrzadowOcFk != null ? !typPrzyrzadowOcFk.equals(that.typPrzyrzadowOcFk) : that.typPrzyrzadowOcFk != null)
            return false;
        if (wsp != null ? !wsp.equals(that.wsp) : that.wsp != null) return false;
        if (poziomZadymIstotny != null ? !poziomZadymIstotny.equals(that.poziomZadymIstotny) : that.poziomZadymIstotny != null)
            return false;
        if (poziomZamglIstotny != null ? !poziomZamglIstotny.equals(that.poziomZamglIstotny) : that.poziomZamglIstotny != null)
            return false;
        if (poziomOpadIstotny != null ? !poziomOpadIstotny.equals(that.poziomOpadIstotny) : that.poziomOpadIstotny != null)
            return false;
        if (poziomMaskIstotny != null ? !poziomMaskIstotny.equals(that.poziomMaskIstotny) : that.poziomMaskIstotny != null)
            return false;
        if (dzien != null ? !dzien.equals(that.dzien) : that.dzien != null) return false;
        if (poziomWyszk != null ? !poziomWyszk.equals(that.poziomWyszk) : that.poziomWyszk != null) return false;
        if (poziomFort != null ? !poziomFort.equals(that.poziomFort) : that.poziomFort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typPrzyrzadowOcFk != null ? typPrzyrzadowOcFk.hashCode() : 0);
        result = 31 * result + (wsp != null ? wsp.hashCode() : 0);
        result = 31 * result + (poziomZadymIstotny != null ? poziomZadymIstotny.hashCode() : 0);
        result = 31 * result + (poziomZamglIstotny != null ? poziomZamglIstotny.hashCode() : 0);
        result = 31 * result + (poziomOpadIstotny != null ? poziomOpadIstotny.hashCode() : 0);
        result = 31 * result + (poziomMaskIstotny != null ? poziomMaskIstotny.hashCode() : 0);
        result = 31 * result + (dzien != null ? dzien.hashCode() : 0);
        result = 31 * result + (poziomWyszk != null ? poziomWyszk.hashCode() : 0);
        result = 31 * result + (poziomFort != null ? poziomFort.hashCode() : 0);
        return result;
    }
}
