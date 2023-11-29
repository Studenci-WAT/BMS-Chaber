package pl.edu.wat.mspw_projekt.model;
/**
 * Amunicja
 * amo
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "amo")
public class Ammo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAZWA")
    private String name;

    @Column(name = "SKROT")
    private String shortcut;

    @Column(name = "KOD")
    private String code;

    @Column(name = "KALIBER")
    private float caliber;

    @Column(name = "SZTUK_W_PACZCE")
    private int unitsPerPackage;

    @Column(name = "MASA_SZTUKI")
    private int unitWeight;

    @Column(name = "WYM_PACZKI_X")
    private float packageSizeX;

    @Column(name = "WYM_PACZKI_Y")
    private float packageSizeY;

    @Column(name = "WYM_PACZKI_Z")
    private float packageSizeZ;

    @ManyToOne()
    @JoinColumn(name = "KATEG_FK")
    private AmmoCategory category;

    @ManyToOne
    @JoinColumn(name = "RODZAJ_GLOWICY_BOJ_FK")
    private WarheadType warhead;

    @ManyToOne
    @JoinColumn(name = "RODZAJ_GLOWICY_NAPROW_FK")
    private WarheadGuidedType warheadGuided;

    @ManyToOne
    @JoinColumn(name = "RODZAJ_NAPROW_FK")
    private GuidanceType guidance;
}
