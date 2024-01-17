package pl.edu.wat.mspw_backend.model;
//TODO: 1) Zmiana nazwy klasy

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fun_wsp_obezwlad")
public class Fun_wsp_obezwlad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "POZIOM_ODDZIAL_OGN_FK")
    private FireUnitLevel fireUnitLevel;

    @Column(name = "WSP")
    private float coefficient;

    @Column(name = "STRZEL_OPANC")
    private boolean isShooterArmored;

    @Column(name = "POZIOM_WYSZK")
    private int skillLevel;

}
