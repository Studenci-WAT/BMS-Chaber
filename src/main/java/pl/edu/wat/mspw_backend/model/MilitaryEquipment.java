package pl.edu.wat.mspw_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SpW
 * sprzet_woj
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sprzet_woj")
public class MilitaryEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAZWA")
    private String name;

    @Column(name = "SKROT")
    private String shortcut;

    @ManyToOne()
    @JoinColumn(name = "KATEGORIA_FK")
    private MilitaryEquipmentCategory militaryEquipmentCategory;

    @Column(name = "KLASA")
    private int type;

    @Column(name = "OBSLUGA")
    private int service;

    @Column(name = "OPANCERZONY")
    private boolean isArmored;

    @Column(name = "KOSZT_JEDN_CYKLU_ZYCIA")
    private float lifeCycleUnitCost;

    @Column(name = "KOSZT_JEDN_NABYCIA")
    private float acquisitionUnitCost;

    @Column(name = "KOSZT_JEDN_UTRZYM_WYSZK_PERSON")
    private float maintainingTrainedPersonnelUnitCost;

    @Column(name = "MASA")
    private float weight;

    @Column(name = "DLUG")
    private float length;

    @Column(name = "SZEROK")
    private float width;

    @Column(name = "WYSOK")
    private float height;

    @Column(name = "POTENCJAL_BOJ")
    private float combatCapability;

    @Column(name = "VALUE")
    private float value;

    @Column(name = "POJEM_ZBIOR_PALIWA")
    private float fuelTankCapacity;

    @Column(name = "POJEM_ZBIOR_PALWA_DODAT")
    private float fuelTankCapacityPositive;

    @Column(name = "POJEM_AKUMULATOROW")
    private float batteryCapacity;

    @Column(name = "JEZDZACY")
    private boolean isDriving;

    @Column(name = "LATAJACY")
    private boolean isFlying;

    @Column(name = "PRZENOSNY")
    private boolean isMobile;

    @Column(name = "CIAGNIONY")
    private boolean isPulled;

    @ManyToOne()
    @JoinColumn(name = "EFEKTOR_LACZN_FK")
    private CommunicationEffector communicationEffector;

    @ManyToOne()
    @JoinColumn(name = "RODZAJ_SRODOW_FK")
    private ClimateType envoirment;

    @ManyToOne()
    @JoinColumn(name = "EFEKTOR_JEZDNY_FK")
    private RunningEffector runningEffector;

    @ManyToOne()
    @JoinColumn(name = "EFEKTOR_PLYWANIA_FK")
    private SwimmingEffector swimmingEffector;

    @ManyToOne()
    @JoinColumn(name = "EFEKTOR_INZ_FK")
    private EngineeringEffector engineeringEffector;

    @ManyToOne()
    @JoinColumn(name = "EFEKTOR_WE_FK")
    private ElectronicWarfareEffector electronicWarfareEffector;

    @ManyToOne()
    @JoinColumn(name = "PARAM_KADLUBA_FK")
    private Hull hullParams;

    @ManyToOne()
    @JoinColumn(name = "EFEKTOR_TRANSP_FK")
    private TransportEffector transportEffector;

    @ManyToOne()
    @JoinColumn(name = "EFEKTOR_LATANIA_FK")
    private FlyingEffector flyingEffector;

    @ManyToOne()
    @JoinColumn(name = "EFEKTOR_ROZPOZ_FK")
    private ReconEffector reconEffector;

    @Column(name = "KLASA_PRZYRZ_OC")
    private int opticsClass;

    @Column(name = "MOC")
    private float power;

    @Column(name = "ZUZYCIE_PALIWA_PRACA")
    private float fuelUsage;

}
