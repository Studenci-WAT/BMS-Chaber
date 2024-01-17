package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Wagi współczynników uśrednione intensywności niszczenia
 * wagi_wsp_usred_intens_niszcz
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "wagi_wsp_usred_intens_niszcz")
public class CoefficientWeightsAveragedDestructionIntensities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "TYP_KLIMATU_FK")
    private ClimateType climateType;

    //private TYP_OPERACJI_PKA_FK TODO
    @Column(name = "DZIEN")
    private boolean isDay;

    @Column(name = "POZIOM_OPAD_ISTOTNY")
    private boolean isRainfallLevelImportant;

    @Column(name = "POZIOM_ZAMGL_ISTOTNY")
    private boolean isFogLevelImportant;

    @Column(name = "POZIOM_FORT_CELU")
    private int targetFortificationLevel;

    @Column(name = "POZIOM_MASK_CELU_ISTOTNY")
    private boolean isTargetCamouflageImportant;

    @Column(name = "POZIOM_ZADYM_CELU_ISTOTNY")
    private boolean isTargetSmokeLevelImportant;

    @Column(name = "MOBIL_STRZEL_ISTOTNA")
    private boolean isShooterMobilityImportant;

    @Column(name = "MOBIL_CELU_ISTOTNA")
    private boolean isTargetMobilityImportant;

    @ManyToOne()
    @JoinColumn(name = "POZIOM_ODDZIAL_OGN_PKA_FK")
    private FireUnitLevel fireUnitLevel;

    @Column(name = "WAGA")
    private float weight;
}
