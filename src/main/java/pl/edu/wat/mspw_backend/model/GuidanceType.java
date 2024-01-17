package pl.edu.wat.mspw_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

/**
 * Rodzaj naprowadzania
 * e_rodzaj_naprow
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "e_rodzaj_naprow")
public class GuidanceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAZWA")
    private String name;
    @Column(name = "SKROT")
    private String shortcut;
}
