package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Parametry strzelania ogniem bezpośrednim
 * param_strzel_og_bezp
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "param_strzel_og_bezp")
public class DirectFireShootingParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "AMO_FK")
    private Ammo ammo;

    @ManyToOne()
    @JoinColumn(name = "SYSTEM_OGN_FK")
    private FireControlSystem fireControlSystem;

    @Column(name = "ODLEG")
    private float distance;

    @Column(name = "PREDK_POCISKU")
    private float bulletVelocity;

    @Column(name = "UCHYL_SZER")
    private float tiltWidth;

    @Column(name = "UCHYL_WYS")
    private float tiltHeight;

    @Column(name = "WYSOK")
    private float height;

}
