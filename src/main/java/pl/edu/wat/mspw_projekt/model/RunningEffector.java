package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Efektor jezdny
 * efektor_jezdny
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "efektor_jezdny")
public class RunningEffector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //todo
    @ManyToOne
    @JoinColumn(name = "RODZAJ_PODWOZIA_FK")
    private ChassisType chassisType;

    @Column(name = "ZUZYCIE_PALIWA_PREDK_EKO_DROGA")
    private float roadFuelEkoConsumption;
    @Column(name = "ZUZYCIE_PALIWA_PREDK_EKO_TEREN")
    private float terrainFuelEkoConsumption;
    @Column(name = "ZUZYCIE_PALIWA_MAX")
    private float maxFuelConsumption;
    @Column(name = "PREDK_MAX_DROGA")
    private float maxRoadVelocity;
    @Column(name = "PREDK_MAX_TEREN")
    private float maxTerrainVelocity;
    @Column(name = "PREDK_EKO_DROGA")
    private float roadEkoVelocity;
    @Column(name = "PREDK_EKO_TEREN")
    private float terrainEkoVelocity;
    @Column(name = "SZEROK_POKONYW_ROWOW")
    private float trenchesOvercomingWidth;
    @Column(name = "GLEBOK_BRODZ")
    private float waddinWidth;
}
