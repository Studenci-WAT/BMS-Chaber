package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunIntensStrzelOpDto implements Serializable {

    private int id;

    private Integer kategStrzelFk;

    private Integer klasaStrzel;

    private Integer kategCeluFk;

    private Integer klasaCelu;

    private Integer poziomWyszkStrzel;

    private Integer typOperacjiStrzelFk;

    private Integer typOperacjiCeluFk;

    private Double odleg;

    private Double intens;

}
