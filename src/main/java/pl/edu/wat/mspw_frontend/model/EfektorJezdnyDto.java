package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorJezdnyDto implements Serializable {

    private int id;

    private Integer rodzajPodwoziaFk;

    private Double zuzyciePaliwaPredkEkoDroga;

    private Double zuzyciePaliwaPredkEkoTeren;

    private Double zuzyciePaliwaMax;

    private Double predkMaxDroga;

    private Double predkMaxTeren;

    private Double predkEkoDroga;

    private Double predkEkoTeren;

    private Double szerokPokonywRowow;

    private Double glebokBrodz;
}
