package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fun_pstwo_zniszcz_op", schema = "mspwTest", catalog = "")
public class FunPstwoZniszczOpEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "POZIOM_FORT_CELU", nullable = true)
    private Integer poziomFortCelu;
    //@Basic
    //@Column(name = "KATEG_STRZEL_FK", nullable = true)
    //private Integer kategStrzelFk;
    @Basic
    @Column(name = "KLASA_STRZEL", nullable = true)
    private Integer klasaStrzel;
    //@Basic
    //@Column(name = "KATEG_CELU_FK", nullable = true)
    //private Integer kategCeluFk;
    @Basic
    @Column(name = "KLASA_CELU", nullable = true)
    private Integer klasaCelu;
    @Basic
    @Column(name = "POZIOM_WYSZK_STRZEL", nullable = true)
    private Integer poziomWyszkStrzel;
    //@Basic
    //@Column(name = "SPW_STRZEL_FK", nullable = true)
    //private Integer spwStrzelFk;
    //@Basic
    //@Column(name = "SPW_CEL_FK", nullable = true)
    //private Integer spwCelFk;
    @Basic
    @Column(name = "PSTWO", nullable = true, precision = 0)
    private Double pstwo;
    @Basic
    @Column(name = "ODLEG", nullable = true, precision = 0)
    private Double odleg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPoziomFortCelu() {
        return poziomFortCelu;
    }

    public void setPoziomFortCelu(Integer poziomFortCelu) {
        this.poziomFortCelu = poziomFortCelu;
    }

    //public Integer getKategStrzelFk() {return kategStrzelFk;}

    //public void setKategStrzelFk(Integer kategStrzelFk) {this.kategStrzelFk = kategStrzelFk;}

    public Integer getKlasaStrzel() {
        return klasaStrzel;
    }

    public void setKlasaStrzel(Integer klasaStrzel) {
        this.klasaStrzel = klasaStrzel;
    }

    //public Integer getKategCeluFk() {return kategCeluFk;}

    //public void setKategCeluFk(Integer kategCeluFk) {this.kategCeluFk = kategCeluFk;}

    public Integer getKlasaCelu() {
        return klasaCelu;
    }

    public void setKlasaCelu(Integer klasaCelu) {
        this.klasaCelu = klasaCelu;
    }

    public Integer getPoziomWyszkStrzel() {
        return poziomWyszkStrzel;
    }

    public void setPoziomWyszkStrzel(Integer poziomWyszkStrzel) {
        this.poziomWyszkStrzel = poziomWyszkStrzel;
    }

    //public Integer getSpwStrzelFk() {return spwStrzelFk;}

    //public void setSpwStrzelFk(Integer spwStrzelFk) {this.spwStrzelFk = spwStrzelFk;}

    //public Integer getSpwCelFk() {return spwCelFk;}

    //public void setSpwCelFk(Integer spwCelFk) {this.spwCelFk = spwCelFk;}

    public Double getPstwo() {
        return pstwo;
    }

    public void setPstwo(Double pstwo) {
        this.pstwo = pstwo;
    }

    public Double getOdleg() {
        return odleg;
    }

    public void setOdleg(Double odleg) {
        this.odleg = odleg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunPstwoZniszczOpEntity that = (FunPstwoZniszczOpEntity) o;

        if (id != that.id) return false;
        if (poziomFortCelu != null ? !poziomFortCelu.equals(that.poziomFortCelu) : that.poziomFortCelu != null)
            return false;
        //if (kategStrzelFk != null ? !kategStrzelFk.equals(that.kategStrzelFk) : that.kategStrzelFk != null)
        //    return false;
        if (klasaStrzel != null ? !klasaStrzel.equals(that.klasaStrzel) : that.klasaStrzel != null) return false;
        //if (kategCeluFk != null ? !kategCeluFk.equals(that.kategCeluFk) : that.kategCeluFk != null) return false;
        if (klasaCelu != null ? !klasaCelu.equals(that.klasaCelu) : that.klasaCelu != null) return false;
        if (poziomWyszkStrzel != null ? !poziomWyszkStrzel.equals(that.poziomWyszkStrzel) : that.poziomWyszkStrzel != null)
            return false;
        //if (spwStrzelFk != null ? !spwStrzelFk.equals(that.spwStrzelFk) : that.spwStrzelFk != null) return false;
        //if (spwCelFk != null ? !spwCelFk.equals(that.spwCelFk) : that.spwCelFk != null) return false;
        if (pstwo != null ? !pstwo.equals(that.pstwo) : that.pstwo != null) return false;
        if (odleg != null ? !odleg.equals(that.odleg) : that.odleg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (poziomFortCelu != null ? poziomFortCelu.hashCode() : 0);
        //result = 31 * result + (kategStrzelFk != null ? kategStrzelFk.hashCode() : 0);
        result = 31 * result + (klasaStrzel != null ? klasaStrzel.hashCode() : 0);
        //result = 31 * result + (kategCeluFk != null ? kategCeluFk.hashCode() : 0);
        result = 31 * result + (klasaCelu != null ? klasaCelu.hashCode() : 0);
        result = 31 * result + (poziomWyszkStrzel != null ? poziomWyszkStrzel.hashCode() : 0);
        //result = 31 * result + (spwStrzelFk != null ? spwStrzelFk.hashCode() : 0);
        //result = 31 * result + (spwCelFk != null ? spwCelFk.hashCode() : 0);
        result = 31 * result + (pstwo != null ? pstwo.hashCode() : 0);
        result = 31 * result + (odleg != null ? odleg.hashCode() : 0);
        return result;
    }
}
