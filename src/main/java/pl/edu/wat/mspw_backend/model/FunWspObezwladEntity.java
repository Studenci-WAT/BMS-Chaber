package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fun_wsp_obezwlad", schema = "mspwTest", catalog = "")
public class FunWspObezwladEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "POZIOM_ODDZIAL_OGN_FK", nullable = true)
    private Integer poziomOddzialOgnFk;
    @Basic
    @Column(name = "WSP", nullable = true, precision = 0)
    private Double wsp;
    @Basic
    @Column(name = "STRZEL_OPANC", nullable = true)
    private Boolean strzelOpanc;
    @Basic
    @Column(name = "POZIOM_WYSZK", nullable = true)
    private Integer poziomWyszk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPoziomOddzialOgnFk() {
        return poziomOddzialOgnFk;
    }

    public void setPoziomOddzialOgnFk(Integer poziomOddzialOgnFk) {
        this.poziomOddzialOgnFk = poziomOddzialOgnFk;
    }

    public Double getWsp() {
        return wsp;
    }

    public void setWsp(Double wsp) {
        this.wsp = wsp;
    }

    public Boolean getStrzelOpanc() {
        return strzelOpanc;
    }

    public void setStrzelOpanc(Boolean strzelOpanc) {
        this.strzelOpanc = strzelOpanc;
    }

    public Integer getPoziomWyszk() {
        return poziomWyszk;
    }

    public void setPoziomWyszk(Integer poziomWyszk) {
        this.poziomWyszk = poziomWyszk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunWspObezwladEntity that = (FunWspObezwladEntity) o;

        if (id != that.id) return false;
        if (poziomOddzialOgnFk != null ? !poziomOddzialOgnFk.equals(that.poziomOddzialOgnFk) : that.poziomOddzialOgnFk != null)
            return false;
        if (wsp != null ? !wsp.equals(that.wsp) : that.wsp != null) return false;
        if (strzelOpanc != null ? !strzelOpanc.equals(that.strzelOpanc) : that.strzelOpanc != null) return false;
        if (poziomWyszk != null ? !poziomWyszk.equals(that.poziomWyszk) : that.poziomWyszk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (poziomOddzialOgnFk != null ? poziomOddzialOgnFk.hashCode() : 0);
        result = 31 * result + (wsp != null ? wsp.hashCode() : 0);
        result = 31 * result + (strzelOpanc != null ? strzelOpanc.hashCode() : 0);
        result = 31 * result + (poziomWyszk != null ? poziomWyszk.hashCode() : 0);
        return result;
    }
}
