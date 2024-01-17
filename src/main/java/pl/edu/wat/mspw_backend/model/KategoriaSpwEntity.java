package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "e_kategoria_spw", schema = "mspwTest", catalog = "")
public class KategoriaSpwEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "KATEG_CELU_RAZENIA_FK", nullable = true)
    private Integer kategCeluRazeniaFk;
    @Basic
    @Column(name = "NAZWA", nullable = true, length = 30)
    private String nazwa;
    @Basic
    @Column(name = "SKROT", nullable = true, length = 10)
    private String skrot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getKategCeluRazeniaFk() {
        return kategCeluRazeniaFk;
    }

    public void setKategCeluRazeniaFk(Integer kategCeluRazeniaFk) {
        this.kategCeluRazeniaFk = kategCeluRazeniaFk;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KategoriaSpwEntity that = (KategoriaSpwEntity) o;

        if (id != that.id) return false;
        if (kategCeluRazeniaFk != null ? !kategCeluRazeniaFk.equals(that.kategCeluRazeniaFk) : that.kategCeluRazeniaFk != null)
            return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;
        if (skrot != null ? !skrot.equals(that.skrot) : that.skrot != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (kategCeluRazeniaFk != null ? kategCeluRazeniaFk.hashCode() : 0);
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (skrot != null ? skrot.hashCode() : 0);
        return result;
    }
}
