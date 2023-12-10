package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Efektor latania
 * efektor_latania
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "efektor_latania")
public class FlyingEffector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PREDK_MIN")
    private float minVelocity;

    @Column(name = "PREDK_EKO")
    private float ekoVelocity;

    @Column(name = "PREDK_MAX")
    private float maxVelocity;

    @Column(name = "WYSOK_MIN")
    private float minFlightCeiling;

    @Column(name = "WYSOK_PRZELOT")
    private float ekoFlightCeiling;

    @Column(name = "WYSOK_MAX")
    private float maxFlightCeiling;

    @Column(name = "ZUZYCIE_PREDK_MIN")
    private float minFuelConsumption;

    @Column(name = "ZUZYCIE_PREDK_PRZELOT")
    private float ekoFuelConsumption;

    @Column(name = "ZUZYCIE_PREDK_MAX")
    private float maxFuelConsumption;


}
