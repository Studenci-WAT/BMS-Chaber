package pl.edu.wat.mspw_projekt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Stan materiałów pędnych i smarów SpW
 * stan_mps_spw
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "stan_mps_spw")
public class PropellantsAndLubricantsStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "SPW_FK")
    private MilitaryEquipment militaryEquipment;
    @ManyToOne
    @JoinColumn(name = "MPS_FK")
    private PropellantAndLubricant propellantAndLubricant;
    @Column(name = "STAN_NORMATYW")
    private float normativeState;
}
