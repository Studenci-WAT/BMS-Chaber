package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Strefa rażenia sił żywej
 * strefa_razenia_sily_zywej
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "strefa_razenia_sily_zywej")
public class LiveForceKillZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "AMO_FK")
    private Ammo ammo;

    @Column(name = "ODLEG_STRZEL")
    private float shooterDistance;
    @Column(name = "POW_RAZ_ODKR")
    private float areaUncoveredtarget;

    //TODO
    @Column(name = "POW_RAZ_ROZB_DORAZNA")
    private float POW_RAZ_ROZB_DORAZNA;
    @Column(name = "POW_RAZ_ROZB_PRZYGOT")
    private float POW_RAZ_ROZB_PRZYGOT;
}
