package pl.edu.wat.mspw_projekt.model;
/**
 * Amunicja
 * amo
 * */
public class Ammo {
    private int id;
    private String nazwa;
    private String shortcut;
    private String code;
    private float caliber;
    private int unitsPerPackage;
    private int unitWeight;
    private float packageSizeX;
    private float packageSizeY;
    private float packageSizeZ;
    private AmmoCategory category;
    private WarheadType warhead;
    private WarheadGuidedType warheadGuided;
    private GuidanceType guidance;
}
