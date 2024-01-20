package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrefaRazeniaSilyZywejDto implements Serializable {

    private int id;

    private Integer amoFk;

    private Double odlegStrzel;

    private Double powRazOdkr;

    private Double powRazRozbDorazna;

    private Double powRazRozbPrzygot;

}
