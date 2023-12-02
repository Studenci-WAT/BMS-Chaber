package pl.edu.wat.mspw_projekt.model;

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
@Table(name = "fun_pstwo_zniszcz_op")
public class Fun_pstwo_zniszcz_op {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "POZIOM_FORT_CELU")
    private int targetFortificationLvl;


    // TO DO:
    // private ShooterCategory shooter;

    @Column(name = "KLASA_STRZEL")
    private int shooterClass;

    @ManyToOne()
    @JoinColumn(name = "KATEG_CELU_FK")
    private TargetCategory target;

    @Column(name = "KLASA_CELU")
    private int targetClass;

    @Column(name = "POZIOM_WYSZK_STRZEL")
    private int shooterExperienceLvl;
    // TO DO:
    // SPW_STRZEL_FK
    // SPW_CEL_FK

    @Column(name = "ODLEG")
    private float distance;

    @Column(name = "PSTWO")
    private float probability;
}
