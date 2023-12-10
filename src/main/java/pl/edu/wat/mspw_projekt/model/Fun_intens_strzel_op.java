package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO: 1) Zmiana nazwy klasy
//      2) dodanie klasy OperationType

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fun_intens_strzel_op")

public class Fun_intens_strzel_op {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "KATEG_STRZEL_FK")
    private TargetCategory shooterTargetCategory;

    @Column(name = "KLASA_STRZEL")
    private int shootersClass;

    @ManyToOne()
    @JoinColumn(name = "KATEG_CELU_FK")
    private TargetCategory targetTargetCategory;

    @Column(name = "KLASA_CELU")
    private int targetClass;

    @Column(name = "POZIOM_WYSZK_STRZEL")
    private int skillLevel;


    //private OperationType shooterOperationType;


    //private OperationType targetOperationType;

    @Column(name = "ODLEG")
    private float distance;

    @Column(name = "INTENS")
    private float intensity;





}
