package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrefaRazeniaSpwDto implements Serializable {

    private int id;

    private Integer amoFk;

    private Double powRazCelOdkr;

    private Double powRazCelZakr;

    private Double odlegStrzel;

    private Integer kategSpwFk;

}
