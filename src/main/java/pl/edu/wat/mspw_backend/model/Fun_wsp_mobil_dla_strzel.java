package pl.edu.wat.mspw_backend.model;
//TODO: Zmiana nazwy klasy

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fun_wsp_mobil_dla_strzel")
public class Fun_wsp_mobil_dla_strzel {

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

    @Column(name = "POZIOM_ZDOLN_MANEWR")
    private int maneuverSkillLevel;
}
