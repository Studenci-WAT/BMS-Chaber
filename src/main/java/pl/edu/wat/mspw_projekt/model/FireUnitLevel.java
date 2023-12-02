package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Poziom oddziaływania ogniowego
 * e_poziom_oddzial_ogn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "e_poziom_oddzial_ogn")
public class FireUnitLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAZWA")
    private String name;

    @Column(name = "SKROT")
    private String shortcut;
}
