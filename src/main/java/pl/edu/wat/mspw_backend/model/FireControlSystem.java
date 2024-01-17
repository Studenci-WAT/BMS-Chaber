package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * System ognia
 * system_ogn
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "system_ogn")
public class FireControlSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAZWA")
    private String name;

    @Column(name = "SKROT")
    private String shortcut;

    @Column(name = "SZYBKOSTRZELNOSC")
    private float rapidFire;

    @Column(name = "KALIBER")
    private float caliber;

    @Column(name = "DLUG_SERII")
    private int burstLength;

    @Column(name = "CZAS_CELOWANIA")
    private float targetingTime;

    @Column(name = "LICZBA_KAN_CEL")
    private int numberOfTarget;

    @ManyToOne()
    @JoinColumn(name = "RODZAJ_SYSTEMU_OGN_FK")
    private FireControlSystemType fireControlSystemType;

    @Column(name = "KLASA_PRZYRZ_OC")
    private int opticsClass;

}
