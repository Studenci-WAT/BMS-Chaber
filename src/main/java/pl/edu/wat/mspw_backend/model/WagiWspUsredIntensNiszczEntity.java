package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wagi_wsp_usred_intens_niszcz", schema = "mspwTest", catalog = "")
public class WagiWspUsredIntensNiszczEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "TYP_KLIMATU_FK", nullable = true)
    private Integer typKlimatuFk;
    @Basic
    @Column(name = "TYP_OPERACJI_PKA_FK", nullable = true)
    private Integer typOperacjiPkaFk;
    @Basic
    @Column(name = "DZIEN", nullable = true)
    private Boolean dzien;
    @Basic
    @Column(name = "POZIOM_OPAD_ISTOTNY", nullable = true)
    private Boolean poziomOpadIstotny;
    @Basic
    @Column(name = "POZIOM_ZAMGL_ISTOTNY", nullable = true)
    private Boolean poziomZamglIstotny;
    @Basic
    @Column(name = "POZIOM_FORT_CELU", nullable = true)
    private Integer poziomFortCelu;
    @Basic
    @Column(name = "POZIOM_MASK_CELU_ISTOTNY", nullable = true)
    private Boolean poziomMaskCeluIstotny;
    @Basic
    @Column(name = "POZIOM_ZADYM_CELU_ISTOTNY", nullable = true)
    private Boolean poziomZadymCeluIstotny;
    @Basic
    @Column(name = "MOBIL_STRZEL_ISTOTNA", nullable = true)
    private Boolean mobilStrzelIstotna;
    @Basic
    @Column(name = "MOBIL_CELU_ISTOTNA", nullable = true)
    private Boolean mobilCeluIstotna;
    @Basic
    @Column(name = "POZIOM_ODDZIAL_OGN_PKA_FK", nullable = true)
    private Integer poziomOddzialOgnPkaFk;
    @Basic
    @Column(name = "WAGA", nullable = true, precision = 0)
    private Double waga;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTypKlimatuFk() {
        return typKlimatuFk;
    }

    public void setTypKlimatuFk(Integer typKlimatuFk) {
        this.typKlimatuFk = typKlimatuFk;
    }

    public Integer getTypOperacjiPkaFk() {
        return typOperacjiPkaFk;
    }

    public void setTypOperacjiPkaFk(Integer typOperacjiPkaFk) {
        this.typOperacjiPkaFk = typOperacjiPkaFk;
    }

    public Boolean getDzien() {
        return dzien;
    }

    public void setDzien(Boolean dzien) {
        this.dzien = dzien;
    }

    public Boolean getPoziomOpadIstotny() {
        return poziomOpadIstotny;
    }

    public void setPoziomOpadIstotny(Boolean poziomOpadIstotny) {
        this.poziomOpadIstotny = poziomOpadIstotny;
    }

    public Boolean getPoziomZamglIstotny() {
        return poziomZamglIstotny;
    }

    public void setPoziomZamglIstotny(Boolean poziomZamglIstotny) {
        this.poziomZamglIstotny = poziomZamglIstotny;
    }

    public Integer getPoziomFortCelu() {
        return poziomFortCelu;
    }

    public void setPoziomFortCelu(Integer poziomFortCelu) {
        this.poziomFortCelu = poziomFortCelu;
    }

    public Boolean getPoziomMaskCeluIstotny() {
        return poziomMaskCeluIstotny;
    }

    public void setPoziomMaskCeluIstotny(Boolean poziomMaskCeluIstotny) {
        this.poziomMaskCeluIstotny = poziomMaskCeluIstotny;
    }

    public Boolean getPoziomZadymCeluIstotny() {
        return poziomZadymCeluIstotny;
    }

    public void setPoziomZadymCeluIstotny(Boolean poziomZadymCeluIstotny) {
        this.poziomZadymCeluIstotny = poziomZadymCeluIstotny;
    }

    public Boolean getMobilStrzelIstotna() {
        return mobilStrzelIstotna;
    }

    public void setMobilStrzelIstotna(Boolean mobilStrzelIstotna) {
        this.mobilStrzelIstotna = mobilStrzelIstotna;
    }

    public Boolean getMobilCeluIstotna() {
        return mobilCeluIstotna;
    }

    public void setMobilCeluIstotna(Boolean mobilCeluIstotna) {
        this.mobilCeluIstotna = mobilCeluIstotna;
    }

    public Integer getPoziomOddzialOgnPkaFk() {
        return poziomOddzialOgnPkaFk;
    }

    public void setPoziomOddzialOgnPkaFk(Integer poziomOddzialOgnPkaFk) {
        this.poziomOddzialOgnPkaFk = poziomOddzialOgnPkaFk;
    }

    public Double getWaga() {
        return waga;
    }

    public void setWaga(Double waga) {
        this.waga = waga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WagiWspUsredIntensNiszczEntity that = (WagiWspUsredIntensNiszczEntity) o;

        if (id != that.id) return false;
        if (typKlimatuFk != null ? !typKlimatuFk.equals(that.typKlimatuFk) : that.typKlimatuFk != null) return false;
        if (typOperacjiPkaFk != null ? !typOperacjiPkaFk.equals(that.typOperacjiPkaFk) : that.typOperacjiPkaFk != null)
            return false;
        if (dzien != null ? !dzien.equals(that.dzien) : that.dzien != null) return false;
        if (poziomOpadIstotny != null ? !poziomOpadIstotny.equals(that.poziomOpadIstotny) : that.poziomOpadIstotny != null)
            return false;
        if (poziomZamglIstotny != null ? !poziomZamglIstotny.equals(that.poziomZamglIstotny) : that.poziomZamglIstotny != null)
            return false;
        if (poziomFortCelu != null ? !poziomFortCelu.equals(that.poziomFortCelu) : that.poziomFortCelu != null)
            return false;
        if (poziomMaskCeluIstotny != null ? !poziomMaskCeluIstotny.equals(that.poziomMaskCeluIstotny) : that.poziomMaskCeluIstotny != null)
            return false;
        if (poziomZadymCeluIstotny != null ? !poziomZadymCeluIstotny.equals(that.poziomZadymCeluIstotny) : that.poziomZadymCeluIstotny != null)
            return false;
        if (mobilStrzelIstotna != null ? !mobilStrzelIstotna.equals(that.mobilStrzelIstotna) : that.mobilStrzelIstotna != null)
            return false;
        if (mobilCeluIstotna != null ? !mobilCeluIstotna.equals(that.mobilCeluIstotna) : that.mobilCeluIstotna != null)
            return false;
        if (poziomOddzialOgnPkaFk != null ? !poziomOddzialOgnPkaFk.equals(that.poziomOddzialOgnPkaFk) : that.poziomOddzialOgnPkaFk != null)
            return false;
        if (waga != null ? !waga.equals(that.waga) : that.waga != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typKlimatuFk != null ? typKlimatuFk.hashCode() : 0);
        result = 31 * result + (typOperacjiPkaFk != null ? typOperacjiPkaFk.hashCode() : 0);
        result = 31 * result + (dzien != null ? dzien.hashCode() : 0);
        result = 31 * result + (poziomOpadIstotny != null ? poziomOpadIstotny.hashCode() : 0);
        result = 31 * result + (poziomZamglIstotny != null ? poziomZamglIstotny.hashCode() : 0);
        result = 31 * result + (poziomFortCelu != null ? poziomFortCelu.hashCode() : 0);
        result = 31 * result + (poziomMaskCeluIstotny != null ? poziomMaskCeluIstotny.hashCode() : 0);
        result = 31 * result + (poziomZadymCeluIstotny != null ? poziomZadymCeluIstotny.hashCode() : 0);
        result = 31 * result + (mobilStrzelIstotna != null ? mobilStrzelIstotna.hashCode() : 0);
        result = 31 * result + (mobilCeluIstotna != null ? mobilCeluIstotna.hashCode() : 0);
        result = 31 * result + (poziomOddzialOgnPkaFk != null ? poziomOddzialOgnPkaFk.hashCode() : 0);
        result = 31 * result + (waga != null ? waga.hashCode() : 0);
        return result;
    }
}
