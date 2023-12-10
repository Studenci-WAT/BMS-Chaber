package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SpW systemu ognia
 * spw_sys_ogn
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "spw_sys_ogn")
public class FireControlSystemMilitaryEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LICZBA")
    private int amount;

    @ManyToOne()
    @JoinColumn(name = "SPW_FK")
    private MilitaryEquipment militaryEquipment;

    @ManyToOne()
    @JoinColumn(name = "SYSTEM_OGN_FK")
    private FireControlSystem fireControlSystem;
}
