package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Strefa rażenia sprzętu wojskowego
 * strefa_razenia_spw
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "strefa_razenia_spw")
public class MilitaryEquipmentKillZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "AMO_FK")
    private Ammo ammo;
    @Column(name = "POW_RAZ_CEL_ODKR")
    private float areaUncoveredtarget;
    @Column(name = "POW_RAZ_CEL_ZAKR")
    private float areaCoveredtarget;
    @Column(name = "ODLEG_STRZEL")
    private float shooterDistance;
    @ManyToOne
    @JoinColumn(name = "KATEG_SPW_FK")
    private MilitaryEquipmentCategory militaryEquipmentCategory;
}
