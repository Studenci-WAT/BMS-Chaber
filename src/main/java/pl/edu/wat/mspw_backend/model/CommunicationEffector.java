package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Efektor łączności
 * efektor_laczn
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "efektor_laczn")
public class CommunicationEffector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LICZBA_TRAKTOW_KABL")
    private int numberOfCableRoutes;

    @Column(name = "LICZBA_TRAKTOW_RADIOL")
    private int numberOfRadiologicalRoutes;

    @Column(name = "LICZBA_SIECI_CNR_DO_PRZYLACZ")
    private int numberOfCNRNetsToConnect;

    @Column(name = "MOC_NADAJNIKA_RADIOL")
    private float radiologicalTransmitterPower;

    @Column(name = "WYSOK_ANTENY_RADIOL")
    private float transmitterHeight;

    @Column(name = "MOC_NADAJNIKA")
    private float transmitterPower;

    @Column(name = "ZASIEG_NADAJNIKA")
    private float transmitterRange;

}
