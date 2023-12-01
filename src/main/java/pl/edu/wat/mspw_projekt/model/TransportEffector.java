package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Efektor zdolności transportowych
 * efektor_transp
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "efektor_transp")
public class TransportEffector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DESANT")
    private int landing;
    @Column(name = "LADOW_MASA")
    private float capacityMass; // Ładowność
    @Column(name = "LADOW_WYM_X")
    private float capacityDimensionX;
    @Column(name = "LADOW_WYM_Y")
    private float capacityDimensionY;
    @Column(name = "LADOW_WYM_Z")
    private float CapacityDimensionX;
    @Column(name = "POJEM")
    private float capacity; // Pojemność
    @Column(name = "TRANSPORT_WODY")
    private boolean waterTransportCapable;
}
