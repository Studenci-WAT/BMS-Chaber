package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "miara_zdolnosci_razenia", schema = "mspwTest", catalog = "")
public class MiaraZdolnosciRazeniaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "NOSICIEL_ZDOLN_FK", nullable = true)
    private Integer nosicielZdolnFk;
    @Basic
    @Column(name = "ZDOLN_RAZ_PANC_OPANC_ZASIEG_BLISKI", nullable = true, precision = 0)
    private Double zdolnRazPancOpancZasiegBliski;
    @Basic
    @Column(name = "ZDOLN_RAZ_SRODK_OGN_ZASIEG_BLISKI", nullable = true, precision = 0)
    private Double zdolnRazSrodkOgnZasiegBliski;
    @Basic
    @Column(name = "ZDOLN_RAZ_SILY_ZYWEJ_ZASIEG_BLISKI", nullable = true, precision = 0)
    private Double zdolnRazSilyZywejZasiegBliski;
    @Basic
    @Column(name = "ZDOLN_RAZ_PANC_OPANC_ZASIEG_SREDNI", nullable = true, precision = 0)
    private Double zdolnRazPancOpancZasiegSredni;
    @Basic
    @Column(name = "ZDOLN_RAZ_SRODK_OGN_ZASIEG_SREDNI", nullable = true, precision = 0)
    private Double zdolnRazSrodkOgnZasiegSredni;
    @Basic
    @Column(name = "ZDOLN_RAZ_SILY_ZYWEJ_ZASIEG_SREDNI", nullable = true, precision = 0)
    private Double zdolnRazSilyZywejZasiegSredni;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNosicielZdolnFk() {
        return nosicielZdolnFk;
    }

    public void setNosicielZdolnFk(Integer nosicielZdolnFk) {
        this.nosicielZdolnFk = nosicielZdolnFk;
    }

    public Double getZdolnRazPancOpancZasiegBliski() {
        return zdolnRazPancOpancZasiegBliski;
    }

    public void setZdolnRazPancOpancZasiegBliski(Double zdolnRazPancOpancZasiegBliski) {
        this.zdolnRazPancOpancZasiegBliski = zdolnRazPancOpancZasiegBliski;
    }

    public Double getZdolnRazSrodkOgnZasiegBliski() {
        return zdolnRazSrodkOgnZasiegBliski;
    }

    public void setZdolnRazSrodkOgnZasiegBliski(Double zdolnRazSrodkOgnZasiegBliski) {
        this.zdolnRazSrodkOgnZasiegBliski = zdolnRazSrodkOgnZasiegBliski;
    }

    public Double getZdolnRazSilyZywejZasiegBliski() {
        return zdolnRazSilyZywejZasiegBliski;
    }

    public void setZdolnRazSilyZywejZasiegBliski(Double zdolnRazSilyZywejZasiegBliski) {
        this.zdolnRazSilyZywejZasiegBliski = zdolnRazSilyZywejZasiegBliski;
    }

    public Double getZdolnRazPancOpancZasiegSredni() {
        return zdolnRazPancOpancZasiegSredni;
    }

    public void setZdolnRazPancOpancZasiegSredni(Double zdolnRazPancOpancZasiegSredni) {
        this.zdolnRazPancOpancZasiegSredni = zdolnRazPancOpancZasiegSredni;
    }

    public Double getZdolnRazSrodkOgnZasiegSredni() {
        return zdolnRazSrodkOgnZasiegSredni;
    }

    public void setZdolnRazSrodkOgnZasiegSredni(Double zdolnRazSrodkOgnZasiegSredni) {
        this.zdolnRazSrodkOgnZasiegSredni = zdolnRazSrodkOgnZasiegSredni;
    }

    public Double getZdolnRazSilyZywejZasiegSredni() {
        return zdolnRazSilyZywejZasiegSredni;
    }

    public void setZdolnRazSilyZywejZasiegSredni(Double zdolnRazSilyZywejZasiegSredni) {
        this.zdolnRazSilyZywejZasiegSredni = zdolnRazSilyZywejZasiegSredni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MiaraZdolnosciRazeniaEntity that = (MiaraZdolnosciRazeniaEntity) o;

        if (id != that.id) return false;
        if (nosicielZdolnFk != null ? !nosicielZdolnFk.equals(that.nosicielZdolnFk) : that.nosicielZdolnFk != null)
            return false;
        if (zdolnRazPancOpancZasiegBliski != null ? !zdolnRazPancOpancZasiegBliski.equals(that.zdolnRazPancOpancZasiegBliski) : that.zdolnRazPancOpancZasiegBliski != null)
            return false;
        if (zdolnRazSrodkOgnZasiegBliski != null ? !zdolnRazSrodkOgnZasiegBliski.equals(that.zdolnRazSrodkOgnZasiegBliski) : that.zdolnRazSrodkOgnZasiegBliski != null)
            return false;
        if (zdolnRazSilyZywejZasiegBliski != null ? !zdolnRazSilyZywejZasiegBliski.equals(that.zdolnRazSilyZywejZasiegBliski) : that.zdolnRazSilyZywejZasiegBliski != null)
            return false;
        if (zdolnRazPancOpancZasiegSredni != null ? !zdolnRazPancOpancZasiegSredni.equals(that.zdolnRazPancOpancZasiegSredni) : that.zdolnRazPancOpancZasiegSredni != null)
            return false;
        if (zdolnRazSrodkOgnZasiegSredni != null ? !zdolnRazSrodkOgnZasiegSredni.equals(that.zdolnRazSrodkOgnZasiegSredni) : that.zdolnRazSrodkOgnZasiegSredni != null)
            return false;
        if (zdolnRazSilyZywejZasiegSredni != null ? !zdolnRazSilyZywejZasiegSredni.equals(that.zdolnRazSilyZywejZasiegSredni) : that.zdolnRazSilyZywejZasiegSredni != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nosicielZdolnFk != null ? nosicielZdolnFk.hashCode() : 0);
        result = 31 * result + (zdolnRazPancOpancZasiegBliski != null ? zdolnRazPancOpancZasiegBliski.hashCode() : 0);
        result = 31 * result + (zdolnRazSrodkOgnZasiegBliski != null ? zdolnRazSrodkOgnZasiegBliski.hashCode() : 0);
        result = 31 * result + (zdolnRazSilyZywejZasiegBliski != null ? zdolnRazSilyZywejZasiegBliski.hashCode() : 0);
        result = 31 * result + (zdolnRazPancOpancZasiegSredni != null ? zdolnRazPancOpancZasiegSredni.hashCode() : 0);
        result = 31 * result + (zdolnRazSrodkOgnZasiegSredni != null ? zdolnRazSrodkOgnZasiegSredni.hashCode() : 0);
        result = 31 * result + (zdolnRazSilyZywejZasiegSredni != null ? zdolnRazSilyZywejZasiegSredni.hashCode() : 0);
        return result;
    }
}
