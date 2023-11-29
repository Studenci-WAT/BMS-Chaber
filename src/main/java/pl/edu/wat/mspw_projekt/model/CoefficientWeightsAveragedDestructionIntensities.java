package pl.edu.wat.mspw_projekt.model;

/**
 * Wagi współczynników uśrednione intensywności niszczenia
 * wagi_wsp_usred_intens_niszcz
 */
public class CoefficientWeightsAveragedDestructionIntensities {
    private int id;
    private ClimateType climateType;
    //private TYP_OPERACJI_PKA_FK TODO
    private boolean isDay;
    private boolean isRainfallLevelImportant;
    private boolean isFogLevelImportant;
    private int targetFortificationLevel;
    private boolean isTargetCamouflageImportant;
    private boolean isTargetSmokeLevelImportant;
    private boolean isShooterMobilityImportant;
    private boolean isTargetMobilityImportant;
    private FireUnitLevel fireUnitLevel;
    private float weight;
}
