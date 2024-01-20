package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WagiWspUsredIntensNiszczDto implements Serializable {

    private int id;

    private Integer typKlimatuFk;

    private Integer typOperacjiPkaFk;

    private Boolean dzien;

    private Boolean poziomOpadIstotny;

    private Boolean poziomZamglIstotny;

    private Integer poziomFortCelu;

    private Boolean poziomMaskCeluIstotny;

    private Boolean poziomZadymCeluIstotny;

    private Boolean mobilStrzelIstotna;

    private Boolean mobilCeluIstotna;

    private Integer poziomOddzialOgnPkaFk;

    private Double waga;

}
