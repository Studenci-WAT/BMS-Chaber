package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO: 1)Zmiana nazwy klasy
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fun_wsp_mobil_dla_wykr")
public class Fun_wsp_mobil_dla_wykr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "WSP")
    private float coefficient;

    @Column(name = "MOBIL_CELU_ISTOTNA")
    private boolean isTargetMobilityLevelRelevant;

    @Column(name = "MOBIL_STRZEL_ISTOTNA")
    private boolean isShooterMobilityLevelRelevant;

    @Column(name = "POZIOM_WYSZK")
    private int skillLevel;

}
