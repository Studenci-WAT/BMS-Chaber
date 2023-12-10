package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Przebijalność pancerza rha
 * przebijal_panc_rha
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "przebijal_panc_rha")
public class RhaArmorPierceability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "AMO_FK")
    private Ammo ammo;

    @Column(name ="PREDK_POCISKU")
    private float bulletVelocity;

    @Column(name ="PRZEBIJAL_POCISKU")
    private float bulletPenetrability;
}
