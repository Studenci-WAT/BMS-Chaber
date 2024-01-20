package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunWspUkryciaDto implements Serializable {

    private int id;

    private Integer typTerenuWidoczFk;

    private Double wsp;

    private Integer poziomFort;

}
