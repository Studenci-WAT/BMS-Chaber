package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mps", schema = "mspwTest", catalog = "")
public class MpsEntity {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MpsEntity mpsEntity = (MpsEntity) o;

        if (id != mpsEntity.id) return false;
        if (nazwa != null ? !nazwa.equals(mpsEntity.nazwa) : mpsEntity.nazwa != null) return false;
        if (skrot != null ? !skrot.equals(mpsEntity.skrot) : mpsEntity.skrot != null) return false;
        if (kod != null ? !kod.equals(mpsEntity.kod) : mpsEntity.kod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (skrot != null ? skrot.hashCode() : 0);
        result = 31 * result + (kod != null ? kod.hashCode() : 0);
        return result;
    }
}
