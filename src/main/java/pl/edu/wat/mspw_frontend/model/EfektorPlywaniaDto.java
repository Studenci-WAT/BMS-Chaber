package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorPlywaniaDto implements Serializable {

    private int id;

    private Double predkMaxNaWodzie;

    private Double predkEkoNaWodzie;

    private Double predkMaxPodWoda;

    private Double predkEkoPodWoda;

    private Integer dzielnosc;

    private Double zuzyciePaliwaPredkMaxNaWod;

    private Double zuzyciePaliwaPredkEkoNaWod;

    private Double zuzyciePaliwaPredkMaxPodWod;

    private Double zuzyciePaliwaPredkEkoPodWod;

}
