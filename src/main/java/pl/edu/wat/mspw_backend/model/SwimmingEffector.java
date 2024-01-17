package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Efektor pływania
 * efektor_pływania
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "efektor_pływania")
public class SwimmingEffector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "PREDK_MAX_NA_WODZIE")
    private float maxSurfaceVelocity;
    @Column(name = "PREDK_EKO_NA_WODZIE")
    private float ekoSurfaceVelocity;
    @Column(name = "PREDK_MAX_POD_WODA")
    private float maxSubmergedVelocity;
    @Column(name = "PREDK_EKO_POD_WODA")
    private float ekoSubmergedVelocity;
    @Column(name = "DZIELNOSC")
    private int seakeeping;
    @Column(name = "ZUZYCIE_PALIWA_PREDK_MAX_NA_WOD")
    private float ekoSurfaceFuelConsumption;
    @Column(name = "ZUZYCIE_PALIWA_PREDK_EKO_NA_WOD")
    private float maxSurfaceFuelConsumption;
    @Column(name = "ZUZYCIE_PALIWA_PREDK_MAX_POD_WOD")
    private float ekoSubmergedFuelConsumption;
    @Column(name = "ZUZYCIE_PALIWA_PREDK_EKO_POD_WOD")
    private float maxSubmergedFuelConsumption;
}
