package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fun_wsp_ukrycia", schema = "mspwTest", catalog = "")
public class FunWspUkryciaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "TYP_TERENU_WIDOCZ_FK", nullable = true)
    private Integer typTerenuWidoczFk;
    @Basic
    @Column(name = "WSP", nullable = true, precision = 0)
    private Double wsp;
    @Basic
    @Column(name = "POZIOM_FORT", nullable = true)
    private Integer poziomFort;

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

    public Double getWsp() {
        return wsp;
    }

    public void setWsp(Double wsp) {
        this.wsp = wsp;
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

        FunWspUkryciaEntity that = (FunWspUkryciaEntity) o;

        if (id != that.id) return false;
        if (typTerenuWidoczFk != null ? !typTerenuWidoczFk.equals(that.typTerenuWidoczFk) : that.typTerenuWidoczFk != null)
            return false;
        if (wsp != null ? !wsp.equals(that.wsp) : that.wsp != null) return false;
        if (poziomFort != null ? !poziomFort.equals(that.poziomFort) : that.poziomFort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typTerenuWidoczFk != null ? typTerenuWidoczFk.hashCode() : 0);
        result = 31 * result + (wsp != null ? wsp.hashCode() : 0);
        result = 31 * result + (poziomFort != null ? poziomFort.hashCode() : 0);
        return result;
    }
}
