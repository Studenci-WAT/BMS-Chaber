package pl.edu.wat.mspw_projekt;

import jakarta.persistence.*;

@Entity
@Table(name = "amo", schema = "mspw", catalog = "")
public class AmoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "NAZWA")
    private String nazwa;
    @Basic
    @Column(name = "SKROT")
    private String skrot;
    @Basic
    @Column(name = "KOD")
    private String kod;
    @Basic
    @Column(name = "KALIBER")
    private Double kaliber;
    @Basic
    @Column(name = "SZTUK_W_PACZCE")
    private Integer sztukWPaczce;
    @Basic
    @Column(name = "MASA_SZTUKI")
    private Integer masaSztuki;
    @Basic
    @Column(name = "WYM_PACZKI_X")
    private Double wymPaczkiX;
    @Basic
    @Column(name = "WYM_PACZKI_Y")
    private Double wymPaczkiY;
    @Basic
    @Column(name = "WYM_PACZKI_Z")
    private Double wymPaczkiZ;
    @Basic
    @Column(name = "KATEG_FK")
    private Integer kategFk;
    @Basic
    @Column(name = "RODZAJ_GLOWICY_BOJ_FK")
    private Integer rodzajGlowicyBojFk;
    @Basic
    @Column(name = "RODZAJ_GLOWICY_NAPROW_FK")
    private Integer rodzajGlowicyNaprowFk;
    @Basic
    @Column(name = "RODZAJ_NAPROW_FK")
    private Integer rodzajNaprowFk;

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

    public Double getKaliber() {
        return kaliber;
    }

    public void setKaliber(Double kaliber) {
        this.kaliber = kaliber;
    }

    public Integer getSztukWPaczce() {
        return sztukWPaczce;
    }

    public void setSztukWPaczce(Integer sztukWPaczce) {
        this.sztukWPaczce = sztukWPaczce;
    }

    public Integer getMasaSztuki() {
        return masaSztuki;
    }

    public void setMasaSztuki(Integer masaSztuki) {
        this.masaSztuki = masaSztuki;
    }

    public Double getWymPaczkiX() {
        return wymPaczkiX;
    }

    public void setWymPaczkiX(Double wymPaczkiX) {
        this.wymPaczkiX = wymPaczkiX;
    }

    public Double getWymPaczkiY() {
        return wymPaczkiY;
    }

    public void setWymPaczkiY(Double wymPaczkiY) {
        this.wymPaczkiY = wymPaczkiY;
    }

    public Double getWymPaczkiZ() {
        return wymPaczkiZ;
    }

    public void setWymPaczkiZ(Double wymPaczkiZ) {
        this.wymPaczkiZ = wymPaczkiZ;
    }

    public Integer getKategFk() {
        return kategFk;
    }

    public void setKategFk(Integer kategFk) {
        this.kategFk = kategFk;
    }

    public Integer getRodzajGlowicyBojFk() {
        return rodzajGlowicyBojFk;
    }

    public void setRodzajGlowicyBojFk(Integer rodzajGlowicyBojFk) {
        this.rodzajGlowicyBojFk = rodzajGlowicyBojFk;
    }

    public Integer getRodzajGlowicyNaprowFk() {
        return rodzajGlowicyNaprowFk;
    }

    public void setRodzajGlowicyNaprowFk(Integer rodzajGlowicyNaprowFk) {
        this.rodzajGlowicyNaprowFk = rodzajGlowicyNaprowFk;
    }

    public Integer getRodzajNaprowFk() {
        return rodzajNaprowFk;
    }

    public void setRodzajNaprowFk(Integer rodzajNaprowFk) {
        this.rodzajNaprowFk = rodzajNaprowFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmoEntity amoEntity = (AmoEntity) o;

        if (id != amoEntity.id) return false;
        if (nazwa != null ? !nazwa.equals(amoEntity.nazwa) : amoEntity.nazwa != null) return false;
        if (skrot != null ? !skrot.equals(amoEntity.skrot) : amoEntity.skrot != null) return false;
        if (kod != null ? !kod.equals(amoEntity.kod) : amoEntity.kod != null) return false;
        if (kaliber != null ? !kaliber.equals(amoEntity.kaliber) : amoEntity.kaliber != null) return false;
        if (sztukWPaczce != null ? !sztukWPaczce.equals(amoEntity.sztukWPaczce) : amoEntity.sztukWPaczce != null)
            return false;
        if (masaSztuki != null ? !masaSztuki.equals(amoEntity.masaSztuki) : amoEntity.masaSztuki != null) return false;
        if (wymPaczkiX != null ? !wymPaczkiX.equals(amoEntity.wymPaczkiX) : amoEntity.wymPaczkiX != null) return false;
        if (wymPaczkiY != null ? !wymPaczkiY.equals(amoEntity.wymPaczkiY) : amoEntity.wymPaczkiY != null) return false;
        if (wymPaczkiZ != null ? !wymPaczkiZ.equals(amoEntity.wymPaczkiZ) : amoEntity.wymPaczkiZ != null) return false;
        if (kategFk != null ? !kategFk.equals(amoEntity.kategFk) : amoEntity.kategFk != null) return false;
        if (rodzajGlowicyBojFk != null ? !rodzajGlowicyBojFk.equals(amoEntity.rodzajGlowicyBojFk) : amoEntity.rodzajGlowicyBojFk != null)
            return false;
        if (rodzajGlowicyNaprowFk != null ? !rodzajGlowicyNaprowFk.equals(amoEntity.rodzajGlowicyNaprowFk) : amoEntity.rodzajGlowicyNaprowFk != null)
            return false;
        if (rodzajNaprowFk != null ? !rodzajNaprowFk.equals(amoEntity.rodzajNaprowFk) : amoEntity.rodzajNaprowFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (skrot != null ? skrot.hashCode() : 0);
        result = 31 * result + (kod != null ? kod.hashCode() : 0);
        result = 31 * result + (kaliber != null ? kaliber.hashCode() : 0);
        result = 31 * result + (sztukWPaczce != null ? sztukWPaczce.hashCode() : 0);
        result = 31 * result + (masaSztuki != null ? masaSztuki.hashCode() : 0);
        result = 31 * result + (wymPaczkiX != null ? wymPaczkiX.hashCode() : 0);
        result = 31 * result + (wymPaczkiY != null ? wymPaczkiY.hashCode() : 0);
        result = 31 * result + (wymPaczkiZ != null ? wymPaczkiZ.hashCode() : 0);
        result = 31 * result + (kategFk != null ? kategFk.hashCode() : 0);
        result = 31 * result + (rodzajGlowicyBojFk != null ? rodzajGlowicyBojFk.hashCode() : 0);
        result = 31 * result + (rodzajGlowicyNaprowFk != null ? rodzajGlowicyNaprowFk.hashCode() : 0);
        result = 31 * result + (rodzajNaprowFk != null ? rodzajNaprowFk.hashCode() : 0);
        return result;
    }
}
