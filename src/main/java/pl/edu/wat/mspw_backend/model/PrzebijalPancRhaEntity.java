package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "przebijal_panc_rha", schema = "mspwTest", catalog = "")
public class PrzebijalPancRhaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "AMO_FK", nullable = true)
    private Integer amoFk;
    @Basic
    @Column(name = "PREDK_POCISKU", nullable = true, precision = 0)
    private Double predkPocisku;
    @Basic
    @Column(name = "PRZEBIJAL_POCISKU", nullable = true, precision = 0)
    private Double przebijalPocisku;

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

    public Double getPredkPocisku() {
        return predkPocisku;
    }

    public void setPredkPocisku(Double predkPocisku) {
        this.predkPocisku = predkPocisku;
    }

    public Double getPrzebijalPocisku() {
        return przebijalPocisku;
    }

    public void setPrzebijalPocisku(Double przebijalPocisku) {
        this.przebijalPocisku = przebijalPocisku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrzebijalPancRhaEntity that = (PrzebijalPancRhaEntity) o;

        if (id != that.id) return false;
        if (amoFk != null ? !amoFk.equals(that.amoFk) : that.amoFk != null) return false;
        if (predkPocisku != null ? !predkPocisku.equals(that.predkPocisku) : that.predkPocisku != null) return false;
        if (przebijalPocisku != null ? !przebijalPocisku.equals(that.przebijalPocisku) : that.przebijalPocisku != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amoFk != null ? amoFk.hashCode() : 0);
        result = 31 * result + (predkPocisku != null ? predkPocisku.hashCode() : 0);
        result = 31 * result + (przebijalPocisku != null ? przebijalPocisku.hashCode() : 0);
        return result;
    }
}
