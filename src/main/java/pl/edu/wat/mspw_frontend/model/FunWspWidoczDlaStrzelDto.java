package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunWspWidoczDlaStrzelDto implements Serializable {

    private int id;

    private Integer typPrzyrzadowOcFk;

    private Double wsp;

    private Boolean poziomZadymIstotny;

    private Boolean poziomZamglIstotny;

    private Boolean poziomOpadIstotny;

    private Boolean poziomMaskIstotny;

    private Boolean dzien;

    private Integer poziomWyszk;

    private Integer poziomFort;

}
