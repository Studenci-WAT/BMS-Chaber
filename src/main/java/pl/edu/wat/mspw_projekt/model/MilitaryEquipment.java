package pl.edu.wat.mspw_projekt.model;

/**
 * SpW
 * sprzet_woj
 */
public class MilitaryEquipment {
    private int id;
    private String name;
    private String shortcut;
    private MilitaryEquipmentCategory militaryEquipmentCategory;
    private int type;
    private int service;
    private boolean isArmored;
    private float lifeCycleUnitCost;
    private float acquisitionUnitCost;
    private float maintainingTrainedPersonnelUnitCost;
    private float weight;
    private float length;
    private float width;
    private float height;
    private float combatCapability;
    private float value;
    private float fuelTankCapacity;
    private float fuelTankCapacityPositive;
    private float batteryCapacity;
    private boolean isDriving;
    private boolean isFlying;
    private boolean isMobile;
    private boolean isPulled;
    private CommunicationEffector communicationEffector;
//    private RODZAJ_SRODOW_fK
    private RunningEffector runningEffector;
    private SwimmingEffector swimmingEffector;
    private EngineeringEffector engineeringEffector;
    private ElectronicWarfareEffector electronicWarfareEffector;
    private Hull hullParams;
    private TransportEffector transportEffector;
    private FlyingEffector flyingEffector;
    private ReconEffector reconEffector;
    private int opticsClass;
    private float power;
    private float fuelUsage;

}
