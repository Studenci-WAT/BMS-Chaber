package pl.edu.wat.mspw_projekt.model;

import javax.persistence.*;

/**
 * Typ głowicy bojowej
 * e_rodzaj_glowicy_naprow
 */
@Entity
@Table(name = "e_rodzaj_glowicy_napraw")
public class WarheadGuidedType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAZWA")
    private String name;
    @Column(name = "SKROT")
    private String shortcut;
}
