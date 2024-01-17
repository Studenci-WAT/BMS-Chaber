package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Parametry strzelania ogniem pośrednim
 * param_strzel_og_posr
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "param_strzel_og_posr")
public class IndirectFireShootingParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "AMO_FK")
    private Ammo ammo;
    @ManyToOne
    @JoinColumn(name = "SYSTEM_OGN_FK")
    private FireControlSystem fireControlSystem;
    @Column(name = "")
    private float distance;
    @Column(name = "")
    private float tiltWidth;
    @Column(name = "")
    private float tiltHeight;
}
