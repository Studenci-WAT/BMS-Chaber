package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Miara zdolności rażenia
 * miara_zdolnosci_razenia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "miara_zdolnosci_razenia")
public class StrikeAbilityMeasure {
    //todo Co to carrier capacity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOSICIEL_ZDOLN_FK")
    private int carrierCapacity;
    @Column(name = "ZDOLN_RAZ_PANC_OPANC_ZASIEG_BLISKI")
    private float strikeCapabilityFirearmsCloseRange;
    @Column(name = "ZDOLN_RAZ_SRODK_OGN_ZASIEG_BLISKI")
    private float strikeCapabilityLiveForceCloseRange;
    @Column(name = "ZDOLN_RAZ_SILY_ZYWEJ_ZASIEG_BLISKI")
    private float penetrationCapabilityCloseDistance;
    @Column(name = "ZDOLN_RAZ_PANC_OPANC_ZASIEG_SREDNI")
    private float strikeCapabilityFirearmsMidRange;
    @Column(name = "ZDOLN_RAZ_SRODK_OGN_ZASIEG_SREDNI")
    private float strikeCapabilityLiveForceMidRange;
    @Column(name = "ZDOLN_RAZ_SILY_ZYWEJ_ZASIEG_SREDNI")
    private float penetrationCapabilityMidRange;

}
