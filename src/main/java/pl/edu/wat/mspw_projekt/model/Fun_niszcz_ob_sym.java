package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fun_niszcz_ob_sym")

public class Fun_niszcz_ob_sym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // SPW_STRZEL_FK
    // SYS_OGN_FK

    @ManyToOne()
    @JoinColumn(name = "SYS_OGN_FK")
    private Ammo ammo;
    // SPW_CEL_FK

    @Column(name = "MOBIL_STRZEL")
    private int shooterMobility;

    @Column(name = "MOBIL_CELU")
    private int targetMobility;

    @ManyToOne()
    @JoinColumn(name = "TYP_TERENU_WIDOCZ_FK")
    private TerrainVisibility visibility;

    @ManyToOne()
    @JoinColumn(name = "TYP_KLIMATU_FK")
    private ClimateType climate;

    @ManyToOne()
    @JoinColumn(name = "POZIOM_ODDZIAL_OGN_PKA_FK")
    private FireUnitLevel unitLevel;

    @Column(name = "POZIOM_FORT_CELU")
    private int targetFortificationLvl;

    @Column(name = "POZIOM_WYSZK_STRZEL")
    private int shooterExperienceLvl;

    @Column(name = "ODLEG")
    private float distance;

    @Column(name = "INTENS_NISZCZ")
    private float destructionIntensity;

    @Column(name = "PSTWO_ZNISZCZ")
    private float probabilityOfDestruction;
}
