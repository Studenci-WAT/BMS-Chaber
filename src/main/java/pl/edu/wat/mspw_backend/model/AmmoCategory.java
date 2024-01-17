package pl.edu.wat.mspw_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

/**
 * Kategoria amunicji
 * e_kategoria_amo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "e_kategoria_amo")
public class AmmoCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAZWA")
    private String name;

    @Column(name = "SKROT")
    private String shortcut;
}
