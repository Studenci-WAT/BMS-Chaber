package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunPstwoZniszczOpDto implements Serializable {

    private int id;

    private Integer poziomFortCelu;

    private Integer kategStrzelFk;

    private Integer klasaStrzel;

    private Integer kategCeluFk;

    private Integer klasaCelu;

    private Integer poziomWyszkStrzel;

    private Integer spwStrzelFk;

    private Integer spwCelFk;

    private Double pstwo;

    private Double odleg;

}
