package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Nazwa klasy to obv. placeholder jak na razie, nie mam pojęcia co może znaczyć
 * */
//TODO: 1) co znaczy nazwa tej klasy
//      2) zmienić nazwę klasy
//      3) stworzyć klasę OperationType
//      4) jako kategorie strzel. i celu dałem MilitaryEquipmentCategory, sprawdzić czy poprawne
//      5) WSP_A i WSP_B - placeholdery, nie wiem co znacza
//      6) stworzyć klasę MilitaryEquipement (do SPW_STRZEL i SPW_CEL)

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fun_intens_niszcz_nosic_sym_2")
public class Fun_intens_niszcz_nosic_sym_2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "TYP_TERENU_WIDOCZ_FK")
    private TerrainVisibility terrainVisibility;

    @ManyToOne()
    @JoinColumn(name = "TYP_KLIMATU_FK")
    private ClimateType climateType;


    //private OperationType operationType;


    @Column(name = "POZIOM_FORT")
    private int fortificationLevel;

    @Column(name = "INTENSYWNOSC")
    private float intensity;

    @Column(name = "ODLEG")
    private float distance;

    @Column(name = "CEL_OPANC")
    private boolean isTargetArmored;

    @Column(name = "POZIOM_WYSZK")
    private int skillLevel;

    @Column(name = "POZIOM_ZDOLN_MANEWR")
    private int maneuverSkillLevel;

    @ManyToOne()
    @JoinColumn(name = "KATEG_STRZEL_FK")
    private MilitaryEquipmentCategory shootersCategory;

    @ManyToOne()
    @JoinColumn(name = "KATEG_CELU_FK")
    private MilitaryEquipmentCategory targetCategory;

    @Column(name = "KLASA_STRZEL")
    private int shootersClass;

    @Column(name = "KLASA_CELU")
    private int targetClass;

    @Column(name = "WSP_A")
    private float WSP_A;

    @Column(name = "WSP_A")
    private float WSP_B;

    @Column(name = "ZASIEG_MIN")
    private float minDistance;

    @Column(name = "ZASIEG_MAX")
    private float maxDistance;

    @ManyToOne()
    @JoinColumn(name = "SPW_STRZEL_FK")
    private MilitaryEquipment shooterMilitaryEquipment;

    @ManyToOne()
    @JoinColumn(name = "SPW_CEL_FK")
    private MilitaryEquipment targetMilitaryEquipment;
}
