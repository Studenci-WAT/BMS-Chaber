package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Kadłub
 * kadlub
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "kadlub")
public class Hull {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "PANCERZ_BOK_KINET_RHA")
    private float sideKineticArmorRha;
    @Column(name = "PANCERZ_BOK_KUMUL_RHA")
    private float sideCumulativeArmorRha;
    @Column(name = "PANCERZ_FRONT_KINET_RHA")
    private float frontKineticArmorRha;
    @Column(name = "PANCERZ_FRONT_KUMUL_RHA")
    private float frontCumulativeArmorRha;
    @Column(name = "PANCERZ_TYL_KINET_RHA")
    private float backKineticArmorRha;
    @Column(name = "PANCERZ_TYL_KUMUL_RHA")
    private float backCumulativeArmorRha;
    @Column(name = "PANCERZ_SPOD_KINET_RHA")
    private float bottomKineticArmorRha;
    @Column(name = "PANCERZ_SPOD_KUMUL_RHA")
    private float bottomCumulativeArmorRha;
    @Column(name = "PANCERZ_STROP_KINET_RHA")
    private float topKineticArmorRha;
    @Column(name = "PANCERZ_STROP_KUMUL_RHA")
    private float topCumulativeArmorRha;


}
