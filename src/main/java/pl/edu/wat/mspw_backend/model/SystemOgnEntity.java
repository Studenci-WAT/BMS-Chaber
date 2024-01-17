package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "system_ogn", schema = "mspwTest", catalog = "")
public class SystemOgnEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "NAZWA", nullable = true, length = 50)
    private String nazwa;
    @Basic
    @Column(name = "SKROT", nullable = true, length = 25)
    private String skrot;
    @Basic
    @Column(name = "SZYBKOSTRZELNOSC", nullable = true, precision = 0)
    private Double szybkostrzelnosc;
    @Basic
    @Column(name = "KALIBER", nullable = true, precision = 0)
    private Double kaliber;
    @Basic
    @Column(name = "DLUG_SERII", nullable = true)
    private Integer dlugSerii;
    @Basic
    @Column(name = "CZAS_CELOWANIA", nullable = true, precision = 0)
    private Double czasCelowania;
    @Basic
    @Column(name = "LICZBA_KAN_CEL", nullable = true)
    private Integer liczbaKanCel;
    @Basic
    @Column(name = "RODZAJ_SYSTEMU_OGN_FK", nullable = true)
    private Integer rodzajSystemuOgnFk;
    @Basic
    @Column(name = "KLASA_PRZYRZ_OC", nullable = true)
    private Integer klasaPrzyrzOc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getSkrot() {
        return skrot;
    }

    public void setSkrot(String skrot) {
        this.skrot = skrot;
    }

    public Double getSzybkostrzelnosc() {
        return szybkostrzelnosc;
    }

    public void setSzybkostrzelnosc(Double szybkostrzelnosc) {
        this.szybkostrzelnosc = szybkostrzelnosc;
    }

    public Double getKaliber() {
        return kaliber;
    }

    public void setKaliber(Double kaliber) {
        this.kaliber = kaliber;
    }

    public Integer getDlugSerii() {
        return dlugSerii;
    }

    public void setDlugSerii(Integer dlugSerii) {
        this.dlugSerii = dlugSerii;
    }

    public Double getCzasCelowania() {
        return czasCelowania;
    }

    public void setCzasCelowania(Double czasCelowania) {
        this.czasCelowania = czasCelowania;
    }

    public Integer getLiczbaKanCel() {
        return liczbaKanCel;
    }

    public void setLiczbaKanCel(Integer liczbaKanCel) {
        this.liczbaKanCel = liczbaKanCel;
    }

    public Integer getRodzajSystemuOgnFk() {
        return rodzajSystemuOgnFk;
    }

    public void setRodzajSystemuOgnFk(Integer rodzajSystemuOgnFk) {
        this.rodzajSystemuOgnFk = rodzajSystemuOgnFk;
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

        SystemOgnEntity that = (SystemOgnEntity) o;

        if (id != that.id) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;
        if (skrot != null ? !skrot.equals(that.skrot) : that.skrot != null) return false;
        if (szybkostrzelnosc != null ? !szybkostrzelnosc.equals(that.szybkostrzelnosc) : that.szybkostrzelnosc != null)
            return false;
        if (kaliber != null ? !kaliber.equals(that.kaliber) : that.kaliber != null) return false;
        if (dlugSerii != null ? !dlugSerii.equals(that.dlugSerii) : that.dlugSerii != null) return false;
        if (czasCelowania != null ? !czasCelowania.equals(that.czasCelowania) : that.czasCelowania != null)
            return false;
        if (liczbaKanCel != null ? !liczbaKanCel.equals(that.liczbaKanCel) : that.liczbaKanCel != null) return false;
        if (rodzajSystemuOgnFk != null ? !rodzajSystemuOgnFk.equals(that.rodzajSystemuOgnFk) : that.rodzajSystemuOgnFk != null)
            return false;
        if (klasaPrzyrzOc != null ? !klasaPrzyrzOc.equals(that.klasaPrzyrzOc) : that.klasaPrzyrzOc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (skrot != null ? skrot.hashCode() : 0);
        result = 31 * result + (szybkostrzelnosc != null ? szybkostrzelnosc.hashCode() : 0);
        result = 31 * result + (kaliber != null ? kaliber.hashCode() : 0);
        result = 31 * result + (dlugSerii != null ? dlugSerii.hashCode() : 0);
        result = 31 * result + (czasCelowania != null ? czasCelowania.hashCode() : 0);
        result = 31 * result + (liczbaKanCel != null ? liczbaKanCel.hashCode() : 0);
        result = 31 * result + (rodzajSystemuOgnFk != null ? rodzajSystemuOgnFk.hashCode() : 0);
        result = 31 * result + (klasaPrzyrzOc != null ? klasaPrzyrzOc.hashCode() : 0);
        return result;
    }
}
