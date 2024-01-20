package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunIntensNiszczNosicSym2Dto implements Serializable  {

    private int id;

    private Integer typTerenuWidoczFk;

    private Integer typKlimatuFk;

    private Integer typOperacjiFk;

    private Integer poziomFort;

    private Double intensywnosc;

    private Double odleg;

    private Boolean celOpanc;

    private Integer poziomWyszk;

    private Integer poziomZdolnManewr;

    private Integer kategStrzelFk;

    private Integer kategCeluFk;

    private Integer klasaStrzel;

    private Integer klasaCelu;

    private Double wspA;

    private Double wspB;

    private Double zasiegMin;

    private Double zasiegMax;

    private Integer spwStrzelFk;

    private Integer spwCelFk;
}
