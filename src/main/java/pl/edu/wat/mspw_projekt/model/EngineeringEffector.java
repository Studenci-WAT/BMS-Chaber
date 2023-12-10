package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Efektor zdolności inżynieryjnych
 * efektor_inz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "efektor_inz")
public class EngineeringEffector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DO_PRAC_ZIEMNYCH")
    private boolean earthworkCapable;

    @Column(name = "ELEMENT_PRZEPR_PROM")
    private boolean ferryCrossingComponent;

    @Column(name = "ELEMENT_PRZEPR_MOST")
    private boolean bridgeCrossingComponent;

    @Column(name = "NOSNOSC")
    private float loadCapacity;

    @Column(name = "SZEROK_PRZEPRAWY")
    private float crossingWidth;
}
