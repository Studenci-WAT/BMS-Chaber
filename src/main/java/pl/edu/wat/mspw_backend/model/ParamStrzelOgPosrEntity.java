package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "param_strzel_og_posr", schema = "mspwTest", catalog = "")
public class ParamStrzelOgPosrEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "AMO_FK", nullable = true)
    private Integer amoFk;
    @Basic
    @Column(name = "SYSTEM_OGN_FK", nullable = true)
    private Integer systemOgnFk;
    @Basic
    @Column(name = "ODLEG", nullable = true, precision = 0)
    private Double odleg;
    @Basic
    @Column(name = "UCHYL_SZER", nullable = true, precision = 0)
    private Double uchylSzer;
    @Basic
    @Column(name = "UCHYL_GLEB", nullable = true, precision = 0)
    private Double uchylGleb;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAmoFk() {
        return amoFk;
    }

    public void setAmoFk(Integer amoFk) {
        this.amoFk = amoFk;
    }

    public Integer getSystemOgnFk() {
        return systemOgnFk;
    }

    public void setSystemOgnFk(Integer systemOgnFk) {
        this.systemOgnFk = systemOgnFk;
    }

    public Double getOdleg() {
        return odleg;
    }

    public void setOdleg(Double odleg) {
        this.odleg = odleg;
    }

    public Double getUchylSzer() {
        return uchylSzer;
    }

    public void setUchylSzer(Double uchylSzer) {
        this.uchylSzer = uchylSzer;
    }

    public Double getUchylGleb() {
        return uchylGleb;
    }

    public void setUchylGleb(Double uchylGleb) {
        this.uchylGleb = uchylGleb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParamStrzelOgPosrEntity that = (ParamStrzelOgPosrEntity) o;

        if (id != that.id) return false;
        if (amoFk != null ? !amoFk.equals(that.amoFk) : that.amoFk != null) return false;
        if (systemOgnFk != null ? !systemOgnFk.equals(that.systemOgnFk) : that.systemOgnFk != null) return false;
        if (odleg != null ? !odleg.equals(that.odleg) : that.odleg != null) return false;
        if (uchylSzer != null ? !uchylSzer.equals(that.uchylSzer) : that.uchylSzer != null) return false;
        if (uchylGleb != null ? !uchylGleb.equals(that.uchylGleb) : that.uchylGleb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amoFk != null ? amoFk.hashCode() : 0);
        result = 31 * result + (systemOgnFk != null ? systemOgnFk.hashCode() : 0);
        result = 31 * result + (odleg != null ? odleg.hashCode() : 0);
        result = 31 * result + (uchylSzer != null ? uchylSzer.hashCode() : 0);
        result = 31 * result + (uchylGleb != null ? uchylGleb.hashCode() : 0);
        return result;
    }
}
