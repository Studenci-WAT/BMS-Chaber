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
@Table(name = "fun_pstwo_zniszcz_traf_ob")
public class Fun_pstwo_zniszcz_traf_ob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // TO DO:
    // private FireControlSystem fs;

    @ManyToOne()
    @JoinColumn(name = "AMO_FK")
    private Ammo ammo;
    // SPW_CEL_FK ???

    @Column(name = "ODLEG")
    private float distance;

    @Column(name = "PSTWO")
    private float probability;
}
