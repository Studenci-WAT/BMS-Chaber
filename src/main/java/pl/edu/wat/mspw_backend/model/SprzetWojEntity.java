package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sprzet_woj", schema = "mspwTest", catalog = "")
public class SprzetWojEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "NAZWA", nullable = true, length = 50)
    private String nazwa;
    @Basic
    @Column(name = "SKROT", nullable = true, length = 20)
    private String skrot;
    @Basic
    @Column(name = "KOD", nullable = true, length = 30)
    private String kod;
    @Basic
    @Column(name = "KATEGORIA_FK", nullable = true)
    private Integer kategoriaFk;
    @Basic
    @Column(name = "KLASA", nullable = true)
    private Integer klasa;
    @Basic
    @Column(name = "OBSLUGA", nullable = true)
    private Integer obsluga;
    @Basic
    @Column(name = "OPANCERZONY", nullable = true)
    private Boolean opancerzony;
    @Basic
    @Column(name = "KOSZT_JEDN_CYKLU_ZYCIA", nullable = true, precision = 0)
    private Double kosztJednCykluZycia;
    @Basic
    @Column(name = "KOSZT_JEDN_NABYCIA", nullable = true, precision = 0)
    private Double kosztJednNabycia;
    @Basic
    @Column(name = "KOSZT_JEDN_UTRZYM_WYSZK_PERSON", nullable = true, precision = 0)
    private Double kosztJednUtrzymWyszkPerson;
    @Basic
    @Column(name = "MASA", nullable = true, precision = 0)
    private Double masa;
    @Basic
    @Column(name = "DLUG", nullable = true, precision = 0)
    private Double dlug;
    @Basic
    @Column(name = "SZEROK", nullable = true, precision = 0)
    private Double szerok;
    @Basic
    @Column(name = "WYSOK", nullable = true, precision = 0)
    private Double wysok;
    @Basic
    @Column(name = "POTENCJAL_BOJ", nullable = true, precision = 0)
    private Double potencjalBoj;
    @Basic
    @Column(name = "VALUE", nullable = true, precision = 0)
    private Double value;
    @Basic
    @Column(name = "POJEM_ZBIOR_PALIWA", nullable = true, precision = 0)
    private Double pojemZbiorPaliwa;
    @Basic
    @Column(name = "POJEM_ZBIOR_PALIWA_DODAT", nullable = true, precision = 0)
    private Double pojemZbiorPaliwaDodat;
    @Basic
    @Column(name = "POJEM_AKUMULATOROW", nullable = true, precision = 0)
    private Double pojemAkumulatorow;
    @Basic
    @Column(name = "JEZDZACY", nullable = true)
    private Boolean jezdzacy;
    @Basic
    @Column(name = "LATAJACY", nullable = true)
    private Boolean latajacy;
    @Basic
    @Column(name = "PLYWAJACY", nullable = true)
    private Boolean plywajacy;
    @Basic
    @Column(name = "PRZENOSNY", nullable = true)
    private Boolean przenosny;
    @Basic
    @Column(name = "CIAGNIONY", nullable = true)
    private Boolean ciagniony;
    @Basic
    @Column(name = "EFEKTOR_LACZN_FK", nullable = true)
    private Integer efektorLacznFk;
    @Basic
    @Column(name = "RODZAJ_SRODOW_FK", nullable = true)
    private Integer rodzajSrodowFk;
    @Basic
    @Column(name = "EFEKTOR_JEZDNY_FK", nullable = true)
    private Integer efektorJezdnyFk;
    @Basic
    @Column(name = "EFEKTOR_PLYWANIA_FK", nullable = true)
    private Integer efektorPlywaniaFk;
    @Basic
    @Column(name = "EFEKTOR_INZ_FK", nullable = true)
    private Integer efektorInzFk;
    @Basic
    @Column(name = "EFEKTOR_WE_FK", nullable = true)
    private Integer efektorWeFk;
    @Basic
    @Column(name = "PARAM_KADLUBA_FK", nullable = true)
    private Integer paramKadlubaFk;
    @Basic
    @Column(name = "EFEKTOR_TRANSP_FK", nullable = true)
    private Integer efektorTranspFk;
    @Basic
    @Column(name = "EFEKTOR_LATANIA_FK", nullable = true)
    private Integer efektorLataniaFk;
    @Basic
    @Column(name = "EFEKTOR_ROZPOZ_FK", nullable = true)
    private Integer efektorRozpozFk;
    @Basic
    @Column(name = "KLASA_PRZYRZ_OC", nullable = true)
    private Integer klasaPrzyrzOc;
    @Basic
    @Column(name = "MOC", nullable = true, precision = 0)
    private Double moc;
    @Basic
    @Column(name = "ZUZYCIE_PALIWA_PRACA", nullable = true, precision = 0)
    private Double zuzyciePaliwaPraca;

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

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Integer getKategoriaFk() {
        return kategoriaFk;
    }

    public void setKategoriaFk(Integer kategoriaFk) {
        this.kategoriaFk = kategoriaFk;
    }

    public Integer getKlasa() {
        return klasa;
    }

    public void setKlasa(Integer klasa) {
        this.klasa = klasa;
    }

    public Integer getObsluga() {
        return obsluga;
    }

    public void setObsluga(Integer obsluga) {
        this.obsluga = obsluga;
    }

    public Boolean getOpancerzony() {
        return opancerzony;
    }

    public void setOpancerzony(Boolean opancerzony) {
        this.opancerzony = opancerzony;
    }

    public Double getKosztJednCykluZycia() {
        return kosztJednCykluZycia;
    }

    public void setKosztJednCykluZycia(Double kosztJednCykluZycia) {
        this.kosztJednCykluZycia = kosztJednCykluZycia;
    }

    public Double getKosztJednNabycia() {
        return kosztJednNabycia;
    }

    public void setKosztJednNabycia(Double kosztJednNabycia) {
        this.kosztJednNabycia = kosztJednNabycia;
    }

    public Double getKosztJednUtrzymWyszkPerson() {
        return kosztJednUtrzymWyszkPerson;
    }

    public void setKosztJednUtrzymWyszkPerson(Double kosztJednUtrzymWyszkPerson) {
        this.kosztJednUtrzymWyszkPerson = kosztJednUtrzymWyszkPerson;
    }

    public Double getMasa() {
        return masa;
    }

    public void setMasa(Double masa) {
        this.masa = masa;
    }

    public Double getDlug() {
        return dlug;
    }

    public void setDlug(Double dlug) {
        this.dlug = dlug;
    }

    public Double getSzerok() {
        return szerok;
    }

    public void setSzerok(Double szerok) {
        this.szerok = szerok;
    }

    public Double getWysok() {
        return wysok;
    }

    public void setWysok(Double wysok) {
        this.wysok = wysok;
    }

    public Double getPotencjalBoj() {
        return potencjalBoj;
    }

    public void setPotencjalBoj(Double potencjalBoj) {
        this.potencjalBoj = potencjalBoj;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getPojemZbiorPaliwa() {
        return pojemZbiorPaliwa;
    }

    public void setPojemZbiorPaliwa(Double pojemZbiorPaliwa) {
        this.pojemZbiorPaliwa = pojemZbiorPaliwa;
    }

    public Double getPojemZbiorPaliwaDodat() {
        return pojemZbiorPaliwaDodat;
    }

    public void setPojemZbiorPaliwaDodat(Double pojemZbiorPaliwaDodat) {
        this.pojemZbiorPaliwaDodat = pojemZbiorPaliwaDodat;
    }

    public Double getPojemAkumulatorow() {
        return pojemAkumulatorow;
    }

    public void setPojemAkumulatorow(Double pojemAkumulatorow) {
        this.pojemAkumulatorow = pojemAkumulatorow;
    }

    public Boolean getJezdzacy() {
        return jezdzacy;
    }

    public void setJezdzacy(Boolean jezdzacy) {
        this.jezdzacy = jezdzacy;
    }

    public Boolean getLatajacy() {
        return latajacy;
    }

    public void setLatajacy(Boolean latajacy) {
        this.latajacy = latajacy;
    }

    public Boolean getPlywajacy() {
        return plywajacy;
    }

    public void setPlywajacy(Boolean plywajacy) {
        this.plywajacy = plywajacy;
    }

    public Boolean getPrzenosny() {
        return przenosny;
    }

    public void setPrzenosny(Boolean przenosny) {
        this.przenosny = przenosny;
    }

    public Boolean getCiagniony() {
        return ciagniony;
    }

    public void setCiagniony(Boolean ciagniony) {
        this.ciagniony = ciagniony;
    }

    public Integer getEfektorLacznFk() {
        return efektorLacznFk;
    }

    public void setEfektorLacznFk(Integer efektorLacznFk) {
        this.efektorLacznFk = efektorLacznFk;
    }

    public Integer getRodzajSrodowFk() {
        return rodzajSrodowFk;
    }

    public void setRodzajSrodowFk(Integer rodzajSrodowFk) {
        this.rodzajSrodowFk = rodzajSrodowFk;
    }

    public Integer getEfektorJezdnyFk() {
        return efektorJezdnyFk;
    }

    public void setEfektorJezdnyFk(Integer efektorJezdnyFk) {
        this.efektorJezdnyFk = efektorJezdnyFk;
    }

    public Integer getEfektorPlywaniaFk() {
        return efektorPlywaniaFk;
    }

    public void setEfektorPlywaniaFk(Integer efektorPlywaniaFk) {
        this.efektorPlywaniaFk = efektorPlywaniaFk;
    }

    public Integer getEfektorInzFk() {
        return efektorInzFk;
    }

    public void setEfektorInzFk(Integer efektorInzFk) {
        this.efektorInzFk = efektorInzFk;
    }

    public Integer getEfektorWeFk() {
        return efektorWeFk;
    }

    public void setEfektorWeFk(Integer efektorWeFk) {
        this.efektorWeFk = efektorWeFk;
    }

    public Integer getParamKadlubaFk() {
        return paramKadlubaFk;
    }

    public void setParamKadlubaFk(Integer paramKadlubaFk) {
        this.paramKadlubaFk = paramKadlubaFk;
    }

    public Integer getEfektorTranspFk() {
        return efektorTranspFk;
    }

    public void setEfektorTranspFk(Integer efektorTranspFk) {
        this.efektorTranspFk = efektorTranspFk;
    }

    public Integer getEfektorLataniaFk() {
        return efektorLataniaFk;
    }

    public void setEfektorLataniaFk(Integer efektorLataniaFk) {
        this.efektorLataniaFk = efektorLataniaFk;
    }

    public Integer getEfektorRozpozFk() {
        return efektorRozpozFk;
    }

    public void setEfektorRozpozFk(Integer efektorRozpozFk) {
        this.efektorRozpozFk = efektorRozpozFk;
    }

    public Integer getKlasaPrzyrzOc() {
        return klasaPrzyrzOc;
    }

    public void setKlasaPrzyrzOc(Integer klasaPrzyrzOc) {
        this.klasaPrzyrzOc = klasaPrzyrzOc;
    }

    public Double getMoc() {
        return moc;
    }

    public void setMoc(Double moc) {
        this.moc = moc;
    }

    public Double getZuzyciePaliwaPraca() {
        return zuzyciePaliwaPraca;
    }

    public void setZuzyciePaliwaPraca(Double zuzyciePaliwaPraca) {
        this.zuzyciePaliwaPraca = zuzyciePaliwaPraca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SprzetWojEntity that = (SprzetWojEntity) o;

        if (id != that.id) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;
        if (skrot != null ? !skrot.equals(that.skrot) : that.skrot != null) return false;
        if (kod != null ? !kod.equals(that.kod) : that.kod != null) return false;
        if (kategoriaFk != null ? !kategoriaFk.equals(that.kategoriaFk) : that.kategoriaFk != null) return false;
        if (klasa != null ? !klasa.equals(that.klasa) : that.klasa != null) return false;
        if (obsluga != null ? !obsluga.equals(that.obsluga) : that.obsluga != null) return false;
        if (opancerzony != null ? !opancerzony.equals(that.opancerzony) : that.opancerzony != null) return false;
        if (kosztJednCykluZycia != null ? !kosztJednCykluZycia.equals(that.kosztJednCykluZycia) : that.kosztJednCykluZycia != null)
            return false;
        if (kosztJednNabycia != null ? !kosztJednNabycia.equals(that.kosztJednNabycia) : that.kosztJednNabycia != null)
            return false;
        if (kosztJednUtrzymWyszkPerson != null ? !kosztJednUtrzymWyszkPerson.equals(that.kosztJednUtrzymWyszkPerson) : that.kosztJednUtrzymWyszkPerson != null)
            return false;
        if (masa != null ? !masa.equals(that.masa) : that.masa != null) return false;
        if (dlug != null ? !dlug.equals(that.dlug) : that.dlug != null) return false;
        if (szerok != null ? !szerok.equals(that.szerok) : that.szerok != null) return false;
        if (wysok != null ? !wysok.equals(that.wysok) : that.wysok != null) return false;
        if (potencjalBoj != null ? !potencjalBoj.equals(that.potencjalBoj) : that.potencjalBoj != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (pojemZbiorPaliwa != null ? !pojemZbiorPaliwa.equals(that.pojemZbiorPaliwa) : that.pojemZbiorPaliwa != null)
            return false;
        if (pojemZbiorPaliwaDodat != null ? !pojemZbiorPaliwaDodat.equals(that.pojemZbiorPaliwaDodat) : that.pojemZbiorPaliwaDodat != null)
            return false;
        if (pojemAkumulatorow != null ? !pojemAkumulatorow.equals(that.pojemAkumulatorow) : that.pojemAkumulatorow != null)
            return false;
        if (jezdzacy != null ? !jezdzacy.equals(that.jezdzacy) : that.jezdzacy != null) return false;
        if (latajacy != null ? !latajacy.equals(that.latajacy) : that.latajacy != null) return false;
        if (plywajacy != null ? !plywajacy.equals(that.plywajacy) : that.plywajacy != null) return false;
        if (przenosny != null ? !przenosny.equals(that.przenosny) : that.przenosny != null) return false;
        if (ciagniony != null ? !ciagniony.equals(that.ciagniony) : that.ciagniony != null) return false;
        if (efektorLacznFk != null ? !efektorLacznFk.equals(that.efektorLacznFk) : that.efektorLacznFk != null)
            return false;
        if (rodzajSrodowFk != null ? !rodzajSrodowFk.equals(that.rodzajSrodowFk) : that.rodzajSrodowFk != null)
            return false;
        if (efektorJezdnyFk != null ? !efektorJezdnyFk.equals(that.efektorJezdnyFk) : that.efektorJezdnyFk != null)
            return false;
        if (efektorPlywaniaFk != null ? !efektorPlywaniaFk.equals(that.efektorPlywaniaFk) : that.efektorPlywaniaFk != null)
            return false;
        if (efektorInzFk != null ? !efektorInzFk.equals(that.efektorInzFk) : that.efektorInzFk != null) return false;
        if (efektorWeFk != null ? !efektorWeFk.equals(that.efektorWeFk) : that.efektorWeFk != null) return false;
        if (paramKadlubaFk != null ? !paramKadlubaFk.equals(that.paramKadlubaFk) : that.paramKadlubaFk != null)
            return false;
        if (efektorTranspFk != null ? !efektorTranspFk.equals(that.efektorTranspFk) : that.efektorTranspFk != null)
            return false;
        if (efektorLataniaFk != null ? !efektorLataniaFk.equals(that.efektorLataniaFk) : that.efektorLataniaFk != null)
            return false;
        if (efektorRozpozFk != null ? !efektorRozpozFk.equals(that.efektorRozpozFk) : that.efektorRozpozFk != null)
            return false;
        if (klasaPrzyrzOc != null ? !klasaPrzyrzOc.equals(that.klasaPrzyrzOc) : that.klasaPrzyrzOc != null)
            return false;
        if (moc != null ? !moc.equals(that.moc) : that.moc != null) return false;
        if (zuzyciePaliwaPraca != null ? !zuzyciePaliwaPraca.equals(that.zuzyciePaliwaPraca) : that.zuzyciePaliwaPraca != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (skrot != null ? skrot.hashCode() : 0);
        result = 31 * result + (kod != null ? kod.hashCode() : 0);
        result = 31 * result + (kategoriaFk != null ? kategoriaFk.hashCode() : 0);
        result = 31 * result + (klasa != null ? klasa.hashCode() : 0);
        result = 31 * result + (obsluga != null ? obsluga.hashCode() : 0);
        result = 31 * result + (opancerzony != null ? opancerzony.hashCode() : 0);
        result = 31 * result + (kosztJednCykluZycia != null ? kosztJednCykluZycia.hashCode() : 0);
        result = 31 * result + (kosztJednNabycia != null ? kosztJednNabycia.hashCode() : 0);
        result = 31 * result + (kosztJednUtrzymWyszkPerson != null ? kosztJednUtrzymWyszkPerson.hashCode() : 0);
        result = 31 * result + (masa != null ? masa.hashCode() : 0);
        result = 31 * result + (dlug != null ? dlug.hashCode() : 0);
        result = 31 * result + (szerok != null ? szerok.hashCode() : 0);
        result = 31 * result + (wysok != null ? wysok.hashCode() : 0);
        result = 31 * result + (potencjalBoj != null ? potencjalBoj.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (pojemZbiorPaliwa != null ? pojemZbiorPaliwa.hashCode() : 0);
        result = 31 * result + (pojemZbiorPaliwaDodat != null ? pojemZbiorPaliwaDodat.hashCode() : 0);
        result = 31 * result + (pojemAkumulatorow != null ? pojemAkumulatorow.hashCode() : 0);
        result = 31 * result + (jezdzacy != null ? jezdzacy.hashCode() : 0);
        result = 31 * result + (latajacy != null ? latajacy.hashCode() : 0);
        result = 31 * result + (plywajacy != null ? plywajacy.hashCode() : 0);
        result = 31 * result + (przenosny != null ? przenosny.hashCode() : 0);
        result = 31 * result + (ciagniony != null ? ciagniony.hashCode() : 0);
        result = 31 * result + (efektorLacznFk != null ? efektorLacznFk.hashCode() : 0);
        result = 31 * result + (rodzajSrodowFk != null ? rodzajSrodowFk.hashCode() : 0);
        result = 31 * result + (efektorJezdnyFk != null ? efektorJezdnyFk.hashCode() : 0);
        result = 31 * result + (efektorPlywaniaFk != null ? efektorPlywaniaFk.hashCode() : 0);
        result = 31 * result + (efektorInzFk != null ? efektorInzFk.hashCode() : 0);
        result = 31 * result + (efektorWeFk != null ? efektorWeFk.hashCode() : 0);
        result = 31 * result + (paramKadlubaFk != null ? paramKadlubaFk.hashCode() : 0);
        result = 31 * result + (efektorTranspFk != null ? efektorTranspFk.hashCode() : 0);
        result = 31 * result + (efektorLataniaFk != null ? efektorLataniaFk.hashCode() : 0);
        result = 31 * result + (efektorRozpozFk != null ? efektorRozpozFk.hashCode() : 0);
        result = 31 * result + (klasaPrzyrzOc != null ? klasaPrzyrzOc.hashCode() : 0);
        result = 31 * result + (moc != null ? moc.hashCode() : 0);
        result = 31 * result + (zuzyciePaliwaPraca != null ? zuzyciePaliwaPraca.hashCode() : 0);
        return result;
    }
}
