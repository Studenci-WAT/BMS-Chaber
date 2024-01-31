package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kadlub", schema = "mspwTest", catalog = "")
public class KadlubEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "PANCERZ_BOK_KINET_RHA", nullable = true, precision = 0)
    private Double pancerzBokKinetRha;
    @Basic
    @Column(name = "PANCERZ_BOK_KUMUL_RHA", nullable = true, precision = 0)
    private Double pancerzBokKumulRha;
    @Basic
    @Column(name = "PANCERZ_FRONT_KINET_RHA", nullable = true, precision = 0)
    private Double pancerzFrontKinetRha;
    @Basic
    @Column(name = "PANCERZ_FRONT_KUMUL_RHA", nullable = true, precision = 0)
    private Double pancerzFrontKumulRha;
    @Basic
    @Column(name = "PANCERZ_TYL_KINET_RHA", nullable = true, precision = 0)
    private Double pancerzTylKinetRha;
    @Basic
    @Column(name = "PANCERZ_TYL_KUMUL_RHA", nullable = true, precision = 0)
    private Double pancerzTylKumulRha;
    @Basic
    @Column(name = "PANCERZ_SPOD_KINET_RHA", nullable = true, precision = 0)
    private Double pancerzSpodKinetRha;
    @Basic
    @Column(name = "PANCERZ_SPOD_KUMUL_RHA", nullable = true, precision = 0)
    private Double pancerzSpodKumulRha;
    @Basic
    @Column(name = "PANCERZ_STROP_KINET_RHA", nullable = true, precision = 0)
    private Double pancerzStropKinetRha;
    @Basic
    @Column(name = "PANCERZ_STROP_KUMUL_RHA", nullable = true, precision = 0)
    private Double pancerzStropKumulRha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPancerzBokKinetRha() {
        return pancerzBokKinetRha;
    }

    public void setPancerzBokKinetRha(Double pancerzBokKinetRha) {
        this.pancerzBokKinetRha = pancerzBokKinetRha;
    }

    public Double getPancerzBokKumulRha() {
        return pancerzBokKumulRha;
    }

    public void setPancerzBokKumulRha(Double pancerzBokKumulRha) {
        this.pancerzBokKumulRha = pancerzBokKumulRha;
    }

    public Double getPancerzFrontKinetRha() {
        return pancerzFrontKinetRha;
    }

    public void setPancerzFrontKinetRha(Double pancerzFrontKinetRha) {
        this.pancerzFrontKinetRha = pancerzFrontKinetRha;
    }

    public Double getPancerzFrontKumulRha() {
        return pancerzFrontKumulRha;
    }

    public void setPancerzFrontKumulRha(Double pancerzFrontKumulRha) {
        this.pancerzFrontKumulRha = pancerzFrontKumulRha;
    }

    public Double getPancerzTylKinetRha() {
        return pancerzTylKinetRha;
    }

    public void setPancerzTylKinetRha(Double pancerzTylKinetRha) {
        this.pancerzTylKinetRha = pancerzTylKinetRha;
    }

    public Double getPancerzTylKumulRha() {
        return pancerzTylKumulRha;
    }

    public void setPancerzTylKumulRha(Double pancerzTylKumulRha) {
        this.pancerzTylKumulRha = pancerzTylKumulRha;
    }

    public Double getPancerzSpodKinetRha() {
        return pancerzSpodKinetRha;
    }

    public void setPancerzSpodKinetRha(Double pancerzSpodKinetRha) {
        this.pancerzSpodKinetRha = pancerzSpodKinetRha;
    }

    public Double getPancerzSpodKumulRha() {
        return pancerzSpodKumulRha;
    }

    public void setPancerzSpodKumulRha(Double pancerzSpodKumulRha) {
        this.pancerzSpodKumulRha = pancerzSpodKumulRha;
    }

    public Double getPancerzStropKinetRha() {
        return pancerzStropKinetRha;
    }

    public void setPancerzStropKinetRha(Double pancerzStropKinetRha) {
        this.pancerzStropKinetRha = pancerzStropKinetRha;
    }

    public Double getPancerzStropKumulRha() {
        return pancerzStropKumulRha;
    }

    public void setPancerzStropKumulRha(Double pancerzStropKumulRha) {
        this.pancerzStropKumulRha = pancerzStropKumulRha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KadlubEntity that = (KadlubEntity) o;

        if (id != that.id) return false;
        if (pancerzBokKinetRha != null ? !pancerzBokKinetRha.equals(that.pancerzBokKinetRha) : that.pancerzBokKinetRha != null)
            return false;
        if (pancerzBokKumulRha != null ? !pancerzBokKumulRha.equals(that.pancerzBokKumulRha) : that.pancerzBokKumulRha != null)
            return false;
        if (pancerzFrontKinetRha != null ? !pancerzFrontKinetRha.equals(that.pancerzFrontKinetRha) : that.pancerzFrontKinetRha != null)
            return false;
        if (pancerzFrontKumulRha != null ? !pancerzFrontKumulRha.equals(that.pancerzFrontKumulRha) : that.pancerzFrontKumulRha != null)
            return false;
        if (pancerzTylKinetRha != null ? !pancerzTylKinetRha.equals(that.pancerzTylKinetRha) : that.pancerzTylKinetRha != null)
            return false;
        if (pancerzTylKumulRha != null ? !pancerzTylKumulRha.equals(that.pancerzTylKumulRha) : that.pancerzTylKumulRha != null)
            return false;
        if (pancerzSpodKinetRha != null ? !pancerzSpodKinetRha.equals(that.pancerzSpodKinetRha) : that.pancerzSpodKinetRha != null)
            return false;
        if (pancerzSpodKumulRha != null ? !pancerzSpodKumulRha.equals(that.pancerzSpodKumulRha) : that.pancerzSpodKumulRha != null)
            return false;
        if (pancerzStropKinetRha != null ? !pancerzStropKinetRha.equals(that.pancerzStropKinetRha) : that.pancerzStropKinetRha != null)
            return false;
        if (pancerzStropKumulRha != null ? !pancerzStropKumulRha.equals(that.pancerzStropKumulRha) : that.pancerzStropKumulRha != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pancerzBokKinetRha != null ? pancerzBokKinetRha.hashCode() : 0);
        result = 31 * result + (pancerzBokKumulRha != null ? pancerzBokKumulRha.hashCode() : 0);
        result = 31 * result + (pancerzFrontKinetRha != null ? pancerzFrontKinetRha.hashCode() : 0);
        result = 31 * result + (pancerzFrontKumulRha != null ? pancerzFrontKumulRha.hashCode() : 0);
        result = 31 * result + (pancerzTylKinetRha != null ? pancerzTylKinetRha.hashCode() : 0);
        result = 31 * result + (pancerzTylKumulRha != null ? pancerzTylKumulRha.hashCode() : 0);
        result = 31 * result + (pancerzSpodKinetRha != null ? pancerzSpodKinetRha.hashCode() : 0);
        result = 31 * result + (pancerzSpodKumulRha != null ? pancerzSpodKumulRha.hashCode() : 0);
        result = 31 * result + (pancerzStropKinetRha != null ? pancerzStropKinetRha.hashCode() : 0);
        result = 31 * result + (pancerzStropKumulRha != null ? pancerzStropKumulRha.hashCode() : 0);
        return result;
    }
}
