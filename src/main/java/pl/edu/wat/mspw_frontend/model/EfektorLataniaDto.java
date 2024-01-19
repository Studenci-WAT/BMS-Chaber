package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorLataniaDto implements Serializable {

    private int id;

    private Double predkMin;

    private Double predkEko;

    private Double predkMax;

    private Double wysokMin;

    private Double wysokPrzelot;

    private Double wysokMax;

    private Double zuzyciePredkMin;

    private Double zuzyciePredkPrzelot;

    private Double zuzyciePredkMax;
}
