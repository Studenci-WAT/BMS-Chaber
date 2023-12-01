package pl.edu.wat.mspw_projekt.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
/**
 * Stan amunicji SpW
 * stan_amo_spw
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "stan_amo_spw")
public class AmmoStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "SPW_FK")
    private MilitaryEquipment militaryEquipment;

    @ManyToOne()
    @JoinColumn(name = "AMO_FK")
    private Ammo ammo;

    @Column(name = "STAN_NORMATYW")
    private int normativeState;
}
