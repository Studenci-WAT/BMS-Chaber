package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Efektor walki elektronicznej
 * efektor_we
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "efektor_we")
public class ElectronicWarfareEffector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAMIERZ_PROMIEN")
    private int targetingRadius;

    @Column(name = "NAMIERZ_CZESTOTLMIN")
    private int minTargetingFrequency;

    @Column(name = "NAMIERZ_CZESTOTL_MAX")
    private int maxTargetingFrequency;

    @Column(name = "NAMIERZ_CZAS")
    private int targetingTime;

    @Column(name = "NAMIERZ_SZYBKOSC_PRZESZUK")
    private int targetingSearchSpeed;

    @Column(name = "ZAKLOC_PROMIEN")
    private int disruptionRadius;

    @Column(name = "ZAKLOC_CZESTOTL_MIN")
    private int minDisruptionFrequency;

    @Column(name = "ZAKLOC_CZESTOTL_MAX")
    private int maxDisruptionFrequency;
}
