package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fun_pstwo_zniszcz_traf_ob", schema = "mspwTest", catalog = "")
public class FunPstwoZniszczTrafObEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
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
    @Column(name = "ODLEG", nullable = true, precision = 0)
    private Double odleg;
    @Basic
    @Column(name = "PSTWO", nullable = true, precision = 0)
    private Double pstwo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getOdleg() {
        return odleg;
    }

    public void setOdleg(Double odleg) {
        this.odleg = odleg;
    }

    public Double getPstwo() {
        return pstwo;
    }

    public void setPstwo(Double pstwo) {
        this.pstwo = pstwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunPstwoZniszczTrafObEntity that = (FunPstwoZniszczTrafObEntity) o;

        if (id != that.id) return false;
        if (sysOgnFk != null ? !sysOgnFk.equals(that.sysOgnFk) : that.sysOgnFk != null) return false;
        if (amoFk != null ? !amoFk.equals(that.amoFk) : that.amoFk != null) return false;
        if (spwCelFk != null ? !spwCelFk.equals(that.spwCelFk) : that.spwCelFk != null) return false;
        if (odleg != null ? !odleg.equals(that.odleg) : that.odleg != null) return false;
        if (pstwo != null ? !pstwo.equals(that.pstwo) : that.pstwo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sysOgnFk != null ? sysOgnFk.hashCode() : 0);
        result = 31 * result + (amoFk != null ? amoFk.hashCode() : 0);
        result = 31 * result + (spwCelFk != null ? spwCelFk.hashCode() : 0);
        result = 31 * result + (odleg != null ? odleg.hashCode() : 0);
        result = 31 * result + (pstwo != null ? pstwo.hashCode() : 0);
        return result;
    }
}
