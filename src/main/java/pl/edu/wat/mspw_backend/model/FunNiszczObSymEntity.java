package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fun_niszcz_ob_sym", schema = "mspwTest", catalog = "")
public class FunNiszczObSymEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "SPW_STRZEL_FK", nullable = true)
    private Integer spwStrzelFk;
    @Basic
    @Column(name = "SYS_OGN_FK", nullable = true)
    private Integer sysOgnFk;
    @Basic
    @Column(name = "AMO_FK", nullable = true)
    private Integer amoFk;
    @Basic
    @Column(name = "SPW_CEL_FK", nullable = true)
    private Integer spwCelFk;
    @Basic
    @Column(name = "MOBIL_STRZEL", nullable = true)
    private Integer mobilStrzel;
    @Basic
    @Column(name = "MOBIL_CELU", nullable = true)
    private Integer mobilCelu;
    @Basic
    @Column(name = "TYP_TERENU_WIDOCZ_FK", nullable = true)
    private Integer typTerenuWidoczFk;
    @Basic
    @Column(name = "TYP_KLIMATU_FK", nullable = true)
    private Integer typKlimatuFk;
    @Basic
    @Column(name = "POZIOM_ODDZIAL_OGN_PKA_FK", nullable = true)
    private Integer poziomOddzialOgnPkaFk;
    @Basic
    @Column(name = "POZIOM_FORT_CELU", nullable = true)
    private Integer poziomFortCelu;
    @Basic
    @Column(name = "POZIOM_WYSZK_STRZEL", nullable = true)
    private Integer poziomWyszkStrzel;
    @Basic
    @Column(name = "ODLEG", nullable = true, precision = 0)
    private Double odleg;
    @Basic
    @Column(name = "INTENS_NISZCZ", nullable = true, precision = 0)
    private Double intensNiszcz;
    @Basic
    @Column(name = "PSTWO_ZNISZCZ", nullable = true, precision = 0)
    private Double pstwoZniszcz;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSpwStrzelFk() {
        return spwStrzelFk;
    }

    public void setSpwStrzelFk(Integer spwStrzelFk) {
        this.spwStrzelFk = spwStrzelFk;
    }

    public Integer getSysOgnFk() {
        return sysOgnFk;
    }

    public void setSysOgnFk(Integer sysOgnFk) {
        this.sysOgnFk = sysOgnFk;
    }

    public Integer getAmoFk() {
        return amoFk;
    }

    public void setAmoFk(Integer amoFk) {
        this.amoFk = amoFk;
    }

    public Integer getSpwCelFk() {
        return spwCelFk;
    }

    public void setSpwCelFk(Integer spwCelFk) {
        this.spwCelFk = spwCelFk;
    }

    public Integer getMobilStrzel() {
        return mobilStrzel;
    }

    public void setMobilStrzel(Integer mobilStrzel) {
        this.mobilStrzel = mobilStrzel;
    }

    public Integer getMobilCelu() {
        return mobilCelu;
    }

    public void setMobilCelu(Integer mobilCelu) {
        this.mobilCelu = mobilCelu;
    }

    public Integer getTypTerenuWidoczFk() {
        return typTerenuWidoczFk;
    }

    public void setTypTerenuWidoczFk(Integer typTerenuWidoczFk) {
        this.typTerenuWidoczFk = typTerenuWidoczFk;
    }

    public Integer getTypKlimatuFk() {
        return typKlimatuFk;
    }

    public void setTypKlimatuFk(Integer typKlimatuFk) {
        this.typKlimatuFk = typKlimatuFk;
    }

    public Integer getPoziomOddzialOgnPkaFk() {
        return poziomOddzialOgnPkaFk;
    }

    public void setPoziomOddzialOgnPkaFk(Integer poziomOddzialOgnPkaFk) {
        this.poziomOddzialOgnPkaFk = poziomOddzialOgnPkaFk;
    }

    public Integer getPoziomFortCelu() {
        return poziomFortCelu;
    }

    public void setPoziomFortCelu(Integer poziomFortCelu) {
        this.poziomFortCelu = poziomFortCelu;
    }

    public Integer getPoziomWyszkStrzel() {
        return poziomWyszkStrzel;
    }

    public void setPoziomWyszkStrzel(Integer poziomWyszkStrzel) {
        this.poziomWyszkStrzel = poziomWyszkStrzel;
    }

    public Double getOdleg() {
        return odleg;
    }

    public void setOdleg(Double odleg) {
        this.odleg = odleg;
    }

    public Double getIntensNiszcz() {
        return intensNiszcz;
    }

    public void setIntensNiszcz(Double intensNiszcz) {
        this.intensNiszcz = intensNiszcz;
    }

    public Double getPstwoZniszcz() {
        return pstwoZniszcz;
    }

    public void setPstwoZniszcz(Double pstwoZniszcz) {
        this.pstwoZniszcz = pstwoZniszcz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunNiszczObSymEntity that = (FunNiszczObSymEntity) o;

        if (id != that.id) return false;
        if (spwStrzelFk != null ? !spwStrzelFk.equals(that.spwStrzelFk) : that.spwStrzelFk != null) return false;
        if (sysOgnFk != null ? !sysOgnFk.equals(that.sysOgnFk) : that.sysOgnFk != null) return false;
        if (amoFk != null ? !amoFk.equals(that.amoFk) : that.amoFk != null) return false;
        if (spwCelFk != null ? !spwCelFk.equals(that.spwCelFk) : that.spwCelFk != null) return false;
        if (mobilStrzel != null ? !mobilStrzel.equals(that.mobilStrzel) : that.mobilStrzel != null) return false;
        if (mobilCelu != null ? !mobilCelu.equals(that.mobilCelu) : that.mobilCelu != null) return false;
        if (typTerenuWidoczFk != null ? !typTerenuWidoczFk.equals(that.typTerenuWidoczFk) : that.typTerenuWidoczFk != null)
            return false;
        if (typKlimatuFk != null ? !typKlimatuFk.equals(that.typKlimatuFk) : that.typKlimatuFk != null) return false;
        if (poziomOddzialOgnPkaFk != null ? !poziomOddzialOgnPkaFk.equals(that.poziomOddzialOgnPkaFk) : that.poziomOddzialOgnPkaFk != null)
            return false;
        if (poziomFortCelu != null ? !poziomFortCelu.equals(that.poziomFortCelu) : that.poziomFortCelu != null)
            return false;
        if (poziomWyszkStrzel != null ? !poziomWyszkStrzel.equals(that.poziomWyszkStrzel) : that.poziomWyszkStrzel != null)
            return false;
        if (odleg != null ? !odleg.equals(that.odleg) : that.odleg != null) return false;
        if (intensNiszcz != null ? !intensNiszcz.equals(that.intensNiszcz) : that.intensNiszcz != null) return false;
        if (pstwoZniszcz != null ? !pstwoZniszcz.equals(that.pstwoZniszcz) : that.pstwoZniszcz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (spwStrzelFk != null ? spwStrzelFk.hashCode() : 0);
        result = 31 * result + (sysOgnFk != null ? sysOgnFk.hashCode() : 0);
        result = 31 * result + (amoFk != null ? amoFk.hashCode() : 0);
        result = 31 * result + (spwCelFk != null ? spwCelFk.hashCode() : 0);
        result = 31 * result + (mobilStrzel != null ? mobilStrzel.hashCode() : 0);
        result = 31 * result + (mobilCelu != null ? mobilCelu.hashCode() : 0);
        result = 31 * result + (typTerenuWidoczFk != null ? typTerenuWidoczFk.hashCode() : 0);
        result = 31 * result + (typKlimatuFk != null ? typKlimatuFk.hashCode() : 0);
        result = 31 * result + (poziomOddzialOgnPkaFk != null ? poziomOddzialOgnPkaFk.hashCode() : 0);
        result = 31 * result + (poziomFortCelu != null ? poziomFortCelu.hashCode() : 0);
        result = 31 * result + (poziomWyszkStrzel != null ? poziomWyszkStrzel.hashCode() : 0);
        result = 31 * result + (odleg != null ? odleg.hashCode() : 0);
        result = 31 * result + (intensNiszcz != null ? intensNiszcz.hashCode() : 0);
        result = 31 * result + (pstwoZniszcz != null ? pstwoZniszcz.hashCode() : 0);
        return result;
    }
}
