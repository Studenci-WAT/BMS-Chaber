package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunWspWidoczDlaWykrDto implements Serializable  {

    private int id;

    private Double wsp;

    private Integer typTerenuWidoczFk;

    private Boolean poziomZadymIstotny;

    private Boolean poziomZamglIstotny;

    private Boolean poziomOpadIstotny;

    private Boolean poziomMaskIstotny;

    private Boolean dzien;

    private Integer poziomWyszk;

    private Integer poziomFort;

    private Integer typPrzyrzadowOcFk;

}
