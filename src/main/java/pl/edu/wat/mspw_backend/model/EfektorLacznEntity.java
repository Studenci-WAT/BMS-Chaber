package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "efektor_laczn", schema = "mspwTest", catalog = "")
public class EfektorLacznEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "LICZBA_TRAKTOW_KABL", nullable = true)
    private Integer liczbaTraktowKabl;
    @Basic
    @Column(name = "LICZBA_TRAKTOW_RADIOL", nullable = true)
    private Integer liczbaTraktowRadiol;
    @Basic
    @Column(name = "LICZBA_SIECI_CNR_DO_PRZYLACZ", nullable = true)
    private Integer liczbaSieciCnrDoPrzylacz;
    @Basic
    @Column(name = "MOC_NADAJNIKA_RADIOL", nullable = true, precision = 0)
    private Double mocNadajnikaRadiol;
    @Basic
    @Column(name = "WYSOK_ANTENY_RADIOL", nullable = true, precision = 0)
    private Double wysokAntenyRadiol;
    @Basic
    @Column(name = "MOC_NADAJNIKA", nullable = true, precision = 0)
    private Double mocNadajnika;
    @Basic
    @Column(name = "ZASIEG_NADAJNIKA", nullable = true, precision = 0)
    private Double zasiegNadajnika;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getLiczbaTraktowKabl() {
        return liczbaTraktowKabl;
    }

    public void setLiczbaTraktowKabl(Integer liczbaTraktowKabl) {
        this.liczbaTraktowKabl = liczbaTraktowKabl;
    }

    public Integer getLiczbaTraktowRadiol() {
        return liczbaTraktowRadiol;
    }

    public void setLiczbaTraktowRadiol(Integer liczbaTraktowRadiol) {
        this.liczbaTraktowRadiol = liczbaTraktowRadiol;
    }

    public Integer getLiczbaSieciCnrDoPrzylacz() {
        return liczbaSieciCnrDoPrzylacz;
    }

    public void setLiczbaSieciCnrDoPrzylacz(Integer liczbaSieciCnrDoPrzylacz) {
        this.liczbaSieciCnrDoPrzylacz = liczbaSieciCnrDoPrzylacz;
    }

    public Double getMocNadajnikaRadiol() {
        return mocNadajnikaRadiol;
    }

    public void setMocNadajnikaRadiol(Double mocNadajnikaRadiol) {
        this.mocNadajnikaRadiol = mocNadajnikaRadiol;
    }

    public Double getWysokAntenyRadiol() {
        return wysokAntenyRadiol;
    }

    public void setWysokAntenyRadiol(Double wysokAntenyRadiol) {
        this.wysokAntenyRadiol = wysokAntenyRadiol;
    }

    public Double getMocNadajnika() {
        return mocNadajnika;
    }

    public void setMocNadajnika(Double mocNadajnika) {
        this.mocNadajnika = mocNadajnika;
    }

    public Double getZasiegNadajnika() {
        return zasiegNadajnika;
    }

    public void setZasiegNadajnika(Double zasiegNadajnika) {
        this.zasiegNadajnika = zasiegNadajnika;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EfektorLacznEntity that = (EfektorLacznEntity) o;

        if (id != that.id) return false;
        if (liczbaTraktowKabl != null ? !liczbaTraktowKabl.equals(that.liczbaTraktowKabl) : that.liczbaTraktowKabl != null)
            return false;
        if (liczbaTraktowRadiol != null ? !liczbaTraktowRadiol.equals(that.liczbaTraktowRadiol) : that.liczbaTraktowRadiol != null)
            return false;
        if (liczbaSieciCnrDoPrzylacz != null ? !liczbaSieciCnrDoPrzylacz.equals(that.liczbaSieciCnrDoPrzylacz) : that.liczbaSieciCnrDoPrzylacz != null)
            return false;
        if (mocNadajnikaRadiol != null ? !mocNadajnikaRadiol.equals(that.mocNadajnikaRadiol) : that.mocNadajnikaRadiol != null)
            return false;
        if (wysokAntenyRadiol != null ? !wysokAntenyRadiol.equals(that.wysokAntenyRadiol) : that.wysokAntenyRadiol != null)
            return false;
        if (mocNadajnika != null ? !mocNadajnika.equals(that.mocNadajnika) : that.mocNadajnika != null) return false;
        if (zasiegNadajnika != null ? !zasiegNadajnika.equals(that.zasiegNadajnika) : that.zasiegNadajnika != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (liczbaTraktowKabl != null ? liczbaTraktowKabl.hashCode() : 0);
        result = 31 * result + (liczbaTraktowRadiol != null ? liczbaTraktowRadiol.hashCode() : 0);
        result = 31 * result + (liczbaSieciCnrDoPrzylacz != null ? liczbaSieciCnrDoPrzylacz.hashCode() : 0);
        result = 31 * result + (mocNadajnikaRadiol != null ? mocNadajnikaRadiol.hashCode() : 0);
        result = 31 * result + (wysokAntenyRadiol != null ? wysokAntenyRadiol.hashCode() : 0);
        result = 31 * result + (mocNadajnika != null ? mocNadajnika.hashCode() : 0);
        result = 31 * result + (zasiegNadajnika != null ? zasiegNadajnika.hashCode() : 0);
        return result;
    }
}
