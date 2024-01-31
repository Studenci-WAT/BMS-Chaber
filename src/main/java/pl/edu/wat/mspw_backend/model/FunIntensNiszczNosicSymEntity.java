package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fun_intens_niszcz_nosic_sym", schema = "mspwTest", catalog = "")
public class FunIntensNiszczNosicSymEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "TYP_TERENU_WIDOCZ_FK", nullable = true)
    private Integer typTerenuWidoczFk;
    @Basic
    @Column(name = "TYP_KLIMATU_FK", nullable = true)
    private Integer typKlimatuFk;
    @Basic
    @Column(name = "TYP_OPERACJI_FK", nullable = true)
    private Integer typOperacjiFk;
    @Basic
    @Column(name = "INTENSYWNOSC", nullable = true, precision = 0)
    private Double intensywnosc;
    @Basic
    @Column(name = "ODLEG", nullable = true, precision = 0)
    private Double odleg;
    @Basic
    @Column(name = "CEL_OPANC", nullable = true)
    private Boolean celOpanc;
    @Basic
    @Column(name = "POZIOM_WYSZK", nullable = true)
    private Integer poziomWyszk;
    @Basic
    @Column(name = "POZIOM_ZDOLN_MANEWR", nullable = true)
    private Integer poziomZdolnManewr;
    @Basic
    @Column(name = "KATEG_STRZEL_FK", nullable = true)
    private Integer kategStrzelFk;
    @Basic
    @Column(name = "KATEG_CELU_FK", nullable = true)
    private Integer kategCeluFk;
    @Basic
    @Column(name = "KLASA_STRZEL", nullable = true)
    private Integer klasaStrzel;
    @Basic
    @Column(name = "KLASA_CELU", nullable = true)
    private Integer klasaCelu;
    @Basic
    @Column(name = "WSP_A", nullable = true, precision = 0)
    private Double wspA;
    @Basic
    @Column(name = "WSP_B", nullable = true, precision = 0)
    private Double wspB;
    @Basic
    @Column(name = "ZASIEG_MIN", nullable = true, precision = 0)
    private Double zasiegMin;
    @Basic
    @Column(name = "ZASIEG_MAX", nullable = true, precision = 0)
    private Double zasiegMax;
    @Basic
    @Column(name = "SPW_STRZEL_FK", nullable = true)
    private Integer spwStrzelFk;
    @Basic
    @Column(name = "SPW_CEL_FK", nullable = true)
    private Integer spwCelFk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getTypOperacjiFk() {
        return typOperacjiFk;
    }

    public void setTypOperacjiFk(Integer typOperacjiFk) {
        this.typOperacjiFk = typOperacjiFk;
    }

    public Double getIntensywnosc() {
        return intensywnosc;
    }

    public void setIntensywnosc(Double intensywnosc) {
        this.intensywnosc = intensywnosc;
    }

    public Double getOdleg() {
        return odleg;
    }

    public void setOdleg(Double odleg) {
        this.odleg = odleg;
    }

    public Boolean getCelOpanc() {
        return celOpanc;
    }

    public void setCelOpanc(Boolean celOpanc) {
        this.celOpanc = celOpanc;
    }

    public Integer getPoziomWyszk() {
        return poziomWyszk;
    }

    public void setPoziomWyszk(Integer poziomWyszk) {
        this.poziomWyszk = poziomWyszk;
    }

    public Integer getPoziomZdolnManewr() {
        return poziomZdolnManewr;
    }

    public void setPoziomZdolnManewr(Integer poziomZdolnManewr) {
        this.poziomZdolnManewr = poziomZdolnManewr;
    }

    public Integer getKategStrzelFk() {
        return kategStrzelFk;
    }

    public void setKategStrzelFk(Integer kategStrzelFk) {
        this.kategStrzelFk = kategStrzelFk;
    }

    public Integer getKategCeluFk() {
        return kategCeluFk;
    }

    public void setKategCeluFk(Integer kategCeluFk) {
        this.kategCeluFk = kategCeluFk;
    }

    public Integer getKlasaStrzel() {
        return klasaStrzel;
    }

    public void setKlasaStrzel(Integer klasaStrzel) {
        this.klasaStrzel = klasaStrzel;
    }

    public Integer getKlasaCelu() {
        return klasaCelu;
    }

    public void setKlasaCelu(Integer klasaCelu) {
        this.klasaCelu = klasaCelu;
    }

    public Double getWspA() {
        return wspA;
    }

    public void setWspA(Double wspA) {
        this.wspA = wspA;
    }

    public Double getWspB() {
        return wspB;
    }

    public void setWspB(Double wspB) {
        this.wspB = wspB;
    }

    public Double getZasiegMin() {
        return zasiegMin;
    }

    public void setZasiegMin(Double zasiegMin) {
        this.zasiegMin = zasiegMin;
    }

    public Double getZasiegMax() {
        return zasiegMax;
    }

    public void setZasiegMax(Double zasiegMax) {
        this.zasiegMax = zasiegMax;
    }

    public Integer getSpwStrzelFk() {
        return spwStrzelFk;
    }

    public void setSpwStrzelFk(Integer spwStrzelFk) {
        this.spwStrzelFk = spwStrzelFk;
    }

    public Integer getSpwCelFk() {
        return spwCelFk;
    }

    public void setSpwCelFk(Integer spwCelFk) {
        this.spwCelFk = spwCelFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunIntensNiszczNosicSymEntity that = (FunIntensNiszczNosicSymEntity) o;

        if (id != that.id) return false;
        if (typTerenuWidoczFk != null ? !typTerenuWidoczFk.equals(that.typTerenuWidoczFk) : that.typTerenuWidoczFk != null)
            return false;
        if (typKlimatuFk != null ? !typKlimatuFk.equals(that.typKlimatuFk) : that.typKlimatuFk != null) return false;
        if (typOperacjiFk != null ? !typOperacjiFk.equals(that.typOperacjiFk) : that.typOperacjiFk != null)
            return false;
        if (intensywnosc != null ? !intensywnosc.equals(that.intensywnosc) : that.intensywnosc != null) return false;
        if (odleg != null ? !odleg.equals(that.odleg) : that.odleg != null) return false;
        if (celOpanc != null ? !celOpanc.equals(that.celOpanc) : that.celOpanc != null) return false;
        if (poziomWyszk != null ? !poziomWyszk.equals(that.poziomWyszk) : that.poziomWyszk != null) return false;
        if (poziomZdolnManewr != null ? !poziomZdolnManewr.equals(that.poziomZdolnManewr) : that.poziomZdolnManewr != null)
            return false;
        if (kategStrzelFk != null ? !kategStrzelFk.equals(that.kategStrzelFk) : that.kategStrzelFk != null)
            return false;
        if (kategCeluFk != null ? !kategCeluFk.equals(that.kategCeluFk) : that.kategCeluFk != null) return false;
        if (klasaStrzel != null ? !klasaStrzel.equals(that.klasaStrzel) : that.klasaStrzel != null) return false;
        if (klasaCelu != null ? !klasaCelu.equals(that.klasaCelu) : that.klasaCelu != null) return false;
        if (wspA != null ? !wspA.equals(that.wspA) : that.wspA != null) return false;
        if (wspB != null ? !wspB.equals(that.wspB) : that.wspB != null) return false;
        if (zasiegMin != null ? !zasiegMin.equals(that.zasiegMin) : that.zasiegMin != null) return false;
        if (zasiegMax != null ? !zasiegMax.equals(that.zasiegMax) : that.zasiegMax != null) return false;
        if (spwStrzelFk != null ? !spwStrzelFk.equals(that.spwStrzelFk) : that.spwStrzelFk != null) return false;
        if (spwCelFk != null ? !spwCelFk.equals(that.spwCelFk) : that.spwCelFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typTerenuWidoczFk != null ? typTerenuWidoczFk.hashCode() : 0);
        result = 31 * result + (typKlimatuFk != null ? typKlimatuFk.hashCode() : 0);
        result = 31 * result + (typOperacjiFk != null ? typOperacjiFk.hashCode() : 0);
        result = 31 * result + (intensywnosc != null ? intensywnosc.hashCode() : 0);
        result = 31 * result + (odleg != null ? odleg.hashCode() : 0);
        result = 31 * result + (celOpanc != null ? celOpanc.hashCode() : 0);
        result = 31 * result + (poziomWyszk != null ? poziomWyszk.hashCode() : 0);
        result = 31 * result + (poziomZdolnManewr != null ? poziomZdolnManewr.hashCode() : 0);
        result = 31 * result + (kategStrzelFk != null ? kategStrzelFk.hashCode() : 0);
        result = 31 * result + (kategCeluFk != null ? kategCeluFk.hashCode() : 0);
        result = 31 * result + (klasaStrzel != null ? klasaStrzel.hashCode() : 0);
        result = 31 * result + (klasaCelu != null ? klasaCelu.hashCode() : 0);
        result = 31 * result + (wspA != null ? wspA.hashCode() : 0);
        result = 31 * result + (wspB != null ? wspB.hashCode() : 0);
        result = 31 * result + (zasiegMin != null ? zasiegMin.hashCode() : 0);
        result = 31 * result + (zasiegMax != null ? zasiegMax.hashCode() : 0);
        result = 31 * result + (spwStrzelFk != null ? spwStrzelFk.hashCode() : 0);
        result = 31 * result + (spwCelFk != null ? spwCelFk.hashCode() : 0);
        return result;
    }
}
