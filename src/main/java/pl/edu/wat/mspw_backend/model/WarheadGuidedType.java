package pl.edu.wat.mspw_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

/**
 * Typ głowicy bojowej
 * e_rodzaj_glowicy_naprow
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "e_rodzaj_glowicy_naprow")
public class WarheadGuidedType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAZWA")
    private String name;
    @Column(name = "SKROT")
    private String shortcut;
}
