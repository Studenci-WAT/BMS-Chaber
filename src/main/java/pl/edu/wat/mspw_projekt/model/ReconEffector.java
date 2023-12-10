package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Efektor zdolności rozpoznawczych
 * efektor_rozpoz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "efektor_rozpoz")
public class ReconEffector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ROZPOZ_AKUST")
    private boolean acousticReconCapable;
    @Column(name = "ROZPOZ_AKUST_PROMIEN")
    private float acousticReconRadius;
    @Column(name = "ROZPOZ_TERMICZ")
    private boolean thermalReconCapable;
    @Column(name = "ROZPOZ_TERMICZ_PROMIEN_DZIEN")
    private float thermalReconRadiusDay;
    @Column(name = "ROZPOZ_TERMICZ_PROMIEN_NOC")
    private float thermalReconRadiusNight;
    @Column(name = "ROZPOZ_NOKTOW")
    private boolean nightVisionReconCapable;
    @Column(name = "ROZPOZ_NOKTOW_PROMIEN")
    private float nightVisionReconRadius;
    @Column(name = "ROZPOZ_RADAR")
    private boolean radarReconCapable;
    @Column(name = "ROZPOZ_RADAR_PROMIEN")
    private float radarReconRadius;
    @Column(name = "KLASA_PRZYRZ_OC")
    private int opticsClass;

}
