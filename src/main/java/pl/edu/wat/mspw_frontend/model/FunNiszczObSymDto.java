package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunNiszczObSymDto implements Serializable {

    private int id;

    private Integer spwStrzelFk;

    private Integer sysOgnFk;

    private Integer amoFk;

    private Integer spwCelFk;

    private Integer mobilStrzel;

    private Integer mobilCelu;

    private Integer typTerenuWidoczFk;

    private Integer typKlimatuFk;

    private Integer poziomOddzialOgnPkaFk;

    private Integer poziomFortCelu;

    private Integer poziomWyszkStrzel;

    private Double odleg;

    private Double intensNiszcz;

    private Double pstwoZniszcz;

}
