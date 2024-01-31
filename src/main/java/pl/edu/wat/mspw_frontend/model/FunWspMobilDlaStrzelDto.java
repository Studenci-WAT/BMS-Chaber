package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunWspMobilDlaStrzelDto implements Serializable  {

    private int id;

    private Double wsp;

    private Boolean mobilCeluIstotna;

    private Boolean mobilStrzelIstotna;

    private Integer poziomWyszk;

    private Integer poziomZdolnManewr;

}
